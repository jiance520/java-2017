package ������FileIO��.�ϻ���ϰ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @version ʱ�䣺2017-12-11 ����3:55:12
 *
 */
public class Test3_�滻�ı����� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice2\\Buffered.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\�ݸ���ϰ\\src\\practice2\\�޸ĵ�Buffered.txt"));
//---------------------StringBuffer�滻������-----------------------------
//		StringBuffer sb = new StringBuffer(str1);
//		sb.replace(8, 14, "ŷŷ");
//		sb.replace(15, 21, "����");//StringBuffer���滻��ÿ���滻���ݺ�Ҫ���¼����±�
//		sb.replace(23, 31, "��ΰ");
//		String str2 = sb.toString();
//--------------------String���滻������StringBuffer--------------------------		
//		String str = br.readLine();
//		while(str!=null){
//			str = str.replace("{name}", "ŷŷ");
//			str = str.replace("{type}", "����");
//			str = str.replace("{master}", "��ΰ");
//			bw.write(str);
//			bw.newLine();
//			str = br.readLine();
//		}
//-----------------------���ܻ���--------------------------------------------
		String str = br.readLine();
		StringBuffer sb = new StringBuffer();
		while(str!=null){
			sb = sb.append(str);
			str = br.readLine();
		}
		String str1 = sb.toString();
		str1 = str1.replace("{name}", "ŷŷ");
		str1 = str1.replace("{type}", "����");
		str1 = str1.replace("{master}", "��ΰ");
		bw.write(str1);
		bw.flush();
		bw.close();
		br.close();
	}

}
