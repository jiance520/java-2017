package 第二章实用类;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-11-27 下午3:44:48
 *
 */
public class 示例8_34_String_验证 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1=null;
		int num = 0;
		String name = null;
		do{
			System.out.println("输入文件名(例123.java)：");
			name=input.next();
			num=name.indexOf(".java");
		}while(num==-1||num==0||!(name.substring(num, name.length()).equals(".java")));
		System.out.println("文件格式正确。");
		do{
			System.out.println("输入邮箱(例123@123.com)：");
			str1=input.next();
		}while(str1.indexOf("@")==-1||str1.indexOf(".")==-1||str1.indexOf("@")>str1.indexOf("."));
		System.out.println("邮箱格式正确。");
	}
}
