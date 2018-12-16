package 第四章线程.复习1生产消费;
/**
 * @version 时间：2017-12-30 下午5:07:45
 *
 */
public class Product {
	boolean flag = false;//没有商品
	public void in(){
		
	}
	public synchronized void in(String str,int temp) throws InterruptedException{
		if(flag == true){//商品满了或有商品
			wait();
		}
		System.out.println(str+"第"+temp+"个");
		if(temp==10){
			flag = true;
			notifyAll();
		}
	}
	public synchronized void out(String str,int temp) throws InterruptedException{
		if(flag == false){
			wait();
		}
		System.out.println(str+"第"+temp+"个");
		if(temp==10){
			flag = false;
			notifyAll();
		}
	}
}
