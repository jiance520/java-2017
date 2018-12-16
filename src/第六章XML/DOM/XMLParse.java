package 第六章XML.DOM;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
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
 * @version 时间：2017-12-7 下午5:10:46
 工厂---解析器---树文档DOM---Element---属性
 */
public class XMLParse {
	Document doc = null;
	public void loadDoc(String path) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.parse(path);
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
	public void saveInfo(String path) throws TransformerException{
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer former = factory.newTransformer();
		former.setOutputProperty(OutputKeys.ENCODING, "GB2312");
		DOMSource xmlSource = new DOMSource(doc);
		StreamResult outputResult = new StreamResult(path);
		former.transform(xmlSource, outputResult);
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		XMLParse parse = new XMLParse();
		parse.loadDoc("收藏信息.xml");
		parse.addInfo();
		parse.modifyInfo();
		parse.delInfo();
		parse.showInfo();
		parse.saveInfo("保存的收藏1.xml");
	}
}
//----------------------------------------------------
//public class XMLParse {
//	Document doc = null;
//	public void loadDocument(String path){//加载创建DOM树
//		try {
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder db = factory.newDocumentBuilder();
//			doc = db.parse(path);//收藏信息.xml文件放在包外，跟jbit.log一个层次
//		} catch (Exception e) {
//		}
//	}
//	public void showInfo(){//查询显示DOM树中的信息
//		NodeList brandlist = doc.getElementsByTagName("Brand");
//		for (int i = 0; i < brandlist.getLength(); i++) {
//			Node brandnode = brandlist.item(i);
//			Element brandEle = (Element)brandnode;//Node接口和Element接口指向的对象，估计都是IIOMetadataNode对象
//			String brandstr = brandEle.getAttribute("name");
//			System.out.println(brandstr);
//			NodeList typelist = brandEle.getChildNodes();//brandEle/brandnode两者都可以用。获取Element的所有下一级子节点
//			//通过方法brandEle.getElementsByTagName("Type");获取的不是子类
//			for (int j = 0; j < typelist.getLength(); j++) {
//				Node typenode = typelist.item(j);//注意不是i是j
//				//IIOMetadataNode类实现了接口Eelement,short getNodeType() 返回节点类型，其始终为 ELEMENT_NODE,即1。
//				//public short getNodeType() {
//				//	return ELEMENT_NODE;
//				//}
//				if(typenode.getNodeType()==Node.ELEMENT_NODE){//1==1，前者返回值是ELEMENT_NODE，而ELEMENT_NODE的常量值是1
//					Element typeEle = (Element)typenode;//先判断再转换
//					String typestr = typeEle.getAttribute("name");
//					System.out.println("手机品牌是："+brandstr+",手机型号是："+typestr);
//				}
//			}
//		}		
//	}
//	public void saveXml(String path){//保存，F5刷新项目
//		try {
//			TransformerFactory factory = TransformerFactory.newInstance();
//			Transformer former = factory.newTransformer();
//			former.setOutputProperty(OutputKeys.ENCODING, "GB2312");//采用适合中文的字体格式转换为xml，xml不区分大小写，gb2312也可以
//			Source xmlSource = new DOMSource(doc);//DOMSource实现的接口Source，接收参数是Source接口，两都都可以
//			Result outputTarget = new StreamResult(path);//StreamResult实现的接口Result，
//			former.transform(xmlSource, outputTarget);//设置好源和目标。
//		} catch (Exception e) {
//		}
//	}
//	public void addNewPhoneInfo(){//增加节点，不能传递参数，此方法不好,
//		Element newBrand =doc.createElement("Brand");//创建Brand节点，setAttribute("三星")
//		newBrand.setAttribute("name", "三星");
//		Element newType = doc.createElement("type");//创建Type节点,setAttribute("Note4")
//		newType.setAttribute("name","Note4");
//		newBrand.appendChild(newType);//Type连接Brand,此方法有返回值，类型是Node
//		doc.getElementsByTagName("PhoneInfo").item(0).appendChild(newBrand);
//	}
//	public void delPhoneInfo(){//删除节点
//		NodeList brandList = doc.getElementsByTagName("Brand");
//		for (int i = 0; i < brandList.getLength(); i++) {
//			Node BrandNode = brandList.item(i);
//			Element element = (Element)BrandNode;
//			if(element.getAttribute("name").equals("三星")){
//				element.getParentNode().removeChild(element);//自己调用的方法来删除自己
//			}
//		}
//		
//	}
//	public void modifyPhoneInfo(){
//		NodeList brandList = doc.getElementsByTagName("Brand");
//		for (int i = 0; i < brandList.getLength(); i++) {
//			Node BrandNode = brandList.item(i);
//			Element element = (Element)BrandNode;
//			if(element.getAttribute("name").equals("SANSUNG")){
//				element.setAttribute("name", "SANSUNG");
//				break;
//			}
//		}
//	}
//	public static void main(String[] args) {
//		XMLParse parse = new XMLParse();
//		parse.loadDocument("收藏信息.xml");
//		parse.addNewPhoneInfo();//要在显示之前调用
//		parse.modifyPhoneInfo();
//		parse.delPhoneInfo();
//		parse.showInfo();
//		parse.saveXml("保存的收藏.xml");
//	}
//}



