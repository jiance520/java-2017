package ��һ��ʾ��;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-11-1 ����10:21:59
 */
public class a14_Iterator_�ص�_171101 {
	public static void main(String[] args){
		Dog ououDog = new Dog("ŷŷ","ѩ����");//�����������ֺ�Ʒ�����
		Dog yayaDog = new Dog("����","��������");
		Dog meimeiDog = new Dog("����","ѩ����");
		Dog feifeiDog = new Dog("�Ʒ�","��������");
		Map dogMap = new HashMap();
//		dogMap.put("ŷŷ","ѩ����");
		dogMap.put(ououDog.getName(), ououDog);//����dogMap���ؼ����ǹ�����ֵ�ǹ�����
		dogMap.put(yayaDog.getName(), yayaDog);
		dogMap.put(meimeiDog.getName(), meimeiDog);
		dogMap.put(feifeiDog.getName(), feifeiDog);
//		System.out.println(ououDog);
		/**
		 * ͨ������������������������й�������Ϣ
		 */
		System.out.println("ʹ��Iterator������"+"���й������ǳƺ�Ʒ�ֱַ��ǣ�");
//		Set keys = dogMap.keySet();//�����еĹؼ��ֹ���ȡ���������ڼ����С�
//		//���ϵ���iterator�������ѹ�������תΪһ��Iterator���ͣ��ﵽ���Ե���Iterator��������Ԫ�ء�
//		Iterator it = keys.iterator();
		Iterator it = dogMap.keySet().iterator();//�Ѽ�ֵ����dogMap��ɵ�һ��Set����������iterator()������
		while(it.hasNext()){//�ж��Ƿ�����һ��������
			String str = (String)(it.next());//�ѹ���ȡ������
			Dog dog = (Dog)dogMap.get(str);//�ؼ��ֹ���ӳ���ֵ��value�������������á�
//			System.out.println(dog.getName()+","+dog.getStrain());
			System.out.println(str+"\t"+dog.getStrain());
		}
	}
}
//----------������(�Լ�����⣺��һ���������ǲ�����get�����ؼ��ֹ���ӳ�䵽������)------------
/*
 public class Test {
	public static void main(String[] args){
		Dog ououDog = new Dog("ŷŷ","ѩ����");//�����������ֺ�Ʒ�����
		Dog yayaDog = new Dog("����","��������");
		Dog meimeiDog = new Dog("����","ѩ����");
		Dog feifeiDog = new Dog("�Ʒ�","��������");
		Map dogMap = new HashMap();
//		dogMap.put("ŷŷ","ѩ����");
		dogMap.put(ououDog,ououDog.getName());//�ѹؼ��ֺ�ֵ�����˵�����
		dogMap.put(yayaDog,yayaDog.getName());
		dogMap.put(meimeiDog,meimeiDog.getName());
		dogMap.put(feifeiDog,feifeiDog.getName());
//		System.out.println(ououDog);
		//ͨ������������������������й�������Ϣ
	
		System.out.println("ʹ��Iterator������"+"���й������ǳƺ�Ʒ�ֱַ��ǣ�");
		Set keys = dogMap.keySet();//�����еĹؼ���ȡ���������ڼ����С�
		//���ϵ���iterator�������Ѽ���תΪһ��Iterator���ͣ��ﵽ���Ե���Iterator��������Ԫ�ء�
		Iterator it = keys.iterator();
		while(it.hasNext()){//�ж��Ƿ�����һ����
			Dog dog = (Dog)(it.next());
			System.out.println(dog.getName()+"\t"+dog.getStrain());
		}
	}
}
 */
/*---------------------------------������--------------------------------*/

//public class a14_Iterator_�ص�_171101 {
//	public static void main(String[] args){
//		Dog ououDog = new Dog("ŷŷ","ѩ����");//�����������ֺ�Ʒ�����
//		Dog yayaDog = new Dog("����","��������");
//		Dog meimeiDog = new Dog("����","ѩ����");
//		Dog feifeiDog = new Dog("�Ʒ�","��������");
//		Map dogMap = new HashMap();
////		dogMap.put("ŷŷ","ѩ����");
//		dogMap.put(ououDog.getName(), ououDog);//����dogMap���ؼ����ǹ�����ֵ�ǹ�����
//		dogMap.put(yayaDog.getName(), yayaDog);
//		dogMap.put(meimeiDog.getName(), meimeiDog);
//		dogMap.put(feifeiDog.getName(), feifeiDog);
////		System.out.println(ououDog);
//		//ͨ������������������������й�������Ϣ
//		System.out.println("ʹ��Iterator������"+"���й������ǳƺ�Ʒ�ֱַ��ǣ�");
//		Set keys = dogMap.keySet();//�����еĹؼ��ֹ���ȡ���������ڼ����С�
//		for(Object key:keys){//��Ϊput�����Ž�ȥ�Ĺؼ����Ƿ���K�����Թ�����String���ͣ�����ҪдObject
//			Dog dog = (Dog)dogMap.get(key);//�ؼ��ֹ���ӳ���ֵ��value�������������á�
//			System.out.println(key+"\t"+dog.getStrain());
//		}
//	}
//}
