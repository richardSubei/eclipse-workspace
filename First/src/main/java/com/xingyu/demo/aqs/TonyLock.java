package com.xingyu.demo.aqs;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class TonyLock implements Lock {

	//拥有锁的线程
	volatile AtomicReference<Thread> owner = new AtomicReference<>();
	
	//等待队列
	volatile LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();
	
	@Override
	public boolean tryLock() {
		return owner.compareAndSet(null, Thread.currentThread());	//如果没有线程获取锁，则当前线程获取锁，并返回true，如果有线程获取了锁，则返回false
	}
	
	@Override
	public void lock() {
		boolean addQ = true;
		while(!tryLock()) {
			if (addQ) {
				//加入等待集合, 此处加boolean防止未拿到锁的线程重复放入等待队列
				waiters.offer(Thread.currentThread());
				addQ = false;
			} else {
				//放入等待队列以后，将未拿到锁的线程挂起
				LockSupport.park();	
			}
		}
		//拿到锁以后，将线程从等待队列移除
		waiters.remove(Thread.currentThread());
	}

	@Override
	public void unlock() {
		//释放锁，即将拥有锁的线程置为null
		owner.compareAndSet(Thread.currentThread(), null);
		//将挂起的线程唤醒，然后这些线程开始抢夺锁
		Iterator<Thread> iterator = waiters.iterator();
		while(iterator.hasNext()) {
			Thread t = iterator.next();
			LockSupport.unpark(t);
		}
	}
	
	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
