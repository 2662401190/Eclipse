package test;

/**
 * ���߳�
 * @author HeWei
 *
 */
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		methon2("����");
	}

	
	public static void methon1(String str) {
		System.out.println("methon...");
		System.out.println(str);
	}
	
	public static void  methon2(String str) {
		
		System.out.println("methon 2...");
		methon1(str);
	}
}


/**
 * �߳̿�ʼ
 * @author HeWei
 *
 */

class TestThred extends Thread{
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
	
}

class test{
	
	public static void main(String[] args) {
		TestThred testThred=new TestThred();
		testThred.start();
		
		System.out.println("湖北省大家发表看法都不");
		
	}
}
