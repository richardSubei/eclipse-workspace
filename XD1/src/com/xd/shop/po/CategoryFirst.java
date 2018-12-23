package com.xd.shop.po;

import java.io.Serializable;
import java.util.List;

public class CategoryFirst implements Serializable{

	private static final long serialVersionUID = -3763996317871763595L;
	
	private String categoryFId;
	private String categoryFName;
	private Integer categoryFStatus;
	private List<CategorySecond> categorySeconds;
	
	public List<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(List<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	public String getCategoryFId() {
		return categoryFId;
	}
	public void setCategoryFId(String categoryFId) {
		this.categoryFId = categoryFId;
	}
	public String getCategoryFName() {
		return categoryFName;
	}
	public void setCategoryFName(String categoryFName) {
		this.categoryFName = categoryFName;
	}
	public Integer getCategoryFStatus() {
		return categoryFStatus;
	}
	public void setCategoryFStatus(Integer categoryFStatus) {
		this.categoryFStatus = categoryFStatus;
	}

	
	
}
