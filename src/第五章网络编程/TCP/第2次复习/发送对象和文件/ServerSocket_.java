package 第五章网络编程.TCP.第2次复习.发送对象和文件;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket_{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(8000);
		Socket socket = serverSocket.accept();
		ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
		Person p = (Person)oi.readObject();
		System.out.println(p.name);
		socket.shutdownInput();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1F92Q35Z2-1.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
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
		bos.close();
		bis.close();
		oi.close();
		socket.close();
	}
}