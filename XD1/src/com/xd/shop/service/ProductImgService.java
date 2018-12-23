package com.xd.shop.service;

import java.util.List;

import com.xd.shop.po.Product;
import com.xd.shop.po.ProductImg;

public interface ProductImgService {

	public List<ProductImg> find();
	
	public int insert(ProductImg productImg);
	
	public void update(ProductImg productImg);
	
	public void delete(String productImgId);
	
}
