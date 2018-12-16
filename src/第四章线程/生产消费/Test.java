package 第四章线程.生产消费;
/**
 * @version 时间：2017-12-27 下午9:32:05
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
