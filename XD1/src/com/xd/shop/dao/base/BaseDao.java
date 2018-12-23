package com.xd.shop.dao.base;

import java.util.List;

public interface BaseDao<T> {

	int insert(T t);
	
	void update(T t);
	
	T get(String id);
	
	List<T> find();
	
	int delete(String id);
}
