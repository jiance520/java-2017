package 第五章网络编程.TCP.多线程Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @version 时间：2017-12-3 下午3:59:52
 服务器处理客户端请求的线程
 LoginThread类并不能调用run方法，必看它的构造方法，要调用有参才能调用run方法。
 没有无参方法的好处就是，如果里面的方法只能被有参对象引用调用。
 
 可以循环读取来自同一个客户端的信息，也可以读取其它客户端的信息，只要客户端开通了与服务器端口一致的流管道
 端口在服务器类里，但是流管道在线程类里，
 */
public class LoginThread extends Thread{
	Socket socket = null;
	public LoginThread (Socket socket){//关键的一步！
		this.socket = socket;
	}
	public void run(){//run方法只能被有参对象调用，不需要定义无参构造。
		//假设是输入流
		//先要有输入流管道
		try {
			InputStream is = socket.getInputStream();
			ObjectInputStream  oi = new ObjectInputStream(is);
			User us = (User)(oi.readObject());
			System.out.println("服务器读取"+us.getName()+" "+us.getPsw());
			//临时关闭输入流管道
			socket.shutdownInput();
			OutputStream os = socket.getOutputStream();
			String info = "登陆成功";
			os.write(info.getBytes());
			os.flush();
			os.close();
			oi.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
