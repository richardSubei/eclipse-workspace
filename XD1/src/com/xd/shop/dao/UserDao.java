package com.xd.shop.dao;

import com.xd.shop.dao.base.BaseDao;
import com.xd.shop.dao.impl.base.BaseDaoImpl;
import com.xd.shop.po.User;

public interface UserDao extends BaseDao<User> {

	public User getByUserAndPassword(User user);
}
