package �������߳�.��ϰ2����ѭ��;
/**
 * @version ʱ�䣺2017-12-30 ����5:06:58
 *
 */
public class In extends Thread{
	Product p;
	public In(Product p){
		this.p = p;
	}
	public void run(){
		System.out.println("û����������������1");
		for (int i = 1; i <= 1000; i++) {
			try {
				System.out.println("û����������������2");
				System.out.println("û����������������3");
				p.in("����",i);
				System.out.println("û����������������4");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
