package 第四章线程.买车票;
/**
 * @version 时间：2017-12-28 下午4:59:08
 *
 */
class Sys implements Runnable{
	static int ticket = 100;
	public void run(){
		while(true){
			synchronized (this){
			if(ticket>0){
				--ticket;
				System.out.println("线程："+Thread.currentThread().getName()+"正在卖出第"+(ticket+1)+"张票。");
			}
			else{
				break;
			}
			}
		}
	}
}
public class Ticket {
	public static void main(String[] args) {
		Runnable sys = new Sys();
		Thread t1 = new Thread(sys);
		Thread t2 = new Thread(sys);
		t2.start();
		t1.start();
	}
}
