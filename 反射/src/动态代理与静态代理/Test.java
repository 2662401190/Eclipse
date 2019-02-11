package 动态代理与静态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author HeWei
 *
 */
public class Test {
	
	public static void main(String[] args) {
		Agent a=new Agent();
		Cagent c=new Cagent();
		
		// 调用 blind() 方法，动态的返回一个同样实现 了 	Agent类实现的 接口 Dagent 的代理类的对象
		//  此时 d 就是代理类的对象
 		Dagent d=(Dagent)c.blind(a);
 		
 		// 转到对InvocationHandler接口的实现类的invoke（）方法的调用
		d.show();
		
		
	}
	
	
}


interface Dagent{
	
	public void show();
}


class Agent implements Dagent {

	@Override
	public void show() {
		// TODO 自动生成的方法存根
		System.out.println(" 被代理的对象 A");
	}

	
	
}	

class Cagent implements InvocationHandler{
	
	Object obj;// 实现接口的被代理类的对象声明
	
	public Object blind(Object obj) {
		this.obj=obj;
		
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
	}
	
	
	// 当通过代理类的对象发起对被重写的方法的调用时，都会转换为对如下的invoke方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO 自动生成的方法存根
		
		Object returnVal=method.invoke(obj, args);
		return returnVal;
	}


	
}



