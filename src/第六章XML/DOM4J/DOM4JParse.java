package ������XML.DOM4J;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


/**
 * @version ʱ�䣺2017-12-10 ����8:46:38
 *
 */
public class DOM4JParse {
	Document doc = null;
	public void loadDoc(String path) throws DocumentException{
		SAXReader reader = new SAXReader();
		doc = reader.read(path);
	}
	public void saveInfo(String path) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();//new OutputFormat();
		format.setEncoding("GB2312");
		XMLWriter write = new XMLWriter(new FileWriter(path),format);
		write.write(doc);
		write.close();//���رձ��治��ʾ//�������ǹر���
//-------------------��ʽ��:д�뱣��------------------------
//		File file = new File(path);
//		FileOutputStream fout = new FileOutputStream(file);
//		OutputStreamWriter ow = new OutputStreamWriter(fout,"UTF-8");
//		OutputFormat format = OutputFormat.createPrettyPrint();
//		format.setEncoding("UTF-8");
//		XMLWriter xw = new XMLWriter(ow,format);
//		xw.write(doc);
//		xw.flush();
//		xw.close();
	}
	public void showInfo(){
		Element rootEle = doc.getRootElement();
		Iterator brandIt = rootEle.elementIterator();
		while(brandIt.hasNext()){
			Element brandEle = (Element)(brandIt.next());//����Ҫ�ж��Ƿ����ӽڵ㣬����Ҫת��
			String brandStr = brandEle.attributeValue("name");
			System.out.println(brandStr);
//			---------------------����һ��ͨforѭ��-----------------------------
//			Iterator typeIt = brandEle.elementIterator();
//			while(typeIt.hasNext()){
//				Element typeEle = (Element)(typeIt.next());
//			-----------��������ʹ������foreachǶ��ѭ����֤��foreachҲ��ѭ�����-------------
			List<Element> typeList = brandEle.elements();
			for(Element typeEle:typeList){
				String typeStr = typeEle.attributeValue("name");
				System.out.println("�ֻ�Ʒ���ǣ�"+brandStr+",�ֻ��ͺ��ǣ�"+typeStr);
				List<Element> colorList = typeEle.elements();
				for(Element colorEle:colorList){
					System.out.println("�ı��ڵ�����"+colorEle.getName());
					System.out.println("�ı��ڵ�ֵ��"+colorEle.getTextTrim());
//					getTextTrim()��getText()�����ı��ڵ�����ı�ֵ��������һ������δ��������
				}
			}
		}
	}
//	ͨ��XPath·����ȡָ��Ԫ�ػ�����
	public void jaxenShow() throws DocumentException{
//		��ȡС���ֻ�����ɫ��ͨ��ָ��·���ڵ�������ȡָ���ڵ��ֵ��
		loadDoc("������ղ�.xml");
//		List<Node> colorList = doc.selectNodes("Color");//��ȡָ���ڵ�ļ���
		Element colorEle = (Element)doc.selectSingleNode("//Color[2]");
		System.out.println("��С���ֻ�����Ϣ��");
		System.out.println("�ı��ڵ�����"+colorEle.getName());
		System.out.println("�ı��ڵ�ֵ��"+colorEle.getTextTrim());
	}
	public void addInfo(){
		Element rootEle = doc.getRootElement();
		Element brandEle = rootEle.addElement("Brand");
		brandEle.addAttribute("name","����");//DOM4J���ӽڵ㲻��setAttribute("name","����");DOM���޸Ľڵ�setAttribute("name","����")
		Element typeEle = brandEle.addElement("Type");
		typeEle.addAttribute("name", "Note4");
	}
	public void jaxenAddInfo(){
		Element rootEle = doc.getRootElement();
		Element brandEle = rootEle.addElement("Brand");
		brandEle.addAttribute("name", "С��");
		Element typeEle = brandEle.addElement("Type");
		typeEle.addAttribute("name", "Note6");
//		Element textEle = typeEle.addElement("Color");
//		textEle.setText("��ɫ");
	}
	public void modifyInfo() throws IOException{
		int cnt = 1;
		Element rootEle = doc.getRootElement();
		Iterator brandIt = rootEle.elementIterator();
		while(brandIt.hasNext()){
			Element brandEle = (Element)(brandIt.next());
			brandEle.addAttribute("Id", cnt+++"");//��������������
		}
		saveInfo("DOM4J�ղ���Ϣ.xml");
	}
	public void delInfo(String str){
		Element rootEle = doc.getRootElement();
		Iterator brandIt = rootEle.elementIterator();
		while (brandIt.hasNext()) {
			Element brandEle = (Element) brandIt.next();
			if(brandEle.attributeValue("name").equals(str)){
				brandEle.getParent().remove(brandEle);
			}
		}
	}
	//----------------------�Լ����ӵ�----------------------
	public void change(String str){
		Element root = doc.getRootElement();
		Iterator brandIt = root.elementIterator();
		while(brandIt.hasNext()){
			Element brandEle = (Element)brandIt.next();
			if (brandEle.attributeValue("name").equals(str)) {
				brandEle.addAttribute("name", "SUNSANG");
				break;
			}
		}
	}
//	public void test(){//���Է����ã��������޹ء�
//		Element root  = doc.getRootElement();
//		Element ele = root.addAttribute("name", "root");
//		Element brandele = root.element("Brand");
//		List brandlist = brandele.elements();
//		System.out.println(brandele.attribute("name").getValue());
//	}
	public static void main(String[] args) throws DocumentException, IOException {
		DOM4JParse parse = new DOM4JParse();
		parse.loadDoc("�ղ���Ϣ.xml");
		parse.addInfo();
		parse.jaxenAddInfo();
//		parse.change("����");
//		parse.delInfo("SUNSANG");
//		parse.modifyInfo();
		parse.showInfo();
		parse.jaxenShow();
		parse.saveInfo("������ղ�.xml");
	}
}
