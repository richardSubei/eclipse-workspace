package com.xingyu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.xingyu.demo.pojo.User;
import com.xingyu.demo.service.UserService;
import com.xingyu.demo.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public void insert() {
		User user = new User();
		user.setId(2);
		user.setName("kobe");
		user.setAge(18);
		userService.insert(user);
	}
	
	public void getById() {
		User user = new User();
		user.setId(1);
		userService.getById(user);
	}

	public void getAll() {
		userService.getAll();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserController userController = (UserController) context.getBean("userController");
		userController.insert();
//		userController.getAll();
	}
}
