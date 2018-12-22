package com.xingyu.demo.tomcat;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;


public class ProjectLoader {

	private static String webapps = "/Users/forever11270201/demo";
	
	
	public static Map<String, Map<String, Object>> load() {
		Map<String, Map<String, Object>> resultInstance = new HashMap<>();
		//1.解压webapps下项目war包
		
		//2.列出webapps下所有文件夹，即每个项目
		File[] files = new File(webapps).listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory();
			}
		});
		//3.去实例化每个项目中的servlet
		for (File file : files) {
			System.out.println("解析"+file+"项目的web.xml");
			//1.解析web.xml得到serlvet名字，类名，映射路径
			WebXml xml = new XmlConfigUtil().parseWebXml(file.getAbsolutePath() + "\\WEB_INF\\web.xml");
			xml.setProjectPath(file.getAbsolutePath());
			//2.根据xml实例化servlet
			Map<String, Object> mapInstance = new ClassLoader().loadClass(xml);
			resultInstance.put(xml.getProjectPath(), mapInstance);
		}
		return resultInstance;
		
	}
	
}
