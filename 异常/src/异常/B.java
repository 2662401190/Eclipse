package 异常;

import java.awt.Transparency;

/**
 * 
 * 自定义 异常
 *  1： 继承现有的异常类
 *  
 *  2 提供一个序列号， 提供几个重载的构造器
 */

public class B {
	
	
	public static void main(String[] args)  {
		A a=new A();
		a.show();
	}
	
}


 class C extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	public C() {
		

	}

	public C(String name) {
		super(name);
	}
	
	
	
}






	class A{
		public void show() {
			try {
				throw new C("name");
			} catch (C e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
				try {
					throw new C("name");
				} catch (C e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
