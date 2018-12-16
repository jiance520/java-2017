package 第五章网络编程.TCP.第2次复习.发送对象和文件;

import java.io.Serializable;

/**
 * @version 时间：2017-12-26 下午9:38:46
 *
 */
public class Person implements Serializable{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
