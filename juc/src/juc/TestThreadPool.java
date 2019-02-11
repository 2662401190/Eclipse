package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池： 提供一个线程队列，队列保存着所有等待状态 的线程。。  避免了创建与销毁的额外开销，提高了响应的速度
 * 二、线程池的体系结构：
 * 	java.util.concurrent.Executor : 负责线程的使用与调度的根接口
 * 		|--**ExecutorService 子接口: 线程池的主要接口
 * 			|--ThreadPoolExecutor 线程池的实现类
 * 			|--ScheduledExecutorService 子接口：负责线程的调度
 * 				|--ScheduledThreadPoolExecutor ：继承 ThreadPoolExecutor， 实现 ScheduledExecutorService
 *  * 三、工具类 : Executors 
 * ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 * ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
 * ExecutorService newSingleThreadExecutor() : 创建单个线程池。线程池中只有一个线程
 * 
 * ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程，可以延迟或定时的执行任务。
 * @author HeWei
 *
 */
public class TestThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1,  创建  线程池      创建了5个线程
		ExecutorService pool=	Executors.newFixedThreadPool(5);
		
		List<Future<Integer>> list=new ArrayList<>();
		
		Future<Integer> future=pool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				
				int sum=0;
				for (int i = 1; i <=100 ; i++) {
					sum+=i;
					System.out.println(sum);
				}   
				return sum;
			}
		});
		list.add(future);
		
		// 返回的结果
		future.get();
			
		pool.shutdown();
		
		
		
		
//		ThreadPoolDemo tpd=new ThreadPoolDemo();
//		//2,  为线程池中的线程分配 任务
//		for (int i = 0; i < 10; i++) {
//			pool.submit(tpd);
//
//			
//		}
//		
//		// 3， 关闭线程
//		pool.shutdown();
		
	}
	
	
}

class ThreadPoolDemo implements Runnable{
	private int j=0;
	@Override
	public void run() {
		
		// TODO 自动生成的方法存根
		for (int i = 0; i <= 100; i++) {
			j=i;
			System.out.println(Thread.currentThread().getName()+":"+j);
			
		}
		
	}
	
}
