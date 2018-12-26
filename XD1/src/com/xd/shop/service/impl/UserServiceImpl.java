package com.xd.shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xd.shop.dao.UserDao;
import com.xd.shop.dao.impl.UserDaoImpl;
import com.xd.shop.po.User;
import com.xd.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public User getByUserAndPassword(User user) {
		return userDao.getByUserAndPassword(user);
	}

}
