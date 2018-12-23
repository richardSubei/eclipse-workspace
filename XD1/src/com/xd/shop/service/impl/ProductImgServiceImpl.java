package com.xd.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xd.shop.dao.ProductImgDao;
import com.xd.shop.dao.impl.ProductImgDaoImpl;
import com.xd.shop.po.Product;
import com.xd.shop.po.ProductImg;
import com.xd.shop.service.ProductImgService;
import com.xd.shop.service.ProductService;

@Service
public class ProductImgServiceImpl implements ProductImgService{
	
	@Resource
	private ProductImgDao productImgDao;

	@Override
	public List<ProductImg> find() {
		return null;
	}

	@Override
	public int insert(ProductImg productImg) {
		return productImgDao.insert(productImg);
	}

	@Override
	public void update(ProductImg productImg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String productImgId) {
		// TODO Auto-generated method stub
		
	}


}
