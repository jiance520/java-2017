package ������������.TCP.��2�θ�ϰ.���߳�;

import java.io.BufferedOutputStream;
import java.net.Socket;

/**
 * @version ʱ�䣺2017-12-27 ����2:10:59
 *
 */
public class Socket2 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8000);
			BufferedOutputStream bw = new BufferedOutputStream(socket.getOutputStream());
			String str = "World!";
			byte[] buf = str.getBytes(); 
			bw.write(buf);
			bw.flush();
			bw.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
