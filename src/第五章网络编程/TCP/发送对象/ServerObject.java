package ������������.TCP.���Ͷ���;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @version ʱ�䣺2017-12-2 ����11:05:53
 *
 */
public class ServerObject {
	public static void main(String[] args) {
		// ---------------------���������տͻ��˵���Ϣ-------------------------
		try {
			ServerSocket serversocket = new ServerSocket(8000);
			Socket socket = serversocket.accept();
			InputStream is = socket.getInputStream();
			ObjectInputStream oi = new ObjectInputStream(is);
			User us = (User) (oi.readObject());//ǿ������ת��
			System.out.println("���������յĶ�����Ϣ�ǣ�"+"�û�����"+us.getName() + " " +"���룺"+ us.getPassword());
			oi.close();
			is.close();
			socket.close();
		} catch (Exception e) {
		} 
	}
}
