package com.xd.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.xd.shop.dao.ProductImgDao;
import com.xd.shop.dao.impl.base.BaseDaoImpl;
import com.xd.shop.po.ProductImg;

@Repository
public class ProductImgDaoImpl extends BaseDaoImpl<ProductImg> implements ProductImgDao {

	public ProductImgDaoImpl() {
		setNamespace("com.xd.shop.mapper.ProductImgMapper.");
	}
}
