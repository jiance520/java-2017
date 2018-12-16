package ������XML.DOM;
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
 * @version ʱ�䣺2017-12-7 ����5:10:46
 ����---������---���ĵ�DOM---Element---����
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
					System.out.println("�ֻ�Ʒ���ǣ�"+brandStr+",�ֻ��ͺ��ǣ�"+typeStr);
				}
			}
		}
	}
	public void addInfo(){
		Element brandEle = doc.createElement("Brand");
		brandEle.setAttribute("name", "����");
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
			if(nodeEle.getAttribute("name").equals("����")){
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
		parse.loadDoc("�ղ���Ϣ.xml");
		parse.addInfo();
		parse.modifyInfo();
		parse.delInfo();
		parse.showInfo();
		parse.saveInfo("������ղ�1.xml");
	}
}
//----------------------------------------------------
//public class XMLParse {
//	Document doc = null;
//	public void loadDocument(String path){//���ش���DOM��
//		try {
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder db = factory.newDocumentBuilder();
//			doc = db.parse(path);//�ղ���Ϣ.xml�ļ����ڰ��⣬��jbit.logһ�����
//		} catch (Exception e) {
//		}
//	}
//	public void showInfo(){//��ѯ��ʾDOM���е���Ϣ
//		NodeList brandlist = doc.getElementsByTagName("Brand");
//		for (int i = 0; i < brandlist.getLength(); i++) {
//			Node brandnode = brandlist.item(i);
//			Element brandEle = (Element)brandnode;//Node�ӿں�Element�ӿ�ָ��Ķ��󣬹��ƶ���IIOMetadataNode����
//			String brandstr = brandEle.getAttribute("name");
//			System.out.println(brandstr);
//			NodeList typelist = brandEle.getChildNodes();//brandEle/brandnode���߶������á���ȡElement��������һ���ӽڵ�
//			//ͨ������brandEle.getElementsByTagName("Type");��ȡ�Ĳ�������
//			for (int j = 0; j < typelist.getLength(); j++) {
//				Node typenode = typelist.item(j);//ע�ⲻ��i��j
//				//IIOMetadataNode��ʵ���˽ӿ�Eelement,short getNodeType() ���ؽڵ����ͣ���ʼ��Ϊ ELEMENT_NODE,��1��
//				//public short getNodeType() {
//				//	return ELEMENT_NODE;
//				//}
//				if(typenode.getNodeType()==Node.ELEMENT_NODE){//1==1��ǰ�߷���ֵ��ELEMENT_NODE����ELEMENT_NODE�ĳ���ֵ��1
//					Element typeEle = (Element)typenode;//���ж���ת��
//					String typestr = typeEle.getAttribute("name");
//					System.out.println("�ֻ�Ʒ���ǣ�"+brandstr+",�ֻ��ͺ��ǣ�"+typestr);
//				}
//			}
//		}		
//	}
//	public void saveXml(String path){//���棬F5ˢ����Ŀ
//		try {
//			TransformerFactory factory = TransformerFactory.newInstance();
//			Transformer former = factory.newTransformer();
//			former.setOutputProperty(OutputKeys.ENCODING, "GB2312");//�����ʺ����ĵ������ʽת��Ϊxml��xml�����ִ�Сд��gb2312Ҳ����
//			Source xmlSource = new DOMSource(doc);//DOMSourceʵ�ֵĽӿ�Source�����ղ�����Source�ӿڣ�����������
//			Result outputTarget = new StreamResult(path);//StreamResultʵ�ֵĽӿ�Result��
//			former.transform(xmlSource, outputTarget);//���ú�Դ��Ŀ�ꡣ
//		} catch (Exception e) {
//		}
//	}
//	public void addNewPhoneInfo(){//���ӽڵ㣬���ܴ��ݲ������˷�������,
//		Element newBrand =doc.createElement("Brand");//����Brand�ڵ㣬setAttribute("����")
//		newBrand.setAttribute("name", "����");
//		Element newType = doc.createElement("type");//����Type�ڵ�,setAttribute("Note4")
//		newType.setAttribute("name","Note4");
//		newBrand.appendChild(newType);//Type����Brand,�˷����з���ֵ��������Node
//		doc.getElementsByTagName("PhoneInfo").item(0).appendChild(newBrand);
//	}
//	public void delPhoneInfo(){//ɾ���ڵ�
//		NodeList brandList = doc.getElementsByTagName("Brand");
//		for (int i = 0; i < brandList.getLength(); i++) {
//			Node BrandNode = brandList.item(i);
//			Element element = (Element)BrandNode;
//			if(element.getAttribute("name").equals("����")){
//				element.getParentNode().removeChild(element);//�Լ����õķ�����ɾ���Լ�
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
//		parse.loadDocument("�ղ���Ϣ.xml");
//		parse.addNewPhoneInfo();//Ҫ����ʾ֮ǰ����
//		parse.modifyPhoneInfo();
//		parse.delPhoneInfo();
//		parse.showInfo();
//		parse.saveXml("������ղ�.xml");
//	}
//}



