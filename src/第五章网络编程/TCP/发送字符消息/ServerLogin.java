package ������������.TCP.�����ַ���Ϣ;

import java.io.*;
import java.net.*;

/**
 * @version ʱ�䣺2017-12-1 ����8:48:26
 ��������֮�䲻��ͨ�������Լ��Ķ������������öԷ�������
 ����ͨ���Լ��ķ�����ȡ�Է������ã������öԷ��ķ�����
 */
public class ServerLogin {
	public static void main(String[] args) throws IOException {
		//---------------------���������տͻ��˵���Ϣ-------------------------
		//�½�һ������������ָ���������˿ں�
		ServerSocket serversocket = new ServerSocket(8000);//��Ҫ��һ���˿ڣ������ҵ�����ڡ�
		//�������������������accept()�û�����
		Socket socket = serversocket.accept();//ָ���˿ڵķ�������������һ���ͻ��˶���ͨ���ö�������һ���������ܵ����ն˵��ţ����ͻ��˷�����ϵ��
		//Ҳ����˵һ�����ܵ��ǿ�ͬһ����Ķ������ͣ����ò�ͬ�ķ���������ֵ�������������������������������˺�����˶˿ڵ��ţ��������ת�䡣
		//����һ����ServerSocketֻ����Ϊ���������������������û�����
		InputStream is = socket.getInputStream();//�Ȳ��ܷ�������ôһ���£���Ҫ��һ��������������Դ���ǵ�ǰ����Ӳ�̵�����ļ���������һ̨���ԣ����ͻ�������������������������������á�
//		InputStreamReader isr = new InputStreamReader(is);//�ֽ���ת�ַ���������ٶ�
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));//�ַ���ת������������ٶ�
		String info = null;
		while((info=reader.readLine())!=null){//ѭ����ȡ����Ϣ
			System.out.println("��������ȡ������Ϣ�ǣ�"+info);
			info = reader.readLine();
		}
		socket.shutdownInput();//�ڷ�����������Ϣǰ�ر��������ܵ��������濪��������ܵ�
		//----------------------����˷�����Ϣ---------------------------
		//��ԭ�������Ŀͻ��˶��󣬴�һ��������ܵ��ķ������˵���
		OutputStream os = socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		bw.write("��½�ɹ�");
		//�رշ��������رշ�����
		os.flush();
		bw.close();
		os.close();
		reader.close();
		is.close();
		socket.close();
		serversocket.close();//�ȹ����ٹط��������ȹط��������ٹؿͻ���
	}
}
