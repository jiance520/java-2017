package �������߳�.�̳߳�ѡѧ.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version ʱ�䣺2017-12-31 ����11:37:27
 *
 */
public class Test implements Runnable{
	int num;
	public Test(int num) {
		super();
		this.num = num;
	}
	public void run(){
		System.out.println("����ִ������"+num);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("����"+num+"ִ�����");
	}
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5,7,300,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(4));
		for (int i = 1; i <= 12; i++) {
			executor.execute(new Test(i));
			System.out.println("�߳��е��߳�����"+executor.getPoolSize()+",��ǰ�����еȴ�����������"+executor.getQueue().size()+"�Ѿ�ִ�������������"+executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}
