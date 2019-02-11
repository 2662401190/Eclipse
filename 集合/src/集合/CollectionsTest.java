package 集合;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class CollectionsTest {
	String name;

	
	public static void main(String[] args) {
		//  Collections（工具类） 常用来操作Collection 和 Map 的工具类
		
		
		List list=new ArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		//  反转  将顺序颠倒
		Collections.reverse(list);
		//  随机 排列
		Collections.shuffle(list);
		
		// 从小到大 排序
		Collections.sort(list);
		
		// 交换位置
		Collections.swap(list, 1, 2);
		// 某个 值出现的次数
		Collections.frequency(list, 23);
		// 将指定旧的值改成新的  值
		Collections.replaceAll(list, 4, 7);
		System.out.println(list);
		
		
		//一下的方法保证 List线程的安全性
		List list2=Collections.synchronizedList(list);
		System.out.println(list2);
	}
}
