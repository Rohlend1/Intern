package com.senlainc.container;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Supplier;

public class IocContainer {
    private final List<Class<?>> classes = new ArrayList<>();
    private final List<Object> beans = new ArrayList<>();
    private final Set<Class<?>> alreadyCreated = new HashSet<>();
    private final String pathToScan;

    public IocContainer(String pathToScan) {
        this.pathToScan = pathToScan;
        scanFiles(pathToScan);
        try {
            createBeans();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void scanFiles(String path){
        File file = new File(path);
        recursiveScanDirectoriesAndFiles(file.listFiles());
    }

    private void recursiveScanDirectoriesAndFiles(File[] files){
        if(files == null) return;
        for(File file : files){
            if(file.isDirectory()){
                recursiveScanDirectoriesAndFiles(file.listFiles());
            }
            else if(file.isFile()){
                if(file.getName().endsWith(".java")){
                    try {
                        String relativePath = Path.of(pathToScan).relativize(Path.of(file.getPath())).toString().replaceAll("[\\\\/]",".");
                        Class<?> clazz = Class.forName(relativePath.substring(0,relativePath.length()-5));
                        if(clazz.isAnnotationPresent(Component.class) || clazz.isAnnotationPresent(Repository.class) || clazz.isAnnotationPresent(Service.class)){
                            classes.add(clazz);
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void createBeans() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Class<?> clazz : classes) {
            if(!alreadyCreated.contains(clazz)) {
                List<Object> dependencies = new ArrayList<>();
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(AutoConnect.class)) {
                        Object dependency;
                        if ((dependency = findBeanIfExist(field.getType().getSimpleName())) == null) {
                            dependency = createDependencyBean(field.getType());
                            beans.add(dependency);
                        }
                        dependencies.add(dependency);
                        alreadyCreated.add(dependency.getClass());
                    }
                }
                if (!dependencies.isEmpty()) {
                    Class<?>[] parameterTypes = dependencies.stream().map(Object::getClass).toArray(Class<?>[]::new);
                    beans.add(createBean(clazz, parameterTypes, dependencies));
                } else if (checkIfDefaultConstructorExists(clazz)) {
                   beans.add(clazz.getConstructor().newInstance());
                }
                alreadyCreated.add(clazz);
            }
        }
    }

    private Object createBean(Class<?> clazz, Class<?>[] parameterTypes, List<Object> dependencies){
        try {
            Constructor<?> constructor = findConstructorWithParameters(parameterTypes,clazz);
            if (constructor != null) {
                Class<?>[] constructorParameterTypes = constructor.getParameterTypes();

                Object[] arguments = new Object[constructorParameterTypes.length];

                for (int i = 0; i < constructorParameterTypes.length; i++) {

                    for (int j = 0; j < parameterTypes.length; j++) {
                        if (constructorParameterTypes[i].isAssignableFrom(parameterTypes[j])) {
                            arguments[i] = dependencies.get(j);
                            break;
                        }
                    }
                }
                return constructor.newInstance(arguments);
            }
            else if(checkIfDefaultConstructorExists(clazz)
                    && areSettersExist(parameterTypes,clazz)){
                Object obj = clazz.getConstructor().newInstance();
                injectDependency(dependencies,obj);
                return obj;
            }
            else{
                throw new RuntimeException(clazz.getSimpleName()+" doesn't has a default constructor or set method");
            }
        }
        catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private Object createDependencyBean(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> dependencies = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoConnect.class)) {
                dependencies.add(createDependencyBean((field.getType())));
            }
        }
        if (!dependencies.isEmpty()) {
            Class<?>[] parameterTypes = dependencies.stream().map(Object::getClass).toArray(Class<?>[]::new);
            return createBean(clazz,parameterTypes,dependencies);
        }
        else{
            if(checkIfDefaultConstructorExists(clazz)){
                return clazz.getConstructor().newInstance();
            }
            throw new RuntimeException("Wrong dependency");
        }
    }

    private Object findBeanIfExist(String name){
        try{
            return findBean(name);
        }
        catch (Throwable ignored){
            return null;
        }
    }

    private Constructor<?> findConstructorWithParameters(Class<?>[] parameterTypes,Class<?> clazz){
        Set<Class<?>> parameters = new HashSet<>(Arrays.stream(parameterTypes).toList());
        for(Constructor<?> constructor : clazz.getConstructors()){
            if(parameters.containsAll(Arrays.stream(constructor.getParameters()).map(Parameter::getType).toList())){
                return constructor;
            }
        }
        return null;
    }

    private boolean injectDependency(List<Object> dependencies, Object obj){
        try{
            for(Object dependency: dependencies){
                obj.getClass().getDeclaredMethod("set"+dependency.getClass().getSimpleName(),dependency.getClass()).invoke(obj,dependency);
            }
            return true;
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored){
            return false;
        }
    }

    private boolean areSettersExist(Class<?>[] parameterTypes,Class<?> clazz){
        try{
            for(Class<?> parameter: parameterTypes){
                clazz.getDeclaredMethod("set"+parameter.getSimpleName(),parameter);
            }
            return true;
        }
        catch (NoSuchMethodException ignored){
            return false;
        }
    }

    private boolean checkIfDefaultConstructorExists(Class<?> clazz){
        for(Constructor<?> constructor : clazz.getConstructors()){
            if(constructor.getParameterCount() == 0){
                return true;
            }
        }
        return false;
    }

    private Object findBean(String name) throws Throwable {
        return beans.stream().filter(obj->obj.getClass().getSimpleName().equals(name))
                .findAny()
                .orElseThrow((Supplier<Throwable>) () -> new RuntimeException(name+" bean doesn't exist"));
    }

    public <T> T getBean(String name, Class<T> classToCast) throws Throwable {
        Object bean = findBean(name);
        if(classToCast.isInstance(bean)){
            return (T) bean;
        }
        else{
            throw new RuntimeException("Unexpected exception");
        }
    }

    public void close(){
        beans.clear();
        classes.clear();
        alreadyCreated.clear();
    }
}
