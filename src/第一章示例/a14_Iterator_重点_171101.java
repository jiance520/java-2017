package 第一章示例;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-11-1 上午10:21:59
 */
public class a14_Iterator_重点_171101 {
	public static void main(String[] args){
		Dog ououDog = new Dog("欧欧","雪纳瑞");//狗对象由名字和品种组成
		Dog yayaDog = new Dog("亚亚","拉不拉多");
		Dog meimeiDog = new Dog("美美","雪纳瑞");
		Dog feifeiDog = new Dog("菲菲","拉不拉多");
		Map dogMap = new HashMap();
//		dogMap.put("欧欧","雪纳瑞");
		dogMap.put(ououDog.getName(), ououDog);//集合dogMap，关键字是狗名，值是狗对象。
		dogMap.put(yayaDog.getName(), yayaDog);
		dogMap.put(meimeiDog.getName(), meimeiDog);
		dogMap.put(feifeiDog.getName(), feifeiDog);
//		System.out.println(ououDog);
		/**
		 * 通过迭代器依次输出集合中所有狗狗的信息
		 */
		System.out.println("使用Iterator遍历，"+"所有狗狗的昵称和品种分别是：");
//		Set keys = dogMap.keySet();//把所有的关键字狗名取出来，放在集合中。
//		//集合调用iterator方法，把狗名集合转为一个Iterator类型，达到可以调用Iterator方法遍历元素。
//		Iterator it = keys.iterator();
		Iterator it = dogMap.keySet().iterator();//把键值集合dogMap变成单一的Set集合来调用iterator()方法。
		while(it.hasNext()){//判断是否有下一个狗名，
			String str = (String)(it.next());//把狗名取出来。
			Dog dog = (Dog)dogMap.get(str);//关键字狗名映射的值是value，即狗对象引用。
//			System.out.println(dog.getName()+","+dog.getStrain());
			System.out.println(str+"\t"+dog.getStrain());
		}
	}
}
//----------方法二(自己的理解：与一三的区别是不采用get方法关键字狗名映射到狗对象)------------
/*
 public class Test {
	public static void main(String[] args){
		Dog ououDog = new Dog("欧欧","雪纳瑞");//狗对象由名字和品种组成
		Dog yayaDog = new Dog("亚亚","拉不拉多");
		Dog meimeiDog = new Dog("美美","雪纳瑞");
		Dog feifeiDog = new Dog("菲菲","拉不拉多");
		Map dogMap = new HashMap();
//		dogMap.put("欧欧","雪纳瑞");
		dogMap.put(ououDog,ououDog.getName());//把关键字和值进行了调换。
		dogMap.put(yayaDog,yayaDog.getName());
		dogMap.put(meimeiDog,meimeiDog.getName());
		dogMap.put(feifeiDog,feifeiDog.getName());
//		System.out.println(ououDog);
		//通过迭代器依次输出集合中所有狗狗的信息
	
		System.out.println("使用Iterator遍历，"+"所有狗狗的昵称和品种分别是：");
		Set keys = dogMap.keySet();//把所有的关键字取出来，放在集合中。
		//集合调用iterator方法，把集合转为一个Iterator类型，达到可以调用Iterator方法遍历元素。
		Iterator it = keys.iterator();
		while(it.hasNext()){//判断是否有下一个，
			Dog dog = (Dog)(it.next());
			System.out.println(dog.getName()+"\t"+dog.getStrain());
		}
	}
}
 */
/*---------------------------------方法三--------------------------------*/

//public class a14_Iterator_重点_171101 {
//	public static void main(String[] args){
//		Dog ououDog = new Dog("欧欧","雪纳瑞");//狗对象由名字和品种组成
//		Dog yayaDog = new Dog("亚亚","拉不拉多");
//		Dog meimeiDog = new Dog("美美","雪纳瑞");
//		Dog feifeiDog = new Dog("菲菲","拉不拉多");
//		Map dogMap = new HashMap();
////		dogMap.put("欧欧","雪纳瑞");
//		dogMap.put(ououDog.getName(), ououDog);//集合dogMap，关键字是狗名，值是狗对象。
//		dogMap.put(yayaDog.getName(), yayaDog);
//		dogMap.put(meimeiDog.getName(), meimeiDog);
//		dogMap.put(feifeiDog.getName(), feifeiDog);
////		System.out.println(ououDog);
//		//通过迭代器依次输出集合中所有狗狗的信息
//		System.out.println("使用Iterator遍历，"+"所有狗狗的昵称和品种分别是：");
//		Set keys = dogMap.keySet();//把所有的关键字狗名取出来，放在集合中。
//		for(Object key:keys){//因为put方法放进去的关键字是泛型K，所以狗名是String类型，还是要写Object
//			Dog dog = (Dog)dogMap.get(key);//关键字狗名映射的值是value，即狗对象引用。
//			System.out.println(key+"\t"+dog.getStrain());
//		}
//	}
//}
