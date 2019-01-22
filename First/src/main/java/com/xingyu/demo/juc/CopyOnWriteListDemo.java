package com.xingyu.demo.juc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListDemo {

	public static void main(String[] args) {
		
		List<String> list = new CopyOnWriteArrayList<>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
//			iterator.remove();
			list.remove(iterator.next());
		}
		System.out.println(list.size());
	}
}
