package ������FileIO��;
import java.io.*;
/**
 * @version ʱ�䣺2017-12-1 ����1:58:20
 *
 */
public class DataInputStream_DataOutputStream {
	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\bin\\practice1\\1F92Q35Z2-1.jpg");
//		FileOutputStream fos = new FileOutputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\bin\\practice1\\FileOutputStream���Ƶ�1F92Q35Z2-1.jpg");
//		int num = fis.read();//ÿ�ζ�ȡһ���ֽ�
//		while(num!=-1){
//			fos.write(num);
//			num=fis.read();
//		}
//		fos.flush();
//		fis.close();
//		fos.close();
		DataInputStream dis = new DataInputStream(new FileInputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\bin\\practice1\\Test.class"));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\bin\\practice1\\DataOutputStream���Ƶ�Test.class"));
		byte[] b = new byte[100];
		int num = dis.read(b);
		while(num!=-1){
			dos.write(b);
			num=dis.read();
		}
		dos.flush();
		dis.close();
		dos.close();
	}
}
