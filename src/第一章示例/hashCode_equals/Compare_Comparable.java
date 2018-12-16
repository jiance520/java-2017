package 第一章示例.hashCode_equals;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @version 时间：2017-12-23 下午3:12:58
 *
 */
class Person implements Comparable<Person>{
	int age = 18;	
	public int compareTo(Person o) {
		return age-o.age;
	}
}
class Man implements Comparator<Person>{
	int age = 18;
	public int compare(Person o1, Person o2) {
		return o1.age-o2.age;
	}	
}
public class Compare_Comparable {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Man m1 = new Man();
		System.out.println(p1.compareTo(p2));
		System.out.println(m1.compare(p1,p2));
	}
}
