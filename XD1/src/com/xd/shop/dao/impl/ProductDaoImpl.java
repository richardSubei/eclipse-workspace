package com.xd.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.xd.shop.dao.ProductDao;
import com.xd.shop.dao.impl.base.BaseDaoImpl;
import com.xd.shop.po.Product;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	public ProductDaoImpl() {
		setNamespace("com.xd.shop.mapper.ProductMapper.");
	}
}
