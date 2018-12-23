package com.xd.shop.dao;

import java.util.List;
import java.util.Map;

import com.xd.shop.dao.base.BaseDao;
import com.xd.shop.po.CategoryFirst;

public interface CategoryDao extends BaseDao<CategoryFirst>{

	public CategoryFirst findCategoryFById(String categoryFId);
	
	public void updateCategoryF(Map<String, String> map);
	
	public List<CategoryFirst> findForSelect();
	
}
