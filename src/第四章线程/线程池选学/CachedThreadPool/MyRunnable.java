package 第四章线程.线程池选学.CachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 时间：2017-12-31 下午6:30:54
 *newCachedThreadPool()
 */
public class MyRunnable implements Runnable{
	int num;
	
	public MyRunnable(int num) {
		super();
		this.num = num;
	}

	public void run(){
		System.out.println(Thread.currentThread().getName()+","+num);
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			cachedThreadPool.execute(new MyRunnable(i));
//			Thread.sleep(200);
		}
	}

}
