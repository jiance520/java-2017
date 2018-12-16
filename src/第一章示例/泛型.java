package 第一章示例;
/**
* @author 邓集军 E-mail: 332992686@qq.com
* @version 时间：2017-11-28 下午11:25:22
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
public class 泛型{
	public static void main(String[] args) {
		Apple apple = new Apple();
		Fruit fruit = new Fruit();
		Food food = new Food();
//		Plate<Fruit> pa = new Plate<Apple>(apple);//放苹果的盘子不能赋值给放水果的苹果。
//		这种泛型没有扩大容器引用范围，单一的盘子引用指向单一的盘子容器对象，目的是单一的盘子容器放单一的水果品种！
		Plate<? extends Fruit> pf = new Plate<Apple>(new Apple());//上界通配符！
		//扩大了盘子容器pf被赋值的种类，盘子引用可以指向装Fruit或其子类类型的盘子容器对象。只要是放Fruit或其子类的盘子都可以赋值给泛型引用。
		//1-N个子类=选其中1种赋值
//		((Plate<Apple>)pf).set(apple);//不能放进任何水果，因为理论上引用pf可能是放入的水果对象的子类，可以强制类型转换。
		Fruit fruit1 = pf.get();//可以取出苹果,但是定义的引用fruit1必须大于等于Fruit类。
		Plate<? super Fruit> pa = new Plate<Food>(new Food());//下界通配符，
		//扩大了盘子容器pf被赋值的种类，盘子引用可以指向装Fruit或其父类类型的盘子容器对象。只要是放Fruit或其的父类的盘子都可以赋值给泛型引用。
		//1-N个父类=选其中1种赋值
		pa.set(new Apple());//可以放入水果及其子类对象,pa引用的指向的容器所放对象的范围是水果到食物之间，但不能放入父类对象食物,因理论上放入的父类食物可能超过引用的对象范围。
//		Object o = pa.get();//不能取出食物，因为pa是一个无限大于Fruit的引用，只有定义超类Object才能取出食物对象，或者多态的类型转换。
	}
}