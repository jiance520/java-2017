package �������߳�.�̳߳�ѡѧ.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @version ʱ�䣺2017-12-31 ����10:44:11
 *
 */

public class Test {
	public static void main(String[] args) {
		ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(3);
		System.out.println("��ʱ3sִ��");
		scheduleThreadPool.scheduleAtFixedRate(new MyRunnable(),3,1,TimeUnit.SECONDS);
	}
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"ÿ1sִ��һ��");
	}
	
}
