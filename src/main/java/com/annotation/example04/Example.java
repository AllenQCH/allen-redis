package com.annotation.example04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.annotation.example04")
public class Example {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Example.class);
        Hello hello = context.getBean(Hello.class);
        hello.say();
    }
}