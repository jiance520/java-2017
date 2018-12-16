package 第六章XML.DOM4J课堂.第5次课堂;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @version 时间：2018-1-4 上午9:40:45
 *
 */
public class Read1 {

	public static void main(String[] args) throws DocumentException {
		SAXReader read = new SAXReader();//自动转换为SAX或DOM工厂。
		File f1 = new File("userinfo.xml");
		Document doc = read.read(f1);//通过doc逐级取元素
		//取根
		Element root = doc.getRootElement();
//		取下一级的元素
		List<Element> list = root.elements();
		System.out.println(list.size());
		for(Element e:list){
//			取属性
			String id = e.attributeValue("id");
			System.out.println("id="+id);
//			往下取
			List<Element> clist = e.elements();
			for(Element c:clist){
				System.out.println("节点名："+c.getName());
				System.out.println("节点值："+c.getTextTrim());
			}
		}
	}

}
