package ������������.UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * @version ʱ�䣺2017-12-4 ����4:10:25
 *
 */
public class Send {
	public static void main(String[] args) throws IOException  {
		//ʹ��DatagramSocket�����ͽ������ݰ�
		DatagramSocket ds = new DatagramSocket();
		//����ȷ���������ݣ�IP���˿�
		String mess  = "����Send���͵���Ϣ";//ȷ������
		InetAddress ia = InetAddress.getByName("localhost");//��ȡIP
		DatagramPacket dp = new DatagramPacket(mess.getBytes(),mess.getBytes().length,ia,8800);
		ds.send(dp);
		
		//Send����Receive��������Ϣ�������������ݵĻ�������Ͷ���,
		byte[] buf = new byte[1024];
		DatagramPacket dps = new DatagramPacket(buf,buf.length);
		ds.receive(dps);
		//dps.getLength()����dps.getData().length
		String reply = new String(dps.getData(),0,dps.getLength());
		System.out.println(dps.getAddress().getHostAddress()+"˵"+reply);
		ds.close();
	}
}
//----------------�ƿ��ô���----------------
//public class Send {
//	public static void main(String[] args) throws IOException {
//		//��ȡ����������ַ
//		InetAddress ia = InetAddress.getByName("localhost");//�ڸ����������������ȷ�������� IP ��ַ��
//		String mess="��ã�������ѯһ������";
//		//��ʾ�뱾�ضԻ���
//		System.out.println("��˵;"+mess);
//		//����DatagramPacket���󣬷�װ����
//		DatagramPacket dp = new DatagramPacket(mess.getBytes(),mess.getBytes().length,ia,8800);
//		//����DatagramSocket����
//		DatagramSocket ds = new DatagramSocket();
//		//���������������		
//		ds.send(dp);
//		byte[] buf = new byte[1024];
//		DatagramPacket dpre = new DatagramPacket(buf,buf.length);
//		ds.receive(dpre);
//		//��ʾ���յ�����Ϣ
//		String reply = new String(dpre.getData(),0,dpre.getLength());//���ݴ���������buf������������dpre��ȡ
//		System.out.println(dpre.getAddress().getHostAddress()+"˵"+reply);
//		ds.close();
//	}
//}