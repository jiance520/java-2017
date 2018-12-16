package 第四章线程.生产消费;

import java.util.ArrayList;

/**
 * @version 时间：2017-12-27 下午9:31:01
 *
 */
public class Use implements Runnable{
	Push_Pop  pp;
//	ArrayList<Integer> list = new ArrayList<Integer>();
	public Use(Push_Pop pp){
		this.pp = pp;
	}
	public void run(){
		for (int i = 1; i <= 10; i++) {
			try {
//				Thread.sleep(100);//保证一个线程慢，不会进入死循环。
				pp.pop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
