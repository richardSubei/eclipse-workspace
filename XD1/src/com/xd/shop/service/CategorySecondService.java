package com.xd.shop.service;

import java.util.List;

import com.xd.shop.po.CategorySecond;

public interface CategorySecondService {

	public List<CategorySecond> find();
	
	public List<CategorySecond> findByFId(String categoryFId);
	
	public int insert(CategorySecond categorySecond);
	
	public int update(CategorySecond categorySecond);
	
	public int delete(String categorySId);
	
	public void deleteBatch(String categoryFId);
}
