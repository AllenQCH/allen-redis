package com.annotation.example02;

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
