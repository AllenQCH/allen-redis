package com.annotation.example04;

import org.springframework.stereotype.Service;

@Service
public class Hello {

    @Boy(name = "小明")
    String name = "world";

    public void say() {
        System.out.println("hello, " + name);
    }
}