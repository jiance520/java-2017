package 第五章网络编程.TCP.第2次复习.多线程;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @version 时间：2017-12-26 下午11:19:36
 *
 */
public class ServerSocket_{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(8000);
		Socket socket;
		while(true){
			socket = serverSocket.accept();
			Runnable run = new RunnableRun(socket);
			Thread t1 = new Thread(run);
			t1.start();
		}
	}
}