package com.xd.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xd.shop.dao.ProductDao;
import com.xd.shop.po.Product;
import com.xd.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Resource
	private ProductDao productDao;
	
	@Override
	public List<Product> find() {
		return productDao.find();
	}

	@Override
	public int insert(Product product) {
		return productDao.insert(product);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public void delete(String productId) {
		productDao.delete(productId);
	}

}
