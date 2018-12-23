package com.xd.shop.dao.impl.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xd.shop.dao.admin.AdminDao;
import com.xd.shop.dao.impl.base.BaseDaoImpl;
import com.xd.shop.po.Admin;

@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

	public AdminDaoImpl() {
		setNamespace("com.xd.shop.mapper.AdminMapper.");
	}
	
	
	@Override
	public Admin findByNameAndPwd(Admin admin) {
		Admin adminSelect = this.getSqlSession().selectOne(getNamespace() + "findByNameAndPwd", admin);
		if (adminSelect != null) {
			return adminSelect;
		} else {
			return null;
		}
	}

}
