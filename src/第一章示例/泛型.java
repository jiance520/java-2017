package ��һ��ʾ��;
/**
* @author �˼��� E-mail: 332992686@qq.com
* @version ʱ�䣺2017-11-28 ����11:25:22
 */
class Food{}
class Fruit extends Food{}
class Apple extends Fruit{}
class Plate<T>{
    private T temp;
//    public Plate(){};
    public Plate(T t){temp=t;}
    public void set(T t){temp=t;}
    public T get(){return temp;}
}
public class ����{
	public static void main(String[] args) {
		Apple apple = new Apple();
		Fruit fruit = new Fruit();
		Food food = new Food();
//		Plate<Fruit> pa = new Plate<Apple>(apple);//��ƻ�������Ӳ��ܸ�ֵ����ˮ����ƻ����
//		���ַ���û�������������÷�Χ����һ����������ָ��һ��������������Ŀ���ǵ�һ�����������ŵ�һ��ˮ��Ʒ�֣�
		Plate<? extends Fruit> pf = new Plate<Apple>(new Apple());//�Ͻ�ͨ�����
		//��������������pf����ֵ�����࣬�������ÿ���ָ��װFruit�����������͵�������������ֻҪ�Ƿ�Fruit������������Ӷ����Ը�ֵ���������á�
		//1-N������=ѡ����1�ָ�ֵ
//		((Plate<Apple>)pf).set(apple);//���ܷŽ��κ�ˮ������Ϊ����������pf�����Ƿ����ˮ����������࣬����ǿ������ת����
		Fruit fruit1 = pf.get();//����ȡ��ƻ��,���Ƕ��������fruit1������ڵ���Fruit�ࡣ
		Plate<? super Fruit> pa = new Plate<Food>(new Food());//�½�ͨ�����
		//��������������pf����ֵ�����࣬�������ÿ���ָ��װFruit���丸�����͵�������������ֻҪ�Ƿ�Fruit����ĸ�������Ӷ����Ը�ֵ���������á�
		//1-N������=ѡ����1�ָ�ֵ
		pa.set(new Apple());//���Է���ˮ�������������,pa���õ�ָ����������Ŷ���ķ�Χ��ˮ����ʳ��֮�䣬�����ܷ��븸�����ʳ��,�������Ϸ���ĸ���ʳ����ܳ������õĶ���Χ��
//		Object o = pa.get();//����ȡ��ʳ���Ϊpa��һ�����޴���Fruit�����ã�ֻ�ж��峬��Object����ȡ��ʳ����󣬻��߶�̬������ת����
	}
}