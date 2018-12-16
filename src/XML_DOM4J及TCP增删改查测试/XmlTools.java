package XML_DOM4J��TCP��ɾ�Ĳ����;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.*;
import org.dom4j.io.*;
/**
 * @version ʱ�䣺2018-1-6 ����10:40:24
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
