package ��һ��ʾ��;
import java.util.ArrayList;
import java.util.List;
/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-10-21 ����7:32:00
 */

public class a1_ArrayList_171021 {
	public static void main(String[] args){
		Dog ououDog = new Dog("ŷŷ","ѩ����");
		Dog yayaDog = new Dog("����","��������");
		Dog meimeiDog = new Dog("����","ѩ����");
		Dog feifeiDog = new Dog("�Ʒ�","��������");
		List arrlist = new ArrayList();//ʹ��ArrayList����Ҳ�ɡ�
		arrlist.add(ououDog);
		arrlist.add(yayaDog);
		arrlist.add(meimeiDog);
		arrlist.add(2,feifeiDog);
		for(int i=0; i<arrlist.size();i++){
			Dog dog = (Dog)arrlist.get(i);
			System.out.println("�����������ǣ�"+dog.getName()+"��\t������Ʒ���ǣ�"+dog.getStrain());
		}
		arrlist.remove(1);
		arrlist.remove(meimeiDog);
		System.out.println("ɾ�����������Ϣ��");
		for(int i=0; i<arrlist.size();i++){
			Dog dog = (Dog)arrlist.get(i);
			System.out.println("�����������ǣ�"+dog.getName()+"��\t������Ʒ���ǣ�"+dog.getStrain());
		}
		if(arrlist.contains(feifeiDog)){
			System.out.println("����feifeiDog��");
		}
		else{
			System.out.println("������feifeiDog��");
		}
	}
}
