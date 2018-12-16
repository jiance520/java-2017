package 第三章FileIO流;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @version 时间：2017-12-11 下午5:33:29
 *没有搞懂方法的用法
 */
public class Data_utf8 {

	public static void main(String[] args) throws IOException {
		FileInputStream in1 = new FileInputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice2\\Test.txt");
		BufferedInputStream in2 = new BufferedInputStream(in1);
		DataInputStream in = new DataInputStream(in2);
//		FileOutputStream fos = new FileOutputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice2\\修改Test.txt"");
//		DataOutputStream dos = new DataOutputStream(fos);
		System.out.println(in.readByte());//读取并返回一个输入字节。
		System.out.println((char)(112));
		System.out.println(in.readLong());//读取八个输入字节并返回一个 long 值。
		System.out.println(in.readChar());//读取两个输入字节并返回一个 char 值。
//		System.out.println(in.readUTF());//报读到末尾的异常,读入一个已使用 UTF-8 修改版格式编码的字符串。
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
