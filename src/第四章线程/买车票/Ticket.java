package �������߳�.��Ʊ;
/**
 * @version ʱ�䣺2017-12-28 ����4:59:08
 *
 */
class Sys implements Runnable{
	static int ticket = 100;
	public void run(){
		while(true){
			synchronized (this){
			if(ticket>0){
				--ticket;
				System.out.println("�̣߳�"+Thread.currentThread().getName()+"����������"+(ticket+1)+"��Ʊ��");
			}
			else{
				break;
			}
			}
		}
	}
}
public class Ticket {
	public static void main(String[] args) {
		Runnable sys = new Sys();
		Thread t1 = new Thread(sys);
		Thread t2 = new Thread(sys);
		t2.start();
		t1.start();
	}
}
