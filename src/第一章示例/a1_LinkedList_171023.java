package ��һ��ʾ��;
import java.util.LinkedList;
import java.util.List;
/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-10-21 ����7:32:00
 */

public class a1_LinkedList_171023 {
	public static void main(String[] args){
		Dog ououDog = new Dog("ŷŷ","ѩ����");
		Dog yayaDog = new Dog("����","��������");
		Dog meimeiDog = new Dog("����","ѩ����");
		Dog feifeiDog = new Dog("�Ʒ�","��������");
		LinkedList linkedlist = new LinkedList();//����ʹ��List���塣
		linkedlist.add(ououDog);
		linkedlist.add(yayaDog);//�����Զ������ӣ�Ҳ���Զ��������β,ɾ��Ҳ��������ɾ��C���������С�
		linkedlist.addLast(meimeiDog);
		linkedlist.addFirst(feifeiDog);
		for(int i=0; i<linkedlist.size();i++){
			Dog dog = (Dog)linkedlist.get(i);
			System.out.println("�����������ǣ�"+dog.getName()+"��\t������Ʒ���ǣ�"+dog.getStrain());
		}
		linkedlist.remove(1);
		linkedlist.remove(meimeiDog);
		linkedlist.removeFirst();
		System.out.println("ɾ�����������Ϣ��");
		for(int i=0; i<linkedlist.size();i++){
			Dog dog = (Dog)linkedlist.get(i);
			System.out.println("�����������ǣ�"+dog.getName()+"��\t������Ʒ���ǣ�"+dog.getStrain());
		}
		if(linkedlist.contains(feifeiDog)){
			System.out.println("����feifeiDog��");
		}
		else{
			System.out.println("������feifeiDog��");
		}
	}
}
