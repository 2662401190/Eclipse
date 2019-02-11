package 网咯编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestTcp2 {
	
	
	/**
	 *客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	@Test
	public void clice() throws UnknownHostException, IOException {
		Socket s=new Socket("127.0.0.1",8989);
		OutputStream os=s.getOutputStream();
		os.write("我是贺威".getBytes());
		//  告诉服务端 我发送完了
		s.shutdownOutput();
		InputStream is =s.getInputStream();
		byte []c=new byte[20];
		int len;
		while((len=is.read(c))!=-1) {
			
			System.out.println(new String(c, 0, len));
		}
		os.close();
		is.close();
		s.close();
	}
	
	@Test
	public void server() throws IOException {
		ServerSocket ss=new ServerSocket(8989);
		Socket s=ss.accept();
		InputStream is=s.getInputStream();
		OutputStream os=s.getOutputStream();
		byte []c=new byte[20];
		int len;
		while((len=is.read(c))!=-1) {
			
			System.out.println(new String(c, 0, len));
		}
		
		
		os.write("收到爸爸".getBytes());
		os.close();
		is.close();
		s.close();
		ss.close();
		
	}
	
	public static void main(String[] args) {
		String sql="sdf";
		System.out.println(sql.toUpperCase());
		
	}
}
