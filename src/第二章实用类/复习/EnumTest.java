package 第二章实用类.复习;
/**
 * @version 时间：2017-12-28 下午9:49:48
 *
 */
interface EnumDemoF{

}
enum EnumDemo implements EnumDemoF{
	Son("小",18),Girl("三",12),Boy("sb",14),Mun;
	String name;
	int age;
	private EnumDemo(){
		
	}
	private EnumDemo(String name, int ordinal) {
		this.name=name;
		this.age=ordinal;
	}
	
}
public class EnumTest {
	public static void main(String[] args) {
		System.out.println(EnumDemo.Boy.name);
	}
}
