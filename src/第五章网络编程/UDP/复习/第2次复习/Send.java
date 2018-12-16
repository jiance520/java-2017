package 第五章网络编程.UDP.复习.第2次复习;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @version 时间：2017-12-27 下午2:51:18
 *
 */
public class Send {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		InetAddress ia = InetAddress.getByName("localhost");
		byte[] buf = "你好".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,ia,8800);
		ds.send(dp);
		
		buf = new byte[1024];
		dp = new DatagramPacket(buf,buf.length);
		ds.receive(dp);
		String str = new String(dp.getData(),0,dp.getLength());
		System.out.println(dp.getAddress().getHostAddress()+str);
	}

}
