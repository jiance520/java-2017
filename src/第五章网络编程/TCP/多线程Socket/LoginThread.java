package ������������.TCP.���߳�Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @version ʱ�䣺2017-12-3 ����3:59:52
 ����������ͻ���������߳�
 LoginThread�ಢ���ܵ���run�������ؿ����Ĺ��췽����Ҫ�����вβ��ܵ���run������
 û���޲η����ĺô����ǣ��������ķ���ֻ�ܱ��вζ������õ��á�
 
 ����ѭ����ȡ����ͬһ���ͻ��˵���Ϣ��Ҳ���Զ�ȡ�����ͻ��˵���Ϣ��ֻҪ�ͻ��˿�ͨ����������˿�һ�µ����ܵ�
 �˿��ڷ���������������ܵ����߳����
 */
public class LoginThread extends Thread{
	Socket socket = null;
	public LoginThread (Socket socket){//�ؼ���һ����
		this.socket = socket;
	}
	public void run(){//run����ֻ�ܱ��вζ�����ã�����Ҫ�����޲ι��졣
		//������������
		//��Ҫ���������ܵ�
		try {
			InputStream is = socket.getInputStream();
			ObjectInputStream  oi = new ObjectInputStream(is);
			User us = (User)(oi.readObject());
			System.out.println("��������ȡ"+us.getName()+" "+us.getPsw());
			//��ʱ�ر��������ܵ�
			socket.shutdownInput();
			OutputStream os = socket.getOutputStream();
			String info = "��½�ɹ�";
			os.write(info.getBytes());
			os.flush();
			os.close();
			oi.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
