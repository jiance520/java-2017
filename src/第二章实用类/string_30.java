package 第二章实用类;
import java.util.*;
/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-11-26 下午10:51:06
 String常用方法：
用途举例：使用String方法实现验证电子邮箱格式的功能。
	判断字符出现的次数。
 int length();
 直接输出字符串的内容System.out.println(str字符串引用);
 void toLowerCase();//字符串转为小写
 void toUpperCase();//字符串转为大写
 String concat(String b);//把字符串a和b连接起来，返回新的字符串。等同于"+"号。
 String[] split(separator,limit);
 	//separator,limit都为可选，separator按字符串中的分隔符拆分字符串，达到limit个数后，不再拆分，返回一个数组！limit就是拆分后的字符串个数。
 	separator分隔符不会出现在拆分的新字符串中。 
  提取和搜索字符串：
 public int indexOf(int ch);//返回ch在字符串中第一次出现的位置，没有找到则返回-1.ch只能是字符'2'或字符串"2"，不能是数字2!ch是下标。
 public int indexOf(String value);//返回value在字符串中第一次出现的位置，没有找到则返回-1.
 public int lastIndexOf(int ch);//返回ch在字符串中最后一次出现的位置，没有找到则返回-1.ch只能是字符'2'或字符串"2"，不能是数字2!ch是下标。
 public int lastIndexOf(String value);//返回value在字符串中最后一次出现的位置，没有找到则返回-1.
 public String subString(int index,int len);//返回从字符串位置index开始以后的(len-index)个字符,长度len为可选,index是位不是下标。
 public String trim();//返回一个字符串的副本(copy),去掉其前后的空格.
 比较
==//比较两个基本类型的变量的值是否相等，如果是比较两个引用型数据，则是内存地址是否相等。
boolean equals(String b);//比较两个字符串的字符是否一致，区分大小写。
boolean equalsIgnoreCase(String b);//比较两个字符串的字符是否一致，不区分大小写。
int compareToIgnoreCase(String B);//A大于B返回正整数，A等于B返回0，A小于B返回负整数。
比较器比较对象
public int compare(Object a, Object b);比较两个对象,返回负数表示a小于b，返回0表示a和b相等，
返回正数表示a大于b，自定义类需要实现java.util.Comparator接口，并重写方法。 
public int compareTo(String B);//按字典顺序比较两个字符串,A大于B返回正整数，A等于B返回0，A小于B返回负整数。
当某个自定义类的对象使用compareTo(Object o)方法进行排序时，需要实现java.lang.Comparable<T>接口，
并重写public int compareTo(T o);方法。
 */
public class string_30 {
	public static void main(String[] args) {
		String str = "123@456@78@9@";
		String[] arr = str.split("@",3);
		System.out.println(Arrays.toString(arr));
		System.out.println("A".compareToIgnoreCase("B"));
		Scanner input = new Scanner(System.in);
		String str1=null;
		do{
			System.out.println("输入邮箱(例123@123.com)：");
			str1=input.next();
		}while(str1.indexOf("@")==-1||str1.indexOf(".")==-1||str1.indexOf("@")>str1.indexOf("."));
		System.out.println("邮箱格式正确。");
	}
}
