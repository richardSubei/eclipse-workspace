package com.example.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBolean {

	//AtomicBoolean的 compareAndSet 方法 常用来保证代码只执行一次
	private static AtomicBoolean flag = new AtomicBoolean(false);
	
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			test();
		}
		
		
	}
	
	public static void test() {
		if (flag.compareAndSet(false, true)) {
			System.out.println("执行");
		}
	}
}
