package com.xingyu.demo.cas;

import java.util.concurrent.atomic.AtomicInteger;

import sun.misc.Unsafe;

public class CasTest {

//	static volatile int value = 0;
	static AtomicInteger value = new AtomicInteger(0);
	
	private static Unsafe unsafe;
	
	static {
//		unsafe = Unsafe.class.getDeclaredField("theUnsafe");
	}
	
	
	
	public static void main(String[] args) throws Exception{
		
		for (int i = 0; i < 2; i++) {
			new Thread(() -> {
				for (int j = 0; j<10000; j++) {
//					value++;
					value.incrementAndGet();
				}
			}).start();
		}
		
		Thread.sleep(3000);
		System.out.println(value);
	}
	
	
}
