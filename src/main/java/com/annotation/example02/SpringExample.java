package com.annotation.example02;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SpringExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassPathScanningCandidateComponentProvider classPathScanningCandidateComponentProvider = new ClassPathScanningCandidateComponentProvider(false);
        classPathScanningCandidateComponentProvider.addIncludeFilter(new AnnotationTypeFilter(Cat.class));
        Set<BeanDefinition> beanDefinitions = classPathScanningCandidateComponentProvider.findCandidateComponents("com.annotation.example02");
        for(BeanDefinition beanDefinition:beanDefinitions){
            String beanClassName = beanDefinition.getBeanClassName();
            Class clazz = Class.forName(beanClassName);
            Cat cat = (Cat)clazz.getDeclaredAnnotation(Cat.class);
            String name = cat.name();
            Object object = clazz.getDeclaredConstructor(String.class).newInstance(name);
            System.out.println(object);
        }
    }
}
