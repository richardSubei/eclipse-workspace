package com.xingyu.demo.test;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryTest {

	public static List<User> list = new ArrayList<User>();
	
	public static void main(String[] args) throws InterruptedException{
		new OutOfMemoryTest().heap();
	}
	
	//堆内存溢出
	public void heap() {
		while (true) {
			list.add(new User(0, "kobe"));
			System.out.println("==");
		}
	}
	
	public void nonHeap() {
		String str = "123";
		while (true) {
			str = str + "123";
			System.out.println("==");
		}
	}
	
	class User {
		private int id;
		private String name;
		
		public User(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
}
