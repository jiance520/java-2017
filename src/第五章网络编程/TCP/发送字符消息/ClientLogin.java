package 第五章网络编程.TCP.发送字符消息;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
/**
 * @version 时间：2017-12-1 下午8:54:01
 * 首先要创建输入或输出流管道，并明确流的方向是通到硬盘、屏幕、还是另一个端口，然后，通过流调用方法输出或输入文本、对象！
 必须先执行服务器，打开端口，否则运行客户端报错。
 */
public class ClientLogin {
	public static void main(String[] args) throws IOException {
		//-----------------------客户端发送信息------------------------------
		//创建一个客户端对象，并指定服务器IP和端口
		Socket socket = new Socket("localhost",8000);
		//对象打开输出流，发出信息
		OutputStream os = socket.getOutputStream();//输出流不能是字符流，因为没有存储，直接在另一端默认用字节读取，并且Socket只有getOutputStream字节流方法。本身字节流就方便传输各种内容。
		//正常情况下OutputStream是接口，os不能调用子类特用的方法。
		//关闭流，关闭客户端
		String info = "客户端发送的信息，用户名：TOM，密码：１２３";//要发送的信息。
		os.write(info.getBytes());//字符串不能发送，只能调用方法转为字节数组，为什么字符也可以转为字节？因为存入数组的是一个unicode,字节和字符都是一个unicode只有存入硬盘时，字节是占一个字节，字符是占两个字节
		socket.shutdownOutput();//关闭客户端的输出流管道，在下面打开输入流管道
		//-----------------------客户端接收服务器反馈的信息------------------------------
		//用已创建的客户端对象，打开一个输入流管道，在客户端的门
		InputStream is = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		info = null;
		while((info = reader.readLine())!=null){
			System.out.println("服务器反馈的信息:"+info);
		}
		reader.close();
		is.close();
		os.flush();
		os.close();//闭闭流
		socket.close();//闭闭服务器对象空间？
	}
}