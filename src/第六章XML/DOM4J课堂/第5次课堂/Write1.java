package 第六章XML.DOM4J课堂.第5次课堂;

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
 * @version 时间：2018-1-4 上午10:42:22
 *
 */
public class Write1 {

	public static void main(String[] args) throws IOException {
//		定义新文档
		Document doc = DocumentHelper.createDocument();
//		加根
		Element root = doc.addElement("users");
		Element u1 = root.addElement("user");
				u1.addAttribute("id","1");
		Element username = u1.addElement("username");
				username.setText("小明");
		Element password = u1.addElement("password");
				password.setText("xiao1234");
		Element email = u1.addElement("email");
				email.setText("xiao@qq.com");
//		写文件
		File f1 = new File("xx.xml");
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
