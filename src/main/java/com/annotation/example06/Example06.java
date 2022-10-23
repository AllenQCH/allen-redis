package com.annotation.example06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Example06 {
    @Person(name="张三",sex = SexEnum.FEMALE,age = 20)
    private Human human1;

    @Person(name = "李四",sex = SexEnum.MALE)
    private Human human2;

    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Example06 example06 = new Example06();
        System.out.println(example06.human1);
        System.out.println(example06.human2);
        initField(example06);
        System.out.println(example06.human1);
        System.out.println(example06.human2);
    }

    private static void initField(Example06 example06) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1、反射获取example06的类
        Class clazz = example06.getClass();
        // 2、根据name获取类中的变量
        Field field1 = clazz.getDeclaredField("human1");
        Field field2 = clazz.getDeclaredField("human2");
        // 3、根据变量的类型获取其原始类型
        Person person1 = field1.getDeclaredAnnotation(Person.class);
        Person person2 = field2.getDeclaredAnnotation(Person.class);
        // 4、根据变量获取类型
        Class clz = field1.getType();
        // 5、根据类型获取构造方法
        Constructor constructor = clz.getConstructor();
        // 6、根据类型获取实例
        Human human1 = (Human) constructor.newInstance();
        Human human2 = (Human) constructor.newInstance();

        // 7、一通设置
        human1.setName(person1.name());
        human1.setSex(person1.sex());
        human1.setAge(person1.age());
        human2.setName(person2.name());
        human2.setSex(person2.sex());
        human2.setAge(person2.age());

        field1.set(example06,human1);
        field2.set(example06,human2);
    }

    private static void initFieldHuman1(Example06 example06) throws NoSuchFieldException {
        // 1、反射获取example06的类
        Class aClass = example06.getClass();
        // 2、根据name获取类中的变量
        Field field = aClass.getField("human1");
        // 3、根据变量的类型获取其原始类型
        Class type = field.getType();
        // 4、根据变量获取类型

        // 5、根据类型获取构造方法

        // 6、根据类型获取实例

        // 7、一通设置

    }
}
