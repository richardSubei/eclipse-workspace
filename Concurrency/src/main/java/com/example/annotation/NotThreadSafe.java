package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记非线程安全的类或者写法
 * @author forever11270201
 *
 */
@Target(ElementType.TYPE)	//Target注解标记自定义注解可以用在类上还是方法上或是其他
@Retention(RetentionPolicy.SOURCE)	//Rentention注解标记该自定义注解的生命周期，source只存在于源文件中，class存在于源文件和编译后的class文件中，runtime存在于整个生命周期
public @interface NotThreadSafe {
	String value() default "";
}
