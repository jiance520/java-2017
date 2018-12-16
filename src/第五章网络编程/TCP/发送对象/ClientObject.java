package ������������.TCP.���Ͷ���;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 * @version ʱ�䣺2017-12-2 ����11:06:13
 Socket���÷���getOutputStream��һ���ֽ�������ܵ������Ǵ�������ݺ���ʽ��Ҫ������������װ��
 */
class User implements Serializable{//����ǵ����л���
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
		// -----------------------�ͻ��˷�����Ϣ------------------------------
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
