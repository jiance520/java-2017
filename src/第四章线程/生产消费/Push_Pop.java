package 第四章线程.生产消费;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version 时间：2017-12-27 下午9:31:51
 *
 */
public class Push_Pop{
	int cnt = 0;
//	int count = 0;
	ArrayList<Integer> list = new ArrayList<Integer>();
	public synchronized void push (Integer ch) throws InterruptedException{
//		Iterator it = list.iterator();
//		while(it.hasNext()){
//			++cnt;
//		}
		this.notify();//当前线程运行后，激活其它等待的线程就绪，当当前线程暂停时，去执行其它线程。
		while(cnt == 10){
			this.wait();
		}
		if(cnt<10){
			list.add(ch);
			++cnt;
			System.out.println("正在生产第"+cnt+"个产品，该产品是："+ch);
		}
	}
	public synchronized void pop() throws InterruptedException{
		this.notify();
		while(list.isEmpty()){
			this.wait();
		}
		if(cnt>0){
			--cnt;
			Integer ch = list.remove(cnt);
			System.out.println("正在消费第"+(cnt+1)+"个产品，该产品是："+ch);
		}
	}
}
