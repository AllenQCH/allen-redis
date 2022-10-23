package com.annotation.example04;

import java.lang.annotation.*;

@Target({ElementType.FIELD}) //声明应用在属性上
@Retention(RetentionPolicy.RUNTIME) //运行期生效
@Documented
public @interface Boy {

    String name() default "";
}