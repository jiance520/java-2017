package XML_DOM4J及TCP增删改查测试;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.*;
import org.dom4j.io.*;
/**
 * @version 时间：2018-1-6 上午10:40:24
 *
 */
public class XmlTools {
	public Document read(File f){
		Document doc = null;
		try {
			if(f.exists()){
				SAXReader read = new SAXReader();
				doc = read.read(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
	public synchronized void write(File f,Document doc){
		try {
			if(f!=null && doc!=null){
				FileOutputStream fout = new FileOutputStream(f);
				OutputStreamWriter out = new OutputStreamWriter(fout,"UTF-8");
				OutputFormat  of = OutputFormat.createPrettyPrint();
				of.setEncoding("UTF-8");
				XMLWriter xw = new XMLWriter(out,of);
				xw.write(doc);
				xw.flush();
				xw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
