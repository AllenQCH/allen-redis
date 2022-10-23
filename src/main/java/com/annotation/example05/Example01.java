package com.annotation.example05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.annotation.example05")
public class Example01 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Example01.class);
        Dog dog = context.getBean(Dog.class);
        System.out.println(dog);
    }
}
