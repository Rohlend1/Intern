package container;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Supplier;

public class IocContainer {
   private final List<Class<?>> classes = new ArrayList<>();
   private final List<Object> beans = new ArrayList<>();

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
        helper(file.listFiles());
    }
    private void helper(File[] files){
        if(files == null) return;
        for(File file : files){
            if(file.isDirectory()){
                helper(file.listFiles());
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
            List<Object> dependencies = new ArrayList<>();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(AutoConnect.class)) {
                    dependencies.add(createBean(field.getType()));
                }
            }
            if (!dependencies.isEmpty()) {
                Class<?>[] parameterTypes = dependencies.stream().map(Object::getClass).toArray(Class<?>[]::new);
                beans.add(clazz.getConstructor(parameterTypes).newInstance(dependencies.toArray()));
            }
        }
    }


    private Object createBean(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> dependencies = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoConnect.class)) {
                dependencies.add(createBean((field.getType())));
            }
        }
        if (!dependencies.isEmpty()) {
            Class<?>[] parameterTypes = dependencies.stream().map(Object::getClass).toArray(Class<?>[]::new);
            return clazz.getConstructor(parameterTypes).newInstance(dependencies.toArray());
        }
        else{
            if(checkIfDefaultConstructorExists(clazz)){
                return clazz.getConstructor().newInstance();
            }
            throw new RuntimeException("Wrong dependency");
        }
    }

    public boolean checkIfDefaultConstructorExists(Class<?> clazz){
        for(Constructor<?> constructor : clazz.getConstructors()){
            if(constructor.getParameterCount() == 0){
                return true;
            }
        }
        return false;
    }

    public <T> T getBean(String name, Class<T> clazz) throws Throwable {
        Object object = beans.stream().filter(obj->obj.getClass().getSimpleName().equals(name)).findAny().orElseThrow((Supplier<Throwable>) () -> new RuntimeException("Bean doesn't exist"));
        if(clazz.isInstance(object)){
            return (T) object;
        }
        else{
            throw new RuntimeException("Unexpected exception");
        }
    }

    public void close(){
        beans.clear();
        classes.clear();
    }
}
