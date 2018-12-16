package ��һ��ʾ��.hashCode_equals;
/**
 * @version ʱ�䣺2017-12-23 ����5:20:41
 *
 */
class Dog{
	int age;
	String name;
	public Dog() {
	}
	//�Զ����ɹ��췽��
	public Dog(int age, String name) {
		this.age = age;
		this.name = name;
	}
	@Override//�Զ����ɵ�toString()
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} 
		else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
public class Test_��д {
	public static void main(String[] args) {
		Dog dog1 = new Dog(12,"fg");
		Dog dog2 = new Dog(13,"kl");
		System.out.println(dog1.equals(dog2));
		System.out.println(dog1.toString());
		System.out.println(dog1.getClass().getName());
	}
}
