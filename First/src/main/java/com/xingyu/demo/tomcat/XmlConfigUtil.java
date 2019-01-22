package com.xingyu.demo.tomcat;
import java.util.HashMap;
import java.util.Map;

public class XmlConfigUtil {

	private String xmlPath = "";
	
	/**根据路径去解析xml*/
	public WebXml parseWebXml(String xmlPath) {
		WebXml webXml = new WebXml();
		
		Map<String, Object> servlets = new HashMap<>();
		Map<String, Object> servletMapping = new HashMap<>();
		
		servlets.put("login", "LoginServlet");
		servletMapping.put("login", "/login");
		
		webXml.setServlets(servlets);
		webXml.setServletMapping(servletMapping);
		return webXml;
	}
}
