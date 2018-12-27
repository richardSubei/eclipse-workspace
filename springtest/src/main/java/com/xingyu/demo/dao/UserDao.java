package com.xingyu.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.xingyu.demo.pojo.Person;


public interface UserDao {

	public void insertByJdbcTemplate() ;
	
	public List<Person> findAll() ;
	
	public Person findById(int id) ;
	
}