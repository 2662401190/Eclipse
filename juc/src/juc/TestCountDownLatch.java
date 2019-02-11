package juc;


import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch（闭锁） 辅助类  只有当其他线程执行完才执行   
 * @author HeWei
 *
 */
public class TestCountDownLatch {
	
	
	//  同时五个线程访问他
	public static void main(String[] args) throws InterruptedException {
		//  数字要和  线程数相等
		final CountDownLatch cdl=new CountDownLatch(5);
		
		
		Test t=new Test(cdl);
		// 当前时间
		long start=System.currentTimeMillis();
		for(int i=0;i<5;i++) {
			new Thread(t).start();
		}
		
		//  等待  等线程 执行完
		cdl.await();
		// 结束时间
		long end =System.currentTimeMillis();
		System.out.println("花费时间"+(end-start));
	}

	
	
}


class Test implements Runnable{

	public CountDownLatch cdl;
	public Test(CountDownLatch cdl) {
		this.cdl=cdl;
	}
	
	@Override
	public void run() {
		
		// TODO 自动生成的方法存根
		for (int i = 0; i <= 50000; i++) {
			if(i%2==0) {
				
				System.out.println(i);
			}
			
		}
		
		//  实现 计数器  递减
		cdl.countDown();
	}
	
	
}