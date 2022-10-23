package com.annotation.example03;

import com.annotation.example02.Cat;

@Cat(name = "tom")
public class Tomcat {
    private String name;
    public Tomcat(){

    }

    public Tomcat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tomcat{" +
                "name='" + name + '\'' +
                '}';
    }
}
