package ������FileIO��.���л��ͼ���;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @version ʱ�䣺2017-12-11 ����9:13:38
 *
 */
class Student implements Serializable{
	String name = "��";
	transient int age = 18;
}
public class Test {

	public static void main(String[] args) throws IOException {
		Student stu1 = new Student();
		Student stu2 = new Student();
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		FileOutputStream fo = new FileOutputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice2\\Student.bin");
		ObjectOutputStream oo = new ObjectOutputStream(fo);
		oo.writeObject(list);
	}

}
