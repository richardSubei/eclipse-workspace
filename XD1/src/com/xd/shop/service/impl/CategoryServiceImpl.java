package com.xd.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xd.shop.dao.CategoryDao;
import com.xd.shop.po.CategoryFirst;
import com.xd.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<CategoryFirst> find() {
		List<CategoryFirst> list = categoryDao.find();
		if (list.size() > 0 && list != null) {
			return list;			
		} else {
			return null;
		}
	}

	@Override
	public CategoryFirst findCategoryFById(String categoryFId) {
		return categoryDao.findCategoryFById(categoryFId);
	}

	@Override
	public void updateCategoryF(Map<String, String> map) {
		categoryDao.updateCategoryF(map);
	}

	@Override
	public int insert(CategoryFirst categoryFirst) {
		return categoryDao.insert(categoryFirst);
	}

	@Override
	public int delete(String categoryFId) {
		return categoryDao.delete(categoryFId);
	}

	@Override
	public List<CategoryFirst> findForSelect() {
		return categoryDao.findForSelect();
	}

}
