import java.beans.Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.management.StandardEmitterMBean;

import org.junit.Test;

/*
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 * 
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 * 
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 * 
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 * 		
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 * 
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 * 
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 * 
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 * 
 */
public class TestChannel {
	
	// 字符集
	@Test
	public void Test06() throws CharacterCodingException {
		Charset cs1=Charset.forName("GBK");
		
		// 获取编码器
		CharsetEncoder ce=cs1.newEncoder();
		// 获取解码器
		CharsetDecoder cd=cs1.newDecoder();
		//  设置 长度
		CharBuffer charBuffer=CharBuffer.allocate(1024);
		charBuffer.put("贺威是你爸爸");
		//  切换 读模式
		charBuffer.flip();
		
		//  编码	
		ByteBuffer buffer=ce.encode(charBuffer);
		
		for(int i=0;i<12;i++) {
			System.out.println(buffer.get());
		}
		
		// 解码
		buffer.flip();
		CharBuffer cb=cd.decode(buffer);
		System.out.println(cd.toString());
		
		System.out.println("------------------------------------------------------");
		
		Charset cs2 = Charset.forName("GBK");
		buffer.flip();
		CharBuffer cBuf3 = cs2.decode(buffer);
		System.out.println(cBuf3.toString());
		
		
	}
	
	/**
	 * 获取全部的编码字集
	 */
	@Test
	public void Test05() {
		Map<String, Charset> map=Charset.availableCharsets();
		
		Set<Entry<String,Charset>> set=map.entrySet();
		
		for (Entry<String, Charset> entry : set) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
	
	/**
	 * 分散和聚集
	 * @throws Exception 
	 */
	@Test
	public void Test04() throws Exception {
		RandomAccessFile  rafl=new RandomAccessFile("1.txt","rw");
		//  获取通道
		FileChannel channel=rafl.getChannel();
		
		//  分配指定大小的缓冲区
		ByteBuffer buffer01=ByteBuffer.allocate(100);
		ByteBuffer buffer02=ByteBuffer.allocate(1024);
		
		// 分散缓冲区
		ByteBuffer [] bufs= {buffer01,buffer02};
		channel.read(bufs);
		
		for (ByteBuffer byteBuffer : bufs) {
			byteBuffer.flip();
		}
		
		System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
		System.out.println(".................");
		System.out.println(new String(bufs[1].array(),0,bufs[0].limit()));
		
		
		
		// 聚集写入
		RandomAccessFile accessFile=new RandomAccessFile("2.txt","w");
		FileChannel fcn2=accessFile.getChannel();
		
		fcn2.write(bufs);
		
		accessFile.close();
		channel.close();
		fcn2.close();
		rafl.close();
		
		
	}
	
	
	/**
	 * 通道之间的数据传输（直接缓冲区）
	 * @throws IOException
	 */
	@Test
	public void Test03() throws IOException {
		FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
		
		FileChannel outChannel=FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		inChannel.transferTo(0,inChannel.size(), outChannel);
		// inChannel.transferForm(inChannel,0, inChannel.size());
		inChannel.close();
		outChannel.close();
	}
	
	
	/**
	 * 使用直接缓冲区完成文件的复制（内存映射文件）
	 * @throws IOException 
	 */
	@Test
	public void Test02() throws IOException {
		// 读
		FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
		
		FileChannel outChannel=FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		// 内存映射文件
		MappedByteBuffer  inMapBuffer=inChannel.map(MapMode.READ_ONLY,0,inChannel.size());
		MappedByteBuffer  outMapBuffer=outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		
		// 直接对缓冲区进行数据的读写操作
		byte [] b=new byte[inMapBuffer.limit()];
		
		inMapBuffer.get(b);
		outMapBuffer.put(b);
		inChannel.close();
		outChannel.close();
		
	}
	
	
	/**
	 * 利用  通道完成文件复制	(非直接缓冲区)
	 * @throws IOException 
	 */
	@Test
	public void Test1() throws IOException {
		FileInputStream fis=new FileInputStream(new File("1.jpg"));
		FileOutputStream fos=new FileOutputStream(new File("2.jpg"));
		
		//  获取 通道
		FileChannel inChannel=fis.getChannel();
		FileChannel outChannel=fos.getChannel();
		
		// 分配空间大小的缓冲区 
		ByteBuffer buf=ByteBuffer.allocate(1024);
		
		// 将通道的数据存入缓冲区中
		while(inChannel.read(buf)!=-1) {
			// 切换到读取数据的模式
			buf.flip();
			// 将缓冲区的数据写入通道中
			outChannel.write(buf);
			buf.clear();
		}
		
		
		outChannel.close();
		inChannel.close();
		fos.close();
		fis.close();
	}
}
