package ��һ��ʾ��;
import java.util.HashMap;
import java.util.Map;

/**
 * @author �˼��� E-mail: 332992686@qq.com
 * @version ʱ�䣺2017-10-28 ����11:39:30
 */
public class a1_HashMap_12_1028 {
	public static void main(String[] args) {
		Map countries = new HashMap();
		countries.put("CN", "�л����񹲺͹�");//��ӳ�Ա����put��������add���ؼ���key��ֵvalue����˫���š�
		countries.put("RU", "����˹����");//key�������ظ�value�����ظ�����Ա��Ҫ������
		countries.put("FR", "���������͹�");//����ͬ��key,���벻����
		countries.put("US", "��������ڹ�");
		String country = (String)countries.get("CN");//��Ϊ����ؼ���ʱput�βν��յ���Objcet key.
//		get(key)����ֵҲ��Object,	�˴�������ǹ����ַ�����
//		����ԭ��ָ�������ַ�������ķ���ֵ����ǿ������ת���������ǿ������ת����������<String>���͡�
		System.out.println("CN��Ӧ�Ĺ�����:"+country);
		System.out.println("Map�й���"+countries.size()+"������");
		System.out.println("Map�а���FR��key��"+countries.containsKey("FR"));
		countries.remove("FR");
		System.out.println("Map�а���FR��key��"+countries.containsKey("FR"));
		//�ֱ���ʾ������ֵ���ͼ�-ֵ�Լ�
		System.out.println(countries.keySet());
		System.out.println(countries.values());
		System.out.println(countries);
		System.out.println(countries.size());
		//���HashMap���ж�
		countries.clear();
		if(countries.isEmpty()){
			System.out.println("�����Map������");
		}
		System.out.println(countries.size());
	}
}
