package �ڶ���ʵ����;
/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-11-27 ����5:13:40
 StringBuffer_StringBuilder��
 ��;��
 ׷���ַ����������ַ�����StringBufferת��Ϊ�ַ���String
String���õķ�����StingBufferҲ�У�
����ֱ�Ӵ�ӡ���StingBuffer������Ϊ�ַ�����
 ����String����ַ����ǹ̶����ɱ�ģ�ֻ��������ָ�������ɵ��ַ�����
StringBuffer��StringBuilder���ַ����ǿɱ�ġ�StringBuffer���̰߳�ȫ�ģ�����ͬ����StringBuilder�ǵ��̣߳�����֮�����ߵȼۡ�
���췽��
StringBuffer sb = new StringBuffer(String str);//�ַ���Stringת��ΪStringBuffer
��ͨ����
public StringBuffer append(String str);//�ַ��������ӣ�append(String str);String��concat()��+�š�
public StringBuffer insert(����λ�ò����±�,Ҫ����Ĳ���);
public String toString(StringBuffer sbr);//StringBufferת��Ϊ�ַ���String
 */
public class StringBuffer_StringBuilder_39 {
     public static void main(String[] args) {
          StringBuffer sb = new StringBuffer("1234567");//˫���ſ��п���
          sb.insert(3, ",");
          System.out.println(sb.toString());
          //--------------------------------------------
          String str1 = "123";
          String str2 = new String("123");
          StringBuffer str3 = new StringBuffer("123");
          System.out.println(str1.equals(str2));//true
          System.out.println(str1.equals(str3));//false
          System.out.println(str2.equals(str3));//false
          System.out.println(str1);//123
          System.out.println(str2);//123
          System.out.println(str3);//123
     }
}

