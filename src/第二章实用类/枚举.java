package �ڶ���ʵ����;
/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-11-25 ����5:38:59
 JDK1.5�����ĳ����ࣺö�٣����Ա�����ǹ̶��ĳ���������˵��ö��Ԫ���������Ҳȫ�ǹ̶�ֵ��
 ö�پ��൱��һ��final�࣬�Զ����ö���Լ���ʵ����������Ա����java.lang.Enum�����࣬�����Ա��̳У�������ʵ�ֽӿڣ�
 ö�ٿ��Զ������ԡ��޲��вι��췽������ͨ���������󷽷��� 
ö����������Լ��Ĺ�������ö�ٵĹ��췽��һ����private���Σ�����ö�����ʵ��������ʾ���оٳ����ģ������ܲ���ʵ����
ö�����������abstract�����ĳ�Ա����ô���뱣֤ö������һ�����ϵ�ö�ٳ���������ÿ��ö�ٳ������ṩ�˸ó�Ա�ľ���ʵ�����壡
 ö�ٵĳ�����Ա����ö�ٵ�ʵ��֮һ����ö���ⲿ���Ե���ö�ٵ����Ժͷ�����
 ö�ٵ�ö��Ԫ�أ��ڲ����Զ���������͵ı������ã�����ֻ�б�ʵ�ֵĳ��󷽷��ܱ�ö��Ԫ�ص��ã�
 ����ö�ٿ��Է��������棬Ҳ���Է��������档
 ����ö�ٲ��ܼ�private��protected��static��final��abstract���Ρ�
 */
interface demo{	}
enum Week implements demo{//week����ͨ�����췽��ʵ����ö��Ԫ��
	Mon("����һ",1){//week�Ѿ�ʵ������ö��Ԫ��Mon��Mon����ı���ֵ(ʵ�κ��β�)���ǹ̶��ģ�
		int num1=1;
		WeekDemo wk = null;
		int fabs(){return num1;};
	},
	Tue("���ڶ�",2){
		int fabs(){return 2;};
	},
	Wed("������",3)
	{
		int fabs(){return 3;};
	},
	Thu{
		int fabs(){return 4;};
	};//�ֺŽ�β��ÿһ��ö�ٳ�Ա�����൱��һ��Week���ã����Ե��ñ���������
	private String name;
	private int num;
	Week(){}//���޲ε�ö��Ԫ�ر���Ҫ���޲ι���
	Week(String name,int num){//ö�ٵ��вι���
		this.name=name;
		this.num=num;
	}
	public int get(){//��ȡԪ�صĵ�numֵ��
		return num;
	}
	abstract int fabs();//���󷽷����뱻�޲κ��в�ʵ��Ԫ��ʵ�֡�
//	public String toString() {//����д�ļ̳���Enum��ö�ٷ���
//        return this.num + "_" + this.name;
//	}
}
class WeekDemo{
	public void doWhat(int num){
		switch(num){//ͨ��ö�ٵ�get�����������num
		case 1:
			System.out.println("����һ");
			break;
		case 2:
			System.out.println("���ڶ�");
		}
	}
}
public class ö�� {
	public static void main(String[] args) {
		WeekDemo wd = new WeekDemo();
		wd.doWhat(Week.Tue.get());//����ֱ��ͨ��ö��Ԫ�ص��÷���
		Week wk = Week.Tue.Mon.Tue.Mon;//ö�ٵ�Ԫ�ؾ������ã����Ե���ͬ�������ñ�����
		wd.doWhat(wk.get());
		System.out.println(Week.Mon.fabs());
	}
}
