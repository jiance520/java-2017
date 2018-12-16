package 第七章_项目_移动业务大厅;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * @version 时间：2017-12-20 下午4:05:57
 *
 */
public class Record implements Serializable{
	private String tel;
	private String value;
	private int month;
	
	public Record(String tel, String value, int month) {
		super();
		setTel(tel);
		setValue(value);
		setMonth(month);
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String toString(){
		String str = tel+"\t"+value;
		return str;
	}
}
//public HashMap<String,Record> readRecordMap() throws IOException, ClassNotFoundException{
//	File file = new File("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\RecordData.bin");
//	if(file.exists()){
//		FileInputStream fis = new FileInputStream("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\RecordData.bin");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		HashMap<String,Record>  map = (HashMap<String,Record>)ois.readObject();
//		ois.close();
//		fis.close();
//		return map;
//	}
//	else{
//		HashMap<String,Record> map = new HashMap<String,Record>();
//		return map;
//	}
//}
//public Record readRecord(String tel) throws IOException, ClassNotFoundException{
//	HashMap<String,Record> map = (HashMap<String,Record>)readRecordMap();
//	if(map.containsKey(tel)){			
//		Record Record = map.get(tel);
//			return Record;
//	}
//	else{
//		return null;
//	}
//}
//public void writeRecordMap(HashMap<String,Record> map) throws IOException{
//	FileOutputStream fos = new FileOutputStream("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\RecordData.bin");
//	ObjectOutputStream oos = new ObjectOutputStream(fos);
//	oos.writeObject(map);
//	oos.flush();
//	fos.flush();
//	oos.close();
//	fos.close();
//}
//public void writeRecord(String tel,Record Record) throws IOException, ClassNotFoundException{
//	File file = new File("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\RecordData.bin");
//	if(file.exists()){
//		HashMap<String,Record> map = (HashMap<String,Record>)readRecordMap();
//		map.put(tel,Record);
//		writeRecordMap(map);
//	}
//	else{
//		HashMap<String,Record> map = new HashMap<String,Record>();
//		map.put(tel,Record);
//		writeRecordMap(map);
//	}			
//}
