package com.xingyu.demo.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xingyu.demo.dao.BaseDao;

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String namespace;
	
	public String getNamespace() {
		return namespace;
	}
	
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public boolean insert(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getById(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
