package �ڶ���ʵ����.�ڲ���;

/**
 * @version ʱ�䣺2017-12-15 ����8:14:11
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
public class �ڲ��� {
	public static void main(String[] args) {
		OutClass oc = new OutClass();
		int b = oc.ic.a;
		int c = oc.ic.doit().a;
	}
}
