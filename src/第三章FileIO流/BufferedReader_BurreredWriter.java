package ������FileIO��;
import java.io.*;
/**
 * @version ʱ�䣺2017-12-1 ����4:41:03
 readline()����ÿ�ζ�дһ�С�bw.newLine();����
 */
public class BufferedReader_BurreredWriter {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice1\\Test.txt");
			fw = new FileWriter("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice1\\BufferedWriter���Ƶ�Test.txt",true);//�ĵ���׷���ĵ�
			br  = new BufferedReader(fr);
			bw  = new BufferedWriter(fw);
			String str = br.readLine();
			bw.newLine();//׷���ĵ�ǰ����
			while(str!=null){
				bw.write(str);
				str = br.readLine();
			}
			bw.newLine();//׷���ĵ�����
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
