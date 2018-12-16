package 第五章网络编程.TCP.发送对象;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @version 时间：2017-12-2 下午11:05:53
 *
 */
public class ServerObject {
	public static void main(String[] args) {
		// ---------------------服务器接收客户端的信息-------------------------
		try {
			ServerSocket serversocket = new ServerSocket(8000);
			Socket socket = serversocket.accept();
			InputStream is = socket.getInputStream();
			ObjectInputStream oi = new ObjectInputStream(is);
			User us = (User) (oi.readObject());//强制类型转换
			System.out.println("服务器接收的对象信息是："+"用户名："+us.getName() + " " +"密码："+ us.getPassword());
			oi.close();
			is.close();
			socket.close();
		} catch (Exception e) {
		} 
	}
}
