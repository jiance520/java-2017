package ������FileIO��;

import java.io.File;

/**
 * @version ʱ�䣺2017-12-12 ����12:19:14
 *���Ŀ¼���ļ��������ļ���
 */
public class File__���Ŀ¼�µ��ļ��� {
	public static void main(String[] args) {
		File file = new File("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice1");
		File pa = file.getParentFile();
		String[] ss = pa.list();
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
	}
}
