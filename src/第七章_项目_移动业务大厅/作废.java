package 第七章_项目_移动业务大厅;

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
 * @version 时间：2017-12-22 下午3:19:28
 *
 */
public class 作废 {
	//-------------------------以下作废---------------------------------------
	//public void mothList(String string){//判断消费是哪一个月，把消费内容放入月数组，
//		Calendar cl = Calendar.getInstance();
//		int month = record.getMonth();//1-12
//		//每一个月new一个列表。
//		record = new Record(tel,string,cl.MONTH);
//		if(record.getMonth() == month){//新时间等于上一次记录的时间
//			recordMap.put(tel, record);
//			arrRecord[month-1] = recordMap;//用新map放入数组中覆盖原数组成员。
////			setArrRecord(arrRecord);	//set方法作废。		
//		}
//		else{
//			for (int i = 0; i < arrRecord.length; i++) {
//				if(record.getMonth()-1==i){
//					recordMap.put(tel, record);
//					arrRecord[i] = recordMap;//用新map放入数组中覆盖原数组成员。
//					recordMap= new HashMap<String,Record>();//不同的月份用新的数组存数据。
//				}
//			}
//		}
	//}
	
//	清空套餐
//	public void clearTypeMap() throws IOException, ClassNotFoundException{
//		HashMap<String,Type> map = readTypeMap();
//		map.clear();
//		writeTypeMap(map);
//		state();
//	}
	
//	------------------------------------------
//	Type type1 = new Type("话唠套餐",500,30,58);
//	Type type2 = new Type("网虫套餐",3,68);
//	Type type3 = new Type("超人套餐",200,1,50,78);
//	sys.writeType("话唠套餐", type1);
//	sys.writeType("网虫套餐", type2);
//	sys.writeType("超人套餐", type3);
////	------------------------------------------
	
//	public HashMap<String,Type> readTypeMap() throws IOException, ClassNotFoundException{
//		File file = new File("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\TypeData.bin");
//		if(file.exists()){
//			FileInputStream fis = new FileInputStream("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\TypeData.bin");
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
////	读取套餐类型
//	public Type readType(String typeName) throws IOException, ClassNotFoundException{
//		HashMap<String,Type> map = readTypeMap();
//		if(map.containsKey(typeName)){//不管在集合中有没有找到该用户数据都返回一个查询结果			
//			Type type = map.get(typeName);
//			return type;
//		}
//		else{
//			System.out.println("套餐类型不存在！");
//			return null;
//		}
//	}
//	
////	读取套餐类型为数组，套餐只有读取显示和选择的作用。
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
////	写入套餐数据
//	public void writeType(String name,Type type) throws IOException, ClassNotFoundException{
//		File file = new File("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\TypeData.bin");
//		if(file.exists()){
//			HashMap<String,Type> map = readTypeMap();
//			map.put(name, type);
////			Type type1 = new Type("话唠套餐",500,30,58);
////			Type type2 = new Type("网虫套餐",3,68);
////			Type type3 = new Type("超人套餐",200,1,50,78);
//			writeTypeMap(map);
//		}
//		else{
//			HashMap<String,Type> map = new HashMap<String,Type>();
//			map.put(name, type);
//			writeTypeMap(map);
//		}
//	}
////	写入套餐数据列表
//	public void writeTypeMap(HashMap<String,Type> map) throws IOException{
//		FileOutputStream fos = new FileOutputStream("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\TypeData.bin");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(map);
//		oos.flush();
//		fos.flush();
//		oos.close();
//		fos.close();
//	}
	

}
