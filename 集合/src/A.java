
public class A {

	
	private A() {
		
	}
	
	
	private static A a=new A();
	
	
	public	static A show() {
		
		return a;
	}
}

class B{
		
	public static void main(String[] args) {
		A a=A.show();
	}
}
