package �������߳�.��ϰ1��������;
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
		for (int i = 1; i <= 50; i++) {
			int temp = i%10;
			if(temp == 0){
				temp = 10;
			}
			try {
				p.in("����",temp);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
