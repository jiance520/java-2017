package 第三章FileIO流.序列化和集合;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @version 时间：2017-12-11 下午9:13:38
 *
 */
class Student implements Serializable{
	String name = "三";
	transient int age = 18;
}
public class Test {

	public static void main(String[] args) throws IOException {
		Student stu1 = new Student();
		Student stu2 = new Student();
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		FileOutputStream fo = new FileOutputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice2\\Student.bin");
		ObjectOutputStream oo = new ObjectOutputStream(fo);
		oo.writeObject(list);
	}

}
