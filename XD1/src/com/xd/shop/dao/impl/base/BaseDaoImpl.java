package com.xd.shop.dao.impl.base;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xd.shop.dao.base.BaseDao;


public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{

	private String namespace;
	
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public int insert(T t) {
		return this.getSqlSession().insert(namespace + "insert", t);
	}

	@Override
	public void update(T t) {
		this.getSqlSession().update(namespace + "update", t);
	}

	@Override
	public T get(String id) {
		T t = this.getSqlSession().selectOne(namespace + "get", id);
		if (t != null) {
			return t;
		} else {
			return null;
		}
	}

	@Override
	public List<T> find() {
		List<T> list = this.getSqlSession().selectList(namespace + "find");
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;			
		}
	}
	
	@Override
	public int delete(String id) {
		return this.getSqlSession().delete(namespace + "delete", id);
	}
	
	

}
