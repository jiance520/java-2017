package ������������.UDP.��ϰ.��1�θ�ϰ;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * @version ʱ�䣺2017-12-10 ����4:09:49
 *
 */
public class Send {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		InetAddress ia = InetAddress.getByName("localhost");
		String mess = "���͵İ�";
		byte[] buf = mess.getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,ia,8800);
		ds.send(dp);
		
		DatagramPacket dpj = new DatagramPacket(buf,buf.length);
		ds.receive(dpj);
		String reply = new String(dpj.getData(),0,dpj.getLength());
		System.out.println(dpj.getAddress().getHostAddress()+"˵:"+reply);
		ds.close();
	}
}
