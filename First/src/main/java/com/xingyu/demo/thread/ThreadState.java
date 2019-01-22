package com.xingyu.demo.thread;

public class ThreadState {

	public static void main(String[] args) throws Exception{
		System.out.println("第一种：新建--》运行--》终止");
		Thread thread = new Thread(() -> {
			System.out.println("thread当前状态：" + Thread.currentThread().getState());
		}) ;
		System.out.println("thread当前状态：" + thread.getState());
		Thread.sleep(50);
		System.out.println("thread当前状态：" + thread.getState());

		System.out.println("---------------------------------------");
		
		System.out.println("第二种：新建--运行--》等待--》运行--》终止");
		Thread thread2 = new Thread(() -> {
			System.out.println("thread2当前状态：" + Thread.currentThread().getState());
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("thread2当前状态：" + Thread.currentThread().getState());
		});
		System.out.println("thread2当前状态：" + thread2.getState());
		thread2.start();
		Thread.sleep(20);
		System.out.println("thread2当前状态：" + thread2.getState());
		Thread.sleep(2000);
		System.out.println("thread2当前状态：" + thread2.getState());
		
		System.out.println("---------------------------------------");
		
		System.out.println("第三种：新建--》运行--》阻塞--》运行--》终止");
		Thread thread3 = new Thread(() ->{
			System.out.println("thread3当前状态：" + Thread.currentThread().getState());
			synchronized (ThreadState.class) {
				System.out.println("thread3当前状态：" + Thread.currentThread().getState());
			}
		});
		System.out.println("thread3当前状态：" + thread3.getState());
		synchronized (ThreadState.class) {
			thread3.start();
			Thread.sleep(20);
			System.out.println("thread3当前状态：" + thread3.getState());
		}
		Thread.sleep(1000);
		System.out.println("thread3当前状态：" + thread3.getState());
		

	}
}
