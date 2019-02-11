package 网咯编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress  位于 java.net 下
 * 用来代表 IP地址  一个 InetAddress 代表一个IP地址
 * 
 * 
 * @author HeWei
 *
 */
public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress d=InetAddress.getByName("www.baidu.com");
		System.out.println(d);
		
		
		//  获取本机的 地址
		InetAddress net1=InetAddress.getLocalHost();
		System.out.println(net1);
	}
}
