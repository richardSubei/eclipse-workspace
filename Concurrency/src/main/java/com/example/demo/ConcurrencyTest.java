package com.example.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import com.example.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class ConcurrencyTest {

	public static int clientTotal = 5000;
	
	public static int threadTotal = 200;
	
	public static int count = 0;				//AutomicInteger 保证原子操作
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(threadTotal);
		CountDownLatch latch = new CountDownLatch(clientTotal);
		
		for (int i=0; i < clientTotal; i++) {
			service.execute(() -> {
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {

				}
				latch.countDown();
			});
		}
		try {
			latch.await();
			service.shutdown();
			System.out.println(latch.getCount());
			System.out.println(count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void add() {
		count++;
	}
	
}
