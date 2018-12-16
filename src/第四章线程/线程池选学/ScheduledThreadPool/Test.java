package 第四章线程.线程池选学.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @version 时间：2017-12-31 下午10:44:11
 *
 */

public class Test {
	public static void main(String[] args) {
		ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(3);
		System.out.println("延时3s执行");
		scheduleThreadPool.scheduleAtFixedRate(new MyRunnable(),3,1,TimeUnit.SECONDS);
	}
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"每1s执行一次");
	}
	
}
