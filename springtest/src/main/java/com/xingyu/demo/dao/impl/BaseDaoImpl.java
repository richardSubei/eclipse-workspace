package com.xingyu.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xingyu.demo.dao.BaseDao;

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String namespace;
	
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	//高版本的mybatis貌似修改了SqlSessionDaoSupport中的SqlSessionFactory的注入方式，此处需要手动注入
	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public int insert(T t) {
		getSqlSession().insert(namespace + "insert", t);
		return 1;
	}

	public T getById(T t) {
		T t2 = getSqlSession().selectOne(namespace + "getById", t);
		return t2;
	}

	public List<T> getAll() {
		return getSqlSession().selectList(namespace + "getAll");
	}

}
