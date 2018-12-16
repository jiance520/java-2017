package 第六章XML.复习.第3次部分复习;

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
import org.xml.sax.SAXException;

/**
 * @version 时间：2017-12-28 下午10:38:18
 *
 */
public class DomTest {
	Document doc;
	public void loadInfo(String path) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.parse(path);
	}
	public void showInfo(){
		
	}
	public void saveInfo(String path) throws TransformerException{
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.ENCODING, "GBK");//忘记 
		DOMSource xmlSource = new DOMSource(doc);//忘记 
		StreamResult outputTarget = new StreamResult(path);//忘记 
		t.transform(xmlSource, outputTarget);//忘记 
	}
	public void addInfo(){
		
	}
	public void changeInfo(){
		
	}
	public void delInfo(){
		
	}
	public static void main(String[] args) {
		DomTest dt = new DomTest();
	}

}
