package 第五章网络编程.TCP.发送字符消息;

import java.io.*;
import java.net.*;

/**
 * @version 时间：2017-12-1 下午8:48:26
 两个对象之间不是通过传递自己的对象引用来调用对方方法，
 而是通过自己的方法获取对方的引用，来调用对方的方法。
 */
public class ServerLogin {
	public static void main(String[] args) throws IOException {
		//---------------------服务器接收客户端的信息-------------------------
		//新建一个服务器对象，指定服务器端口号
		ServerSocket serversocket = new ServerSocket(8000);//先要有一个端口，让流找到出入口。
		//服务器对象监听并接受accept()用户请求
		Socket socket = serversocket.accept();//指定端口的服务器方法产生一个客户端对象，通过该对象来打开一个输入流管道接收端的门，跟客户端发生关系。
		//也就是说一个流管道是靠同一个类的对象类型，调用不同的方法，返回值生成输入流和输出流，来打开流的输入端和输出端端口的门，完成连接转输。
		//另外一个类ServerSocket只是作为服务器打开输入流，处理用户请求
		InputStream is = socket.getInputStream();//先不管方法是怎么一回事，先要有一个输入流，其来源不是当前电脑硬盘的里的文件，而是另一台电脑，即客户端生成输入流，就是这个方法的作用。
//		InputStreamReader isr = new InputStreamReader(is);//字节流转字符流，提高速度
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));//字符流转缓冲流，提高速度
		String info = null;
		while((info=reader.readLine())!=null){//循环读取流信息
			System.out.println("服务器读取的流信息是："+info);
			info = reader.readLine();
		}
		socket.shutdownInput();//在服务器反馈信息前关闭输入流管道。在下面开启输出流管道
		//----------------------服务端反馈信息---------------------------
		//用原来创建的客户端对象，打开一个输出流管道的服务器端的门
		OutputStream os = socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		bw.write("登陆成功");
		//关闭服务器，关闭服务器
		os.flush();
		bw.close();
		os.close();
		reader.close();
		is.close();
		socket.close();
		serversocket.close();//先关流再关服务器，先关服务器，再关客户端
	}
}
