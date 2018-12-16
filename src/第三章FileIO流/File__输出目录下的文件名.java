package 第三章FileIO流;

import java.io.File;

/**
 * @version 时间：2017-12-12 下午12:19:14
 *输出目录下文件夹名和文件名
 */
public class File__输出目录下的文件名 {
	public static void main(String[] args) {
		File file = new File("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice1");
		File pa = file.getParentFile();
		String[] ss = pa.list();
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
	}
}
