package 第三章FileIO流;
import java.io.*;
/**
 * @version 时间：2017-12-1 下午1:58:20
 *
 */
public class DataInputStream_DataOutputStream {
	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\bin\\practice1\\1F92Q35Z2-1.jpg");
//		FileOutputStream fos = new FileOutputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\bin\\practice1\\FileOutputStream复制的1F92Q35Z2-1.jpg");
//		int num = fis.read();//每次读取一个字节
//		while(num!=-1){
//			fos.write(num);
//			num=fis.read();
//		}
//		fos.flush();
//		fis.close();
//		fos.close();
		DataInputStream dis = new DataInputStream(new FileInputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\bin\\practice1\\Test.class"));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\bin\\practice1\\DataOutputStream复制的Test.class"));
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
