package 第四章线程.线程池选学.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 时间：2017-12-31 下午11:37:27
 *
 */
public class Test implements Runnable{
	int num;
	public Test(int num) {
		super();
		this.num = num;
	}
	public void run(){
		System.out.println("正在执行任务"+num);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("任务"+num+"执行完毕");
	}
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5,7,300,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(4));
		for (int i = 1; i <= 12; i++) {
			executor.execute(new Test(i));
			System.out.println("线程中的线程数："+executor.getPoolSize()+",当前队列中等待的任务数："+executor.getQueue().size()+"已经执行完的任务数："+executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}
