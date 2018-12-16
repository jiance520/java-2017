package 第五章网络编程.TCP.第3次复习课堂内容;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @version 时间：2018-1-2 上午11:41:02
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		Socket st = new Socket("localhost",9999);
		ObjectOutputStream out1 = new ObjectOutputStream(st.getOutputStream());
		ObjectInputStream oin = new ObjectInputStream(st.getInputStream());
		while(true){
			System.out.println("是否输入，y/n");
			String str = input.nextLine();
			News n2 = new News();
			if(str.equals("y")){
				System.out.println("请输入新闻的标题：");
				String title = input.nextLine();
				System.out.println("请输入新闻的作者：");
				String author = input.nextLine();
				System.out.println("请输入新闻的内容：");
				String details = input.nextLine();
				n2.setTitle(title);
				n2.setAuthor(author);
				n2.setDetails(details);
				out1.writeObject(n2);
				out1.flush();
			}
			else{
				News temp = new News();
				temp.setFlag("quit");
				out1.writeObject(temp);
				out1.flush();
				break;
			}
			News nt = (News)oin.readObject();
			System.out.println(" 客户端是否接收到信息："+nt.flag);
		}
		oin.close();
		out1.close();
	}
}
