package 第三章FileIO流.复习;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 时间：2017-12-28 上午11:22:56
 *
 */
public class Test {

	public static void main(String[] args) throws IOException {
		File file1 = new File("1F92Q35Z2-1.jpg");
		File file2 = new File("保存1F92Q35Z2-1.jpg");
		FileInputStream fis = new FileInputStream(file1);
		FileReader fr = new FileReader(file1);
//		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream(file2);
//		FileWriter fw = new FileWriter(file2);
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
//		byte[] buf = new byte[1024];//使用了数组缓存和Buffered缓存
//		char[] buf = new char[1024];//使用了数组缓存和Buffered缓存
		int b = fis.read();
		while(b!=-1){
			fos.write(b);
			b = fis.read();
		}
		//无法打开
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
