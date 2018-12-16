package 第七章_项目_移动业务大厅;

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
 * @version 时间：2017-12-12 下午7:50:17,2017.12.26.18
 *对于读写本地的bin数据，一定要用HashMap<String,User>类型的Map对象来调用方法，保证存入的是读出来的列表，更新再存入！
 *列表一直是原来的列表，只是读写更改了数据，不能是又new一个列表放进去，否则，对于序列化的对象列表，报UID标记不一样的错，InvalidClassException
 *另外还要注意强转和泛型的使用。
 *不要随意修改类的属性!会导致已存数据类型和加载的类属性不一致而报错！
 *注意流的并发问题。方法和内部数据调用要小心
 *每执行一次读数据操作，设置一个断点。
 */
public class Sys {
//	初始化一个数据不多的列表，不放入硬盘
	static int count1 = 0;
	static int count2 = 0;
	Calendar cd = Calendar.getInstance();
	ArrayList<Type> typeList = new ArrayList<Type>();
	public Sys(){
		typeList.add(new Type("话唠套餐",500,30,58));
		typeList.add(new Type("网虫套餐",3,68));
		typeList.add(new Type("超人套餐",200,1,50,78));
	}
	//设置一个月份，当前月做为时间起点！
	//test.writeUserMap(test.readUserMap());虽然本地数据会被覆盖，但是读写的是同一个列表。
	public HashMap<String,UserData> readUserMap() throws IOException, ClassNotFoundException{//读入数据
		File file = new File("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\UserData.bin");
		if(file.exists()){
			FileInputStream fis = new FileInputStream("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\UserData.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<String,UserData>  map = (HashMap<String,UserData>)ois.readObject();
			ois.close();
			fis.close();
			Test.getLog().debug("读取了"+(++count1)+"次:"+map.toString());
			return map;
		}
		else{
			HashMap<String,UserData> map = new HashMap<String,UserData>();
//			writeUserMap(map);//此处暂时不保存
			Test.getLog().debug("读取了"+(++count1)+"次:"+map);
			return map;
		}
	}
	
	//集合中唯一的手机号码，是数字不是对象，不能调用方法，所以转为对象存入集合。使用HashMap比List更适合检索。
	public UserData readUser(String tel) throws IOException, ClassNotFoundException{//读入数据
		HashMap<String,UserData> map = readUserMap();
		if(map.containsKey(tel)){//不管在集合中有没有找到该用户数据都返回一个查询结果			
			UserData userData = map.get(tel);
				return userData;
		}
		else{
//			System.out.println("用户不存在！");此句不能加，因为有个选号的方法会调用此方法
			return null;
		}
	}
	
	public void writeUserMap(HashMap<String,UserData> map) throws IOException{//保存新注册的用户到bin
		FileOutputStream fos = new FileOutputStream("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\UserData.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(map);
		oos.flush();
		fos.flush();
		oos.close();
		fos.close();
		Test.getLog().debug("写入了"+(++count2)+"map:"+map);
	}
	
	//必须指定套餐类型，否则，套餐类型调用属性方法报错
	public void writeUser(String tel,UserData userData) throws IOException, ClassNotFoundException{//保存新注册的用户到bin
		File file = new File("E:\\计算机编程\\学习笔记\\java笔记\\java高级特性2017\\src\\第七章_项目_移动业务大厅\\UserData.bin");
		if(file.exists()){
			//把本地的列表对象读出来
			HashMap<String,UserData> map = readUserMap();//绝对不能new HashMap<String,User>();
			map.put(tel,userData);
			writeUserMap(map);//加入用户后，再把修改的列表再放进去，
		}
		else{
			HashMap<String,UserData> map = new HashMap<String,UserData>();
			map.put(tel,userData);
			writeUserMap(map);
		}
	}
	
//	主菜单
	public void start() throws IOException, ClassNotFoundException{//菜单页
//		resetSys();//--------可有可无,一个月用一次，如报错，删除---------------
		Scanner input = new Scanner(System.in);
		System.out.println("**************欢迎使用嗖嗖移动业务大厅*************");
		System.out.print("1.办理查询\t");
		System.out.print("2.用户注册\t");
		System.out.print("3.使用服务\t");
		System.out.print("4.话费充值\t");
		System.out.print("5.资费说明\t");
		System.out.println("6.退出系统");
		System.out.print("请选择服务项目:");
		int num = input.nextInt();
		UserData userData;
		switch(num){
		case 1:
//			个人业务办理查询，会更改流数据
			userData = login();
			menu(userData);
			break;
		case 2:
//			注册，会更改流数据
			register();
			break;
		case 3:
//			使用服务，会更改流数据
			userData = login();
			useSys(userData);
			break;
		case 4:
//			充值，会更改流数据
			userData = login();
			pay(userData);
			writeUser(userData.getTel(),userData);
			exit();
			break;
		case 5:
//			介绍
			state();
			exit();
			break;
		default:
			exit();
			break;
		}
	}
	
	//月初，初始化套餐余量，同时保留话费余额，每次启动菜单(每月至少启动一次)，此方法，单独使用。或者放入start，
	public void resetSys() throws IOException, ClassNotFoundException{
//		Calendar t1 = Calendar.getInstance();
//		Scanner input = new Scanner(System.in);
//		//读取用户的列表，遍历每一个用户，对免费通话时长、免费流量、免费短信进行初始化
//		HashMap<String,UserData> map = readUserMap();
//		Collection<UserData> collection = map.values();
//		Iterator<UserData> it = collection.iterator();
//		//如果数据中有用户，使用第一个用户的时间，跟当前时间比较，如果没有读取到，则使用当前时间。
//		if (it.hasNext()) {
//			//有用户，下一步判断时间月份
//			if (it.next().getRecord().getMonth()!=t1.get(Calendar.MONTH)+1) {
//				while(it.hasNext()){
//					UserData userData = it.next();
////					每次登陆判断，如果不是新用户，月初生成一个月账单并放入数组中
//					if(userData.getRecord().getMonth()!=0&&userData.getRecord().getMonth()!=t1.get(Calendar.MONTH)+1){
//						userData.setAllTimes(0);//通话总时长
//						userData.setAllDuanxin(0);//累积短信条数
//						userData.setAllLiuliang(0);//累积流量 MB
//						userData.setAllBalances(0);//累积话费
//						userData.setMonthDetails(new MonthDetails(userData.getAllTimes(),userData.getDuanxin(),userData.getLiuliang(),userData.getBalances()));
//						userData.getArrMonthDetails()[userData.getRecord().getMonth()-1] = userData.getMonthDetails();
//						resetUserData(userData);//月初初始化用户数据
//						userData.setRecord(new Record(null,null,t1.get(Calendar.MONTH)+1));//单次通话记录
//						userData.setrecordList(new ArrayList<Record>());//新的月详单
//						double huafei = userData.getBalances()-userData.getType().getPrice();
//						if(huafei>0){
//							resetType(userData);//月初，初始化套餐余量
//							userData.setBalances(userData.getBalances()-userData.getType().getPrice());//扣除月套餐费后的余额-----------待修改-----
//						}
//						else{
//							System.out.println("余额不足");//----------------------------------
//						}
//					}
//				}
//			}
//		}
//		writeUserMap(map);//修改后保存
	}
//	登陆
	public void menu(UserData userData) throws IOException, ClassNotFoundException{//登陆
		Scanner input = new Scanner(System.in);
		System.out.println("**********用户菜单**********");
		System.out.println("1.月账单查询");
		System.out.println("2.套餐余量查询");
		System.out.println("3.打印消费记录");
		System.out.println("4.套餐变更");
		System.out.println("5.办理退网");
		System.out.println("6.showAll");
		System.out.println("7.showMonth");
		System.out.println("8.iteratorAllUser");
		System.out.println("9.进入使用功能");
		System.out.println("请选择服务：输入1-5，其它数字返回上一级");
		int num = input.nextInt();
		String str;
		switch(num){
		case 1://指定月账单查询
			userData.showMonthList();
			System.out.println("是否继续业务办理或查询:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 2://套餐余量查询
			userData.showtaocanlist();
			System.out.println("是否继续业务办理或查询:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 3://打印指定月份的消费清单，即消费记录
			userData.showRecoredMap();
			System.out.println("是否继续业务办理或查询:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 4://套餐变更
			changeType(userData);
			writeUser(userData.getTel(),userData);
			System.out.println("是否继续业务办理或查询:y/n");
			str = input.next();
			if(str.equals("y")){
				menu(userData);
			}
			else{
				exit();
			}
			break;
		case 5://办理退网
			delTel(login());
			System.out.println("是否继续业务办理或查询:y/n");
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
			System.out.println("是否继续业务办理或查询:y/n");
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
			System.out.println("是否继续业务办理或查询:y/n");
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
			System.out.println("是否继续业务办理或查询:y/n");
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
//	注册
	public void register() throws IOException, ClassNotFoundException{//注册用户
		Scanner input = new Scanner(System.in);
		String[] array = new String[9];
		Arrays.fill(array, " ");//填充数组的null空元素引用。
		for (int i = 0; i < array.length; i++) {
			//Math.random()无穷小到1，
			//随机11位1开头的手机号码
			String telnew = ""+((long)((Math.random()*9000000000L)+10000000000L));
			if (readUser(telnew)==null) {//随机的号码没有被注册。
				boolean flag = true;
				for (int j = 0; j < array.length; j++) {
					if (array[j].equals(telnew)) {//验证随机的号码没有在临时列表中重复
						flag = false;
						--i;
						break;
					}
				}
				if(flag){
					array[i] = telnew;
					System.out.print(telnew+"\t");
					if ((i+1)%3==0) {//每输出三个就换行
						System.out.println();
					}
				}
			}
			else{
				--i;//
			}
		}
		System.out.print("请输入手机号：");
		String tel = input.next();//从列表中显示的号码中选一个注册
		if(readUser(tel)!=null){
			System.out.println("对不起，你注册的号码已经存在，请重新注册。");
			register();
			//---------------------------返回注册
		}
		else{
			System.out.print("请输入密码：");
			String password = input.next();
			state();//显示套餐介绍
//			Type[] arrType = readArrType();//---------------------------
//			HashMap<String,Type> map = readTypeMap();
//			for (int i = 0; i < arrType.length; i++) {
//				System.out.print((i+1)+"."+arrType[i].getName()+"\t");
//			}
			System.out.println();
			System.out.print("请选择你的套餐类型：");
			Type type = typeList.get(input.nextInt()-1);
//			Type type = arrType[input.nextInt()-1];		
			UserData userData = new UserData(tel,password,type);//注意不要写反了,初始化新用户的免费电话、短信、流量
			//办卡时充值,并扣除套餐费，算出余额。
			double money = 0;
			double list = 0;
			do{
				System.out.print("请输入充值金额：");
				money = input.nextInt();
				list = money-type.getPrice();
				if(list<0){
					System.out.println("充值金额不足，请重新充值");
				}
			}while(list<0);
			userData.setBalances(list);
			System.out.println("你充值了"+money+"元话费。余额："+list);
			
//			新用户充值后，扣除套餐费
			userData.setBalances(money-userData.getType().getPrice());
			System.out.print("是否继续完善用户信息？y/n");
			if(input.next().equals("y")){
				System.out.print("请输入你的姓名：");
				userData.setName(input.next());
				System.out.println("注册完成！");
			}
			else{
				System.out.println("注册完成！");
			}
			writeUser(tel,userData);
			//进入服务页面，或者返回主页面登陆-------------------
			start();//---------------------------------待补充修改
		}	
	}
	
//	4.套餐变更
	public void changeType(UserData userData) throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		state();//显示套餐介绍
//		HashMap<String,Type> type = readTypeMap();
//		Set<String> set = type.keySet();
//		Iterator<String> it = set.iterator();
//		String str = "序号\t套餐类型\t通话时长\t上网流量\t短信条数\t资费";
//		System.out.println(str);
//		int cnt = 0;
//		while(it.hasNext()){
//			String typeName = it.next();
//			System.out.print(++cnt+"\t");
//			System.out.println(type.get(typeName));
//		}
		System.out.println("请输入你想要变更的套餐，下月生效");
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
//	5.退网
	public void delTel(UserData userData) throws IOException, ClassNotFoundException{//办理退网二
		HashMap<String,UserData> map = readUserMap();
		map.remove(userData.getTel());
		System.out.println("退网成功！");
		writeUserMap(map);	
	}
//	充值
	public void pay(UserData userData) throws IOException, ClassNotFoundException{
		userData.pay();
		writeUser(userData.getTel(),userData);
	}	
//	使用嗖嗖服务，打电话，发短信，上网，查询
	public void useSys(UserData userData) throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
//		int num = (int)(Math.random()*6+1);
		System.out.println("1打电话");
		System.out.println("2发短信");
		System.out.println("3上网");
		System.out.println("4累积消费");
		System.out.println("5余量");
		System.out.println("6.showAll");
		System.out.println("7.showMonth");
		System.out.println("8.进入业务查询");
		System.out.println("请输入数字1-6选择服务");
		int num = input.nextInt();
		String str;
		switch(num){
		case 1:
			//打电话
			userData.telStart();
			writeUser(userData.getTel(),userData);
			System.out.println("是否继续使用嗖嗖:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 2:
			//发短信
			userData.faDuangXin();
			writeUser(userData.getTel(),userData);
			System.out.println("是否继续使用嗖嗖:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 3:
			//上网
			userData.gprs();
			writeUser(userData.getTel(),userData);
			System.out.println("是否继续使用嗖嗖:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 4:
			//当月消费情况
			userData.showExpend();
			writeUser(userData.getTel(),userData);
			System.out.println("是否继续使用嗖嗖:y/n");
			str = input.next();
			if(str.equals("y")){
				useSys(userData);
			}
			else{
				exit();
			}
			break;
		case 5:
			//套餐余量
			userData.showtaocanlist();
			System.out.println("是否继续使用嗖嗖:y/n");
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
			System.out.println("是否继续使用嗖嗖:y/n");
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
			System.out.println("是否继续使用嗖嗖:y/n");
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
			System.out.println("运行错误");
			System.out.println("是否继续使用嗖嗖:y/n");
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
//	套餐介绍，资费说明
	public void state() throws IOException, ClassNotFoundException{
		String str = "序号\t套餐类型\t通话时长\t上网流量(G)\t短信条数\t资费";
		System.out.println(str);
		int cnt = 0;
		Iterator<Type> it = typeList.iterator();
		while(it.hasNext()){
			Type type = it.next();
			System.out.print(++cnt+"\t");
			System.out.println(type);
		}
//		String str = "套餐类型\t通话时长\t上网流量\t短信条数\t资费\t";
//		System.out.println(str);
//		HashMap<String,Type> map = readTypeMap();
//		//嵌套类
//		for (Map.Entry<String,Type> type:map.entrySet()) {
//			System.out.println(type.getValue());
//		}
	}
//	退出
	public void exit() throws IOException, ClassNotFoundException{//退出系统
		Scanner input = new Scanner(System.in);
		System.out.println("返回主菜单或退出程序：y/n");
		String str = input.next();
		if(str.equals("y")){
			start();
		}
		else{
			System.out.println("退出系统");
			System.exit(-1);
		}
	}
	
//	新用户或月初，初始化套餐余量,所以必需登陆用户或获取到用户对象才能调用用。
	public void resetType(UserData userData) throws IOException, ClassNotFoundException{
		userData.setTimes(userData.getType().getTimes());//剩余免费通话时长
		userData.setDuanXin(userData.getType().getCount());//剩余免费短信条数
		userData.setLiuLiang(userData.getType().getFlow());//剩余免费流量 MB
	}
	
//	只用于判断月初初始化老用户数据。含话费余额，因为有充值提示。可用于登陆后的重置
	public void resetUserData(UserData userData) throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
//		每次登陆判断，如果不是新用户，月初生成一个月账单并放入数组中
		int month = userData.getRecord().getMonth();
		if(month!=0&&month!=cd.get(Calendar.MONTH)+1){
			Test.getLog().debug("进入月初信息重置");
			//判断是否上月申请了套餐变更，如变更本月套餐类型改变
			if(userData.getTypeTemp()!=null){
				userData.setType(userData.getTypeTemp());
				userData.setTypeTemp(null);
			}
			userData.setAllTimes(0);//通话总时长
			userData.setAllDuanXin(0);//累积短信条数
			userData.setAllLiuLiang(0);//累积流量 MB
			userData.setAllBalances(0);//累积话费
//			userData.setMonthDetails(new MonthDetails(userData.getAllTimes(),userData.getAllDuanXin(),userData.getAllLiuLiang(),userData.getAllBalances()));
//			userData.getArrMonthDetails()[userData.getRecord().getMonth()-1] = userData.getMonthDetails();
			MonthDetails  monthDetails = new MonthDetails();
			userData.setMonthDetails(monthDetails);
			userData.getArrMonthDetails()[cd.get(Calendar.MONTH)] = userData.getMonthDetails();
			userData.setRecord(new Record(null,null,cd.get(Calendar.MONTH)+1));//单次通话记录
			userData.setRecordList(new ArrayList<Record>());//新的月详单
			resetType(userData);//月初，初始化套餐余量
			double huafei = userData.getBalances()-userData.getType().getPrice();
			userData.setBalances(huafei);
			if(huafei>0){
				userData.setBalances(userData.getBalances()-userData.getType().getPrice());//扣除月套餐费后的余额-----------待修改-----
			}
			else{
				System.out.println("您的手机余额不足"+huafei+"元,请充值:y/n");
				String str = input.next();
				if(str.equals("y")){
					userData.pay();
					resetType(userData);
				}
				else{
					System.out.println("余额不足");//----------------------------------
				}
			}
		}
		else{
			System.out.println("欢迎老客户");
		}
		writeUser(userData.getTel(),userData);//修改后保存
	}
	
//	遍历所有列表中的用户
	public void iteratorAllUser() throws IOException, ClassNotFoundException{
		HashMap<String,UserData> map = readUserMap();
		String str = "姓名\t手机号码\t套餐类型\t话费\t通话时长\t短信条数\t流量G";
		System.out.println(str);
		for(Map.Entry<String, UserData> userData:map.entrySet()){
			System.out.println(userData.getValue());
		}
//		while(it.hasNext()){
//			String userStr = it.next();//手机号码
//			User user = readUser(userStr);//用户对象
//			System.out.println(user.toString());
//		}
	}
	
//	清空用户列表数据
	public void clearUserMap() throws IOException, ClassNotFoundException{
		HashMap<String,UserData> map = readUserMap();
		map.clear();
		writeUserMap(map);
		iteratorAllUser();
	}
//	显示当前月总详单
	public void showAll(UserData userData){
		//显示用户当前所有数据和Sys中数组中的月记录
		System.out.println("用户名\t手机号\t密码\t套餐类型\t套餐通话\t套餐流量\t套餐短信\t套餐费");
		System.out.println(userData.getName()+"\t"+userData.getTel()+"\t"+userData.getPassword()+"\t"+userData.getType());
		System.out.println();
		System.out.println("余额\t免费通话时长\t免费短信条数\t免费流量 G");
		System.out.println(userData.getBalances()+"\t"+userData.getTimes()+"\t"+userData.getDuanxin()+"\t"+userData.getLiuliang());
		System.out.println();
		System.out.println("通话总时长\t累积短信条数\t累积流量 MB\t累积话费\t下月套餐类型");
		System.out.println(userData.getAllTimes()+"\t"+userData.getAllDuanXin()+"\t"+userData.getAllLiuLiang()+"\t"+userData.getAllBalances()+"\t"+userData.getTypeTemp());
		System.out.println();
		if(userData.getRecord().getValue()!=null){
			System.out.println("消费记录不为空");
			System.out.println("手机号\t消费记录\t单次消费时间");
			System.out.println(userData.getRecord().toString()+"\t"+userData.getRecord().getMonth());
		}
		else{
			System.out.println("消费记录为空");
		}
		System.out.println();
		if(!userData.getRecordList().isEmpty()){
			System.out.println("月消费记录详单不为空");
			Iterator<Record> it = userData.getRecordList().iterator();
			System.out.println("手机号\t消费内容\t单次消费时间");
			while(it.hasNext()){
				Record record = it.next();
				System.out.println(record.toString()+"\t"+record.getMonth());
			}
		}
		else{
			System.out.println("月消费记录详单为空");
		}
		System.out.println();
		if(userData.getArrRecord()[cd.get(Calendar.MONTH)+1-1]!=null){			
			System.out.println("数组中当前月消费记录不为空");
			ArrayList<Record> recordList = userData.getArrRecord()[cd.get(Calendar.MONTH)+1-1];
			Iterator<Record> itmonth = recordList.iterator();
			System.out.println("手机号\t消费内容\t单次消费时间");
			while(itmonth.hasNext()){
				Record record = itmonth.next();
				System.out.println(record.toString()+"\t"+record.getMonth());
			}
		}
		else{
			System.out.println("数组中当前月消费记录为空");
		}
		System.out.println();
		if(userData.getMonthDetails().getMonthBalances()!=0){
			System.out.println("当月累积消费不为空");	
			System.out.println("月累积通话\t月累积短信\t月累积流量\t月累积话费");
			System.out.println(userData.getMonthDetails());;
//		System.out.println(userData.getMonthDetails().getMonthBalances()+"\t"+userData.getMonthDetails().getMonthDuanxin()+"\t"+userData.getMonthDetails().getMonthLiuliang()+"\t"+userData.getMonthDetails().getMonthTimes());
		}
		else{
			System.out.println("当月累积消费为空");
		}
		System.out.println();
		if(userData.getArrMonthDetails()[cd.get(Calendar.MONTH)+1-1]!=null){
			System.out.println("数组中当月累积消费不为空");
			System.out.println("月累积通话时长\t月累积短信\t月累积流量\t月累积话费");
			System.out.println(userData.getArrMonthDetails()[cd.get(Calendar.MONTH)+1-1]);
		}
		else{
			System.out.println("数组中当月消费为空");
		}
		System.out.println();
	}
//	显示指定月总详单
	public void showMonth(UserData userData) throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要查询的月份总详单：");
		int month = input.nextInt();
		//显示用户当前所有数据和Sys中数组中的月记录
		System.out.println("用户名\t手机号\t密码\t套餐类型\t套餐通话\t套餐流量\t套餐短信\t套餐费");
		System.out.println(userData.getName()+"\t"+userData.getTel()+"\t"+userData.getPassword()+"\t"+userData.getType());
		System.out.println();
		if(userData.getArrRecord()[month-1]!=null){			
			System.out.println("数组中当前月消费记录不为空");
			ArrayList<Record> recordList = userData.getArrRecord()[month-1];
			Iterator<Record> itmonth = recordList.iterator();
			System.out.println("手机号\t消费内容\t单次消费时间");
			while(itmonth.hasNext()){
				Record record = itmonth.next();
				System.out.println(record.toString()+"\t"+record.getMonth());
			}
		}
		else{
			System.out.println("数组中当前月消费记录为空");
		}
		System.out.println();
		if(userData.getArrMonthDetails()[month-1]!=null){
			System.out.println("数组中当月累积消费不为空");
			System.out.println("月累积通话时长\t月累积短信\t月累积流量\t月累积话费");
			System.out.println(userData.getArrMonthDetails()[month-1]);
		}
		else{
			System.out.println("数组中当月消费为空");
		}
		System.out.println();
	}
	public UserData login() throws IOException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		boolean flag = false;
		UserData userData;
		int cnt = 5;//密码输入错误次数限制
		do {
			System.out.print("请输入手机号码：");
			String tel = input.next();
			System.out.print("请输入服务密码：");
			String password = input.next();
			userData = readUser(tel);
			boolean bl = userData != null && userData.getPassword().equals(password);
			if(bl){
				System.out.println("用户名和密码正确！");
//				每次登陆判断月初，则初始化用户数据；并判断是否欠费
				resetUserData(userData);//输入流关闭，不影响当前对象数据？-----------------------
				System.out.println("登陆成功!");
				flag = false;
				break;//不能少
				//进入查询页面-------------------------------------
			}
			else{
				cnt--;
				if(cnt>0){
					System.out.println("手机号或密码错误，请重新输入,你还有"+cnt+"次机会：");
					flag = true;
				}
				else{
					System.out.println("输错5次，禁止登陆！");
					//返回其它菜单-----------------------
					System.exit(-1);;
				}
			}
		} while (flag);	
		Test.getLog().debug("用户登陆成功");
		return userData;
	}
}
