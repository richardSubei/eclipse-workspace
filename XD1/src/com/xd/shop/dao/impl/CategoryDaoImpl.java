package com.xd.shop.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xd.shop.dao.CategoryDao;
import com.xd.shop.dao.impl.base.BaseDaoImpl;
import com.xd.shop.po.CategoryFirst;

@Repository
public class CategoryDaoImpl extends BaseDaoImpl<CategoryFirst>implements CategoryDao {

	public CategoryDaoImpl() {
		setNamespace("com.xd.shop.mapper.CategoryFirstMapper.");
	}

	@Override
	public CategoryFirst findCategoryFById(String categoryFId) {
		CategoryFirst categoryFirst = this.getSqlSession().selectOne(getNamespace() + "findCategoryFById", categoryFId);
		return categoryFirst;
	}

	@Override
	public void updateCategoryF(Map<String, String> map) {
		this.getSqlSession().update(getNamespace() + "updateCategoryF", map);
	}

	@Override
	public List<CategoryFirst> findForSelect() {
		return this.getSqlSession().selectList(getNamespace() + "findForSelect");
	}
}
