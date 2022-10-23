package com.annotation.example03;


import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ReflectionsExample {
    @Person(name = "张三", sex = "男", age = 30)
    private Human human1;

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Reflections reflections = new Reflections("com.annotation.example03", new TypeAnnotationsScanner(), new SubTypesScanner(), new FieldAnnotationsScanner());
        Set<Class<?>> cats = reflections.getTypesAnnotatedWith(Cat.class);
        for(Class<?> clazz : cats){
            Cat cat = (Cat) clazz.getDeclaredAnnotation(Cat.class);
            String name = cat.name();
            Object object = clazz.getDeclaredConstructor(String.class).newInstance(name);
            System.out.println(object);
        }

        Set<Field> fields = reflections.getFieldsAnnotatedWith(Person.class);
        for(Field field:fields){
            Person person   = field.getDeclaredAnnotation(Person.class);
            Human human = (Human) field.getType().getDeclaredConstructor().newInstance();
            human.setSex(person.sex());
            human.setName(person.name());
            human.setAge(person.age());
            //todo：需要完成
//            ReflectionsExample reflectionsExample = (ReflectionsExample) field.getDeclaringClass().getDeclaredConstructor();
            field.setAccessible(true);
        }
    }
}
