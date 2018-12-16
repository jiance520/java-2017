package 第四章线程.复习1生产消费;
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
		for (int i = 1; i <= 50; i++) {
			int temp = i%10;
			if(temp == 0){
				temp = 10;
			}
			try {
				p.out("消费",temp);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
