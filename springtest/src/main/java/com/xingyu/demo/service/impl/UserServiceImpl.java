package com.xingyu.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xingyu.demo.config.AppConfig;
import com.xingyu.demo.context.DBConstants;
import com.xingyu.demo.context.RoutingDataSource;
import com.xingyu.demo.dao.UserDao;
import com.xingyu.demo.dao.impl.UserDaompl;
import com.xingyu.demo.pojo.Person;
import com.xingyu.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired()
	private UserDao userDao;
	
	@RoutingDataSource(DBConstants.MYSQL)
	public void insert(String str) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		System.out.println(context.getBean("userserviceimpl"));
		userDao.insertByJdbcTemplate();
//		userDaompl.insertByJdbcDaoSupport();
	}
	
	public void findAll() {
		List<Person> list = userDao.findAll();
		for (Person person : list) {
			System.out.println(person.toString());
		}
//		System.out.println("===");
	}
	
	public void findById() {
		Person person = userDao.findById(1);
		System.out.println(person.toString());
	}	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userserviceimpl");
//		UserService userServiceImpl = new UserServiceImpl();
//		userServiceImpl.test();
//		userServiceImpl.findAll();
		userServiceImpl.findById();
	}

	
}
