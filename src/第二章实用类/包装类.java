package �ڶ���ʵ����;
import java.util.*;
/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-11-26 ����1:33:49
 ��װ����ʲô�ã�
 ������֣�ͨ������;�̬�������ﵽ���Ե��÷����������֡��ַ��������󡢼���֮��ת�����ﵽ��������Ҫ��
 ���ϲ������Ż������͵����ݣ�����Ҫ������תΪ���󣬴ﵽʹ�ü��ϵ����з����������ݣ���ɾ�Ĳ飬�����ȣ�����ת����
 ����char�İ�װ��û���ַ������췽����Ҳû���ַ�����valueOf������
Boolean�๹�췽������ΪString����ʱ�������ַ�������Ϊtrue(�����Ǵ�Сд)�����Boolean�����ʾtrue�������ʾfalse��
��Number��װ�๹�췽������ΪString����ʱ���ַ�������Ϊnull�� �Ҹ��ַ�������ɽ���Ϊ��Ӧ�Ļ����������͵�����
1.5JDK���װ�����ͻ������Ϳ����Զ�ת����Ҳ����˵�������ֱ����Ϊ�����á�
������Number������Byte��Short��Integer(int)��Long��Float��Double��Boolean��Character
���췽��������ת�ɶ���
public Integer(int num);
public Integer(String "num");
��ͨ������
static Integer valueOf(int num)//���ܵ�ͬ�ڹ��췽��
static Integer valueOf(String "num")
static Integer valueOf(String "num",int num)//num�ǽ��ƣ���"num"����Ϊnum���Ƶ����ֶ���
���ַ���ת�������ֶ�����ͨ�������ֶ���ת�����֣�
int num = (new Integer("12")).intValue();
������ת�����ַ�����
String toString(num);
����ת�������ַ���"ff"����16����ת��Ϊ10����int���֣�����Ϊ255
int num = Integer.parseInt("ff",16);
Integer.valueOf(String "num")��Integer.parseInt(String "num")����һ���Ƿ��ض���һ���Ƿ�������
 */
public class ��װ�� {
	public static void main(String[] args) {
		Integer a = new Integer(8);
		Integer b = new Integer("8");
		Integer c = Integer.valueOf(8);
		List list = new LinkedList<Integer> ();//���ͣ���֤�����Ԫ����Integer����
		list.add(a);
		list.add(b);
		list.add(c);
		Iterator<Integer> it = list.iterator();//��֤����Ԫ�ص�������Integer����
		while(it.hasNext()){
			System.out.println((it.next()).intValue());//����תΪ���������
		}
	}
}
