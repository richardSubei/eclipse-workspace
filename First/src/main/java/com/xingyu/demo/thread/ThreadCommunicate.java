package com.xingyu.demo.thread;

/**
 * @author forever11270201 线程间的通讯方式 文件共享、网络共享、变量共享、API 1.suspend resume 被弃用
 *         容易写出死锁的代码，suspend不释放锁， resume一定要在suspend之后执行，否则无法唤醒 2.wait notify
 *         释放锁，但是对执行顺序有要求，保证notify方法在wait之后执行，否则无法唤醒 3.park unpark
 *         对执行顺序无要求，但是不释放锁，不要在同步代码块中使用，否则容易死锁
 * 
 *         最重要的一点-伪唤醒 对于挂起的线程，不是调用notify、unpark等方法唤醒的，而是由于底层的一些机制唤醒的，称为伪唤醒，
 *         所以不应使用if做判断，而应该用while，否则会影响到程序执行逻辑
 */
public class ThreadCommunicate {

	Object baozidian = null;

	public static void main(String[] args) throws Exception {
		// new ThreadCommunicate().suspend();
//		new ThreadCommunicate().suspendDeadLock();
//		new ThreadCommunicate().suspendDeadLock1();
		new ThreadCommunicate().waitTest();

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void suspend() throws Exception {
		Thread consumerThread = new Thread(() -> {
			if (baozidian == null) {
				System.out.println("1.没有包子，进入等待");
				Thread.currentThread().suspend();
				;
			}
			System.out.println("2.买到包子回家");
		});
		consumerThread.start();
		Thread.sleep(20);
		baozidian = new Object();
		consumerThread.resume();
		System.out.println("3.通知消费者有包子了");
	}

	/**
	 * suspend不释放锁，用在代码块中导致死锁
	 * 
	 * @throws Exception
	 */
	public void suspendDeadLock() throws Exception {
		Thread consumerThread = new Thread(() -> {
			synchronized (this) {
				if (baozidian == null) {
					System.out.println("1.没有包子，进入等待");
					Thread.currentThread().suspend();
					;
				}
			}
			System.out.println("2.买到包子回家");
		});
		consumerThread.start();
		Thread.sleep(20);
		baozidian = new Object();
		synchronized (this) {
			consumerThread.resume();
		}
		System.out.println("3.通知消费者有包子了");
	}

	/*
	 * suspend在resume之后执行，导致死锁
	 * 
	 * @throws Exception
	 */
	public void suspendDeadLock1() throws Exception {
		Thread consumerThread = new Thread( ()-> {
			if (baozidian == null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("1.没有包子，进入等待");
				Thread.currentThread().suspend();
			}
			System.out.println("2.买到包子回家");
		});
		consumerThread.start();
		Thread.sleep(20);
		baozidian = new Object();
		consumerThread.resume();
		System.out.println("3.通知消费者有包子了");
	}
	
	public void waitTest() throws Exception {
		Thread consumerThread = new Thread( ()-> {
			if (baozidian == null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("1.没有包子，进入等待");
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("2.买到包子回家");
		});
		consumerThread.start();
		Thread.sleep(3000);
		baozidian = new Object();
		synchronized (this) {
			notifyAll();
		}
		System.out.println("3.通知消费者有包子了");
	}
	
}
