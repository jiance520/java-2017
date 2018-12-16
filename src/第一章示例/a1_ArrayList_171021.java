package 第一章示例;
import java.util.ArrayList;
import java.util.List;
/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-10-21 下午7:32:00
 */

public class a1_ArrayList_171021 {
	public static void main(String[] args){
		Dog ououDog = new Dog("欧欧","雪纳瑞");
		Dog yayaDog = new Dog("亚亚","拉不拉多");
		Dog meimeiDog = new Dog("美美","雪纳瑞");
		Dog feifeiDog = new Dog("菲菲","拉不拉多");
		List arrlist = new ArrayList();//使用ArrayList定义也可。
		arrlist.add(ououDog);
		arrlist.add(yayaDog);
		arrlist.add(meimeiDog);
		arrlist.add(2,feifeiDog);
		for(int i=0; i<arrlist.size();i++){
			Dog dog = (Dog)arrlist.get(i);
			System.out.println("狗狗的名字是："+dog.getName()+"，\t狗狗的品种是："+dog.getStrain());
		}
		arrlist.remove(1);
		arrlist.remove(meimeiDog);
		System.out.println("删除狗狗后的信息。");
		for(int i=0; i<arrlist.size();i++){
			Dog dog = (Dog)arrlist.get(i);
			System.out.println("狗狗的名字是："+dog.getName()+"，\t狗狗的品种是："+dog.getStrain());
		}
		if(arrlist.contains(feifeiDog)){
			System.out.println("包含feifeiDog。");
		}
		else{
			System.out.println("不包含feifeiDog。");
		}
	}
}
