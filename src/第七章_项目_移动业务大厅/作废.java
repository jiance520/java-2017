package ������_��Ŀ_�ƶ�ҵ�����;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @version ʱ�䣺2017-12-22 ����3:19:28
 *
 */
public class ���� {
	//-------------------------��������---------------------------------------
	//public void mothList(String string){//�ж���������һ���£����������ݷ��������飬
//		Calendar cl = Calendar.getInstance();
//		int month = record.getMonth();//1-12
//		//ÿһ����newһ���б�
//		record = new Record(tel,string,cl.MONTH);
//		if(record.getMonth() == month){//��ʱ�������һ�μ�¼��ʱ��
//			recordMap.put(tel, record);
//			arrRecord[month-1] = recordMap;//����map���������и���ԭ�����Ա��
////			setArrRecord(arrRecord);	//set�������ϡ�		
//		}
//		else{
//			for (int i = 0; i < arrRecord.length; i++) {
//				if(record.getMonth()-1==i){
//					recordMap.put(tel, record);
//					arrRecord[i] = recordMap;//����map���������и���ԭ�����Ա��
//					recordMap= new HashMap<String,Record>();//��ͬ���·����µ���������ݡ�
//				}
//			}
//		}
	//}
	
//	����ײ�
//	public void clearTypeMap() throws IOException, ClassNotFoundException{
//		HashMap<String,Type> map = readTypeMap();
//		map.clear();
//		writeTypeMap(map);
//		state();
//	}
	
//	------------------------------------------
//	Type type1 = new Type("�����ײ�",500,30,58);
//	Type type2 = new Type("�����ײ�",3,68);
//	Type type3 = new Type("�����ײ�",200,1,50,78);
//	sys.writeType("�����ײ�", type1);
//	sys.writeType("�����ײ�", type2);
//	sys.writeType("�����ײ�", type3);
////	------------------------------------------
	
//	public HashMap<String,Type> readTypeMap() throws IOException, ClassNotFoundException{
//		File file = new File("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\java�߼�����2017\\src\\������_��Ŀ_�ƶ�ҵ�����\\TypeData.bin");
//		if(file.exists()){
//			FileInputStream fis = new FileInputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\java�߼�����2017\\src\\������_��Ŀ_�ƶ�ҵ�����\\TypeData.bin");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			HashMap<String,Type> map = (HashMap<String,Type>)ois.readObject();
//			ois.close();
//			fis.close();
//			return map;
//		}
//		else{
//			HashMap<String,Type> map = new HashMap<String,Type>();
//			return map;
//		}
//	}
////	��ȡ�ײ�����
//	public Type readType(String typeName) throws IOException, ClassNotFoundException{
//		HashMap<String,Type> map = readTypeMap();
//		if(map.containsKey(typeName)){//�����ڼ�������û���ҵ����û����ݶ�����һ����ѯ���			
//			Type type = map.get(typeName);
//			return type;
//		}
//		else{
//			System.out.println("�ײ����Ͳ����ڣ�");
//			return null;
//		}
//	}
//	
////	��ȡ�ײ�����Ϊ���飬�ײ�ֻ�ж�ȡ��ʾ��ѡ������á�
//	public Type[] readArrType() throws IOException, ClassNotFoundException{
//		HashMap<String,Type>  map = readTypeMap();
//		Set<String> set = map.keySet();
//		Iterator<String> it = set.iterator();
//		int num = 0;
//		Type[] arrType = new Type[3];
//		while(it.hasNext()){
//			String typeStr = it.next();
//			arrType[num] = readType(typeStr);
//			num++;
//		}
//		System.out.println();
//		return arrType;
//	}
////	д���ײ�����
//	public void writeType(String name,Type type) throws IOException, ClassNotFoundException{
//		File file = new File("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\java�߼�����2017\\src\\������_��Ŀ_�ƶ�ҵ�����\\TypeData.bin");
//		if(file.exists()){
//			HashMap<String,Type> map = readTypeMap();
//			map.put(name, type);
////			Type type1 = new Type("�����ײ�",500,30,58);
////			Type type2 = new Type("�����ײ�",3,68);
////			Type type3 = new Type("�����ײ�",200,1,50,78);
//			writeTypeMap(map);
//		}
//		else{
//			HashMap<String,Type> map = new HashMap<String,Type>();
//			map.put(name, type);
//			writeTypeMap(map);
//		}
//	}
////	д���ײ������б�
//	public void writeTypeMap(HashMap<String,Type> map) throws IOException{
//		FileOutputStream fos = new FileOutputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\java�߼�����2017\\src\\������_��Ŀ_�ƶ�ҵ�����\\TypeData.bin");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(map);
//		oos.flush();
//		fos.flush();
//		oos.close();
//		fos.close();
//	}
	

}
