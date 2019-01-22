package com.xingyu.demo.thread;

/**
 * @author forever11270201
 * 
 * 线程中止的方式
 * 1. stop，不推荐，无法保证代码块里的数据一致性
 * 2. interrupt，推荐
 * 	  如果目标线程在调用wait，join，sleep方法时阻塞，那么interrupt方法生效，该线程的中断状态将被清楚，抛出InterruptedException异常
 *    如果目标线程被I/O,NIO锁阻塞，I/O操作会被中断或者返回特殊异常值
 *    如果以上条件都不满足，则不会中止线程
 * 3. 使用标志位来判断
 * 
 *
 */
public class ThreadStop {

	public static void main(String[] args) throws Exception {
		StopThread thread = new StopThread();
		thread.start();
		Thread.sleep(50);
//		thread.stop();		//	 thread.stop()方法破坏线程安全	无法保证代码块里的数据一致性（事物）
		try {
			thread.interrupt();
		} catch (Exception e) {
			System.out.println("写进日志");
		}
		while (thread.isAlive()) {
			
		}
		thread.print();
	}
	
	
	
	static class StopThread extends Thread {
		private int i = 0, j = 0;
		
		@Override
		public void run() {
			synchronized (this) {
				++i;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				++j;
			}
		}
		
		public void print() {
			System.out.println("i=" + i + ",  j=" + j);
		}
		
	}
}
