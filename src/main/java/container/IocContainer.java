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

public class IocContainer {
   static List<Class<?>> classes = new ArrayList<>();
   static List<Object> beans = new ArrayList<>();

    static String path = "C:\\Program Files\\Java\\Projects\\intern\\src\\main\\java";
    public static void main(String[] args) {

        scanFiles(path);
        System.out.println(classes);

        try {
            createBeans();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        for (Object obj : beans){
            System.out.println(obj);
        }
    }

    public static void scanFiles(String path){
        File file = new File(path);
        helper(file.listFiles());
    }
    public static void helper(File[] files){
        if(files == null) return;
        for(File file : files){
            if(file.isDirectory()){
                helper(file.listFiles());
            }
            else if(file.isFile()){
                if(file.getName().endsWith(".java")){
                    try {
                        String relativePath = Path.of(path).relativize(Path.of(file.getPath())).toString().replaceAll("\\\\",".");
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

    public static void createBeans() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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


    private static Object createBean(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
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

    public static boolean checkIfDefaultConstructorExists(Class<?> clazz){
        for(Constructor<?> constructor : clazz.getConstructors()){
            if(constructor.getParameterCount() == 0){
                return true;
            }
        }
        return false;
    }
}
