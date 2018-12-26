package com.xingyu.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xingyu.demo.dao.BaseDao;

public class BaseDaoImpl implements BaseDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
}
