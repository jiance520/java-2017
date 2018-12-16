package ������XML.��ϰ.��3�β��ָ�ϰ;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @version ʱ�䣺2017-12-28 ����11:21:12
 *
 */
public class Dom4jTest {
	Document doc;
	public void loadInfo(String path) throws DocumentException{
		SAXReader sr = new SAXReader();
		doc = sr.read(path);
	}
	public void saveInfo(String path) throws IOException{
		OutputFormat of = OutputFormat.createPrettyPrint();//����
		of.setEncoding("GBK");//����
		XMLWriter xw = new XMLWriter(new FileWriter(path),of);//����
		xw.write(doc);//����
		xw.close();
	}
}
