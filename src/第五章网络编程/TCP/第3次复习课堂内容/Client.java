package ������������.TCP.��3�θ�ϰ��������;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @version ʱ�䣺2018-1-2 ����11:41:02
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		Socket st = new Socket("localhost",9999);
		ObjectOutputStream out1 = new ObjectOutputStream(st.getOutputStream());
		ObjectInputStream oin = new ObjectInputStream(st.getInputStream());
		while(true){
			System.out.println("�Ƿ����룬y/n");
			String str = input.nextLine();
			News n2 = new News();
			if(str.equals("y")){
				System.out.println("���������ŵı��⣺");
				String title = input.nextLine();
				System.out.println("���������ŵ����ߣ�");
				String author = input.nextLine();
				System.out.println("���������ŵ����ݣ�");
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
			System.out.println(" �ͻ����Ƿ���յ���Ϣ��"+nt.flag);
		}
		oin.close();
		out1.close();
	}
}
