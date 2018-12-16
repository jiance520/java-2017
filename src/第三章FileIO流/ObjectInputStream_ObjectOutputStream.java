package ������FileIO��;
import java.io.*;
/**
 * @version ʱ�䣺2017-12-1 ����3:55:29
����ʵ��Serializable�ӿڣ�transient���ε����Բ������л������л����ϣ������л����е����ж���
��ȡ���������Ҫǿ������ת����
 */
class Student implements Serializable{
	String name = "С��";
	transient int age = 19;//��transient ���ε����Բ������л�
}
public class ObjectInputStream_ObjectOutputStream {
	public static void main(String[] args){
		Student st = new Student();
		FileOutputStream fo = null;
		ObjectOutputStream oo = null;
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		Student newst = null;
		try {
			fo = new FileOutputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice1\\ObjectOutputStream����Test.bin");
			oo = new ObjectOutputStream(fo);
			fi = new FileInputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice1\\ObjectOutputStream����Test.bin");
			oi = new ObjectInputStream(fi);
			oo.writeObject(st);//�Ѷ���stд��һ���ļ����ڡ�
			newst = (Student)(oi.readObject());//���ļ����ж�������st--Test.bin������ֵ��Object����Ҫǿ������ת��
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				fo.flush();
				oo.flush();
				fo.close();
				oo.close();
				fi.close();
				oi.close();
			} catch (java.io.IOException e) {//���������ڲ������쳣��java.io.IOException
				e.printStackTrace();
			}
		}
		System.out.println(newst.name);
	}
}
