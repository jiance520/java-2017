package 第三章FileIO流;
import java.io.*;
/**
 * @version 时间：2017-12-1 下午3:55:29
必须实现Serializable接口，transient修饰的属性不会序列化，序列化集合，会序列化其中的所有对象！
读取对象可能需要强制类型转换。
 */
class Student implements Serializable{
	String name = "小三";
	transient int age = 19;//被transient 修饰的属性不会序列化
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
			fo = new FileOutputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice1\\ObjectOutputStream对象Test.bin");
			oo = new ObjectOutputStream(fo);
			fi = new FileInputStream("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice1\\ObjectOutputStream对象Test.bin");
			oi = new ObjectInputStream(fi);
			oo.writeObject(st);//把对象st写入一个文件夹内。
			newst = (Student)(oi.readObject());//从文件夹中读出对象st--Test.bin。返回值是Object，需要强制类型转换
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
			} catch (java.io.IOException e) {//还可以在内部导入异常？java.io.IOException
				e.printStackTrace();
			}
		}
		System.out.println(newst.name);
	}
}
