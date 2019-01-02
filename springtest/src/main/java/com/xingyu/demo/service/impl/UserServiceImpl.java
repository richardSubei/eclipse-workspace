package com.xingyu.demo.service.impl;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import com.ibm.db2.jcc.am.li;
import com.ibm.db2.jcc.am.u;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xingyu.demo.cache.GuavaCache;
import com.xingyu.demo.cache.UserCacheLoader;
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
	private UserDao<User> userDao;
	
//	LoadingCache<Object, Object> cache = GuavaCache.getLoadingCache();
	
	private RateLimiter limiter = RateLimiter.create(10);
	
	private Semaphore semaphore = new Semaphore(10);
	
	private ExecutorService executor = Executors.newFixedThreadPool(20);
	
	private CountDownLatch latch = new CountDownLatch(100);
	
	@RoutingDataSource(DBConstants.MYSQL)
	public void insert(User user) {
//		userDao.insertByJdbcTemplate();
//		userDaompl.insertByJdbcDaoSupport();
		for(int i = 0; i < 100; i++) {
			final int x = i;
			executor.execute(() -> {
				try {
//					semaphore.acquire();
//					userDao.insert(user);	
//					Thread.sleep(2000);
//					System.out.println(x);
//					semaphore.release();
//					latch.countDown();
					
					limiter.acquire();
					userDao.insert(user);
					Thread.sleep(2000);
					System.out.println(x);
					latch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RoutingDataSource(DBConstants.MYSQL)
	public void getById(User user) {
		User user2 = (User) userDao.getById(user);
//		try {
//			User user2 = (User) cache.get(user);
			System.out.println(user2.toString());
//			System.out.println(cache.asMap().size());
//		} catch (ExecutionException e) {
// 		}
	}	
	
	public void getAll() {
		List<User> list = userDao.getAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
	}


	
}
