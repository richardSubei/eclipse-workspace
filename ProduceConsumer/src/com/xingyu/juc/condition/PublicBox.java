package com.xingyu.juc.condition;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PublicBox {

	private int max = 10;
	
	private int min = 2;
	
	private int count = 0;
	
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void increase(int threadNum) throws InterruptedException {
		lock.lock();
		while(count == max) {
			System.out.println("仓库个数" + count + ", 仓库已满，停止生产");
			condition.await();
		}
		count++;
		System.out.println("生产者" + threadNum + "生产一个，当前库存" + count);
		condition.signalAll();
		lock.unlock();		//应当在finally中释放
		Thread.sleep((long)Math.random()*10);

	}
	
	public void decrease(int threadNum) throws InterruptedException {
		lock.lock();		
		while(count <= min) {
			System.out.println("消费者" + threadNum + "前来消费，对不起，" + "仓库个数" + count + ", 库存不足，停止购买");
			condition.await();
		}
		count--;
		System.out.println("消费者" + threadNum + "消费一个，当前库存" + count);
		condition.signalAll();
		lock.unlock();		//应当在finally中释放
		Thread.sleep((long)Math.random()*10);
		
	}
	
}
