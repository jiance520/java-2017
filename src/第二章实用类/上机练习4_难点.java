package �ڶ���ʵ����;
import java.util.Scanner;
/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-11-27 ����7:17:22
 */
class Goods{
	String name;
	String password;
	int flag=0;//.���±�
	String pricestr = null;
	StringBuffer pricesb = null;
	String[] goods = new String[]{"�����","ϴ�»�","���ӻ�","����","�յ���"};
	double[] price = new double[]{124.23,4500,8800.90,5000.88,4456,12000.46};
	//�ҵ�ÿ��Ԫ����.���ַ����е��±�flag��Ȼ��flag-3������,
	public boolean login(){
		System.out.print("�������û�����");
		Scanner input = new Scanner(System.in);
		name = input.next();
		System.out.print("���������룺");
		password = input.next();
		if (name.equals("a")&&password.equals("1")) {
			return true;
		}
		else{
			return false;
		}
	}
	public void show(){
		System.out.println("*************��ӭ������Ʒ������*************");
		System.out.println("\t���\t��Ʒ\t�۸�");
		for(int i=0;i<goods.length;i++){
			System.out.print(i+1+"\t");
			System.out.print(goods[i]+"\t");
			System.out.println("\t"+change(price[i]));
		}
		System.out.println("*************************************");
	}
	public StringBuffer change(double d){
		pricesb = new StringBuffer(String.valueOf(d));//String���õķ����������±꣬StingBufferҲ�У�
		for (int i = pricesb.indexOf(".")-3; i>0; i=i-3) {
			pricesb.insert(i, ",");//ѭ������,
		}
		return pricesb;
	}
}
public class �ϻ���ϰ4_�ѵ� {
	public static void main(String[] args) {
		Goods gd = new Goods();
		int number;//��Ʒ���
		int count;//��������
		double pricesum;
		boolean flag = false;
		do{
			flag = gd.login();
			if(flag){
				System.out.println("��½�ɹ���");
				break;
			}
			else{
				System.out.println("��½ʧ�ܣ������µ�½��");
			}
		}while(!flag);
		gd.show();
		Scanner input = new Scanner(System.in);
		System.out.print("������������Ʒ��ţ�");
		number = input.nextInt();
		System.out.print("�������������������");
		count = input.nextInt();
		System.out.println("����Ҫ���"+gd.change(gd.price[number-1]*count));
	}
}
