package com.xingyu.demo.tomcat;
import java.util.HashMap;
import java.util.Map;

public class WebXml {

	private String projectPath = "";
	
	//存名称和全限定类名
	private Map<String, Object> servlets = new HashMap<>();	
	
	//存名字和映射路径
	private Map<String, Object> servletMapping = new HashMap<>();
	
	//存映射路径和实例的关系
	private Map<String, Object> mappingToInstance = new HashMap<>();
	

	public Map<String, Object> getMappingToInstance() {
		return mappingToInstance;
	}

	public void setMappingToInstance(Map<String, Object> mappingToInstance) {
		this.mappingToInstance = mappingToInstance;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public Map<String, Object> getServlets() {
		return servlets;
	}

	public void setServlets(Map<String, Object> servlets) {
		this.servlets = servlets;
	}

	public Map<String, Object> getServletMapping() {
		return servletMapping;
	}

	public void setServletMapping(Map<String, Object> servletMapping) {
		this.servletMapping = servletMapping;
	}
	
	//存名字和实例
//	private Map<String, Object> servletInstance = new HashMap<>();
	
	
}
