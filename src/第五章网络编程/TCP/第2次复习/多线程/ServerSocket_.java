package ������������.TCP.��2�θ�ϰ.���߳�;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @version ʱ�䣺2017-12-26 ����11:19:36
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