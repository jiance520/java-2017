package �������߳�.��ϰ2����ѭ��;
/**
 * @version ʱ�䣺2017-12-30 ����5:07:19
 *
 */
public class Test {

	public static void main(String[] args) {
		Product p = new Product();
		In in = new In(p);
		Out out = new Out(p);
		in.start();
		out.start();
	}

}
