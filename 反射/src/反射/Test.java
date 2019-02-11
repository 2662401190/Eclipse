package 反射;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Properties;

public class Test {

	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		Class c=Person.class;
		
	
		

		Person p=(Person) c.newInstance();

		System.out.println(c.newInstance());
		Field f1=c.getField("name");
		System.out.println(f1);
		f1.set(p,"sdfsd");
		System.out.println(p.getName());
		
		
		// 给  private修饰的字段  赋值
		Field f2=c.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p.getAge());
		
	}
	
	
	
	public void test01() {
		Class<Person> clazz=Person.class;
		// 获取 所有   被public修饰的  属性    及父类 的
		clazz.getFields();
		//  获取 类 声明的 所有属性
		clazz.getDeclaredFields();
	}
}
