package ������XML.DOM4J����.��5�ο���;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @version ʱ�䣺2018-1-4 ����10:42:22
 *
 */
public class Write1 {

	public static void main(String[] args) throws IOException {
//		�������ĵ�
		Document doc = DocumentHelper.createDocument();
//		�Ӹ�
		Element root = doc.addElement("users");
		Element u1 = root.addElement("user");
				u1.addAttribute("id","1");
		Element username = u1.addElement("username");
				username.setText("С��");
		Element password = u1.addElement("password");
				password.setText("xiao1234");
		Element email = u1.addElement("email");
				email.setText("xiao@qq.com");
//		д�ļ�
		File f1 = new File("xx.xml");
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
