package com.xingyu.demo.test;

import java.util.concurrent.atomic.AtomicReference;

public class Test {

	public static void main(String[] args) {

		AtomicReference<Thread> atomicReference = new AtomicReference<>(Thread.currentThread());
		System.out.println(atomicReference);
	}
	
	
}
