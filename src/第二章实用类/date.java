package 第二章实用类;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-11-30 上午8:34:31
 http://blog.csdn.net/oreo_go/article/details/52157714
 Date：系统当前日期
 DateFormat、SimpleDateFormat：可以格式化日期
 Calendar抽象类用来取代Date：实例化对象调用静态方法Calendar calendar = Calendar.getInstance();
 要记住日期的字母YYYY-MM-DD：小写y-年，大写M-月，小写dd-日，时间格式：HH:mm:ss
 */
public class date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));//自定义格式化系统默认日期date
		Calendar t1 = Calendar.getInstance();
		System.out.println("今天是"+t1.get(Calendar.YEAR)+"年"+t1.get(Calendar.MONTH)+"月"+t1.get(Calendar.DATE)+"日");
		System.out.println("今天是星期"+(t1.get(Calendar.DAY_OF_WEEK)-1));
	}
}
