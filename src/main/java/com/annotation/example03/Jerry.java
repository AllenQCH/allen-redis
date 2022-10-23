package com.annotation.example03;

import com.annotation.example02.Cat;

@Cat(name = "jerry")
public class Jerry {
    private String name;
    public Jerry(){

    }

    public Jerry(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Jerry{" +
                "name='" + name + '\'' +
                '}';
    }
}
