package com.xd.shop.service.impl.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.xd.shop.dao.admin.AdminDao;
import com.xd.shop.po.Admin;
import com.xd.shop.service.admin.AdminService;

@Controller
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao;
	
	@Override
	public Admin findByNameAndPwd(Admin admin) {
		return adminDao.findByNameAndPwd(admin);
	}

}
