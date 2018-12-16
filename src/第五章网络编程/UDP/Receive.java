package 第五章网络编程.UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
/**
 * @version 时间：2017-12-4 下午4:40:31
 *
 */
public class Receive {
	public static void main(String[] args) throws IOException {
		//使用DatagramSocket接收数据，先确定端口，再从缓存获取IP用于返回信息,读取数据
		DatagramSocket ds = new DatagramSocket(8800);//确定端口
		//使用字节数组缓存接收的数据包
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//接收缓存数据，再赋值给字符串
		ds.receive(dp);
		//dp.getLength()不是dp.getData().length
		String mess = new String(dp.getData(),0,dp.getLength());
		System.out.println(dp.getAddress().getHostAddress()+"说"+mess);//输出字符串
		
		//谁缓存的数据包，谁来获取对方Socket的IP，切记，一定要在ds.receive(dp);之后才能获取IP和端口
		SocketAddress sa = dp.getSocketAddress();
		//Receive反馈发送信息给Send,先确定数据包字符内容，要转字节数组，sa是发送的IP地址和端口
		String reply = "我是Send的反馈";
		DatagramPacket dpto = new DatagramPacket(reply.getBytes(),reply.getBytes().length,sa);
		ds.send(dpto);
		ds.close();
	}
}
//----------------云课堂代码----------------
//public class Receive {
//	public static void main(String[] args) throws IOException {
//		DatagramPacket dp = null;
//		DatagramSocket ds = null;
//		DatagramPacket dpto = null;
//		byte[] buf = new byte[1024];
//		//创建DatagrabPacket对象，用来接收数据包
//		dp = new DatagramPacket(buf,buf.length);
//		//创建DatagramSocket对象，用来接收数据
//		ds = new DatagramSocket(8800);
//		ds.receive(dp);
//		//显示接收的信息
//		String mess = new String(dp.getData(),0,dp.getLength());
//		System.out.println(dp.getAddress().getHostAddress()+"说"+mess);
//		String reply = "你好，我在，请咨询";
//		
//		SocketAddress sa = dp.getSocketAddress();
//		//创建DatagramPacket对象，封装数据
//		dpto = new DatagramPacket(reply.getBytes(),reply.getBytes().length,sa);
//		//显示与本地对话框
//		System.out.println("我说"+reply);
//		ds.send(dpto);
//		ds.close();
//	}
//}
