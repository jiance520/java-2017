package �ڶ���ʵ����;
import java.util.*;
/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-11-26 ����10:51:06
 String���÷�����
��;������ʹ��String����ʵ����֤���������ʽ�Ĺ��ܡ�
	�ж��ַ����ֵĴ�����
 int length();
 ֱ������ַ���������System.out.println(str�ַ�������);
 void toLowerCase();//�ַ���תΪСд
 void toUpperCase();//�ַ���תΪ��д
 String concat(String b);//���ַ���a��b���������������µ��ַ�������ͬ��"+"�š�
 String[] split(separator,limit);
 	//separator,limit��Ϊ��ѡ��separator���ַ����еķָ�������ַ������ﵽlimit�����󣬲��ٲ�֣�����һ�����飡limit���ǲ�ֺ���ַ���������
 	separator�ָ�����������ڲ�ֵ����ַ����С� 
  ��ȡ�������ַ�����
 public int indexOf(int ch);//����ch���ַ����е�һ�γ��ֵ�λ�ã�û���ҵ��򷵻�-1.chֻ�����ַ�'2'���ַ���"2"������������2!ch���±ꡣ
 public int indexOf(String value);//����value���ַ����е�һ�γ��ֵ�λ�ã�û���ҵ��򷵻�-1.
 public int lastIndexOf(int ch);//����ch���ַ��������һ�γ��ֵ�λ�ã�û���ҵ��򷵻�-1.chֻ�����ַ�'2'���ַ���"2"������������2!ch���±ꡣ
 public int lastIndexOf(String value);//����value���ַ��������һ�γ��ֵ�λ�ã�û���ҵ��򷵻�-1.
 public String subString(int index,int len);//���ش��ַ���λ��index��ʼ�Ժ��(len-index)���ַ�,����lenΪ��ѡ,index��λ�����±ꡣ
 public String trim();//����һ���ַ����ĸ���(copy),ȥ����ǰ��Ŀո�.
 �Ƚ�
==//�Ƚ������������͵ı�����ֵ�Ƿ���ȣ�����ǱȽ��������������ݣ������ڴ��ַ�Ƿ���ȡ�
boolean equals(String b);//�Ƚ������ַ������ַ��Ƿ�һ�£����ִ�Сд��
boolean equalsIgnoreCase(String b);//�Ƚ������ַ������ַ��Ƿ�һ�£������ִ�Сд��
int compareToIgnoreCase(String B);//A����B������������A����B����0��AС��B���ظ�������
�Ƚ����Ƚ϶���
public int compare(Object a, Object b);�Ƚ���������,���ظ�����ʾaС��b������0��ʾa��b��ȣ�
����������ʾa����b���Զ�������Ҫʵ��java.util.Comparator�ӿڣ�����д������ 
public int compareTo(String B);//���ֵ�˳��Ƚ������ַ���,A����B������������A����B����0��AС��B���ظ�������
��ĳ���Զ�����Ķ���ʹ��compareTo(Object o)������������ʱ����Ҫʵ��java.lang.Comparable<T>�ӿڣ�
����дpublic int compareTo(T o);������
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
			System.out.println("��������(��123@123.com)��");
			str1=input.next();
		}while(str1.indexOf("@")==-1||str1.indexOf(".")==-1||str1.indexOf("@")>str1.indexOf("."));
		System.out.println("�����ʽ��ȷ��");
	}
}
