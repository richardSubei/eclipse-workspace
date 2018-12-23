package com.xd.shop.po;

import java.io.Serializable;

public class Admin implements Serializable{

	private static final long serialVersionUID = 6382627975421726655L;

	private String adminId;
	private String adminName;
	private String adminPassword;
	private Integer adminStatus;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Integer getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(Integer adminStatus) {
		this.adminStatus = adminStatus;
	}
	
	
	
	
}
