package ��һ��ʾ��.hashCode_equals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @version ʱ�䣺2017-12-23 ����4:43:59
 *ʹ�ù��취��List��Set����ת����
 */
public class ListToSet {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		Set set = new HashSet(list1);
		ArrayList list2 = new ArrayList(set);
	}
}
