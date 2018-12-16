package 第二章实用类;
/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-11-25 下午5:38:59
 JDK1.5新增的常量类：枚举！其成员属性是固定的常量，或者说是枚举元素里的属性也全是固定值。
 枚举就相当于一个final类，自定义的枚举以及其实例化常量成员都是java.lang.Enum的子类，不可以被继承，但可以实现接口！
 枚举可以定义属性、无参有参构造方法、普通方法、抽象方法。 
枚举类可以有自己的构造器，枚举的构造方法一般用private修饰，但是枚举类的实例必须显示的列举出来的，否则不能产生实例。
枚举类型如果有abstract方法的成员，那么必须保证枚举类有一个以上的枚举常量，并且每个枚举常量都提供了该成员的具体实现类体！
 枚举的常量成员就是枚举的实例之一，在枚举外部可以调用枚举的属性和方法！
 枚举的枚举元素，内部可以定义各种类型的变量引用，但是只有被实现的抽象方法能被枚举元素调用！
 定义枚举可以放在类里面，也可以放在类外面。
 定义枚举不能加private、protected、static、final、abstract修饰。
 */
interface demo{	}
enum Week implements demo{//week可以通过构造方法实例化枚举元素
	Mon("星期一",1){//week已经实例化的枚举元素Mon，Mon里面的变量值(实参和形参)都是固定的！
		int num1=1;
		WeekDemo wk = null;
		int fabs(){return num1;};
	},
	Tue("星期二",2){
		int fabs(){return 2;};
	},
	Wed("星期三",3)
	{
		int fabs(){return 3;};
	},
	Thu{
		int fabs(){return 4;};
	};//分号结尾，每一个枚举成员，都相当于一个Week引用，可以调用变量方法。
	private String name;
	private int num;
	Week(){}//有无参的枚举元素必须要有无参构造
	Week(String name,int num){//枚举的有参构造
		this.name=name;
		this.num=num;
	}
	public int get(){//获取元素的的num值。
		return num;
	}
	abstract int fabs();//抽象方法必须被无参和有参实例元素实现。
//	public String toString() {//被重写的继承自Enum的枚举方法
//        return this.num + "_" + this.name;
//	}
}
class WeekDemo{
	public void doWhat(int num){
		switch(num){//通过枚举的get方法获得数字num
		case 1:
			System.out.println("星期一");
			break;
		case 2:
			System.out.println("星期二");
		}
	}
}
public class 枚举 {
	public static void main(String[] args) {
		WeekDemo wd = new WeekDemo();
		wd.doWhat(Week.Tue.get());//可以直接通过枚举元素调用方法
		Week wk = Week.Tue.Mon.Tue.Mon;//枚举的元素就是引用，可以调用同类型引用变量。
		wd.doWhat(wk.get());
		System.out.println(Week.Mon.fabs());
	}
}
