package com.xd.shop.service;

import java.util.List;
import java.util.Map;

import com.xd.shop.po.CategoryFirst;
import com.xd.shop.po.CategorySecond;

public interface CategoryService {

	public List<CategoryFirst> find();
	
	public CategoryFirst findCategoryFById(String categoryFId);
	
	public void updateCategoryF(Map<String, String> map);
	
	public int insert(CategoryFirst categoryFirst);
	
	public int delete(String categoryFId);
	
	public List<CategoryFirst> findForSelect();
	
}
