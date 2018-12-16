package 第五章网络编程.UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * @version 时间：2017-12-4 下午4:10:25
 *
 */
public class Send {
	public static void main(String[] args) throws IOException  {
		//使用DatagramSocket对象发送接收数据包
		DatagramSocket ds = new DatagramSocket();
		//首先确定发送内容，IP，端口
		String mess  = "我是Send发送的信息";//确定内容
		InetAddress ia = InetAddress.getByName("localhost");//获取IP
		DatagramPacket dp = new DatagramPacket(mess.getBytes(),mess.getBytes().length,ia,8800);
		ds.send(dp);
		
		//Send接收Receive反馈的信息，创建接收数据的缓存数组和对象,
		byte[] buf = new byte[1024];
		DatagramPacket dps = new DatagramPacket(buf,buf.length);
		ds.receive(dps);
		//dps.getLength()不是dps.getData().length
		String reply = new String(dps.getData(),0,dps.getLength());
		System.out.println(dps.getAddress().getHostAddress()+"说"+reply);
		ds.close();
	}
}
//----------------云课堂代码----------------
//public class Send {
//	public static void main(String[] args) throws IOException {
//		//获取本地主机地址
//		InetAddress ia = InetAddress.getByName("localhost");//在给定主机名的情况下确定主机的 IP 地址。
//		String mess="你好，我想咨询一个问题";
//		//显示与本地对话框
//		System.out.println("我说;"+mess);
//		//创建DatagramPacket对象，封装数据
//		DatagramPacket dp = new DatagramPacket(mess.getBytes(),mess.getBytes().length,ia,8800);
//		//创建DatagramSocket对象，
//		DatagramSocket ds = new DatagramSocket();
//		//向服务器发送数据		
//		ds.send(dp);
//		byte[] buf = new byte[1024];
//		DatagramPacket dpre = new DatagramPacket(buf,buf.length);
//		ds.receive(dpre);
//		//显示接收到的信息
//		String reply = new String(dpre.getData(),0,dpre.getLength());//数据存在数组里buf，用数据引用dpre获取
//		System.out.println(dpre.getAddress().getHostAddress()+"说"+reply);
//		ds.close();
//	}
//}