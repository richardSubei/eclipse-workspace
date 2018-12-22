package com.xingyu.demo.tomcat;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class ClassLoader {

	
	/**servlet实例化 */
	public Map<String, Object> loadClass(WebXml webXml) {
		Map<String, Object> mapServlets = webXml.getServlets();
		Map<String, Object> mapServletMapping = webXml.getServletMapping();
		Map<String, Object> mapInstance = new HashMap<>();
		@SuppressWarnings("resource")
		URLClassLoader loader;
		try {
			loader = new URLClassLoader(new URL[] {new URL("file:" + webXml.getProjectPath() + "/WEB-INF/classes")});
			
			for (Entry<String, Object> entry : mapServlets.entrySet()) {
				for (Entry<String, Object> entry2 : mapServletMapping.entrySet()) {
					String servletName = entry.getKey().toString();
					String servletName2 = entry2.getKey().toString();
					if (servletName == servletName2) {
						String servletMapping = entry2.getValue().toString();
						String servletClassName = entry.getValue().toString();
						//加载到jvm
						Class<?> serlvetClass = loader.loadClass(servletClassName);
						//反射实例化
						Object servletInstance =  serlvetClass.newInstance();
						System.out.println(servletClassName + "已实例化");
						mapInstance.put(servletMapping, servletInstance);
					}
					
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException  | IllegalAccessException e) {
			e.printStackTrace();

		}

		return mapInstance;
	}
}
