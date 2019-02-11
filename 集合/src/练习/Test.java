package 练习;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {

	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		
		list.add(123);
		list.add(2);
		list.add(1);
		list.add(1,4);
		list.add(250);
		
	
		
		
		// 从小到大
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		
		  Map<String, Integer> map = new HashMap<String, Integer>();  
	       map.put("小花", 100);  
	       map.put("小白", 80);  
	       map.put("小花", 90);  
	       map.put("DD", 90);  
	       map.put("EE", 93);  
	       map.put("WW", 93);  
	       map.put("HH", 95);  
	       map.put("DD", 90);  
	 
	       // 通过.entrySet()的方法把Map类型的转化为Set集合  
	       Set<Entry<String, Integer>> entrySet = map.entrySet();  
	 
	       // 把Set集合转化为List集合  
	       List<Entry<String, Integer>> list1 = new ArrayList<Map.Entry<String, Integer>>(  
	               entrySet);  
	 
	       for (Entry<String, Integer> temp : list1)  
	           System.out.println(temp);// 未排序的结果  
	       System.out.println("--------------------");  
	 
	       // 通过Collections.sort排序  
	       Collections.sort(list1, new Comparator<Entry<String, Integer>>() {  
	 
	           public int compare(Entry<String, Integer> o1,  
	                   Entry<String, Integer> o2) {  
	                
	 
	               return o2.getValue() - o1.getValue();  
	           }  
	       });  
	 
	       for (int i=0;i<3;i++) {
	        System.out.println(list1.get(i).getKey());  
	       } 

		
		
		
		
	}
}
