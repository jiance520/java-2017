package 第四章线程.复习1生产消费;
/**
 * @version 时间：2017-12-30 下午5:07:19
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
