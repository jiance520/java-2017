package ������_��Ŀ_�ƶ�ҵ�����;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @version ʱ�䣺2017-12-12 ����5:24:59
 *1.���ֽӿں��࣬�û�����(�û��������롢�����Ϣ���ײ�����)����װ����
 *2.�ײ����ͣ����󣬼���
 *3.�ӵ��Զ�д�û����ײ�����,���������û�������뼯��
 *4.�˵���ע�����(��������½���ײͱ��(�Ķ�)����ѯ��ʾ���˳�ϵͳ(ɾ)
 *5.�Ʒ�
 *6.���ѳ�ֵ
 *7.�ʷ�˵��
 *�����˵���ѯ��
 *�ײ�������ѯ��
 *��ʾ�����嵥��
 *����������
 *
 *ע��������11λ���ֻ���
 *
 *���е���Ϣ�����û������й�
 *�����û�ֻ��ϵͳ���˲���
 *ͳһ��������ںͳ���
 */
public class UserData implements Serializable{
	Calendar cd = Calendar.getInstance();
	private String name;//�û���
	private String passWord;//�û�����
	private String tel;//�ֻ���
	private Type type;//�ײ�����
	private double balances;//���
	private int times;//ʣ�����ͨ��ʱ��,�³���ʼ��
	private int duanXin;//ʣ����Ѷ�������,�³���ʼ��
	private double liuLiang;//ʣ��������� MB,�³���ʼ��
	private int allTimes;//ͨ����ʱ��,�³���ʼ��
	private int allDuanXin;//�ۻ���������,�³���ʼ��
	private double allLiuLiang;//�ۻ����� MB,�³���ʼ��
	private double allBalances;//�ۻ�����,�³���ʼ��
	private Type typeTemp;//��һ���µ��ײ����ͣ������³�ʱ��type��Ĭ��ֵ��null��
	private MonthDetails monthDetails = new MonthDetails();//�������˵�����ÿ��ʹ�÷��񣬴���һ�ε�������
	private MonthDetails[] arrMonthDetails = new MonthDetails[12];//���12���µ��굥
	private Record record = new Record(null,null,cd.get(Calendar.MONTH)+1);//����ͨ����¼,������ʱ���µ��½���һ������
	//��绰��¼�Ǹ��û�����һ��ģ���ͨ����¼�����˶�Ӧ���û����б��У����û�������һ���д��
	private ArrayList<Record> recordList = new ArrayList<Record>();//������ʱ���µ��½���һ������
	private ArrayList[] arrRecord = new ArrayList[12];//ֻ�ܱ������12���µ���������,�����Գ�ʼ��������
	//
	public UserData() {
		super();
	}
	
	public UserData(String tel,String passWord,Type type) {
		setPassWord(passWord);
		setTel(tel);
		setType(type);
//		setBalances(type.getPrice());
		setTimes(type.getTimes());
		setDuanXin(type.getCount());
		setLiuLiang(type.getFlow());
	}
	
	public String getName() {
		int a =2;
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public double getBalances() {
		return balances;
	}
		
	public void setBalances(double balances) {
		BigDecimal bg = new BigDecimal(balances);
		double db = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		this.balances = db;//-----------���޸�--------
	}
	
	public int getTimes() {//���ͨ��ʱ��--------------���޸�(ÿ��绰����٣����Σ�)
		
		return times;
	}
	
	public void setTimes(int times) {//���ͨ��ʱ��--------------���޸�(ÿ��绰�����)
		this.times = times;
	}
	
	public int getDuanxin() {//ͬͨ��ʱ�����޸�
		return duanXin;
	}
	
	public void setDuanXin(int duanXin) {//ͬͨ��ʱ�����޸�
		this.duanXin = duanXin;
	}
	
	public double getLiuliang() {//ͬ��
		return liuLiang;
	}
	
	public void setLiuLiang(double liuLiang) {//ͬ��
		BigDecimal bg = new BigDecimal(liuLiang);
		double db = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		this.liuLiang = db;
	}
	
	public int getAllTimes() {
		return allTimes;
	}
	
	public void setAllTimes(int allTimes) {
		this.allTimes = allTimes;
	}
	
	public int getAllDuanXin() {
		return allDuanXin;
	}
	
	public void setAllDuanXin(int allDuanXin) {
		this.allDuanXin = allDuanXin;
	}
	
	public double getAllLiuLiang() {
		return allLiuLiang;
	}
	
	public void setAllLiuLiang(double allLiuLiang) {
		this.allLiuLiang = allLiuLiang;
	}
	
	public double getAllBalances() {
		return allBalances;
	}
	
	public void setAllBalances(double allBalances) {
		BigDecimal bg = new BigDecimal(allBalances);
		double db = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		this.allBalances = db;
	}
	
	public Record getRecord() {
		return record;
	}
	
	public void setRecord(Record record) {
		this.record = record;
	}
		
	public ArrayList<Record> getRecordList() {
		return recordList;
	}
	
	public void setRecordList(ArrayList<Record> recordList) {
		this.recordList = recordList;
	}
	
	public ArrayList[] getArrRecord() {
		return arrRecord;
	}
	
	public void setArrRecord(ArrayList[] arrRecord) {
		this.arrRecord = arrRecord;
	}	

	public Type getTypeTemp() {
		return typeTemp;
	}

	public void setTypeTemp(Type typeTemp) {
		this.typeTemp = typeTemp;
	}

	public MonthDetails getMonthDetails() {
		return monthDetails;
	}
    
	public void setMonthDetails(MonthDetails monthDetails) {
		this.monthDetails = monthDetails;
	}
	
	public MonthDetails[] getArrMonthDetails() {
		return arrMonthDetails;
	}
	
	public void setArrMonthDetails(MonthDetails[] arrMonthDetails) {
		this.arrMonthDetails = arrMonthDetails;
	}
	
	public String toString(){
//		String str = "����\t�ֻ�����\t�ײ�����\t����\tͨ��ʱ��\t��������\t����\t";
		String str1 = name+"\t"+tel+"\t"+type.getName()+"\t"+balances+"\t"+times+"\t"+duanXin+"\t"+liuLiang;
		return str1;
	}
	
	public double pay() {//��ֵ֮�����Ҫ�ڷ�����䶯��������绰
		Scanner input = new Scanner(System.in);
		double money = 0;
		System.out.print("�������ֵ��");
		money = input.nextInt();
		setBalances(balances+money);
		System.out.println("���ֵ��"+money+"Ԫ���ѡ����"+balances+"Ԫ");
		return money;
	}
//  ��绰���̣߳�
	public void telStart(){
		Calendar cd = Calendar.getInstance();
		if(balances<0){
			System.out.println("���㣬����ͨ�����뷵�س�ֵ");
			pay();
		}
		else{
			//��ʱ 
			System.out.println("��ʼ��绰");
			int timeTemp = (int)(Math.random()*99+1);//ÿ��ͨ��ʱ�䣬�������
			int sumTemp = 0;//������ʱ����һ��ֵtimeTemp=sumTemp
//			if(ʣ�����ʱ��times>0&&ͨ��ʱ��û�г���ʣ�����ʱ��)//�ۻ����Ѻ�����
//			�ж����ͨ��Ϊ0�������㣬������ͨ������ͨ����¼��
			if(times==0&&balances<0.2){
				System.out.println("���㣬�� �ܽ���ͨ��������¼���Ѽ�¼���뷵�س�ֵ��");
			}
			else if(times>0&&timeTemp<=times){
				setTimes(times-timeTemp);//��������ʣ�����ͨ��ʱ��
				setAllTimes(allTimes+timeTemp);//���������ۻ�ͨ��ʱ��
				
				monthDetails.setMonthTimes(getAllTimes());
//				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				//�Ȼ�ȡ��һ�ε�ʱ��,����һ�μ�¼�У�Ҳ����һ���б��У��������굥������
				record.setTel(tel);
				record.setValue("��绰 "+timeTemp+"����");
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;//����map���������и���ԭ�����Ա��		
				System.out.println("����ͨ��"+timeTemp+"���ӣ�����¼һ�����Ѽ�¼");
			}
//			else if(ʣ�����ʱ��times>0&&ͨ��ʱ�䳬��ʣ�����ʱ�䣬Ҫ�۷ѣ���Ҫforѭ�����ж����<0.2ֹͣͨ��)
			else if(times>=0&&timeTemp>times){
				//����ͨ���������ʱ��timeTemp>times������ͨ�����ܳ������(timeTemp-timeTemp)*0.2>balancesֹͣͨ��
//					1.ͨ��û�г������ʱ�䲻�۷ѣ�ֻ�����ۻ�ͨ������ʣ�����ʱ��
//					2.ͨ��������Ѳ��֣��ж�����������0.2��ִ��ͨ�����۷ѣ��������ж�������<0.2��ֹͣͨ���������ۻ�ͨ������ʣ�����ʱ�䡣
				for (int i = 1; i <= timeTemp; i++) {
					if(times>0){
						sumTemp += 1;
						setAllTimes(allTimes+1);
						setTimes(times-1);
					}
					else if(balances>0.2){
						sumTemp += 1;
						setAllTimes(allTimes+1);
						setBalances(balances-0.2);
						setAllBalances(allBalances+0.2);
					}
					else{
						System.out.println("���㣬ֹͣͨ�������ֵ��");
						break;
					}
				}
				monthDetails.setMonthTimes(getAllTimes());
				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				//�Ȼ�ȡ��һ�ε�ʱ��,����һ�μ�¼�У�Ҳ����һ���б��У��������굥������
				Record record = new Record(tel,"��绰"+sumTemp+"����",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;//����map���������и���ԭ�����Ա��		
				System.out.println("����ͨ��"+sumTemp+"���ӣ�����¼һ�����Ѽ�¼");
			}
		}
	}
//	������,������Ѷ�����������۷�
	public void faDuangXin(){
		Calendar cd = Calendar.getInstance();
		if(balances<0){
			System.out.println("���㣬���ܷ����ţ��뷵�س�ֵ");
			pay();
		}
		else{
			System.out.println("��ʼ������");
			int duanXinTemp = (int)(Math.random()*9+1);
			int sumTemp = 0;
			if(duanXin==0&&balances<0.1){
				System.out.println("���㣬���ܷ���Ϣ������¼���Ѽ�¼���뷵�س�ֵ��");
			}
			else if(duanXin>0&&duanXinTemp<=duanXin){
				setDuanXin(duanXin-duanXinTemp);//���۷ѣ�ֻ����ʣ����Ѵ���
				setAllDuanXin(allDuanXin+duanXinTemp);
				
				monthDetails.setMonthDuanxin(getAllDuanXin());
//				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				allDuanXin = allDuanXin+1;
				Record record = new Record(tel,"���Ͷ���"+duanXinTemp+"��",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;
				System.out.println("���η���"+duanXinTemp+"�����ţ�����¼һ�����Ѽ�¼");
			}
			else if(duanXin>=0&&duanXinTemp>duanXin){
				for (int i = 1; i <= duanXinTemp; i++) {
					if(duanXin>0){
						sumTemp += 1;
						setDuanXin(duanXin-1);
						setAllDuanXin(allDuanXin+1);
					}
					else if(balances>0.1){
						sumTemp += 1;
						setAllDuanXin(allDuanXin+1);
						setBalances(balances-0.1);
						setAllBalances(allBalances+0.1);
					}
					else{
						System.out.println("���㣬���ܷ����ţ����ֵ��");
						break;
					}
				}
				monthDetails.setMonthDuanxin(getAllDuanXin());
				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				allDuanXin = allDuanXin+1;
				Record record = new Record(tel,"���Ͷ���"+sumTemp+"��",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;
				System.out.println("���η���"+sumTemp+"�����ţ�����¼һ�����Ѽ�¼");
			}
		}
	}
//	��Gprs�������̣߳��ж��������ĸ��£�Ӱ�쵱ǰ�µ��ۻ�����
	public void gprs(){
		Calendar cd = Calendar.getInstance();
		if(balances<0){
			System.out.println("���㣬�����������뷵�س�ֵ");
			pay();
		}
		else{
			//��������ѷ�Χ�ڣ�ֻ���������
			//����������������㻰�������ۻ����Ѻ��ۼ�����
			System.out.println("��ʼ����");
			int liuLiangTemp = (int)(Math.random()*299+1);
			int sumTemp = 0;
			if(liuLiang==0&&balances<0.1){
				System.out.println("���㣬��������������¼���Ѽ�¼���뷵�س�ֵ��");
			}
			else if(liuLiang>0&&liuLiangTemp<=liuLiang*1024){
				setLiuLiang((liuLiang*1024-liuLiangTemp)/1024);//���۷ѣ�ֻ����ʣ����Ѵ���
				setAllLiuLiang(allLiuLiang+liuLiangTemp);
				monthDetails.setMonthLiuliang(getAllLiuLiang());
//				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				Record record = new Record(tel,"�������� "+liuLiangTemp+"MB",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;
				System.out.println("����������������"+liuLiangTemp+"MB������¼һ�����Ѽ�¼");
			}
			else if(liuLiang>=0&&liuLiangTemp>liuLiang*1024){
				for (int i = 1; i <= liuLiangTemp; i++) {
					if(liuLiang>0.0001){
						sumTemp += 1;
						setLiuLiang((liuLiang*1024-1)/1024);
						setAllLiuLiang(allLiuLiang+1);
					}
					else if(balances>0.1){
						sumTemp += 1;
						setLiuLiang(0);
						setAllLiuLiang(allLiuLiang+1);
						setBalances(balances-0.1);
						setAllBalances(allBalances+0.1);
					}
					else{
						System.out.println("���㣬�������������ֵ��");
						break;
					}
				}
				monthDetails.setMonthLiuliang(getAllLiuLiang());
				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				Record record = new Record(tel,"�������� "+sumTemp+"MB",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;
				System.out.println("����������������"+sumTemp+"MB������¼һ�����Ѽ�¼");
			}
		}
	}	
//	2.�ײ�������ʣ����ѵĶ��š�������ͨ��ʱ����������
	public void showtaocanlist(){
		String str1 = "ʣ�໰��\tʣ��ͨ��ʱ��\tʣ���������\tʣ������(G)";
		System.out.println(str1);
		String str2 = balances+"\t"+times+"\t"+duanXin+"\t"+liuLiang;
		System.out.println(str2);
	}
//	��ǰ�������ۻ�,ʹ���˶��ٻ��ѣ����ٶ��ţ���������
	public void showExpend(){
		System.out.println("��ǰ�µ��ۻ����������");
		System.out.println("�ۻ�����\t�ۻ�����MB\t�ۻ�����\t�ۻ�ͨ��ʱ��");
		System.out.println(allBalances+"\t"+allLiuLiang+"\t"+allDuanXin+"\t"+allTimes);
	}
//	ָ���·ݵ��˵�
	public void showMonthList(){
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ���˵����·�1-12");
		int month = input.nextInt();
		//�ۻ����ѣ��ۻ��������ۻ����ţ��ۻ�ͨ��ʱ��
		int now = cd.get(Calendar.MONTH)+1;
		System.out.println("��ǰ����"+now+"�£�Ҫ��ѯ���·���"+month+"��");
		if( now == month){//	��ǰ�������ۻ�,ʹ���˶��ٻ��ѣ����ٶ��ţ���������
			showExpend();
		}
		else if(arrMonthDetails[month-1]!=null){//	ָ���·ݵ��˵�
			System.out.println("��"+month+"���µ��ۻ����������");
			System.out.println("�ۻ�����\t�ۻ�����MB\t�ۻ�����\t�ۻ�ͨ��ʱ��");
			System.out.println(arrMonthDetails[month-1].getMonthBalances()+"\t"+arrMonthDetails[month-1].getMonthLiuliang()+"\t"+arrMonthDetails[month-1].getMonthDuanxin()+"\t"+arrMonthDetails[month-1].getMonthTimes());
		}
		else{
			System.out.println("�޵����˵�");
		}
	}
//	3.���ָ���������굥
	public void showRecoredMap(){
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ���·�1-12");
		int month = input.nextInt();
		System.out.println("����\t���Ѽ�¼");
		if(month==cd.get(Calendar.MONTH)+1){
			Iterator<Record> it = recordList.iterator();
			while(it.hasNext()){
				Record record = it.next();
				System.out.println(tel+"\t"+record.getValue());
			}
		}
		else{
			ArrayList<Record> hm = arrRecord[month-1];
			Iterator<Record> it = hm.iterator();
			while(it.hasNext()){
				Record record = it.next();
				System.out.println(tel+"\t"+record.getValue());
			}
		}
	}
}
//
//	�û���½��Ҫ�ģ���Ϊ��½���ǲ��������˵��������˵�δ���
//	��������
