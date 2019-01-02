package com.xingyu.demo.thread;


public class ThreadCommunicate {

	public static void main(String[] args) {
		
	}
	
	Object baozidian = null;
	public void suspend() {
		Thread consumerThread = new Thread( ()-> {
			if (baozidian == null) {
				System.out.println("没有包子，进入等待");
				suspend();
			}
			System.out.println("买到包子回家");
		});
		consumerThread.start();
		baozidian = new Object();
		consumerThread.resume();
		System.out.println("通知消费者有包子了");
	}
	

	
}
