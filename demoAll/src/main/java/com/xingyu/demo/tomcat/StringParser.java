package com.xingyu.demo.tomcat;
import java.util.HashMap;
import java.util.Map;

public class StringParser {

	
	/**此处只解析路径*/
	public static Map<String, String> parseHeader(String header) {
		Map<String, String> map = new HashMap<>();
		String[] first = header.split(" ");	//以空各分开请求方式、路径、协议
		String[] second = first[1].split("/");
		String projectPath = second[1];
		String servletUrl = second[2];
		map.put("projectPath", projectPath);
		map.put("servletUrl", servletUrl);
		return map;
	}
}
