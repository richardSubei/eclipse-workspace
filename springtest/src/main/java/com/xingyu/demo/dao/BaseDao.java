package com.xingyu.demo.dao;

import java.util.List;


public interface BaseDao<T> {

	public int insert(T t);
	
	public T getById(T t);
	
	public List<T> getAll();
	
	
}
