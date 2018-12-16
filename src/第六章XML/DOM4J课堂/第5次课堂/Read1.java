package ������XML.DOM4J����.��5�ο���;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @version ʱ�䣺2018-1-4 ����9:40:45
 *
 */
public class Read1 {

	public static void main(String[] args) throws DocumentException {
		SAXReader read = new SAXReader();//�Զ�ת��ΪSAX��DOM������
		File f1 = new File("userinfo.xml");
		Document doc = read.read(f1);//ͨ��doc��ȡԪ��
		//ȡ��
		Element root = doc.getRootElement();
//		ȡ��һ����Ԫ��
		List<Element> list = root.elements();
		System.out.println(list.size());
		for(Element e:list){
//			ȡ����
			String id = e.attributeValue("id");
			System.out.println("id="+id);
//			����ȡ
			List<Element> clist = e.elements();
			for(Element c:clist){
				System.out.println("�ڵ�����"+c.getName());
				System.out.println("�ڵ�ֵ��"+c.getTextTrim());
			}
		}
	}

}
