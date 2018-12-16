package 第三章FileIO流;
import java.io.*;
/**
 * @version 时间：2017-12-1 下午4:41:03
 readline()方法每次读写一行。bw.newLine();换行
 */
public class BufferedReader_BurreredWriter {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice1\\Test.txt");
			fw = new FileWriter("E:\\计算机编程\\学习笔记\\java笔记\\草稿练习\\src\\practice1\\BufferedWriter复制的Test.txt",true);//文档后追加文档
			br  = new BufferedReader(fr);
			bw  = new BufferedWriter(fw);
			String str = br.readLine();
			bw.newLine();//追加文档前换行
			while(str!=null){
				bw.write(str);
				str = br.readLine();
			}
			bw.newLine();//追加文档后换行
			fw.flush();
			bw.flush();
			fr.close();
			br.close();
			fw.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
