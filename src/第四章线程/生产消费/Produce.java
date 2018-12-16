package 第四章线程.生产消费;

import java.util.ArrayList;

/**
 * @version 时间：2017-12-27 下午9:29:19
 *
 */
public class Produce implements Runnable{
	Push_Pop  pp;
//	ArrayList<Integer> list = new ArrayList<Integer>();
	public Produce(Push_Pop pp){
		this.pp = pp;
	}
	public void run(){
		for (int i = 1; i <= 10; i++) {
			Integer ch = new Integer(i);
			try {
				pp.push(ch);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
