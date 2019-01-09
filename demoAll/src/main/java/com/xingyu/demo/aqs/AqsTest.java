package com.xingyu.demo.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class AqsTest {

	static volatile int count = 0;
	
	static volatile CountDownLatch latch = new CountDownLatch(2);
	
	public static void main(String[] args) throws Exception {
		ReentrantLock reentrantLock = new ReentrantLock();
		TonyLock tonyLock = new TonyLock();
		XingyuLock xingyuLock = new XingyuLock();
		
		for (int i = 0; i < 2; i++) {
			new Thread(() ->  {
				for (int j = 0; j < 10000; j++) {
//					reentrantLock.lock();
//					tonyLock.lock();
					xingyuLock.lock();
					count++;
//					reentrantLock.unlock();
//					tonyLock.unlock();
					xingyuLock.unlock();
				}
				latch.countDown();
			}).start();
		}
		latch.await();
		System.out.println(count);
		
	}
	
}
