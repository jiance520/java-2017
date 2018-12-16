package ������������.UDP.��ϰ.��2�θ�ϰ;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

/**
 * @version ʱ�䣺2017-12-27 ����2:51:07
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
		buf = "��Ҳ��".getBytes();
		dp = new DatagramPacket(buf,buf.length,sa);
		ds.send(dp);
	}

}
