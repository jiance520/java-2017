package ������������.TCP.�����ַ���Ϣ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
/**
 * @version ʱ�䣺2017-12-1 ����8:54:01
 * ����Ҫ���������������ܵ�������ȷ���ķ�����ͨ��Ӳ�̡���Ļ��������һ���˿ڣ�Ȼ��ͨ�������÷�������������ı�������
 ������ִ�з��������򿪶˿ڣ��������пͻ��˱���
 */
public class ClientLogin {
	public static void main(String[] args) throws IOException {
		//-----------------------�ͻ��˷�����Ϣ------------------------------
		//����һ���ͻ��˶��󣬲�ָ��������IP�Ͷ˿�
		Socket socket = new Socket("localhost",8000);
		//������������������Ϣ
		OutputStream os = socket.getOutputStream();//������������ַ�������Ϊû�д洢��ֱ������һ��Ĭ�����ֽڶ�ȡ������Socketֻ��getOutputStream�ֽ��������������ֽ����ͷ��㴫��������ݡ�
		//���������OutputStream�ǽӿڣ�os���ܵ����������õķ�����
		//�ر������رտͻ���
		String info = "�ͻ��˷��͵���Ϣ���û�����TOM�����룺������";//Ҫ���͵���Ϣ��
		os.write(info.getBytes());//�ַ������ܷ��ͣ�ֻ�ܵ��÷���תΪ�ֽ����飬Ϊʲô�ַ�Ҳ����תΪ�ֽڣ���Ϊ�����������һ��unicode,�ֽں��ַ�����һ��unicodeֻ�д���Ӳ��ʱ���ֽ���ռһ���ֽڣ��ַ���ռ�����ֽ�
		socket.shutdownOutput();//�رտͻ��˵�������ܵ�����������������ܵ�
		//-----------------------�ͻ��˽��շ�������������Ϣ------------------------------
		//���Ѵ����Ŀͻ��˶��󣬴�һ���������ܵ����ڿͻ��˵���
		InputStream is = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		info = null;
		while((info = reader.readLine())!=null){
			System.out.println("��������������Ϣ:"+info);
		}
		reader.close();
		is.close();
		os.flush();
		os.close();//�ձ���
		socket.close();//�ձշ���������ռ䣿
	}
}