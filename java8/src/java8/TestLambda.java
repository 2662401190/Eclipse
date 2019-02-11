package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.Test;

import java8.java8.Employee;

public class TestLambda {
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	
	
	
	
	
	
	@Test
	public void Test06() {
		List<String> list=new ArrayList<>();
		Stream<String> ss=list.stream();
	}
	
	@Test
	public void  Test04() {
		
		Consumer<Integer> ci=System.out::print;
		ci.accept(1111);
	} 
	
	/**
	 *定制 排序
	 */
	@Test
	public void Test03() {
		Collections.sort(emps, (x,y) -> {
			if(x.getAge()==y.getAge()) {
				return x.getName().compareTo(y.getName());
			}else {
				return Integer.compare(x.getAge(), y.getAge());
			}
		});
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void Test01() throws Exception {
		int i;
		
		i=0;
		i++;
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.println(" 贺威是你爸爸");
				
			}
		};
		
		r.run();
		
		System.out.println("................................");
		
		Runnable r1=() -> System.out.println("贺威");
		r1.run();
		
		Callable<Integer> ci=()	->  2*2;
		
		System.out.println(ci.call());
		
	}
}
