package juc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  线程的调度
 * @author HeWei
 *
 */
public class TestScheduledTheadPool {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 开启十个线程
		ScheduledExecutorService pool=Executors.newScheduledThreadPool(10);
		
			Future<Integer>future=pool.schedule(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int i=new Random().nextInt(101);// 随机数
				System.out.println(Thread.currentThread().getName()+":"+i);
				return i;
			}
			// 3 是延迟	后面的是时间单位
		}, 3, TimeUnit.SECONDS);
		
			// 返回值
			future.get();
			
			pool.shutdown();
		
				
	}
}
