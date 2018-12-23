package com.xd.shop.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Product implements Serializable{

	private static final long serialVersionUID = -1169800729650168312L;
	
	private String productId;
	private String categorySId;
	private String productNo;
	private String productName;
	private double productPrice;
	private int inventory;
	private int productSalesTotal;
	private int productStatus;
	private String productRemark;
	private List<ProductImg> productImgs;
	
	public List<ProductImg> getProductImgs() {
		return productImgs;
	}
	public void setProductImgs(List<ProductImg> productImgs) {
		this.productImgs = productImgs;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategorySId() {
		return categorySId;
	}
	public void setCategorySId(String categorySId) {
		this.categorySId = categorySId;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getProductSalesTotal() {
		return productSalesTotal;
	}
	public void setProductSalesTotal(int productSalesTotal) {
		this.productSalesTotal = productSalesTotal;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductRemark() {
		return productRemark;
	}
	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}
	
}
