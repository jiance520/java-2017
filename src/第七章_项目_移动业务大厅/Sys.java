package ������_��Ŀ_�ƶ�ҵ�����;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * @version ʱ�䣺2017-12-12 ����7:50:17,2017.12.26.18
 *���ڶ�д���ص�bin���ݣ�һ��Ҫ��HashMap<String,User>���͵�Map���������÷�������֤������Ƕ��������б������ٴ��룡
 *�б�һֱ��ԭ�����б�ֻ�Ƕ�д���������ݣ���������newһ���б�Ž�ȥ�����򣬶������л��Ķ����б���UID��ǲ�һ���Ĵ�InvalidClassException
 *���⻹Ҫע��ǿת�ͷ��͵�ʹ�á�
 *��Ҫ�����޸��������!�ᵼ���Ѵ��������ͺͼ��ص������Բ�һ�¶�����
 *ע�����Ĳ������⡣�������ڲ����ݵ���ҪС��
 *ÿִ��һ�ζ����ݲ���������һ���ϵ㡣
 */
public class Sys {
//	��ʼ��һ�����ݲ�����б�������Ӳ��
	static int count1 = 0;
	static int count2 = 0;
	Calendar cd = Calendar.getInstance();
	ArrayList<Type> typeList = new ArrayList<Type>();
	public Sys(){
		typeList.add(new Type("�����ײ�",500,30,58));
		typeList.add(new Type("�����ײ�",3,68));
		typeList.add(new Type("�����ײ�",200,1,50,78));
	}
	//����һ���·ݣ���ǰ����Ϊʱ����㣡
	//test.writeUserMap(test.readUserMap());��Ȼ�������ݻᱻ���ǣ����Ƕ�д����ͬһ���б�
	public HashMap<String,UserData> readUserMap() throws IOException, ClassNotFoundException{//��������
		File file = new File("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\java�߼�����2017\\src\\������_��Ŀ_�ƶ�ҵ�����\\UserData.bin");
		if(file.exists()){
			FileInputStream fis = new FileInputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\java�߼�����2017\\src\\������_��Ŀ_�ƶ�ҵ�����\\UserData.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<String,UserData>  map = (HashMap<String,UserData>)ois.readObject();
			ois.close();
			fis.close();
			Test.getLog().debug("��ȡ��"+(++count1)+"��:"+map.toString());
			return map;
		}
		else{
			HashMap<String,UserData> map = new HashMap<String,UserData>();
//			writeUserMap(map);//�˴���ʱ������
			Test.getLog().debug("��ȡ��"+(++count1)+"��:"+map);
			return map;
		}
	}
	
	//������Ψһ���ֻ����룬�����ֲ��Ƕ��󣬲��ܵ��÷���������תΪ������뼯�ϡ�ʹ��HashMap��List���ʺϼ�����
	public UserData readUser(String tel) throws IOException, ClassNotFoundException{//��������
		HashMap<String,UserData> map = readUserMap();
		if(map.containsKey(tel)){//�����ڼ�������û���ҵ����û����ݶ�����һ����ѯ���			
			UserData userData = map.get(tel);
				return userData;
		}
		else{
//			System.out.println("�û������ڣ�");�˾䲻�ܼӣ���Ϊ�и�ѡ�ŵķ�������ô˷���
			return null;
		}
	}
	
	public void writeUserMap(HashMap<String,UserData> map) throws IOException{//������ע����û���bin
		FileOutputStream fos = new FileOutputStream("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\java�߼�����2017\\src\\������_��Ŀ_�ƶ�ҵ�����\\UserData.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(map);
		oos.flush();
		fos.flush();
		oos.close();
		fos.close();
		Test.getLog().debug("д����"+(++count2)+"map:"+map);
	}
	
	//����ָ���ײ����ͣ������ײ����͵������Է�������
	public void writeUser(String tel,UserData userData) throws IOException, ClassNotFoundException{//������ע����û���bin
		File file = new File("E:\\��������\\ѧϰ�ʼ�\\java�ʼ�\\java�߼�����2017\\src\\������_��Ŀ_�ƶ�ҵ�����\\UserData.bin");
		if(file.exists()){
			//�ѱ��ص��б���������
			HashMap<String,UserData> map = readUserMap();//���Բ���new HashMap<String,User>();
			map.put(tel,userData);
			writeUserMap(map);//�����û����ٰ��޸ĵ��б��ٷŽ�ȥ��
		}
		else{
			HashMap<String,UserData> map = new HashMap<String,UserData>();
			map.put(tel,userData);
			writeUserMap(map);
		}
	}
	
//	���˵�
	public void start() throws IOException, ClassNotFoundException{//�˵�ҳ
//		resetSys();//--------���п���,һ������һ�Σ��籨��ɾ��---------------
		Scanner input = new Scanner(System.in);
		System.out.println("**************��ӭʹ�����ƶ�ҵ�����*************");
		System.out.print("1.�����ѯ\t");
		System.out.print("2.�û�ע��\t");
		System.out.print("3.ʹ�÷���\t");
		System.out.print("4.���ѳ�ֵ\t");
		System.out.print("5.�ʷ�˵��\t");
		System.out.println("6.�˳�ϵͳ");
		System.out.print("��ѡ�������Ŀ:");
		int num = input.nextInt();
		UserData userData;
		switch(num){
		case 1:
//			����ҵ������ѯ�������������
			userData = login();
			menu(userData);
			break;
		case 2:
//			ע�ᣬ�����������
			register();
			break;
		case 3:
//			ʹ�÷��񣬻����������
			userData = login();
			useSys(userData);
			break;
		case 4:
//			��ֵ�������������
			userData = login();
			pay(userData);
			writeUser(userData.getTel(),userData);
			exit();
			break;
		case 5:
//			����
			state();
			exit();
			break;
		default:
			exit();
			break;
		}
	}
	
	//�³�����ʼ���ײ�������ͬʱ����������ÿ�������˵�(ÿ����������һ��)���˷���������ʹ�á����߷���start��
	public void resetSys() throws IOException, ClassNotFoundException{
//		Calendar t1 = Calendar.getInstance();
//		Scanner input = new Scanner(System.in);
//		//��ȡ�û����б�����ÿһ���û��������ͨ��ʱ���������������Ѷ��Ž��г�ʼ��
//		HashMap<String,UserData> map = readUserMap();
//		Collection<UserData> collection = map.values();
//		Iterator<UserData> it = collection.iterator();
//		//������������û���ʹ�õ�һ���û���ʱ�䣬����ǰʱ��Ƚϣ����û�ж�ȡ������ʹ�õ�ǰʱ�䡣
//		if (it.hasNext()) {
//			//���û�����һ���ж�ʱ���·�
//			if (it.next().getRecord().getMonth()!=t1.get(Calendar.MONTH)+1) {
//				while(it.hasNext()){
//					UserData userData = it.next();
////					ÿ�ε�½�жϣ�����������û����³�����һ�����˵�������������
//					if(userData.getRecord().getMonth()!=0&&userData.getRecord().getMonth()!=t1.get(Calendar.MONTH)+1){
//						userData.setAllTimes(0);//ͨ����ʱ��
//						userData.setAllDuanxin(0);//�ۻ���������
//						userData.setAllLiuliang(0);//�ۻ����� MB
//						userData.setAllBalances(0);//�ۻ�����
//						userData.setMonthDetails(new MonthDetails(userData.getAllTimes(),userData.getDuanxin(),userData.getLiuliang(),userData.getBalances()));
//						userData.getArrMonthDetails()[userData.getRecord().getMonth()-1] = userData.getMonthDetails();
//						resetUserData(userData);//�³���ʼ���û�����
//						userData.setRecord(new Record(null,null,t1.get(Calendar.MONTH)+1));//����ͨ����¼
//						userData.setrecordList(new ArrayList<Record>());//�µ����굥
//						double huafei = userData.getBalances()-userData.getType().getPrice();
//						if(huafei>0){
//							resetType(userData);//�³�����ʼ���ײ�����
//							userData.setBalances(userData.getBalances()-userData.getType().getPrice());//�۳����ײͷѺ�����-----------���޸�-----
//						}
//						else{
//							System.out.println("����");//----------------------------------
//						}
//					}
//				}
//			}
//		}
//		writeUserMap(map);//�޸ĺ󱣴�
	}
//	��½
	public void menu(UserData userData) throws IOException, ClassNotFoundException{//��½
		Scanner input = new Scanner(System.in);
		System.out.println("**********�û��˵�**********");
		System.out.println("1.���˵���ѯ");
		System.out.println("2.�ײ�������ѯ");
		System.out.println("3.��ӡ���Ѽ�¼");
		System.out.println("4.�ײͱ��");
		System.out.println("5.��������");
		System.out.println("6.showAll");
		System.out.println("7.showMonth");
		System.out.println("8.iteratorAllUser");
		System.out.println("9.����ʹ�ù���");
		System.out.println("��ѡ���������1-5���������ַ�����һ��");
		int num = input.nextInt();
		String str;
		switch(num){
		case 1://ָ�����˵���ѯ
			userData.showMonthList();
			System.out.println("�Ƿ����ҵ�������ѯ:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 2://�ײ�������ѯ
			userData.showtaocanlist();
			System.out.println("�Ƿ����ҵ�������ѯ:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 3://��ӡָ���·ݵ������嵥�������Ѽ�¼
			userData.showRecoredMap();
			System.out.println("�Ƿ����ҵ�������ѯ:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 4://�ײͱ��
			changeType(userData);
			writeUser(userData.getTel(),userData);
			System.out.println("�Ƿ����ҵ�������ѯ:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 5://��������
			delTel(login());
			System.out.println("�Ƿ����ҵ�������ѯ:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 6:
			showAll(userData);
			System.out.println("�Ƿ����ҵ�������ѯ:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 7:
			showMonth(userData);
			System.out.println("�Ƿ����ҵ�������ѯ:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 8:
			iteratorAllUser();
			System.out.println("�Ƿ����ҵ�������ѯ:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 9:
			useSys(userData);
			break;
		default:
			start();
			break;
		}

	}
//	ע��
	public void register() throws IOException, ClassNotFoundException{//ע���û�
		Scanner input = new Scanner(System.in);
		String[] array = new String[9];
		Arrays.fill(array, " ");//��������null��Ԫ�����á�
		for (int i = 0; i < array.length; i++) {
			//Math.random()����С��1��
			//���11λ1��ͷ���ֻ�����
			String telnew = ""+((long)((Math.random()*9000000000L)+10000000000L));
			if (readUser(telnew)==null) {//����ĺ���û�б�ע�ᡣ
				boolean flag = true;
				for (int j = 0; j < array.length; j++) {
					if (array[j].equals(telnew)) {//��֤����ĺ���û������ʱ�б����ظ�
						flag = false;
						--i;
						break;
					}
				}
				if(flag){
					array[i] = telnew;
					System.out.print(telnew+"\t");
					if ((i+1)%3==0) {//ÿ��������ͻ���
						System.out.println();
					}
				}
			}
			else{
				--i;//
			}
		}
		System.out.print("�������ֻ��ţ�");
		String tel = input.next();//���б�����ʾ�ĺ�����ѡһ��ע��
		if(readUser(tel)!=null){
			System.out.println("�Բ�����ע��ĺ����Ѿ����ڣ�������ע�ᡣ");
			register();
			//---------------------------����ע��
		}
		else{
			System.out.print("���������룺");
			String password = input.next();
			state();//��ʾ�ײͽ���
//			Type[] arrType = readArrType();//---------------------------
//			HashMap<String,Type> map = readTypeMap();
//			for (int i = 0; i < arrType.length; i++) {
//				System.out.print((i+1)+"."+arrType[i].getName()+"\t");
//			}
			System.out.println();
			System.out.print("��ѡ������ײ����ͣ�");
			Type type = typeList.get(input.nextInt()-1);
//			Type type = arrType[input.nextInt()-1];		
			UserData userData = new UserData(tel,password,type);//ע�ⲻҪд����,��ʼ�����û�����ѵ绰�����š�����
			//�쿨ʱ��ֵ,���۳��ײͷѣ������
			double money = 0;
			double list = 0;
			do{
				System.out.print("�������ֵ��");
				money = input.nextInt();
				list = money-type.getPrice();
				if(list<0){
					System.out.println("��ֵ���㣬�����³�ֵ");
				}
			}while(list<0);
			userData.setBalances(list);
			System.out.println("���ֵ��"+money+"Ԫ���ѡ���"+list);
			
//			���û���ֵ�󣬿۳��ײͷ�
			userData.setBalances(money-userData.getType().getPrice());
			System.out.print("�Ƿ���������û���Ϣ��y/n");
			if(input.next().equals("y")){
				System.out.print("���������������");
				userData.setName(input.next());
				System.out.println("ע����ɣ�");
			}
			else{
				System.out.println("ע����ɣ�");
			}
			writeUser(tel,userData);
			//�������ҳ�棬���߷�����ҳ���½-------------------
			start();//---------------------------------�������޸�
		}	
	}
	
//	4.�ײͱ��
	public void changeType(UserData userData) throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		state();//��ʾ�ײͽ���
//		HashMap<String,Type> type = readTypeMap();
//		Set<String> set = type.keySet();
//		Iterator<String> it = set.iterator();
//		String str = "���\t�ײ�����\tͨ��ʱ��\t��������\t��������\t�ʷ�";
//		System.out.println(str);
//		int cnt = 0;
//		while(it.hasNext()){
//			String typeName = it.next();
//			System.out.print(++cnt+"\t");
//			System.out.println(type.get(typeName));
//		}
		System.out.println("����������Ҫ������ײͣ�������Ч");
		int num = input.nextInt();
		switch(num){
		case 1:
			userData.setTypeTemp(typeList.get(num-1));
			break;
		case 2:
			userData.setTypeTemp(typeList.get(num-1));
			break;
		case 3:
			userData.setTypeTemp(typeList.get(num-1));
			break;
		default:
			exit();
			break;
		}
	}
//	5.����
	public void delTel(UserData userData) throws IOException, ClassNotFoundException{//����������
		HashMap<String,UserData> map = readUserMap();
		map.remove(userData.getTel());
		System.out.println("�����ɹ���");
		writeUserMap(map);	
	}
//	��ֵ
	public void pay(UserData userData) throws IOException, ClassNotFoundException{
		userData.pay();
		writeUser(userData.getTel(),userData);
	}	
//	ʹ���ಷ��񣬴�绰�������ţ���������ѯ
	public void useSys(UserData userData) throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
//		int num = (int)(Math.random()*6+1);
		System.out.println("1��绰");
		System.out.println("2������");
		System.out.println("3����");
		System.out.println("4�ۻ�����");
		System.out.println("5����");
		System.out.println("6.showAll");
		System.out.println("7.showMonth");
		System.out.println("8.����ҵ���ѯ");
		System.out.println("����������1-6ѡ�����");
		int num = input.nextInt();
		String str;
		switch(num){
		case 1:
			//��绰
			userData.telStart();
			writeUser(userData.getTel(),userData);
			System.out.println("�Ƿ����ʹ����:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 2:
			//������
			userData.faDuangXin();
			writeUser(userData.getTel(),userData);
			System.out.println("�Ƿ����ʹ����:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 3:
			//����
			userData.gprs();
			writeUser(userData.getTel(),userData);
			System.out.println("�Ƿ����ʹ����:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 4:
			//�����������
			userData.showExpend();
			writeUser(userData.getTel(),userData);
			System.out.println("�Ƿ����ʹ����:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 5:
			//�ײ�����
			userData.showtaocanlist();
			System.out.println("�Ƿ����ʹ����:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 6:
			showAll(userData);
			System.out.println("�Ƿ����ʹ����:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 7:
			showMonth(userData);
			System.out.println("�Ƿ����ʹ����:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 8:
			menu(userData);
			break;
		default:
			System.out.println("���д���");
			System.out.println("�Ƿ����ʹ����:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		}
	}
//	�ײͽ��ܣ��ʷ�˵��
	public void state() throws IOException, ClassNotFoundException{
		String str = "���\t�ײ�����\tͨ��ʱ��\t��������(G)\t��������\t�ʷ�";
		System.out.println(str);
		int cnt = 0;
		Iterator<Type> it = typeList.iterator();
		while(it.hasNext()){
			Type type = it.next();
			System.out.print(++cnt+"\t");
			System.out.println(type);
		}
//		String str = "�ײ�����\tͨ��ʱ��\t��������\t��������\t�ʷ�\t";
//		System.out.println(str);
//		HashMap<String,Type> map = readTypeMap();
//		//Ƕ����
//		for (Map.Entry<String,Type> type:map.entrySet()) {
//			System.out.println(type.getValue());
//		}
	}
//	�˳�
	public void exit() throws IOException, ClassNotFoundException{//�˳�ϵͳ
		Scanner input = new Scanner(System.in);
		System.out.println("�������˵����˳�����y/n");
		String str = input.next();
		if(str.equals("y")){
			start();
		}
		else{
			System.out.println("�˳�ϵͳ");
			System.exit(-1);
		}
	}
	
//	���û����³�����ʼ���ײ�����,���Ա����½�û����ȡ���û�������ܵ����á�
	public void resetType(UserData userData) throws IOException, ClassNotFoundException{
		userData.setTimes(userData.getType().getTimes());//ʣ�����ͨ��ʱ��
		userData.setDuanXin(userData.getType().getCount());//ʣ����Ѷ�������
		userData.setLiuLiang(userData.getType().getFlow());//ʣ��������� MB
	}
	
//	ֻ�����ж��³���ʼ�����û����ݡ�����������Ϊ�г�ֵ��ʾ�������ڵ�½�������
	public void resetUserData(UserData userData) throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
//		ÿ�ε�½�жϣ�����������û����³�����һ�����˵�������������
		int month = userData.getRecord().getMonth();
		if(month!=0&&month!=cd.get(Calendar.MONTH)+1){
			Test.getLog().debug("�����³���Ϣ����");
			//�ж��Ƿ������������ײͱ�������������ײ����͸ı�
			if(userData.getTypeTemp()!=null){
				userData.setType(userData.getTypeTemp());
				userData.setTypeTemp(null);
			}
			userData.setAllTimes(0);//ͨ����ʱ��
			userData.setAllDuanXin(0);//�ۻ���������
			userData.setAllLiuLiang(0);//�ۻ����� MB
			userData.setAllBalances(0);//�ۻ�����
//			userData.setMonthDetails(new MonthDetails(userData.getAllTimes(),userData.getAllDuanXin(),userData.getAllLiuLiang(),userData.getAllBalances()));
//			userData.getArrMonthDetails()[userData.getRecord().getMonth()-1] = userData.getMonthDetails();
			MonthDetails  monthDetails = new MonthDetails();
			userData.setMonthDetails(monthDetails);
			userData.getArrMonthDetails()[cd.get(Calendar.MONTH)] = userData.getMonthDetails();
			userData.setRecord(new Record(null,null,cd.get(Calendar.MONTH)+1));//����ͨ����¼
			userData.setRecordList(new ArrayList<Record>());//�µ����굥
			resetType(userData);//�³�����ʼ���ײ�����
			double huafei = userData.getBalances()-userData.getType().getPrice();
			userData.setBalances(huafei);
			if(huafei>0){
				userData.setBalances(userData.getBalances()-userData.getType().getPrice());//�۳����ײͷѺ�����-----------���޸�-----
			}
			else{
				System.out.println("�����ֻ�����"+huafei+"Ԫ,���ֵ:y/n");
				String str = input.next();
				if(str.equals("y")){
					userData.pay();
					resetType(userData);
				}
				else{
					System.out.println("����");//----------------------------------
				}
			}
		}
		else{
			System.out.println("��ӭ�Ͽͻ�");
		}
		writeUser(userData.getTel(),userData);//�޸ĺ󱣴�
	}
	
//	���������б��е��û�
	public void iteratorAllUser() throws IOException, ClassNotFoundException{
		HashMap<String,UserData> map = readUserMap();
		String str = "����\t�ֻ�����\t�ײ�����\t����\tͨ��ʱ��\t��������\t����G";
		System.out.println(str);
		for(Map.Entry<String, UserData> userData:map.entrySet()){
			System.out.println(userData.getValue());
		}
//		while(it.hasNext()){
//			String userStr = it.next();//�ֻ�����
//			User user = readUser(userStr);//�û�����
//			System.out.println(user.toString());
//		}
	}
	
//	����û��б�����
	public void clearUserMap() throws IOException, ClassNotFoundException{
		HashMap<String,UserData> map = readUserMap();
		map.clear();
		writeUserMap(map);
		iteratorAllUser();
	}
//	��ʾ��ǰ�����굥
	public void showAll(UserData userData){
		//��ʾ�û���ǰ�������ݺ�Sys�������е��¼�¼
		System.out.println("�û���\t�ֻ���\t����\t�ײ�����\t�ײ�ͨ��\t�ײ�����\t�ײͶ���\t�ײͷ�");
		System.out.println(userData.getName()+"\t"+userData.getTel()+"\t"+userData.getPassword()+"\t"+userData.getType());
		System.out.println();
		System.out.println("���\t���ͨ��ʱ��\t��Ѷ�������\t������� G");
		System.out.println(userData.getBalances()+"\t"+userData.getTimes()+"\t"+userData.getDuanxin()+"\t"+userData.getLiuliang());
		System.out.println();
		System.out.println("ͨ����ʱ��\t�ۻ���������\t�ۻ����� MB\t�ۻ�����\t�����ײ�����");
		System.out.println(userData.getAllTimes()+"\t"+userData.getAllDuanXin()+"\t"+userData.getAllLiuLiang()+"\t"+userData.getAllBalances()+"\t"+userData.getTypeTemp());
		System.out.println();
		if(userData.getRecord().getValue()!=null){
			System.out.println("���Ѽ�¼��Ϊ��");
			System.out.println("�ֻ���\t���Ѽ�¼\t��������ʱ��");
			System.out.println(userData.getRecord().toString()+"\t"+userData.getRecord().getMonth());
		}
		else{
			System.out.println("���Ѽ�¼Ϊ��");
		}
		System.out.println();
		if(!userData.getRecordList().isEmpty()){
			System.out.println("�����Ѽ�¼�굥��Ϊ��");
			Iterator<Record> it = userData.getRecordList().iterator();
			System.out.println("�ֻ���\t��������\t��������ʱ��");
			while(it.hasNext()){
				Record record = it.next();
				System.out.println(record.toString()+"\t"+record.getMonth());
			}
		}
		else{
			System.out.println("�����Ѽ�¼�굥Ϊ��");
		}
		System.out.println();
		if(userData.getArrRecord()[cd.get(Calendar.MONTH)+1-1]!=null){			
			System.out.println("�����е�ǰ�����Ѽ�¼��Ϊ��");
			ArrayList<Record> recordList = userData.getArrRecord()[cd.get(Calendar.MONTH)+1-1];
			Iterator<Record> itmonth = recordList.iterator();
			System.out.println("�ֻ���\t��������\t��������ʱ��");
			while(itmonth.hasNext()){
				Record record = itmonth.next();
				System.out.println(record.toString()+"\t"+record.getMonth());
			}
		}
		else{
			System.out.println("�����е�ǰ�����Ѽ�¼Ϊ��");
		}
		System.out.println();
		if(userData.getMonthDetails().getMonthBalances()!=0){
			System.out.println("�����ۻ����Ѳ�Ϊ��");	
			System.out.println("���ۻ�ͨ��\t���ۻ�����\t���ۻ�����\t���ۻ�����");
			System.out.println(userData.getMonthDetails());;
//		System.out.println(userData.getMonthDetails().getMonthBalances()+"\t"+userData.getMonthDetails().getMonthDuanxin()+"\t"+userData.getMonthDetails().getMonthLiuliang()+"\t"+userData.getMonthDetails().getMonthTimes());
		}
		else{
			System.out.println("�����ۻ�����Ϊ��");
		}
		System.out.println();
		if(userData.getArrMonthDetails()[cd.get(Calendar.MONTH)+1-1]!=null){
			System.out.println("�����е����ۻ����Ѳ�Ϊ��");
			System.out.println("���ۻ�ͨ��ʱ��\t���ۻ�����\t���ۻ�����\t���ۻ�����");
			System.out.println(userData.getArrMonthDetails()[cd.get(Calendar.MONTH)+1-1]);
		}
		else{
			System.out.println("�����е�������Ϊ��");
		}
		System.out.println();
	}
//	��ʾָ�������굥
	public void showMonth(UserData userData) throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ���·����굥��");
		int month = input.nextInt();
		//��ʾ�û���ǰ�������ݺ�Sys�������е��¼�¼
		System.out.println("�û���\t�ֻ���\t����\t�ײ�����\t�ײ�ͨ��\t�ײ�����\t�ײͶ���\t�ײͷ�");
		System.out.println(userData.getName()+"\t"+userData.getTel()+"\t"+userData.getPassword()+"\t"+userData.getType());
		System.out.println();
		if(userData.getArrRecord()[month-1]!=null){			
			System.out.println("�����е�ǰ�����Ѽ�¼��Ϊ��");
			ArrayList<Record> recordList = userData.getArrRecord()[month-1];
			Iterator<Record> itmonth = recordList.iterator();
			System.out.println("�ֻ���\t��������\t��������ʱ��");
			while(itmonth.hasNext()){
				Record record = itmonth.next();
				System.out.println(record.toString()+"\t"+record.getMonth());
			}
		}
		else{
			System.out.println("�����е�ǰ�����Ѽ�¼Ϊ��");
		}
		System.out.println();
		if(userData.getArrMonthDetails()[month-1]!=null){
			System.out.println("�����е����ۻ����Ѳ�Ϊ��");
			System.out.println("���ۻ�ͨ��ʱ��\t���ۻ�����\t���ۻ�����\t���ۻ�����");
			System.out.println(userData.getArrMonthDetails()[month-1]);
		}
		else{
			System.out.println("�����е�������Ϊ��");
		}
		System.out.println();
	}
	public UserData login() throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		boolean flag = false;
		UserData userData;
		int cnt = 5;//������������������
		do {
			System.out.print("�������ֻ����룺");
			String tel = input.next();
			System.out.print("������������룺");
			String password = input.next();
			userData = readUser(tel);
			boolean bl = userData != null && userData.getPassword().equals(password);
			if(bl){
				System.out.println("�û�����������ȷ��");
//				ÿ�ε�½�ж��³������ʼ���û����ݣ����ж��Ƿ�Ƿ��
				resetUserData(userData);//�������رգ���Ӱ�쵱ǰ�������ݣ�-----------------------
				System.out.println("��½�ɹ�!");
				flag = false;
				break;//������
				//�����ѯҳ��-------------------------------------
			}
			else{
				cnt--;
				if(cnt>0){
					System.out.println("�ֻ��Ż������������������,�㻹��"+cnt+"�λ��᣺");
					flag = true;
				}
				else{
					System.out.println("���5�Σ���ֹ��½��");
					//���������˵�-----------------------
					System.exit(-1);;
				}
			}
		} while (flag);	
		Test.getLog().debug("�û���½�ɹ�");
		return userData;
	}
}
