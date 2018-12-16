package 第五章网络编程.TCP.发送对象;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 * @version 时间：2017-12-2 下午11:06:13
 Socket调用方法getOutputStream打开一个字节输出流管道，但是传输的内容和形式，要靠其它流来包装，
 */
class User implements Serializable{//必须记得序列化类
	private String name;
	private int password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
}
public class ClientObject {
	public static void main(String[] args) {
		// -----------------------客户端发送信息------------------------------
		try {
			Socket socket = new Socket("localhost", 8000);
			OutputStream os = socket.getOutputStream();
			User us = new User();
			us.setName("TOM");
			us.setPassword(123);
			ObjectOutputStream oo = new ObjectOutputStream(os);
			oo.writeObject(us);
			oo.flush();
			oo.close();
			os.close();
			socket.close();
		} catch (IOException e) {
		}
	}
}
