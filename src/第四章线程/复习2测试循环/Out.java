package �������߳�.��ϰ2����ѭ��;
/**
 * @version ʱ�䣺2017-12-30 ����5:07:07
 *
 */
public class Out extends Thread{
	Product p;
	public Out(Product p){
		this.p = p;
	}
	public void run(){
		System.out.println("û�����������Ѵ���1");
		for (int i = 1; i <= 1000; i++) {
			try {
				System.out.println("û�����������Ѵ���2");
				p.out("����",i);
				System.out.println("û�����������Ѵ���3");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
