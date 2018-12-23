package com.xd.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.xd.shop.dao.CategorySecondDao;
import com.xd.shop.dao.impl.base.BaseDaoImpl;
import com.xd.shop.po.CategorySecond;

@Controller
public class CategorySecondDaoImpl extends BaseDaoImpl<CategorySecond> implements CategorySecondDao{

	public CategorySecondDaoImpl() {
		setNamespace("com.xd.shop.mapper.CategorySecondMapper.");
	}

	@Override
	public List<CategorySecond> findByFId(String categoryFId) {
		return this.getSqlSession().selectList(getNamespace() + "findByFId", categoryFId);
	}

	@Override
	public void deleteBatch(String categoryFId) {
		 this.getSqlSession().selectList(getNamespace() + "deleteBatch", categoryFId);
	}
}
