package 第五章网络编程.TCP.多线程Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 * @version 时间：2017-12-3 下午3:45:38
服务器只有一个，客户端有多个，但只有一个线程，所以服务器要有多个线程来处理不同客户端的信息。所以要用继承Thread的类对象循环调用start()方法。
服务器的线程可能是在发送，也可能是在接收信息。
 */
public class SocketObject {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",8000);
			//假设是输出流，先要开通流管道
			User us = new User();
			us.setName("TOM");
			us.setPsw(123);
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(os);
			oo.writeObject(us);
			//临时关闭输出流管道
			socket.shutdownOutput();
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = br.readLine();
			while(info!=null){
				System.out.println(info);
				info = br.readLine();
			}
			br.close();
			is.close();
			oo.flush();
			oo.close();
			os.close();
			socket.close();
		} catch (IOException e) {
		}
	}
}
