package 第四章线程.复习2测试循环;
/**
 * @version 时间：2017-12-30 下午5:07:07
 *
 */
public class Out extends Thread{
	Product p;
	public Out(Product p){
		this.p = p;
	}
	public void run(){
		System.out.println("没有锁定的消费代码1");
		for (int i = 1; i <= 1000; i++) {
			try {
				System.out.println("没有锁定的消费代码2");
				p.out("消费",i);
				System.out.println("没有锁定的消费代码3");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
