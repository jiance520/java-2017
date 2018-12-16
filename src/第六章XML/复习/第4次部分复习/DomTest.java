package 第六章XML.复习.第4次部分复习;

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
 * @version 时间：2017-12-29 下午1:41:52
 *if(typeNode.getNodeType()==Node.ELEMENT_NODE
 */
public class DomTest {
	Document doc;
	public void loadInfo() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.parse("收藏信息.xml");
	}
	public void saveInfo() throws TransformerException{
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.ENCODING, "GBK");
		DOMSource xmlSource  = new DOMSource(doc);
		StreamResult outputTarget = new StreamResult("保存的收藏.xml");
		t.transform(xmlSource, outputTarget);
	}
	public void showInfo(){
		NodeList brandList = doc.getElementsByTagName("Brand");
		Node node = doc.getElementsByTagName("PhoceInfo").item(0);
		Element element  = (Element)node;
		String value = element.getAttribute("name");
		element.setAttribute("Phoncename", "手机");
	}
	public static void main(String[] args) {

	}

}
