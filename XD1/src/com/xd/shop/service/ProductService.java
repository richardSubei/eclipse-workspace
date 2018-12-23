package com.xd.shop.service;

import java.util.List;

import com.xd.shop.po.Product;

public interface ProductService {

	public List<Product> find();
	
	public int insert(Product product);
	
	public void update(Product product);
	
	public void delete(String productId);
	
}
