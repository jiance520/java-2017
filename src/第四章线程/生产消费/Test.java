package �������߳�.��������;
/**
 * @version ʱ�䣺2017-12-27 ����9:32:05
 *
 */
public class Test {

	public static void main(String[] args) {
		Push_Pop pp = new Push_Pop();
		Produce produce = new Produce(pp);
		Use use = new Use(pp);
		Thread t1 = new Thread(produce);
		Thread t2 = new Thread(use);
		t1.start();
		t2.start();
	}
}
