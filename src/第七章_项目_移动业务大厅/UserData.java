package 第七章_项目_移动业务大厅;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @version 时间：2017-12-12 下午5:24:59
 *1.发现接口和类，用户对象，(用户名、密码、身份信息、套餐类型)，封装属性
 *2.套餐类型，对象，集合
 *3.从电脑读写用户和套餐数据,对象流，用户对象存入集合
 *4.菜单，注册办理(增）、登陆、套餐变更(改二)、查询显示、退出系统(删)
 *5.计费
 *6.话费充值
 *7.资费说明
 *本月账单查询二
 *套餐余量查询二
 *显示消费清单二
 *办理退网二
 *
 *注册办理，随机11位数手机号
 *
 *所有的信息都跟用户对象有关
 *但是用户只是系统的了部分
 *统一方法的入口和出口
 */
public class UserData implements Serializable{
	Calendar cd = Calendar.getInstance();
	private String name;//用户名
	private String passWord;//用户密码
	private String tel;//手机号
	private Type type;//套餐类型
	private double balances;//余额
	private int times;//剩余免费通话时长,月初初始化
	private int duanXin;//剩余免费短信条数,月初初始化
	private double liuLiang;//剩余免费流量 MB,月初初始化
	private int allTimes;//通话总时长,月初初始化
	private int allDuanXin;//累积短信条数,月初初始化
	private double allLiuLiang;//累积流量 MB,月初初始化
	private double allBalances;//累积话费,月初初始化
	private Type typeTemp;//下一个月的套餐类型，用来月初时给type，默认值是null。
	private MonthDetails monthDetails = new MonthDetails();//单月总账单，在每次使用服务，存入一次当月数组
	private MonthDetails[] arrMonthDetails = new MonthDetails[12];//最近12个月的详单
	private Record record = new Record(null,null,cd.get(Calendar.MONTH)+1);//单次通话记录,在启动时，新的月建了一个对象
	//打电话记录是跟用户绑定在一起的，把通话记录放入了对应的用户的列表中，跟用户的数据一起读写。
	private ArrayList<Record> recordList = new ArrayList<Record>();//在启动时，新的月建了一个对象
	private ArrayList[] arrRecord = new ArrayList[12];//只能保存最近12个月的上网数据,不可以初始化的数据
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
		this.balances = db;//-----------待修改--------
	}
	
	public int getTimes() {//免费通话时长--------------待修改(每打电话会减少，传参？)
		
		return times;
	}
	
	public void setTimes(int times) {//免费通话时长--------------待修改(每打电话会减少)
		this.times = times;
	}
	
	public int getDuanxin() {//同通话时长待修改
		return duanXin;
	}
	
	public void setDuanXin(int duanXin) {//同通话时长待修改
		this.duanXin = duanXin;
	}
	
	public double getLiuliang() {//同上
		return liuLiang;
	}
	
	public void setLiuLiang(double liuLiang) {//同上
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
//		String str = "姓名\t手机号码\t套餐类型\t话费\t通话时长\t短信条数\t流量\t";
		String str1 = name+"\t"+tel+"\t"+type.getName()+"\t"+balances+"\t"+times+"\t"+duanXin+"\t"+liuLiang;
		return str1;
	}
	
	public double pay() {//充值之后，余额要在方法里变动，包括打电话
		Scanner input = new Scanner(System.in);
		double money = 0;
		System.out.print("请输入充值金额：");
		money = input.nextInt();
		setBalances(balances+money);
		System.out.println("你充值了"+money+"元话费。余额"+balances+"元");
		return money;
	}
//  打电话，线程？
	public void telStart(){
		Calendar cd = Calendar.getInstance();
		if(balances<0){
			System.out.println("余额不足，不能通话，请返回充值");
			pay();
		}
		else{
			//计时 
			System.out.println("开始打电话");
			int timeTemp = (int)(Math.random()*99+1);//每次通话时间，如果余额够，
			int sumTemp = 0;//当余额不足时返回一个值timeTemp=sumTemp
//			if(剩余免费时间times>0&&通话时间没有超过剩余免费时间)//累积话费和余额不变
//			判断免费通话为0，且余额不足，不进行通话，无通话记录。
			if(times==0&&balances<0.2){
				System.out.println("余额不足，不 能进行通话，不记录消费记录，请返回充值！");
			}
			else if(times>0&&timeTemp<=times){
				setTimes(times-timeTemp);//重新设置剩余免费通话时间
				setAllTimes(allTimes+timeTemp);//重新设置累积通话时长
				
				monthDetails.setMonthTimes(getAllTimes());
//				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				//先获取上一次的时间,在上一次记录中，也在上一次列表中，还在月详单数组中
				record.setTel(tel);
				record.setValue("打电话 "+timeTemp+"分钟");
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;//用新map放入数组中覆盖原数组成员。		
				System.out.println("本次通话"+timeTemp+"分钟，并记录一条消费记录");
			}
//			else if(剩余免费时间times>0&&通话时间超过剩余免费时间，要扣费，还要for循环，判断余额<0.2停止通话)
			else if(times>=0&&timeTemp>times){
				//先是通话超过免费时间timeTemp>times，后是通话可能超过余额(timeTemp-timeTemp)*0.2>balances停止通话
//					1.通话没有超过免费时间不扣费，只计算累积通话，和剩余免费时间
//					2.通话超过免费部分，判断余额如果大于0.2，执行通话，扣费，计算余额，判断余额如果<0.2，停止通话，计算累积通话，和剩余免费时间。
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
						System.out.println("余额不足，停止通话，请充值！");
						break;
					}
				}
				monthDetails.setMonthTimes(getAllTimes());
				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				//先获取上一次的时间,在上一次记录中，也在上一次列表中，还在月详单数组中
				Record record = new Record(tel,"打电话"+sumTemp+"分钟",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;//用新map放入数组中覆盖原数组成员。		
				System.out.println("本次通话"+sumTemp+"分钟，并记录一条消费记录");
			}
		}
	}
//	发短信,超过免费短信条数，则扣费
	public void faDuangXin(){
		Calendar cd = Calendar.getInstance();
		if(balances<0){
			System.out.println("余额不足，不能发短信，请返回充值");
			pay();
		}
		else{
			System.out.println("开始发短信");
			int duanXinTemp = (int)(Math.random()*9+1);
			int sumTemp = 0;
			if(duanXin==0&&balances<0.1){
				System.out.println("余额不足，不能发信息，不记录消费记录，请返回充值！");
			}
			else if(duanXin>0&&duanXinTemp<=duanXin){
				setDuanXin(duanXin-duanXinTemp);//不扣费，只计算剩余免费次数
				setAllDuanXin(allDuanXin+duanXinTemp);
				
				monthDetails.setMonthDuanxin(getAllDuanXin());
//				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				allDuanXin = allDuanXin+1;
				Record record = new Record(tel,"发送短信"+duanXinTemp+"条",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;
				System.out.println("本次发送"+duanXinTemp+"条短信，并记录一条消费记录");
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
						System.out.println("余额不足，不能发短信，请充值！");
						break;
					}
				}
				monthDetails.setMonthDuanxin(getAllDuanXin());
				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				allDuanXin = allDuanXin+1;
				Record record = new Record(tel,"发送短信"+sumTemp+"条",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;
				System.out.println("本次发送"+sumTemp+"条短信，并记录一条消费记录");
			}
		}
	}
//	打开Gprs上网，线程？判断上网上哪个月，影响当前月的累积话费
	public void gprs(){
		Calendar cd = Calendar.getInstance();
		if(balances<0){
			System.out.println("余额不足，不能上网，请返回充值");
			pay();
		}
		else{
			//短信在免费范围内，只求免费余量
			//超出免费流量，计算话费余额和累积话费和累计流量
			System.out.println("开始上网");
			int liuLiangTemp = (int)(Math.random()*299+1);
			int sumTemp = 0;
			if(liuLiang==0&&balances<0.1){
				System.out.println("余额不足，不能上网，不记录消费记录，请返回充值！");
			}
			else if(liuLiang>0&&liuLiangTemp<=liuLiang*1024){
				setLiuLiang((liuLiang*1024-liuLiangTemp)/1024);//不扣费，只计算剩余免费次数
				setAllLiuLiang(allLiuLiang+liuLiangTemp);
				monthDetails.setMonthLiuliang(getAllLiuLiang());
//				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				Record record = new Record(tel,"上网流量 "+liuLiangTemp+"MB",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;
				System.out.println("本次上网消耗流量"+liuLiangTemp+"MB，并记录一条消费记录");
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
						System.out.println("余额不足，不能上网，请充值！");
						break;
					}
				}
				monthDetails.setMonthLiuliang(getAllLiuLiang());
				monthDetails.setMonthBalances(getAllBalances());
				arrMonthDetails[cd.get(Calendar.MONTH)] = monthDetails;
				Record record = new Record(tel,"上网流量 "+sumTemp+"MB",cd.get(Calendar.MONTH)+1);
				recordList.add(record);
				arrRecord[record.getMonth()-1] = recordList;
				System.out.println("本次上网消耗流量"+sumTemp+"MB，并记录一条消费记录");
			}
		}
	}	
//	2.套餐余量，剩余免费的短信、流量、通话时长，话费余额。
	public void showtaocanlist(){
		String str1 = "剩余话费\t剩余通话时长\t剩余短信条数\t剩余流量(G)";
		System.out.println(str1);
		String str2 = balances+"\t"+times+"\t"+duanXin+"\t"+liuLiang;
		System.out.println(str2);
	}
//	当前月消费累积,使用了多少话费，多少短信，多少流量
	public void showExpend(){
		System.out.println("当前月的累积消费情况：");
		System.out.println("累积话费\t累积流量MB\t累积短信\t累积通话时长");
		System.out.println(allBalances+"\t"+allLiuLiang+"\t"+allDuanXin+"\t"+allTimes);
	}
//	指定月份的账单
	public void showMonthList(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要查询月账单的月份1-12");
		int month = input.nextInt();
		//累积话费，累积流量，累积短信，累积通话时长
		int now = cd.get(Calendar.MONTH)+1;
		System.out.println("当前月是"+now+"月，要查询的月份是"+month+"月");
		if( now == month){//	当前月消费累积,使用了多少话费，多少短信，多少流量
			showExpend();
		}
		else if(arrMonthDetails[month-1]!=null){//	指定月份的账单
			System.out.println("第"+month+"个月的累积消费情况：");
			System.out.println("累积话费\t累积流量MB\t累积短信\t累积通话时长");
			System.out.println(arrMonthDetails[month-1].getMonthBalances()+"\t"+arrMonthDetails[month-1].getMonthLiuliang()+"\t"+arrMonthDetails[month-1].getMonthDuanxin()+"\t"+arrMonthDetails[month-1].getMonthTimes());
		}
		else{
			System.out.println("无当月账单");
		}
	}
//	3.输出指定月消费详单
	public void showRecoredMap(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要查询的月份1-12");
		int month = input.nextInt();
		System.out.println("卡号\t消费记录");
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
//	用户登陆需要改，因为登陆后是操作二级菜单，二级菜单未完成
//	办理退网
