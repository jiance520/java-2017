package ������������.TCP.���߳�Socket;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @version ʱ�䣺2017-12-3 ����3:45:15
 *System.out.println(new File(".").getAbsolutePath());
 */
public class ServerObject {
	public static void main(String[] args){
		try {
			ServerSocket serversocket = new ServerSocket(8000);
//һ����ӵ���run��������Aһ��ֻ��һ��������ʵ��Runnable��������ж��B,C��������T�ͨ��A�Ķ����ӵ���B,C�����start��������run�̡߳�
			while(true){//�������������̡߳�
				Socket socket = serversocket.accept();//��������
				LoginThread th = new LoginThread(socket);
				th.start();
			}
		} catch (Exception e) {
		}
	}
}
