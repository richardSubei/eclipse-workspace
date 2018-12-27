package com.xingyu.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xingyu.demo.context.DBContextHolder;
import com.xingyu.demo.dao.UserDao;
import com.xingyu.demo.pojo.Person;

@Repository
public class UserDaompl extends BaseDaoImpl implements UserDao{

//	@Autowired
//	private DataSource dataSource;
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
//	@Resource
//	private JdbcTemplate jdbcTemplate1;
	
//	public void insertByDataSource() {
//		
//		String sql = "insert into person (id, name) values (1, 'kobe')";
//		
//		Connection conn = null;
//		PreparedStatement pst = null;
//		try {
//			conn = dataSource.getConnection();
//			pst = conn.prepareStatement(sql);
//			pst.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				pst.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
	public void insertByJdbcTemplate() {
		String sql = "insert into user (id, name,age) values (1, 'kobe',18)";
		jdbcTemplate.execute(sql);
		
	}
	
	public List<Person> findAll() {
		String sql = "select * from user";
		List<Person> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Person.class));
		return list;
	}
	
	public Person findById(int id) {
		String sql = "select * from user where id = ?";
		Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Person.class));
		return person;
	}
	
}
