package com.xd.shop.dao.admin;

import java.util.List;

import com.xd.shop.dao.base.BaseDao;
import com.xd.shop.po.Admin;

public interface AdminDao extends BaseDao<Admin>{

	public Admin findByNameAndPwd(Admin admin);
}
