package com.xingyu.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

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

	public int insert(T t) {
		getSqlSession().insert(namespace + "insert", t);
		return 1;
	}

	public T getById(T t) {
		// TODO Auto-generated method stub
		return t;
	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<T>();
	}

}
