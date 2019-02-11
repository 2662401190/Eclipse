import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/**
 * 一 ， 使用NIO 完成网咯通信的三个核心：
 * 		1， 通道（channel）： 负责连接
 *  * 		
 * 	   		 java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 * 
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 * 		2： 缓存区（buffer）： 负责数据的存取
 * 		3，选择器（selector） : 是SelectableChannel 的多路复用器，用于监控SelectableChannel 的Io 状况的
 * @author HeWei
 *
 */
public class TestBlockingNio {
	
	// 客户端
	@Test
	public void client() throws IOException {
		// 1,获取通道
		SocketChannel sc=SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
		
		//  2，获得指定大小的缓冲区
		ByteBuffer bbf=ByteBuffer.allocate(1024);
		
		// 读取本地的文件，并发送到服务端
		while(inChannel.read(bbf)!=-1) {
			bbf.flip();
			sc.write(bbf);
			bbf.clear();
			
		}
		// 关闭
		inChannel.close();
		 sc.close();
		
	}
	
	@Test
	// 服务端
	public void server() throws IOException {
		  // 获取通道
		ServerSocketChannel ssChannel=ServerSocketChannel.open();
		
		FileChannel outChannel =FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		//  绑定连接
		ssChannel.bind(new InetSocketAddress(9898));
		
		// 获取客户端连接的通道 
		SocketChannel sChannel=ssChannel.accept();
		
		// 分配指定大小的缓冲区
		ByteBuffer buf=ByteBuffer.allocate(1024);
		
		// 接受客户端的数据，并保存在本地
		
		while(sChannel.read(buf)!=1024) {
			buf.flip();
			outChannel.write(buf);
			buf.clear();
		}
		
		outChannel.close();
		ssChannel.close();
		
	}

}
