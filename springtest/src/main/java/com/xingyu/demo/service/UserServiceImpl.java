package com.xingyu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.xingyu.demo.daoimpl.UserDaompl;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDaompl userDaompl;
	
	public void test() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		System.out.println(context.getBean("userserviceimpl"));
		userDaompl.insertByDataSource();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userserviceimpl");
		userServiceImpl.test();
		
	}
	
}
