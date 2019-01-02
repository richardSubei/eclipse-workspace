package com.xingyu.demo.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheLoader;
import com.xingyu.demo.dao.UserDao;
import com.xingyu.demo.pojo.User;

@Component
public class UserCacheLoader extends CacheLoader<Object, Object>{
	
	@Autowired
	private UserDao<User> userDao;
	
//	public UserCacheLoader(UserDao<User> userDao) {
//		this.userDao = userDao;
//	}
	
	
	@Override
	public Object load(Object key) throws Exception {
		System.out.println("userDao===" + userDao );
		User user = userDao.getById((User) key);
//		User user = new User();
//		user.setId(1);
//		user.setName("kobe");
//		user.setAge(18);
//		System.out.println("重新加载");
		return user;
	}

}
