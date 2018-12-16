package ������������.TCP.���߳�Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 * @version ʱ�䣺2017-12-3 ����3:45:38
������ֻ��һ�����ͻ����ж������ֻ��һ���̣߳����Է�����Ҫ�ж���߳�������ͬ�ͻ��˵���Ϣ������Ҫ�ü̳�Thread�������ѭ������start()������
���������߳̿������ڷ��ͣ�Ҳ�������ڽ�����Ϣ��
 */
public class SocketObject {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",8000);
			//���������������Ҫ��ͨ���ܵ�
			User us = new User();
			us.setName("TOM");
			us.setPsw(123);
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(os);
			oo.writeObject(us);
			//��ʱ�ر�������ܵ�
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
