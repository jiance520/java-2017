package 第五章网络编程.TCP.多线程Socket;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @version 时间：2017-12-3 下午3:45:15
 *System.out.println(new File(".").getAbsolutePath());
 */
public class ServerObject {
	public static void main(String[] args){
		try {
			ServerSocket serversocket = new ServerSocket(8000);
//一个间接调用run方法的类A一般只有一个，但是实现Runnable的类可以有多个B,C，在主类T里，通过A的对象间接调用B,C对象的start方法开启run线程。
			while(true){//持续监听所有线程。
				Socket socket = serversocket.accept();//监听请求
				LoginThread th = new LoginThread(socket);
				th.start();
			}
		} catch (Exception e) {
		}
	}
}
