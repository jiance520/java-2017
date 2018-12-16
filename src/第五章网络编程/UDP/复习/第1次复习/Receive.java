package 第五章网络编程.UDP.复习.第1次复习;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

/**
 * @version 时间：2017-12-10 下午4:09:36
 *
 */
public class Receive {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(8800);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		ds.receive(dp);
		String mess = new String(dp.getData(),0,dp.getLength());//buf.toString();
		System.out.println(dp.getAddress().getHostAddress()+"说"+mess);
		SocketAddress sa = dp.getSocketAddress();
		
		String reply = "我回的包";
		byte[] buf1 = reply.getBytes();
		DatagramPacket dpreply = new DatagramPacket(buf1,buf1.length,sa);
		ds.send(dpreply);
		ds.close();
	}
}
