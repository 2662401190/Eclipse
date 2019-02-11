import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public  class TestFile {

	
	@Test
	public void test1() throws IOException {
		File f=new File("hello.txt");
		
		//获取绝对文件名
		System.out.println(f.getAbsoluteFile()); 
		
		
		System.out.println(f.delete());
		System.out.println(f.createNewFile());
		
		for (String iterable_element : f.list()) {
			System.out.println(12);
			System.out.println(iterable_element);
		}
	}
}
