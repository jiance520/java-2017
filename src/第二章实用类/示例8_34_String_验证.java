package �ڶ���ʵ����;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-11-27 ����3:44:48
 *
 */
public class ʾ��8_34_String_��֤ {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1=null;
		int num = 0;
		String name = null;
		do{
			System.out.println("�����ļ���(��123.java)��");
			name=input.next();
			num=name.indexOf(".java");
		}while(num==-1||num==0||!(name.substring(num, name.length()).equals(".java")));
		System.out.println("�ļ���ʽ��ȷ��");
		do{
			System.out.println("��������(��123@123.com)��");
			str1=input.next();
		}while(str1.indexOf("@")==-1||str1.indexOf(".")==-1||str1.indexOf("@")>str1.indexOf("."));
		System.out.println("�����ʽ��ȷ��");
	}
}
