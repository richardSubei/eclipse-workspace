package com.xingyu.demo.jmm;

public class VisibleDemo {

	private static  boolean flag = true;
	
	public static void main(String[] args) throws InterruptedException{
		new Thread(() -> {
			int i = 0;
			while (flag) {
				i++;
			}
			System.out.println(i);
		}).start();
		Thread.sleep(2000);
		flag = false;
		System.out.println("flag false");
	}
	
}
