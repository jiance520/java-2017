package 第二章实用类;
import java.util.Scanner;
/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-11-27 下午7:17:22
 */
class Goods{
	String name;
	String password;
	int flag=0;//.的下标
	String pricestr = null;
	StringBuffer pricesb = null;
	String[] goods = new String[]{"电风扇","洗衣机","电视机","冰箱","空调机"};
	double[] price = new double[]{124.23,4500,8800.90,5000.88,4456,12000.46};
	//找到每个元素中.在字符串中的下标flag，然后flag-3，插入,
	public boolean login(){
		System.out.print("请输入用户名：");
		Scanner input = new Scanner(System.in);
		name = input.next();
		System.out.print("请输入密码：");
		password = input.next();
		if (name.equals("a")&&password.equals("1")) {
			return true;
		}
		else{
			return false;
		}
	}
	public void show(){
		System.out.println("*************欢迎进入商品批发城*************");
		System.out.println("\t编号\t商品\t价格");
		for(int i=0;i<goods.length;i++){
			System.out.print(i+1+"\t");
			System.out.print(goods[i]+"\t");
			System.out.println("\t"+change(price[i]));
		}
		System.out.println("*************************************");
	}
	public StringBuffer change(double d){
		pricesb = new StringBuffer(String.valueOf(d));//String常用的方法，查找下标，StingBuffer也有！
		for (int i = pricesb.indexOf(".")-3; i>0; i=i-3) {
			pricesb.insert(i, ",");//循环插入,
		}
		return pricesb;
	}
}
public class 上机练习4_难点 {
	public static void main(String[] args) {
		Goods gd = new Goods();
		int number;//商品编号
		int count;//批发数量
		double pricesum;
		boolean flag = false;
		do{
			flag = gd.login();
			if(flag){
				System.out.println("登陆成功！");
				break;
			}
			else{
				System.out.println("登陆失败！请重新登陆。");
			}
		}while(!flag);
		gd.show();
		Scanner input = new Scanner(System.in);
		System.out.print("请输入您的商品编号：");
		number = input.nextInt();
		System.out.print("请输入你的批发数量：");
		count = input.nextInt();
		System.out.println("您需要付款："+gd.change(gd.price[number-1]*count));
	}
}
