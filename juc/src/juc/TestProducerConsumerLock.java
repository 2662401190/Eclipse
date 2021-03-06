package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者问题    使用同步锁
 * @author HeWei
 *
 */
public class TestProducerConsumerLock {
		
		
		public static void main(String[] args) {
			Clerk2 c=new Clerk2();
			Producer2 p=new Producer2(c);
			Consumer2 s=new Consumer2(c);
			new Thread(p,"生产者").start();
			new Thread(s,"消费者").start();;
		} 
	
}


/**
 * 店员
 * @author HeWei
 *
 */
class Clerk2 {
	
	private int product=0;
	private Lock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	
	// 进货  
	public  void  get()  {
		lock.lock();
		
		try {
			
			while(product>=10) {
				System.out.println(" 货物已满");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
					
				try {
					// 等待		应该放在 循环当中不然可能会出现；虚假唤醒的操作  对应 wait
					condition.await(); 
				} catch (Exception e) {
					
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+ ++product);
			condition.signalAll();
		} finally {
			//  唤醒 对应者 notifyAll
			
			lock.unlock();
			
		}
		
		
	}
	
	
	// 卖货
	public  void sale() {
		lock.lock();
		try {
			
			while(product<=0) {
				System.out.println(" 已卖完");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				try {
					// 等待		应该放在 循环当中不然可能会出现；虚假唤醒的操作
					condition.await(); 
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+ --product);
			condition.signalAll();
		} finally {
			lock.unlock();
		}
		
	}
	
}

//  生产者
class Producer2 implements Runnable{
	
	private Clerk2 c;
	Producer2(Clerk2 c){
		this.c=c;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		for (int i = 0; i < 20; i++) {
			c.get();
		}
		
	}
	
	
	
	
	
}
class Consumer2 implements Runnable{
	private Clerk2 c;
	Consumer2(Clerk2 c){
		this.c=c;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			c.sale();
		}
		
	}
	
}
