package ������FileIO��.��ϰ;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version ʱ�䣺2017-12-28 ����11:22:56
 *
 */
public class Test {

	public static void main(String[] args) throws IOException {
		File file1 = new File("1F92Q35Z2-1.jpg");
		File file2 = new File("����1F92Q35Z2-1.jpg");
		FileInputStream fis = new FileInputStream(file1);
		FileReader fr = new FileReader(file1);
//		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream(file2);
//		FileWriter fw = new FileWriter(file2);
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
//		byte[] buf = new byte[1024];//ʹ�������黺���Buffered����
//		char[] buf = new char[1024];//ʹ�������黺���Buffered����
		int b = fis.read();
		while(b!=-1){
			fos.write(b);
			b = fis.read();
		}
		//�޷���
//		bos.flush();
		fos.flush();
		fos.close();
//		bos.close();
//		bis.close();
		fis.close();
//		fw.flush();
//		fw.close();
//		fr.close();
	}

}
