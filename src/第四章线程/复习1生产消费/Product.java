package �������߳�.��ϰ1��������;
/**
 * @version ʱ�䣺2017-12-30 ����5:07:45
 *
 */
public class Product {
	boolean flag = false;//û����Ʒ
	public void in(){
		
	}
	public synchronized void in(String str,int temp) throws InterruptedException{
		if(flag == true){//��Ʒ���˻�����Ʒ
			wait();
		}
		System.out.println(str+"��"+temp+"��");
		if(temp==10){
			flag = true;
			notifyAll();
		}
	}
	public synchronized void out(String str,int temp) throws InterruptedException{
		if(flag == false){
			wait();
		}
		System.out.println(str+"��"+temp+"��");
		if(temp==10){
			flag = false;
			notifyAll();
		}
	}
}
