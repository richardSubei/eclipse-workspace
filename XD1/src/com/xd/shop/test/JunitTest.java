package com.xd.shop.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xd.shop.controller.UserController;
import com.xd.shop.po.CategoryFirst;
import com.xd.shop.po.User;
import com.xd.shop.service.CategoryService;
import com.xd.shop.service.UserService;
import com.xd.shop.service.impl.CategoryServiceImpl;
import com.xd.shop.service.impl.UserServiceImpl;

public class JunitTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testSmsCodeFactory() {
//		UserController uc = new UserController();
//		System.out.println(uc.SmsCodeFactory());
//	}

//	@Test
//	public void testUserInsert() {
//		User user = new User();
//		user.setUserPhone("15550185615");
//		user.setUserName("苏备");
//		user.setUserPassword("1234");
//		user.setUserAvatar("abc");
//		user.setRegisterDate(new Date());
//		user.setUserLevel("铂金会员");
//		user.setUserPoints(100000);
//		user.setUserStatus(1);
//		
//		UserService userService = new UserServiceImpl();
//		userService.insert(user);
//	}
//	
//	@Test
//	public void testCategoryCascade() {
//		CategoryService categoryService = new CategoryServiceImpl();
//		List<CategoryFirst> list = categoryService.find();
//		for (CategoryFirst categoryFirst : list) {
//			System.out.println(categoryFirst);
//		}
//	}
}
