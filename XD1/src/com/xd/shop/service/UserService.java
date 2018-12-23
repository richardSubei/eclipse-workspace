package com.xd.shop.service;

import com.xd.shop.po.User;

public interface UserService {

	public int insert(User user);
	
	public User getByUserAndPassword(User user);
	
}
