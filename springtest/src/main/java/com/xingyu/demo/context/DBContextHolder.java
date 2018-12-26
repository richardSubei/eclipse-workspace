package com.xingyu.demo.context;


public class DBContextHolder {

	private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	
	public static void setDBType(String DBType) {
		contextHolder.set(DBType);
	}
	
	public static String getDBType() {
		return contextHolder.get();
	}
	
	public static void removeDBType() {
		contextHolder.remove();
	}
}
