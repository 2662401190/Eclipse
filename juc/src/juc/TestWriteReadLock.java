package juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  读写锁
 *  读读 不需要互斥、
 *  读写需要互斥
 *  
 * @author HeWei
 *
 */
public class TestWriteReadLock {
	public static void main(String[] args) {
		ReadWriteLockDemo r=new ReadWriteLockDemo();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
					r.set(1);
			}
		},"写").start();
		/**
		 * 读
		 */
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i <100; i++) {
					r.get();
				}
			}
		},"读").start();
		
	}
	
}

class ReadWriteLockDemo{
	
	private int number=0;
	ReadWriteLock lock=new ReentrantReadWriteLock();
	
	/**
	 * 读
	 */
	public void get() {
		lock.readLock().lock();
		
		try {
			
			System.out.println(Thread.currentThread().getName()+":"+number);
		} finally {
			lock.readLock().unlock();
		}
		
	}
	
	public void set(int number) {
		lock.writeLock().lock();
		
		try {
			
			System.out.println(Thread.currentThread().getName());
			this.number=number;
		} finally {
				
			lock.writeLock().unlock();
		}
	}
		
	
}
