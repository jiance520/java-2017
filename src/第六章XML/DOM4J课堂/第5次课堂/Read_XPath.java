package ������XML.DOM4J����.��5�ο���;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @version ʱ�䣺2018-1-4 ����9:40:45
 *xPath
 *jaxen��
 */
public class Read_XPath {

	public static void main(String[] args) throws DocumentException {
		SAXReader read = new SAXReader();//�Զ�ת��ΪSAX��DOM������
		File f1 = new File("userinfo.xml");
		Document doc = read.read(f1);//ͨ��doc��ȡԪ��
		
		List<Node> list = doc.selectNodes("//user");//"/users/user"
		for(Node n:list){
			Element e = (Element)n;
			String id = e.attributeValue("id");
			System.out.println("id="+id);
		}
//		Node n2 = doc.selectSingleNode("//username[1]");//���ڵ�//"//user[1]/username"
		Node n2 = doc.selectSingleNode("//user[1]/username");
		Element e2 = (Element)n2;
		System.out.println("value="+e2.getTextTrim());
		
		List<Node> list2 = doc.selectNodes("//username");
		Element e3 = (Element)list2.get(1);
		System.out.println("value="+e3.getTextTrim());
	}

}
