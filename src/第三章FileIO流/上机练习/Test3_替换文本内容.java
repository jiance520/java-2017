package 第三章FileIO流.上机练习;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 时间：2017-12-11 下午3:55:12
 *
 */
public class Test3_替换文本内容 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice2\\Buffered.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice2\\修改的Buffered.txt"));
//---------------------StringBuffer替换不好用-----------------------------
//		StringBuffer sb = new StringBuffer(str1);
//		sb.replace(8, 14, "欧欧");
//		sb.replace(15, 21, "狗狗");//StringBuffer的替换，每次替换内容后，要重新计算下标
//		sb.replace(23, 31, "李伟");
//		String str2 = sb.toString();
//--------------------String的替换，不用StringBuffer--------------------------		
//		String str = br.readLine();
//		while(str!=null){
//			str = str.replace("{name}", "欧欧");
//			str = str.replace("{type}", "狗狗");
//			str = str.replace("{master}", "李伟");
//			bw.write(str);
//			bw.newLine();
//			str = br.readLine();
//		}
//-----------------------不能换行--------------------------------------------
		String str = br.readLine();
		StringBuffer sb = new StringBuffer();
		while(str!=null){
			sb = sb.append(str);
			str = br.readLine();
		}
		String str1 = sb.toString();
		str1 = str1.replace("{name}", "欧欧");
		str1 = str1.replace("{type}", "狗狗");
		str1 = str1.replace("{master}", "李伟");
		bw.write(str1);
		bw.flush();
		bw.close();
		br.close();
	}

}
