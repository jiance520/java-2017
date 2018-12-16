package 第一章示例;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-10-28 上午11:39:30
 */
public class a1_HashMap_12_1028 {
	public static void main(String[] args) {
		Map countries = new HashMap();
		countries.put("CN", "中华人民共和国");//添加成员是用put，不是用add。关键字key和值value是有双引号。
		countries.put("RU", "俄罗斯联邦");//key不允许重复value可以重复，成员不要求有序。
		countries.put("FR", "法兰西共和国");//有相同的key,编译不报错？
		countries.put("US", "美利坚合众国");
		String country = (String)countries.get("CN");//因为放入关键字时put形参接收的是Objcet key.
//		get(key)返回值也是Object,	此处输出的是国名字符串，
//		所以原本指向子类字符串对象的返回值可以强制类型转换。如果不强制类型转换，可以用<String>泛型。
		System.out.println("CN对应的国家是:"+country);
		System.out.println("Map中共有"+countries.size()+"组数据");
		System.out.println("Map中包含FR的key吗？"+countries.containsKey("FR"));
		countries.remove("FR");
		System.out.println("Map中包含FR的key吗？"+countries.containsKey("FR"));
		//分别显示键集、值集和键-值对集
		System.out.println(countries.keySet());
		System.out.println(countries.values());
		System.out.println(countries);
		System.out.println(countries.size());
		//清空HashMap并判断
		countries.clear();
		if(countries.isEmpty()){
			System.out.println("已清空Map中数据");
		}
		System.out.println(countries.size());
	}
}
