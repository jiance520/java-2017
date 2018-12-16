package 第六章XML.复习.第1次复习;

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
 * @version 时间：2017-12-10 下午4:54:11
 *
 */
public class XMLParse {
	Document doc = null;
	public void loadDoc() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.parse("收藏信息.xml");
	}
	public void showInfo(){
		NodeList brandList = doc.getElementsByTagName("Brand");
		for (int i = 0; i < brandList.getLength(); i++) {
			Node brandNode = brandList.item(i);
			Element brandEle = (Element)brandNode;
			String brandStr = brandEle.getAttribute("name");
			NodeList typeList = brandEle.getChildNodes();
			for (int j = 0; j < typeList.getLength(); j++) {
				Node typeNode = typeList.item(j);
				if(typeNode.getNodeType() == Node.ELEMENT_NODE){
					Element typeEle = (Element)typeNode;
					String typeStr = typeEle.getAttribute("name");
					System.out.println("手机品牌是："+brandStr+",手机型号是："+typeStr);
				}
			}
		}
	}
	public void addInfo(){
		Element brandEle = doc.createElement("Brand");
		brandEle.setAttribute("name", "三星");
		Element typeEle = doc.createElement("Type");
		typeEle.setAttribute("name", "Note4");
		brandEle.appendChild(typeEle);
		doc.getElementsByTagName("PhoneInfo").item(0).appendChild(brandEle);
	}
	public void modifyInfo(){
		NodeList brandList = doc.getElementsByTagName("Brand");
		for (int i = 0; i < brandList.getLength(); i++) {
			Node brandNode = brandList.item(i);
			Element nodeEle = (Element)brandNode;
			if(nodeEle.getAttribute("name").equals("三星")){
				nodeEle.setAttribute("name", "SUNSANG");
				break;
			}
		}
	}
	public void delInfo(){
		NodeList brandList = doc.getElementsByTagName("Brand");
		for (int i = 0; i < brandList.getLength(); i++) {
			Node brandNode = brandList.item(i);
			Element brandEle = (Element)brandNode;
			if (brandEle.getAttribute("name").equals("SUNSANG")) {
				brandEle.getParentNode().removeChild(brandEle);
			}
		}
	}
	public void saveInfo() throws TransformerException{
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer former = factory.newTransformer();
		former.setOutputProperty(OutputKeys.ENCODING, "GB2312");
		DOMSource xmlSource = new DOMSource(doc);
		StreamResult outputResult = new StreamResult("保存的收藏1.xml");
		former.transform(xmlSource, outputResult);
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		XMLParse parse = new XMLParse();
		parse.loadDoc();
//		parse.addInfo();
//		parse.modifyInfo();
//		parse.delInfo();
		parse.showInfo();
		parse.saveInfo();
	}
}
