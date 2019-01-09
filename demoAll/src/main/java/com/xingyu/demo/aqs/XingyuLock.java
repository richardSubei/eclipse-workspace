package com.xingyu.demo.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class XingyuLock implements Lock {

	XingyuAQS sync = new XingyuAQS() {
		public boolean tryAcquire() {
			return owner.compareAndSet(null, Thread.currentThread());
		};
		
		public boolean tryRelease() {
			return owner.compareAndSet(Thread.currentThread(), null);
		};
	};
	
	
	@Override
	public boolean tryLock() {
		return sync.tryAcquire();
	}
	
	@Override
	public void lock() {
		sync.acquire();
	}

	@Override
	public void unlock() {
		sync.release();
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
