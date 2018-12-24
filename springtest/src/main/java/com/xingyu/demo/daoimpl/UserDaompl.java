package com.xingyu.demo.daoimpl;

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

import com.xingyu.demo.pojo.Person;

public class UserDaompl {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Resource
//	private JdbcTemplate jdbcTemplate1;
	
	public void insertByDataSource() {
		
		String sql = "insert into person (id, name) values (1, 'kobe')";
		
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = dataSource.getConnection();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insertByJdbcTemplate() {
		String sql = "insert into person (id, name) values (2, 'james')";
		jdbcTemplate.execute(sql);
		
	}
	
	public List<Person> findAll() {
		String sql = "select * from person";
		List<Person> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Person.class));
		return list;
	}
	
	public Person findById(int id) {
		String sql = "select * from person where id = ?";
		Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Person.class));
		return person;
	}
	
}