package 第六章XML.复习.第3次部分复习;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @version 时间：2017-12-28 下午11:21:12
 *
 */
public class Dom4jTest {
	Document doc;
	public void loadInfo(String path) throws DocumentException{
		SAXReader sr = new SAXReader();
		doc = sr.read(path);
	}
	public void saveInfo(String path) throws IOException{
		OutputFormat of = OutputFormat.createPrettyPrint();//忘记
		of.setEncoding("GBK");//忘记
		XMLWriter xw = new XMLWriter(new FileWriter(path),of);//忘记
		xw.write(doc);//忘记
		xw.close();
	}
}
