package com.xingyu.demo.service;

import com.xingyu.demo.pojo.User;

public interface UserService {
	
	 void insert(User user);

	 void getAll();

	 void getById(User user);
}
