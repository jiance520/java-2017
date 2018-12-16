package 第五章网络编程.TCP.第2次复习.多线程;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 时间：2017-12-26 下午11:23:04
 *
 */
public class RunnableRun implements Runnable {
	Socket socket = null;
	public RunnableRun(Socket socket){
		this.socket = socket;
	}
	public void run(){
		try {
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			int buf = bis.read();
			while(buf!=-1){
				System.out.print((char)buf);
				buf = bis.read();
			}
			bis.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
