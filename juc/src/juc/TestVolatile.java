package juc;


// Volatile  关键 ： 当多个线程进行操作共享数据时；可以保证内存中数据是可见的
public class TestVolatile implements Runnable {

	
	private boolean  flag=false;
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		flag=true;
		
		
		System.out.println("flag:"+  isFlag()
		);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	

}
