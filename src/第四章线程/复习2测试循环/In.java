package 第四章线程.复习2测试循环;
/**
 * @version 时间：2017-12-30 下午5:06:58
 *
 */
public class In extends Thread{
	Product p;
	public In(Product p){
		this.p = p;
	}
	public void run(){
		System.out.println("没有锁定的生产代码1");
		for (int i = 1; i <= 1000; i++) {
			try {
				System.out.println("没有锁定的生产代码2");
				System.out.println("没有锁定的生产代码3");
				p.in("生产",i);
				System.out.println("没有锁定的生产代码4");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
