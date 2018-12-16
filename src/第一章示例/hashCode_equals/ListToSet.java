package 第一章示例.hashCode_equals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 时间：2017-12-23 下午4:43:59
 *使用构造法，List与Set互相转换。
 */
public class ListToSet {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		Set set = new HashSet(list1);
		ArrayList list2 = new ArrayList(set);
	}
}
