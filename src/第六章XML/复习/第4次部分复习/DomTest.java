package ������XML.��ϰ.��4�β��ָ�ϰ;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @version ʱ�䣺2017-12-29 ����1:41:52
 *if(typeNode.getNodeType()==Node.ELEMENT_NODE
 */
public class DomTest {
	Document doc;
	public void loadInfo() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.parse("�ղ���Ϣ.xml");
	}
	public void saveInfo() throws TransformerException{
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.ENCODING, "GBK");
		DOMSource xmlSource  = new DOMSource(doc);
		StreamResult outputTarget = new StreamResult("������ղ�.xml");
		t.transform(xmlSource, outputTarget);
	}
	public void showInfo(){
		NodeList brandList = doc.getElementsByTagName("Brand");
		Node node = doc.getElementsByTagName("PhoceInfo").item(0);
		Element element  = (Element)node;
		String value = element.getAttribute("name");
		element.setAttribute("Phoncename", "�ֻ�");
	}
	public static void main(String[] args) {

	}

}
