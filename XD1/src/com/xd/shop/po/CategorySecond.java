package com.xd.shop.po;

import java.io.Serializable;

public class CategorySecond implements Serializable{

	private static final long serialVersionUID = -1703492813282928778L;

	private String categorySId;
	private String categorySName;
	private Integer categorySStatus;
	private CategoryFirst categoryFirst;
	
	public String getCategorySId() {
		return categorySId;
	}
	public void setCategorySId(String categorySId) {
		this.categorySId = categorySId;
	}
	public String getCategorySName() {
		return categorySName;
	}
	public void setCategorySName(String categorySName) {
		this.categorySName = categorySName;
	}
	public Integer getCategorySStatus() {
		return categorySStatus;
	}
	public void setCategorySStatus(Integer categorySStatus) {
		this.categorySStatus = categorySStatus;
	}
	public CategoryFirst getCategoryFirst() {
		return categoryFirst;
	}
	public void setCategoryFirst(CategoryFirst categoryFirst) {
		this.categoryFirst = categoryFirst;
	}	
	
}
