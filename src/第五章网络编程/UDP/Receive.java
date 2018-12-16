package ������������.UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
/**
 * @version ʱ�䣺2017-12-4 ����4:40:31
 *
 */
public class Receive {
	public static void main(String[] args) throws IOException {
		//ʹ��DatagramSocket�������ݣ���ȷ���˿ڣ��ٴӻ����ȡIP���ڷ�����Ϣ,��ȡ����
		DatagramSocket ds = new DatagramSocket(8800);//ȷ���˿�
		//ʹ���ֽ����黺����յ����ݰ�
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//���ջ������ݣ��ٸ�ֵ���ַ���
		ds.receive(dp);
		//dp.getLength()����dp.getData().length
		String mess = new String(dp.getData(),0,dp.getLength());
		System.out.println(dp.getAddress().getHostAddress()+"˵"+mess);//����ַ���
		
		//˭��������ݰ���˭����ȡ�Է�Socket��IP���мǣ�һ��Ҫ��ds.receive(dp);֮����ܻ�ȡIP�Ͷ˿�
		SocketAddress sa = dp.getSocketAddress();
		//Receive����������Ϣ��Send,��ȷ�����ݰ��ַ����ݣ�Ҫת�ֽ����飬sa�Ƿ��͵�IP��ַ�Ͷ˿�
		String reply = "����Send�ķ���";
		DatagramPacket dpto = new DatagramPacket(reply.getBytes(),reply.getBytes().length,sa);
		ds.send(dpto);
		ds.close();
	}
}
//----------------�ƿ��ô���----------------
//public class Receive {
//	public static void main(String[] args) throws IOException {
//		DatagramPacket dp = null;
//		DatagramSocket ds = null;
//		DatagramPacket dpto = null;
//		byte[] buf = new byte[1024];
//		//����DatagrabPacket���������������ݰ�
//		dp = new DatagramPacket(buf,buf.length);
//		//����DatagramSocket����������������
//		ds = new DatagramSocket(8800);
//		ds.receive(dp);
//		//��ʾ���յ���Ϣ
//		String mess = new String(dp.getData(),0,dp.getLength());
//		System.out.println(dp.getAddress().getHostAddress()+"˵"+mess);
//		String reply = "��ã����ڣ�����ѯ";
//		
//		SocketAddress sa = dp.getSocketAddress();
//		//����DatagramPacket���󣬷�װ����
//		dpto = new DatagramPacket(reply.getBytes(),reply.getBytes().length,sa);
//		//��ʾ�뱾�ضԻ���
//		System.out.println("��˵"+reply);
//		ds.send(dpto);
//		ds.close();
//	}
//}
