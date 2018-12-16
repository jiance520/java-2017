package ������XML.��ϰ.��2�θ�ϰ;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @version ʱ�䣺2017-12-27 ����7:47:03
 *
 */
public class Dom4jReader {
	Document doc = null;
	public void loadInfo(String path) throws DocumentException{
		SAXReader sr = new SAXReader();
		doc = sr.read(path);//����
	}
	public void saveInfo(String path) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();//����
		format.setEncoding("GB2312");//����
		XMLWriter xmlw = new XMLWriter(new FileWriter(path),format);//����
		xmlw.write(doc);
		xmlw.close();
	}
	public void showInfo(){
		Element rootEle = doc.getRootElement();
		Iterator brandIt = rootEle.elements().iterator();
		while(brandIt.hasNext()){
			Element brandEle = (Element)brandIt.next();
			String brandStr = brandEle.attributeValue("name");
			System.out.println(brandStr);
			Iterator<Element> typeIt = brandEle.elementIterator();
			while(typeIt.hasNext()){
				Element typeEle = typeIt.next();
				String typeStr = typeEle.attributeValue("name");
				System.out.println("�ֻ�Ʒ���ǣ�"+brandStr+",�ֻ��ͺ��ǣ�"+typeStr);
			}
		}
	}
	public void addInfo(){
		Element rootEle = doc.getRootElement();
		Element brandEle = rootEle.addElement("Brand");//����
		brandEle.addAttribute("name", "����");
		Element typeEle = brandEle.addElement("Type");
		typeEle.addAttribute("name", "Node4");
	}
	public void modifyInfo() throws IOException{
		Element rootEle = doc.getRootElement();
		Iterator<Element> brandIt = rootEle.elements().iterator();
		int cnt = 0;
		while(brandIt.hasNext()){
			Element brandEle = brandIt.next();
			brandEle.addAttribute("id",++cnt+"");
		}
		saveInfo("dom4j����.xml");//����
	}
	public void delInfo(){
		Element rootEle = doc.getRootElement();
		Iterator<Element> brandIt = rootEle.elements().iterator();
		while(brandIt.hasNext()){
			Element brandEle = brandIt.next();
			if(brandEle.attribute("name").getValue().equals("����")){
				brandEle.getParent().remove(brandEle);
			}
		}
	}
	public static void main(String[] args) throws DocumentException, IOException {
		Dom4jReader dom4jReader = new Dom4jReader();
		dom4jReader.loadInfo("�ղ���Ϣ.xml");
		dom4jReader.saveInfo("dom4j����.xml");
		dom4jReader.addInfo();
		dom4jReader.modifyInfo();
		dom4jReader.delInfo();
		dom4jReader.showInfo();
	}

}
