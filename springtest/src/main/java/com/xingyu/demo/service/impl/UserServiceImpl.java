package com.xingyu.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ibm.db2.jcc.am.u;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xingyu.demo.config.AppConfig;
import com.xingyu.demo.context.DBConstants;
import com.xingyu.demo.context.RoutingDataSource;
import com.xingyu.demo.dao.UserDao;
import com.xingyu.demo.dao.impl.UserDaoImpl;
import com.xingyu.demo.pojo.Person;
import com.xingyu.demo.pojo.User;
import com.xingyu.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired()
	private UserDao userDao;
	
	@RoutingDataSource(DBConstants.MYSQL)
	public void insert(User user) {
//		userDao.insertByJdbcTemplate();
//		userDaompl.insertByJdbcDaoSupport();
		userDao.insert(user);		
	}
	
	public void getById(User user) {
		User user2 = (User) userDao.getById(user);
		System.out.println(user2.toString());
	}	
	
	public void getAll() {
		List<User> list = userDao.getAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
	}


	
}
