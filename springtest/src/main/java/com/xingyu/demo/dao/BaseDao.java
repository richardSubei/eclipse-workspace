package com.xingyu.demo.dao;


public interface BaseDao<T> {

	public boolean insert(T t);
	
	public boolean getById(T t);
	
	public boolean getAll();
	
	
}
