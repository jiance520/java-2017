package 第六章XML.复习.第4次部分复习;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * @version 时间：2017-12-29 下午2:02:12
 *
 */
public class Dom4jTest {
	Document doc;
	public void loadInfo() throws DocumentException{
		SAXReader sr = new SAXReader();
		sr.read("收藏信息.xml");
	}
	public void saveInfo() throws IOException{
		OutputFormat of = OutputFormat.createPrettyPrint();
		of.setEncoding("GBK");
//		以流的方式保存文件，并指定转换格式
		XMLWriter xw = new XMLWriter(new FileWriter("保存收藏信息.xml"),of);
		xw.write(doc);
		xw.close();
	}
	public void showInfo(){
		Element rootEle = doc.getRootElement();
		Element brandEle = rootEle.addElement("Brand");
		brandEle.addAttribute("name", "三星");
		brandEle.addAttribute("name", "SUNSANG");
		Element typeEle = brandEle.addElement("Type");
		typeEle.addAttribute("name", "Note4");
	}

	public static void main(String[] args) {

	}

}
