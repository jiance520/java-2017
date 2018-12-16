package 第六章XML.复习.第2次复习;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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
 * @version 时间：2017-12-27 下午3:49:44
 *
 */
public class Dom {
	DocumentBuilderFactory	factory;
	DocumentBuilder db;
	Document doc;
	public void loadInfo(String string) throws ParserConfigurationException, SAXException, IOException{
		factory = DocumentBuilderFactory.newInstance();//忘记单词
		db = factory.newDocumentBuilder();//忘记单词
		doc = db.parse(string);
	}
	public void saveInfo(String string) throws TransformerException{
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();
		trans.setOutputProperty(OutputKeys.ENCODING,"GB2312");//忘记
		DOMSource doms = new DOMSource(doc);//忘记
		StreamResult sr = new StreamResult(string);//忘记
		trans.transform(doms, sr);//忘记
	}
	public void showInfo() throws ParserConfigurationException, SAXException, IOException{
		NodeList nodeList = doc.getElementsByTagName("Brand");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node brandNode = nodeList.item(i);
			Element brandEle = (Element)brandNode;
			String strBrand = brandEle.getAttribute("name");
			System.out.println(strBrand);
			NodeList typeList = brandEle.getChildNodes();
			for (int j = 0; j < typeList.getLength(); j++) {
				Node typeNode = typeList.item(j);
				if(typeNode.getNodeType() == Node.ELEMENT_NODE){//忘记判断
					Element typeEle = (Element)typeNode;
					String strType = typeEle.getAttribute("name");
					System.out.println("手机品牌是："+strBrand+",手机型号是："+strType);
				}
			}
		}
	}
	public void addInfo(){
		Element typeEle = doc.createElement("Type");
		typeEle.setAttribute("name", "Note4");
		Element brandEle = doc.createElement("Brand");
		brandEle.setAttribute("name", "三星");
		brandEle.appendChild(typeEle);
		NodeList nodeList = doc.getElementsByTagName("PhoneInfo");//忘记,
		nodeList.item(0).appendChild(brandEle);
	}
	public void modifyInfo(){
		NodeList nodeList = doc.getElementsByTagName("Brand");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node brandNode = nodeList.item(i);
			Element brandEle = (Element)brandNode;
			if(brandEle.getAttribute("name").equals("三星")){
				brandEle.setAttribute("name", "SUNSANG");
			}
		}
	}
	public void delInfo(){
		NodeList nodeList = doc.getElementsByTagName("Brand");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node brandNode = nodeList.item(i);
			Element brandEle = (Element)brandNode;
			if(brandEle.getAttribute("name").equals("SUNSANG")){
				brandEle.getParentNode().removeChild(brandNode);
			}
		}
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Dom dom = new Dom();
		dom.loadInfo("收藏信息.xml");
		dom.addInfo();
		dom.modifyInfo();
		dom.delInfo();
		dom.showInfo();
		dom.saveInfo("DOM保存");
	}

}
