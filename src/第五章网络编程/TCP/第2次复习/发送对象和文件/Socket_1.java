package ������������.TCP.��2�θ�ϰ.���Ͷ�����ļ�;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Socket_1{
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",8000);
		ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
		Person p = new Person("��",18);
		oo.writeObject(p);
		socket.shutdownOutput();
		BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("���Ƶ�1F92Q35Z2-1.jpg"));
//		int buf = bis.read();
//		while(buf!=-1){
//			bos.write(buf);
//			buf = bis.read();
//		}
		byte[] buf = new byte[1024];
		int len = bis.read(buf);
		while(len!=-1){
			bos.write(buf,0,len);
			len = bis.read(buf);
		}
		bos.flush();
		oo.flush();
		bos.close();
		bis.close();
		oo.close();
		socket.close();
	}
}