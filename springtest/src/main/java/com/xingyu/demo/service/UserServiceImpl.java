package com.xingyu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.xingyu.demo.config.AppConfig;
import com.xingyu.demo.daoimpl.UserDaompl;
import com.xingyu.demo.pojo.Person;

@Service
public class UserServiceImpl {

//	@Autowired
	private UserDaompl userDaompl;
	
	//set ·½·¨×¢Èë
	public void setUserDaompl(UserDaompl userDaompl) {
		this.userDaompl = userDaompl;
	}
	
	public void test() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		System.out.println(context.getBean("userserviceimpl"));
		userDaompl.insertByJdbcTemplate();
//		userDaompl.insertByJdbcDaoSupport();
	}
	
	public void findAll() {
		List<Person> list = userDaompl.findAll();
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}
	
	public void findById() {
		Person person = userDaompl.findById(2);
		System.out.println(person.toString());
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userserviceimpl");
//		userServiceImpl.test();
//		userServiceImpl.findAll();
		userServiceImpl.findById();
	}
	
}
