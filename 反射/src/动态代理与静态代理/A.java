package 动态代理与静态代理;


/**
 * 静态代理
 * @author HeWei
 *
 */
public class A implements B{




	@Override
	public void show() {
		// TODO 自动生成的方法存根
		System.out.println(" 我是卖家 A");
		
	}
	
	
	
	

}

  interface B {
	
	public void show() ;
}



class C implements B{
	
	B b;
	
	public C(B b) {
		this.b=b;
	}
	

	@Override
	public void show() {
		// TODO 自动生成的方法存根
		System.out.println("我是买家 C");
		b.show();
		
		
	}
	
}

class d{
	public static void main(String[] args) {
		
		A  a=new A();
		C c=new C(a);
		c.show();
	}
}
