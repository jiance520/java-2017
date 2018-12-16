package ������������.UDP.��ϰ.��1�θ�ϰ;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

/**
 * @version ʱ�䣺2017-12-10 ����4:09:36
 *
 */
public class Receive {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(8800);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		ds.receive(dp);
		String mess = new String(dp.getData(),0,dp.getLength());//buf.toString();
		System.out.println(dp.getAddress().getHostAddress()+"˵"+mess);
		SocketAddress sa = dp.getSocketAddress();
		
		String reply = "�һصİ�";
		byte[] buf1 = reply.getBytes();
		DatagramPacket dpreply = new DatagramPacket(buf1,buf1.length,sa);
		ds.send(dpreply);
		ds.close();
	}
}
