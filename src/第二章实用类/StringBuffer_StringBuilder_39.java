package 第二章实用类;
/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-11-27 下午5:13:40
 StringBuffer_StringBuilder，
 用途：
 追加字符串，插入字符串，StringBuffer转换为字符串String
String常用的方法，StingBuffer也有！
可以直接打印输出StingBuffer的引用为字符串。
 区别：String类的字符串是固定不可变的，只能让引用指向新生成的字符串。
StringBuffer和StringBuilder则字符串是可变的。StringBuffer是线程安全的，可以同步，StringBuilder是单线程，除此之外两者等价。
构造方法
StringBuffer sb = new StringBuffer(String str);//字符串String转换为StringBuffer
普通方法
public StringBuffer append(String str);//字符串的连接：append(String str);String的concat()和+号。
public StringBuffer insert(插入位置不是下标,要插入的参数);
public String toString(StringBuffer sbr);//StringBuffer转换为字符串String
 */
public class StringBuffer_StringBuilder_39 {
     public static void main(String[] args) {
          StringBuffer sb = new StringBuffer("1234567");//双引号可有可无
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

