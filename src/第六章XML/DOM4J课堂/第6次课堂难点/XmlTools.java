package 第六章XML.DOM4J课堂.第6次课堂难点;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.*;
import org.dom4j.io.*;

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
