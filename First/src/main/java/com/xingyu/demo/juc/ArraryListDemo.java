package com.xingyu.demo.juc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 非线程安全
 * @author forever11270201
 *
 */
public class ArraryListDemo {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
//			iterator.remove();
			list.remove(iterator.next());
		}
		
	}

}
