package �������߳�.��������;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version ʱ�䣺2017-12-27 ����9:31:51
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
		this.notify();//��ǰ�߳����к󣬼��������ȴ����߳̾���������ǰ�߳���ͣʱ��ȥִ�������̡߳�
		while(cnt == 10){
			this.wait();
		}
		if(cnt<10){
			list.add(ch);
			++cnt;
			System.out.println("����������"+cnt+"����Ʒ���ò�Ʒ�ǣ�"+ch);
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
			System.out.println("�������ѵ�"+(cnt+1)+"����Ʒ���ò�Ʒ�ǣ�"+ch);
		}
	}
}
