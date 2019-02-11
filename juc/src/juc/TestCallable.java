package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  实现线程的 的方式  三 ： 实现 callable 接口  相较于Runnable接口 方式；方法可以有返回值；并且可以抛出异常 ;;   也可以用作 闭锁
 * @author HeWei
 *
 */
public class TestCallable {
	public static void main(String[] args) {
		ThreadDemo td=new ThreadDemo();
		
		// 执行 callable 方式；需要FutureTask 实现类的支持； 用=用于接受运算结果   // FutureTask 是Future接口的实现类
		FutureTask<Integer> ft=new FutureTask<>(td);
		new Thread(ft).start();
		
		//  接收线程运算过的结果
		try {
			// 获取 返回值
		Integer sum=ft.get();
		System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}

class ThreadDemo implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		int sum=0;
		for (int i = 1; i <=100; i++) {
			sum+=i;
			
		}
		// TODO 自动生成的方法存根
		return sum;
	}
	
}

