package juc;

/**
 * 生产者消费者问题
 * @author HeWei
 *
 */
public class TestProducerConsumer {
		
		
		public static void main(String[] args) {
			Clerk c=new Clerk();
			Producer p=new Producer(c);
			Consumer s=new Consumer(c);
			new Thread(p,"生产者").start();
			new Thread(s,"消费者").start();;
		} 
	
}


/**
 * 店员
 * @author HeWei
 *
 */
class Clerk {
	
	private int product=0;
	
	// 进货  
	public synchronized void  get()  {
		while(product>=10) {
			System.out.println(" 货物已满");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			try {
				// 等待		应该放在 循环当中不然可能会出现；虚假唤醒的操作
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(Thread.currentThread().getName()+":"+ ++product);
		
		this.notifyAll();
	}
	
	
	// 卖货
	public synchronized void sale() {
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
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(Thread.currentThread().getName()+":"+ --product);
		
		this.notifyAll();
	}
	
}

//  生产者
class Producer implements Runnable{
	
	private Clerk c;
	Producer(Clerk c){
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
class Consumer implements Runnable{
	private Clerk c;
	Consumer(Clerk c){
		this.c=c;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			c.sale();
		}
		
	}
	
}
