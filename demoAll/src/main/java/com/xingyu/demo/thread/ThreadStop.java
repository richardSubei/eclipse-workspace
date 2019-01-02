package com.xingyu.demo.thread;

public class ThreadStop {

	
	public static void main(String[] args) {
		StopThread thread = new StopThread();
		thread.start();
//		thread.stop();		//	 thread.stop()方法破坏线程安全
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
					Thread.sleep(10000);
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
