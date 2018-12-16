package 第一章示例;
import java.util.LinkedList;
import java.util.List;
/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-10-21 下午7:32:00
 */

public class a1_LinkedList_171023 {
	public static void main(String[] args){
		Dog ououDog = new Dog("欧欧","雪纳瑞");
		Dog yayaDog = new Dog("亚亚","拉不拉多");
		Dog meimeiDog = new Dog("美美","雪纳瑞");
		Dog feifeiDog = new Dog("菲菲","拉不拉多");
		LinkedList linkedlist = new LinkedList();//不能使用List定义。
		linkedlist.add(ououDog);
		linkedlist.add(yayaDog);//即可以定义随便加，也可以定义加在首尾,删除也可以随意删，C语言链表不行。
		linkedlist.addLast(meimeiDog);
		linkedlist.addFirst(feifeiDog);
		for(int i=0; i<linkedlist.size();i++){
			Dog dog = (Dog)linkedlist.get(i);
			System.out.println("狗狗的名字是："+dog.getName()+"，\t狗狗的品种是："+dog.getStrain());
		}
		linkedlist.remove(1);
		linkedlist.remove(meimeiDog);
		linkedlist.removeFirst();
		System.out.println("删除狗狗后的信息。");
		for(int i=0; i<linkedlist.size();i++){
			Dog dog = (Dog)linkedlist.get(i);
			System.out.println("狗狗的名字是："+dog.getName()+"，\t狗狗的品种是："+dog.getStrain());
		}
		if(linkedlist.contains(feifeiDog)){
			System.out.println("包含feifeiDog。");
		}
		else{
			System.out.println("不包含feifeiDog。");
		}
	}
}
