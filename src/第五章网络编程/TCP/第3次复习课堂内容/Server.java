package ������������.TCP.��3�θ�ϰ��������;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version ʱ�䣺2018-1-2 ����11:42:03
 *
 */
public class Server {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket ss = new ServerSocket(9999);
		Socket sk = ss.accept();
		ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(sk.getOutputStream());
		while(true){
			News news1 = (News)ois.readObject();
			if(news1.getFlag().equals("quit")){
				break;
			}
			else{
				System.out.println(news1);
				News news2= new News();
				news2.setFlag("success");
				oos.writeObject(news2);
				oos.flush();
			}
		}
		oos.close();
		ois.close();
	}
}
