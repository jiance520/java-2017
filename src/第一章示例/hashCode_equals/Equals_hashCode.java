package 第一章示例.hashCode_equals;
/**
 * @version 时间：2017-12-23 上午8:52:19
 *
 */
class A {	
}
public class Equals_hashCode {
	A aa = new A();
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aa == null) ? 0 : aa.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equals_hashCode other = (Equals_hashCode) obj;
		if (aa == null) {
			if (other.aa != null)
				return false;
		} else if (!aa.equals(other.aa))
			return false;
		return true;
	}
	public static void main(String[] args) {
		Equals_hashCode t = new Equals_hashCode();
		System.out.println(t.aa.hashCode());
		System.out.println(t.hashCode());
}
}

