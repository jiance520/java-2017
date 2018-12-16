package 第二章实用类;
import java.util.*;
/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-11-26 下午1:33:49
 包装类有什么用？
 针对数字，通过构造和静态方法，达到可以调用方法，在数字、字符串、对象、集合之间转换，达到处理数据要求。
 集合不允许存放基本类型的数据，所以要把数据转为对象，达到使用集合的所有方法处理数据，增删改查，遍历等，进制转换。
 但是char的包装类没有字符串构造方法，也没有字符串的valueOf方法。
Boolean类构造方法参数为String类型时，若该字符串内容为true(不考虑大小写)，则该Boolean对象表示true，否则表示false。
当Number包装类构造方法参数为String类型时，字符串不能为null， 且该字符串必须可解析为相应的基本数据类型的数据
1.5JDK后包装类对象和基本类型可以自动转换。也就是说对象可以直接做为数字用。
抽象类Number的子类Byte、Short、Integer(int)、Long、Float、Double；Boolean、Character
构造方法把数字转成对象：
public Integer(int num);
public Integer(String "num");
普通方法：
static Integer valueOf(int num)//功能等同于构造方法
static Integer valueOf(String "num")
static Integer valueOf(String "num",int num)//num是进制，把"num"解析为num进制的数字对象。
把字符串转换成数字对象，再通过把数字对象转成数字：
int num = (new Integer("12")).intValue();
把数字转换成字符串：
String toString(num);
进制转换：将字符串"ff"按照16进制转换为10进制int数字，则结果为255
int num = Integer.parseInt("ff",16);
Integer.valueOf(String "num")和Integer.parseInt(String "num")区别，一个是返回对象，一个是返回数字
 */
public class 包装类 {
	public static void main(String[] args) {
		Integer a = new Integer(8);
		Integer b = new Integer("8");
		Integer c = Integer.valueOf(8);
		List list = new LinkedList<Integer> ();//泛型：保证放入的元素是Integer对象
		list.add(a);
		list.add(b);
		list.add(c);
		Iterator<Integer> it = list.iterator();//保证遍历元素的类型是Integer对象。
		while(it.hasNext()){
			System.out.println((it.next()).intValue());//对象转为数字再输出
		}
	}
}
