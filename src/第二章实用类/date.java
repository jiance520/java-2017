package �ڶ���ʵ����;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-11-30 ����8:34:31
 http://blog.csdn.net/oreo_go/article/details/52157714
 Date��ϵͳ��ǰ����
 DateFormat��SimpleDateFormat�����Ը�ʽ������
 Calendar����������ȡ��Date��ʵ����������þ�̬����Calendar calendar = Calendar.getInstance();
 Ҫ��ס���ڵ���ĸYYYY-MM-DD��Сдy-�꣬��дM-�£�Сдdd-�գ�ʱ���ʽ��HH:mm:ss
 */
public class date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(date));//�Զ����ʽ��ϵͳĬ������date
		Calendar t1 = Calendar.getInstance();
		System.out.println("������"+t1.get(Calendar.YEAR)+"��"+t1.get(Calendar.MONTH)+"��"+t1.get(Calendar.DATE)+"��");
		System.out.println("����������"+(t1.get(Calendar.DAY_OF_WEEK)-1));
	}
}
