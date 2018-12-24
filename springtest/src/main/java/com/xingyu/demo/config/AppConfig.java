package com.xingyu.demo.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.xingyu.demo.pojo.Person;

//@Configuration
//@Import({AddressConfig.class, PersonConfig.class})
public class AppConfig {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = (Person) context.getBean("person");
		System.out.println(person.toString());
	}
}
