package ������FileIO��;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @version ʱ�䣺2017-12-11 ����5:33:29
 *û�и㶮�������÷�
 */
public class Data_utf8 {

	public static void main(String[] args) throws IOException {
		FileInputStream in1 = new FileInputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice2\\Test.txt");
		BufferedInputStream in2 = new BufferedInputStream(in1);
		DataInputStream in = new DataInputStream(in2);
//		FileOutputStream fos = new FileOutputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice2\\�޸�Test.txt"");
//		DataOutputStream dos = new DataOutputStream(fos);
		System.out.println(in.readByte());//��ȡ������һ�������ֽڡ�
		System.out.println((char)(112));
		System.out.println(in.readLong());//��ȡ�˸������ֽڲ�����һ�� long ֵ��
		System.out.println(in.readChar());//��ȡ���������ֽڲ�����һ�� char ֵ��
//		System.out.println(in.readUTF());//������ĩβ���쳣,����һ����ʹ�� UTF-8 �޸İ��ʽ������ַ�����
//		dos.writeUTF("122131");
//		dos.flush();
//		dos.close();
//		fos.flush();
//		fos.close();
		in.close();
		in2.close();
		in1.close();
	}
}
