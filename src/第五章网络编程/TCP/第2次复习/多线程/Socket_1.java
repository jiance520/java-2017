package ������������.TCP.��2�θ�ϰ.���߳�;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

/**
 * @version ʱ�䣺2017-12-26 ����11:20:33
 *
 */
public class Socket_1{
	public static void main(String[] args) throws IOException {
//		Socket socket = new Socket("127.0.0.1",8000);
		Socket socket = new Socket("localhost",8000);
		BufferedOutputStream bw = new BufferedOutputStream(socket.getOutputStream());
		String str = "Hello!";
		byte[] buf = str.getBytes(); 
		bw.write(buf);
		bw.flush();
		bw.close();
		socket.close();
	}
}