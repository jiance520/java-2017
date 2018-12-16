package 第二章实用类.内部类;

/**
 * @version 时间：2017-12-15 下午8:14:11
 *
 */
class OutClass{
	InClass ic = new InClass();
	class InClass{
		int a = 10;
		public InClass doit(){
			return new InClass();
		}
	}
}
public class 内部类 {
	public static void main(String[] args) {
		OutClass oc = new OutClass();
		int b = oc.ic.a;
		int c = oc.ic.doit().a;
	}
}
