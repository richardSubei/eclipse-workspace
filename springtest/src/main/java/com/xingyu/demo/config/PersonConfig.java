package com.xingyu.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xingyu.demo.pojo.Person;

//@Configuration
public class PersonConfig {

//	@Bean(name="person")
	public Person person() {
		Person person = new  Person();
		person.setId(1);
		person.setName("kobe");
		return person;
	}

}
