package com.xingyu.demo.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 如何确定合适数量的线程
 * 计算型任务：cpu数量的1-2倍
 * IO型任务：要根据具体的IO阻塞时长进行考量决定，例如tomcat默认的最大线程数为200
 * @author forever11270201
 *
 */
public class ThreadPoolTest {

	public static void main(String[] args) throws Exception {
//		new ThreadPoolTest().threadPoolExecutorTest();
//		new ThreadPoolTest().threadPoolExecutorTest1();
//		new ThreadPoolTest().threadPoolExecutorTest2();

//		new ThreadPoolTest().threadPoolExecutorTest3();
//		new ThreadPoolTest().threadPoolExecutorTest4();
//		new ThreadPoolTest().threadPoolExecutorTest5();
//		new ThreadPoolTest().threadPoolExecutorTest6();
		new ThreadPoolTest().threadPoolExecutorTest7();

		
	}
	
	public void testComm(ThreadPoolExecutor threadPoolExecutor) throws Exception{
		for (int i = 0; i < 15; i++) {
			int n = i;
			threadPoolExecutor.submit(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("开始执行："+ n);
						Thread.sleep(3000L);
						System.err.println("执行结束：ִ" + n);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			System.out.println("任务提交成功：" + i);
		}
		Thread.sleep(500L);
		System.out.println("当前线程池数量：" + threadPoolExecutor.getPoolSize());
		System.out.println("当前线程等待的数量：" + threadPoolExecutor.getQueue().size());
		Thread.sleep(15000L);
		System.out.println("当前线程池数量：" + threadPoolExecutor.getPoolSize());
		System.out.println("当前线程等待的数量：" + threadPoolExecutor.getQueue().size());
	}
	
	/**
	 * 线程池运行顺序
	 * 1.首先判断是否达到核心线程数，如果没达到继续生成一个线程
	 * 2.如果达到核心线程数，往队列里放入任务（若为无界队列则一直放）
	 * 3.如果队列已满，判断是否达到最大线程数，如果没达到，继续生成线程，如果达到则拒绝执行
	 * 
	 * 由于本例是无界队列，所以达到核心线程数之后，便不再生成线程
	 * @throws Exception
	 */
	public void threadPoolExecutorTest() throws Exception {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		testComm(threadPoolExecutor);
		
	}
	
	/**
	 * 定义拒绝策略
	 * @throws Exception
	 */
	public void threadPoolExecutorTest1() throws Exception {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.err.println("不要意思，线程池已满，不允许执行新的任务");
			}
		}); 
		testComm(threadPoolExecutor);
	}
	
	/**
	 * Executors.newCachedThreadPool
	 * @throws Exception
	 */
	public void threadPoolExecutorTest2() throws Exception {
		//Executors.newCachedThreadPool() 的实现
		//只要有任务就会新建一个线程用来处理任务
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<>());
		testComm(threadPoolExecutor);
		Thread.sleep(60000);
		System.out.println("线程数量为：" + threadPoolExecutor.getPoolSize());
	}
	
	/**
	 * 等待一定时间后一次执行
	 * 利用 DelayedWorkQueue 延时队列实现
	 * @throws Exception
	 */
	public void threadPoolExecutorTest3() throws Exception {
		ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(5);
		threadPoolExecutor.schedule(()->{
			System.out.println("任务1被执行，现在时间：" + System.currentTimeMillis());
		}, 3, TimeUnit.SECONDS);
		System.out.println("定时任务提交成功：" + System.currentTimeMillis() + "当前线程池中线程数量：" + threadPoolExecutor.getPoolSize());
	}
	
	/**
	 * 若任务执行时间大于周期时间，则任务执行完毕后立即执行下一个任务
	 * @throws Exception
	 */
	public void threadPoolExecutorTest4() throws Exception {
		ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(5);
		threadPoolExecutor.scheduleAtFixedRate(()->{
			try {
				Thread.sleep(3000);
				System.out.println("当前线程数量为：" + threadPoolExecutor.getPoolSize() + "---" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 3, 1, TimeUnit.SECONDS);
	}
	
	/**
	 * 若任务执行时间大于周期时间，则任务执行完毕后延时一个周期时间后再执行
	 */
	public void threadPoolExecutorTest5() {
		ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(5);
		threadPoolExecutor.scheduleWithFixedDelay(()->{
			try {
				Thread.sleep(3000);
				System.out.println(System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 3, 1, TimeUnit.SECONDS);
		
	}
	
	public void threadPoolExecutorTest6() throws Exception {
		ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(5);
		threadPoolExecutor.scheduleAtFixedRate(()->{
			try {
				Thread.sleep(200);
				System.out.println("当前线程数量为：" + threadPoolExecutor.getPoolSize());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}, 1, 2, TimeUnit.SECONDS);
		
	}
	/**
	 * 测试shutdown和shutdownNow用法
	 * @throws Exception
	 */
	public void threadPoolExecutorTest7() throws Exception {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.err.println("有任务被拒绝执行");
			}
		});
		for (int i = 0; i < 15; i++) {
			int n = i;
			threadPoolExecutor.submit(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("开始执行："+ n);
						Thread.sleep(3000L);
						System.err.println("执行结束：ִ" + n);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			System.out.println("任务提交成功：" + i);
		}		
//		Thread.sleep(1000);
//		threadPoolExecutor.shutdown();
//		threadPoolExecutor.submit(()->{
//			System.out.println("追加一个任务");
//		});
		Thread.sleep(1000);
		java.util.List<Runnable> list = threadPoolExecutor.shutdownNow();
		threadPoolExecutor.submit(()->{
			System.out.println("追加一个任务");
		});	
		System.out.println(list.size());
	}
	
	
	
	
	
}
