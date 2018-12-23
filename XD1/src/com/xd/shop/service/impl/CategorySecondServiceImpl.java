package com.xd.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xd.shop.dao.CategorySecondDao;
import com.xd.shop.po.CategorySecond;
import com.xd.shop.service.CategorySecondService;

@Service
public class CategorySecondServiceImpl implements CategorySecondService{

	@Resource
	private CategorySecondDao categorySecondDao;
	
	@Override
	public List<CategorySecond> find() {
		return categorySecondDao.find();
	}

	@Override
	public List<CategorySecond> findByFId(String categoryFId) {
		return categorySecondDao.findByFId(categoryFId);
	}

	@Override
	public int insert(CategorySecond categorySecond) {
		return categorySecondDao.insert(categorySecond);
	}

	@Override
	public int update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String categorySId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteBatch(String categoryFId) {
		categorySecondDao.deleteBatch(categoryFId);
	}



}
