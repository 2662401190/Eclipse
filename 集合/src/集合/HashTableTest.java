package 集合;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Properties;

public class HashTableTest {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//  HashTable 被废除了  但是有个properties 常用来处理属性文件，键值都是String 类型的
		
		
		Properties p=new Properties();
		p.load(new FileInputStream(new File("src/jdbc.properits")));
		//  获取 他的键
		System.out.println(p.getProperty("user"));
	}
}
