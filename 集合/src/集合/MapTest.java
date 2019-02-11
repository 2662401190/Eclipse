package 集合;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MapTest {

	
	/**
	 * 遍历 map
	 */
	@Test
	public void test() {
	Map  m=new HashMap<>();
	
	m.put("1", 12);
	m.put("DD", 2);
	m.put("3", "hewei");
	m.put("AA", 24);
	m.put("BB", 345);
	m.put("CC", 13623);
	
	//  遍历所有的key  返回一个Set
	Set set=m.keySet();
	for (Object iterable_element : m.keySet()) {
		System.out.println(iterable_element);
	}
	
	System.out.println("........");
	// 遍历 所有的  value  返回一个 Collection
	Collection c=m.values();
	
	Iterator iterator=c.iterator();
	while (iterator.hasNext()) {
	 System.out.println(iterator.next());
		
	}
	System.out.println("............");
	
	// 遍历Map 的键值对  entry
	// 方法一
	Set s=m.keySet();
	for (Object object : s) {
		System.out.println("key _value:  "+object   +"___"+m.get(object));
	}
	
	System.out.println("....................");
	// 方法二
	Set set2=m.entrySet();
	for (Object object : set2) {
	
		System.out.println(object);
	}
	
	
	
	System.out.println();
	}
}
