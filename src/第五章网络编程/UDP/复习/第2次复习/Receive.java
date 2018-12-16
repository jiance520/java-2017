package 第五章网络编程.UDP.复习.第2次复习;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

/**
 * @version 时间：2017-12-27 下午2:51:07
 *
 */
public class Receive {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(8800);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		ds.receive(dp);
		String str = new String(dp.getData(),0,dp.getLength());
		System.out.println(dp.getAddress().getHostAddress()+str);
		
		SocketAddress sa = dp.getSocketAddress();
		buf = "你也好".getBytes();
		dp = new DatagramPacket(buf,buf.length,sa);
		ds.send(dp);
	}

}
