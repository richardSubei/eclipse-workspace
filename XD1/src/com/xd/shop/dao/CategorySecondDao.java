package com.xd.shop.dao;

import java.util.List;

import com.xd.shop.dao.base.BaseDao;
import com.xd.shop.po.CategorySecond;

public interface CategorySecondDao extends BaseDao<CategorySecond>{

	public List<CategorySecond> findByFId(String categoryFId);
	
	public void deleteBatch(String categoryFId);

}
