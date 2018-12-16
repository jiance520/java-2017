package ������XML.DOM4J����.��5�ο���;
/**
 * @version ʱ�䣺2018-1-4 ����11:08:25
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
 * @version ʱ�䣺2018-1-4 ����10:42:22
 *
 */
public class Write_XPath {

	public static void main(String[] args) throws IOException, DocumentException {
//		�ȶ�ȡԭ�е��ļ�
		File f1 = new File("xx.xml");
		SAXReader read = new SAXReader();
		Document doc = read.read(f1);
		Node n = doc.selectSingleNode("/users");
		Element e = (Element)n;
		Element u1 = e.addElement("user");
		u1.addAttribute("id", "2");
		Element username = e.addElement("username");
		username.setText("����");
		Element password = e.addElement("password");
		password.setText("lao1234");
		Element email = e.addElement("email");
		email.setText("wan@qq.com");
		
		FileOutputStream fout = new FileOutputStream(f1);
//		�ļ���UTF-8
		OutputStreamWriter ow = new OutputStreamWriter(fout,"UTF-8");
//		����xml�ĸ�ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
//		�豸�ļ�ͷ
					format.setEncoding("UTF-8");
		XMLWriter xw = new XMLWriter(ow,format);
				xw.write(doc);
				xw.flush();
		xw.close();
		System.out.println("end");
	}
}
