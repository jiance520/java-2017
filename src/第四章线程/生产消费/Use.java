package �������߳�.��������;

import java.util.ArrayList;

/**
 * @version ʱ�䣺2017-12-27 ����9:31:01
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
//				Thread.sleep(100);//��֤һ���߳��������������ѭ����
				pp.pop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
