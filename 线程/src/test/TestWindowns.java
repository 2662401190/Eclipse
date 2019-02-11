package test;


/**
 * 
 *  处理 线程安全问题  同步
 * @author HeWei
 *
 */
public class TestWindowns {

	
	public static void main(String[] args) {
		Window window1=new Window();
		Window window2=new Window();
		Window window3=new Window();
		
		
		window1.setName("����1");
		window2.setName("����2");
		window3.setName("����3");
		
		window1.start();
		window2.start();
		window3.start();
	}
}

class Window extends Thread{
		
	
	static int ticket=100;
	static	Object obj=new Object();
	
	
	public void run() {
		
		
		
	while(true) {
		synchronized (obj) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		if(ticket>0) {
				
			System.out.println(Thread.currentThread().getName()+"��   ��������Ʊ��"+ ticket--);
			
		}else {
			break;
		}
		
			
		
	}
		}
	}
	
}
