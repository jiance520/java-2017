package �ڶ���ʵ����.��ϰ;
/**
 * @version ʱ�䣺2017-12-28 ����9:49:48
 *
 */
interface EnumDemoF{

}
enum EnumDemo implements EnumDemoF{
	Son("С",18),Girl("��",12),Boy("sb",14),Mun;
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
