package com.xingyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.xingyu.demo.service.UserService;
import com.xingyu.demo.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	

	public void findAll() {
		userService.findAll();
	}

	public void findById() {
		userService.findById();
	}
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserController userController = (UserController) context.getBean("userController");
		userController.findAll();
	}
}
