package 网咯编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.OutputValueSwitch;

/**
 * 客户端给服务端发送信息，服务端输出此信息到控制台
 * @author HeWei
 *
 */
public class TestTcp {
	
	/**
	 * 客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	@Test
	public void client() throws UnknownHostException, IOException {
		Socket socket =new Socket(InetAddress.getByName("127.0.0.1"),9090);
		
		OutputStream os=socket.getOutputStream();
		os.write("我是你爸爸".getBytes());;
		os.close();
		socket.close();
	}
	
	/**
	 * 服务端
	 * @throws IOException 
	 */
	@Test
	public void server() throws IOException {
		ServerSocket ss=new ServerSocket(9090);
		Socket s=ss.accept();
		InputStream is=s.getInputStream();
		
		byte []c=new byte[20];
		int len;
		while((len=is.read(c))!=-1) {
			
			System.out.println(new String(c, 0, len));
		}
		is.close();
		s.close();
		ss.close();
		
	}

	
}
