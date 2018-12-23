package com.xd.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xd.shop.dao.UserDao;
import com.xd.shop.dao.impl.base.BaseDaoImpl;
import com.xd.shop.po.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public UserDaoImpl() {
		setNamespace("com.xd.shop.mapper.UserMapper.");
	}

	@Override
	public User getByUserAndPassword(User user) {
		User userSelect = this.getSqlSession().selectOne(this.getNamespace() + "getByUserAndPassword", user);
		if (userSelect != null) {
			return userSelect;
		} else {
			return null;
		}
	}
}
