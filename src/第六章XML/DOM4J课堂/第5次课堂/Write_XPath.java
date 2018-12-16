package 第六章XML.DOM4J课堂.第5次课堂;
/**
 * @version 时间：2018-1-4 上午11:08:25
 *
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @version 时间：2018-1-4 上午10:42:22
 *
 */
public class Write_XPath {

	public static void main(String[] args) throws IOException, DocumentException {
//		先读取原有的文件
		File f1 = new File("xx.xml");
		SAXReader read = new SAXReader();
		Document doc = read.read(f1);
		Node n = doc.selectSingleNode("/users");
		Element e = (Element)n;
		Element u1 = e.addElement("user");
		u1.addAttribute("id", "2");
		Element username = e.addElement("username");
		username.setText("老王");
		Element password = e.addElement("password");
		password.setText("lao1234");
		Element email = e.addElement("email");
		email.setText("wan@qq.com");
		
		FileOutputStream fout = new FileOutputStream(f1);
//		文件是UTF-8
		OutputStreamWriter ow = new OutputStreamWriter(fout,"UTF-8");
//		设置xml的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
//		设备文件头
					format.setEncoding("UTF-8");
		XMLWriter xw = new XMLWriter(ow,format);
				xw.write(doc);
				xw.flush();
		xw.close();
		System.out.println("end");
	}
}
