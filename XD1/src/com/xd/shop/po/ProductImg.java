package com.xd.shop.po;

import java.io.Serializable;

public class ProductImg implements Serializable{
	
	private static final long serialVersionUID = 3801127103603887049L;

	private String productImgId;
	private String productId;
	private String productImg;
	private int imgStatus;
	private int imgOrder;
	
	public String getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(String productImgId) {
		this.productImgId = productImgId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public int getImgStatus() {
		return imgStatus;
	}
	public void setImgStatus(int imgStatus) {
		this.imgStatus = imgStatus;
	}
	public int getImgOrder() {
		return imgOrder;
	}
	public void setImgOrder(int imgOrder) {
		this.imgOrder = imgOrder;
	}
	
}
