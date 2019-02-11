import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * 1. 缓冲区（Buffer）:  在java Nio 中负责数据的存取。缓冲区就是数组。用于储存不同数据类型的数据
 * 		根据数据类型 不同（Boolean 除外）：提供了相应类型的暖冲区
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 
 * 上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
 * @author HeWei
 *
 *2  缓冲区 存取数据的核心两个方法:
 *		put(): 存入数据到缓冲区中;
 *		get(): 获取缓冲区中的数据
 *
 *4  缓冲区的四个核心属性:
 *		capacity : 容量， 表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 *		limit	: 界限，表示缓冲区中可以操作数据的大小。（limit 后的数据不能进行读写）
 *		position :	位置，表示缓冲区中正在操作数据的位置。
 *		
 *
 * 	mark : 标记，表示记录当前position的位置，可以通过reset（） 恢复到Mark的位置
 * 
 *	0<=mark<=position <=limit <=capacity
 *
 *
 *5	 直接缓冲区和非直接缓冲区：
 *		非直接缓冲区：可以通过allocate() 方法分配缓冲区，将缓冲区建立在jvm内存中
 *		直接缓冲区：  通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理的内存中
 *
 *
 */
public class TestBuffer {

	@Test
	public void Test2() {
		String str="abced";
		
		ByteBuffer bbf=ByteBuffer.allocate(1024);
		
		bbf.put(str.getBytes());
		
		//  读
		bbf.flip();
		
		byte [] b=new byte[bbf.limit()];
		bbf.get(b, 0, 2);
		System.out.println(new String(b, 0, 2));
		System.out.println(bbf.position());
		
		///  笔记
		bbf.mark();
		
		bbf.get(b, 2, 2); 
		
		System.out.println(new String(b, 2, 2));
		
		System.out.println(bbf.position());
		
		//  reset 恢复到mark 的位置
		bbf.reset();
		System.out.println(bbf.position());
		
		//  判断缓冲区中是否还有剩余的数据 
		if(bbf.hasRemaining()) {
			
			// 获取缓冲区可以操作的数量
			System.out.println(bbf.remaining());
			
		}
	}
	
	@Test
	public  void  test1() {
		
		String str="abcde";
		// 1.  分配一个 指定大小的缓存区
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		
		// 2, 利用put() 存入数据缓冲区
		 buffer.put(str.getBytes());
	
		System.out.println("................");
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		
		//3  切换成读取数据的模式
		buffer.flip();
		System.out.println("...................");
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		
		
		System.out.println("................");
		//4 读取数据  
		byte[] b=new byte[buffer.limit()];
		
		//把数据读到数组里面
		buffer.get(b);
		System.out.println(new String(b, 0, b.length));
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		
		
		System.out.println("................");
		
		// 5, 执行 rewind() 方法     可重复读的意思 
		buffer.rewind();
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		
		
		// 6 ,clear(); 清空缓冲区，但是缓冲区的数据依然存在，但是处于“被遗忘的状态”
		
		buffer.clear();
	}
	
	
	

}
