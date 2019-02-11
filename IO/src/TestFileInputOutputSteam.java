import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

/**
 * 抽象基类     					（文件流）节点流
 * InputStream               FileInputStream 
 * OutPUtStream 			 FileOutPUtStream
 * Reader					 FileReader
 * Writer					 FileWriter
 * @author HeWei
 *
 */
public class TestFileInputOutputSteam {
	
	@Test
	public void testInputOutput() throws IOException {
		// 要读的文件
		File file=new File("1.jpg");
		// 目的地
		File file1=new File("src/1.jpg");
		FileInputStream input =new FileInputStream(file);
		FileOutputStream out=new FileOutputStream(file1);
		
		byte[] b=new byte[5];
		
		int len;
	
		while((len=input.read(b))!=-1) {
			
			System.out.print(new String(b, 0, len));
			 out.write(b, 0, len);
			
		}
		
		
		input.close();
		out.close();
		
		
	}
	
	
	/**
	 * 向文件中写 东西
	 * @throws IOException
	 */
	@Test
	public void testFileOutputSteam() throws IOException {
		File file=new File("hello.txt");
		FileOutputStream out=new FileOutputStream(file);
		out.write("我爱你,".getBytes());
		out.close();
	}
	
	
	
	/**
	 * 读的快
	 * @throws IOException
	 */
	@Test
	public void testFileInput2() {
		
		
		FileInputStream input=null;
		try {
			File file=new File("hello.txt");
			input = new FileInputStream(file);
			byte b[]=new byte[5];
		
			int i;
			while((i=input.read(b))!=-1) {
				
				for (int j = 0; j < i; j++) {
					System.out.print((char)b[j]);
				}
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {

			try {
				input.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	
	/**
	 * 读的慢
	 * @throws IOException
	 */
	@Test
	public void testFileInput() throws IOException {
		
		File file=new File("hello.txt");
		FileInputStream input=new FileInputStream(file);
		
		// 一个一个的读取
		int i=input.read();
		while(i!=-1) {
			System.out.println(i);
			i=input.read();
		}
		
		input.close();
		
		
	}
}
