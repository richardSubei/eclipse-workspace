package com.xingyu.demo.aqs;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * 抽象队列同步器
 * @author forever11270201
 *
 */
public class XingyuAQS {

	public volatile AtomicReference<Thread> owner = new AtomicReference<Thread>();
	
	public volatile LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();
	
	public volatile AtomicInteger state = new AtomicInteger(0);
	
	//定义了 如何获取到锁
	public boolean tryAcquire() {
		throw new UnsupportedOperationException("AQS未实现此方法，交由子类实现");
	}
	
	//定义了 
	public void acquire() {
		boolean addQ = true;
		while(!tryAcquire()) {
			if (addQ) {
				//加入等待队列
				waiters.offer(Thread.currentThread());
				addQ = false;
			} else {
				//挂起当前线程
				LockSupport.park();		//用while循环防止伪唤醒
			}
		}
		//获取到锁之后，将线程从等待队列中移除
		waiters.remove(Thread.currentThread());
	}
	
	
	public boolean tryRelease() {
		throw new UnsupportedOperationException("AQS未实现此方法，交由子类实现");
	}
	
	public void release() {
		if (tryRelease()) {
			Iterator<Thread> iterator = waiters.iterator();
			while (iterator.hasNext()) {
				Thread t = iterator.next();
				LockSupport.unpark(t);
			}
		}
	}
	 
}
