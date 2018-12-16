package 第四章线程.复习2测试循环;
/**
 * @version 时间：2017-12-30 下午5:07:45
 *循环整个锁定的代码块
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
		if(temp==1000){//生产了50个商品，if被In类的for循环控制也变成了循环
			flag = true;
			notifyAll();
		}
	}
	public synchronized void out(String str,int temp) throws InterruptedException{
		if(flag == false){
			wait();
		}
		System.out.println("开始消费");
		System.out.println(str+"第"+temp+"个");
		if(temp==1000){//消费了50个商品
			flag = false;
			notifyAll();
		}
	}
}
