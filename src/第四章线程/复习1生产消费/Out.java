package �������߳�.��ϰ1��������;
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
		for (int i = 1; i <= 50; i++) {
			int temp = i%10;
			if(temp == 0){
				temp = 10;
			}
			try {
				p.out("����",temp);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
