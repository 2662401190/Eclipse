package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	public static void main(String[] args) {
		Ticket t=new Ticket();
		new Thread(t,"一号：").start();
		new Thread(t,"二号:").start();
		new Thread(t,"三号:").start();
	}
}

class Ticket implements Runnable{

	private int tick=100;
	private Lock  lock=new ReentrantLock();
	
	@Override
	public void run() {
		while(true) {
			
			//上锁
			lock.lock();
			try {
				if(tick>0) {
					try {
						Thread.sleep(200);
					} catch (Exception e) {
					} }
					System.out.println(Thread.currentThread().getName()+": 完成售票，余票为 "+tick--);
				}
				
			 finally {
				
				lock.unlock();
			}
			
			
		}
	}
	
}
