package XML_DOM4J及TCP增删改查测试;

import java.util.*;
import java.net.*;
import java.io.*;
//client 客户端 
public class ClientSys {
	private Socket st;// 通信对象
	// 先写
	private OutputStream os;
	private ObjectOutputStream out;
	// 后读
	private InputStream is;
	private ObjectInputStream in;
	public ClientSys(){
		try {
			st = new Socket("127.0.0.1",9999);// 对应服务器
			System.out.println("----客服端起动----");
			// 先生成 输出流
			os = st.getOutputStream();
			out = new ObjectOutputStream(os);
			// 后生成输入流
			is = st.getInputStream();
			in = new ObjectInputStream(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 启动的 方法 
	public void start(){
		System.out.println("---欢迎来到产品管理系统---");
		Scanner input = new Scanner(System.in);
		try {
			while(true){
				System.out.println("1.入库产品");
				System.out.println("2.查询产品");
				System.out.println("3.修改产品");
				System.out.println("4.出库产品");
				System.out.println("5.退出系统");
				System.out.println("请选择：");
				String cnum1 = input.nextLine();
				if(cnum1.equals("1")){// 入库
					insertProduct();
				}
				else if(cnum1.equals("2")){// 查询
				Product select = new Product();
				select.setType(Param.SELECT.toString());
				out.writeObject(select);
				out.flush();
				}
				else if(cnum1.equals("3")){// 修改
					updateProduct();
				}
				else if(cnum1.equals("4")){// 出库
					deleteProduct();
				}else{// 退出系统
					// 先发对象， 提醒服务端 退出 
					Product nd = new Product();
					nd.setType(Param.EXIT.toString());
					out.writeObject(nd);
					out.flush();
					System.out.println("----退出客户端。");
					// 后断循环   
					break;
				}
//				把增删改查的输出，
				Object robj = in.readObject();
				Product rs = (Product)robj;// 转型
				// 类型判断
				if(rs.getType().equals(Param.INSERT.toString())){// 入库
					if(rs.getFlag().equals(Param.SUCCESS.toString())){
						System.out.println("-----入库成功。");
					}else{
						System.out.println("-----入库失败！！");
					}
				}
				if(rs.getType().equals(Param.SELECT.toString())){// 查询
					List<Product> list = rs.getList();
					System.out.println("----产品信息如下：");
					for(Product n:list){
						System.out.println(n);// 输出
					}
				}
				else{
					for(Product nd:rs.getList()){
						System.out.println(nd);
					}
				}
			}
			// 关闭流
			out.close();
			in.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 入库产品 
	public void insertProduct() throws IOException{
		Scanner input = new Scanner(System.in);
		Product pd = new Product();// 建对象
		System.out.print("请输入产品id：");
		String id = input.nextLine();
		System.out.print("请输入产品名称：");
		String name = input.nextLine();
		System.out.print("请输入产品介绍：");
		String introduction = input.nextLine();
		System.out.println("请输入生产日期:");
		String factoryDate = input.nextLine();
		// 对象赋值
		pd.setId(id);
		pd.setName(name);
		pd.setIntroduction(introduction);
		pd.setFactoryDate(factoryDate);
		// 设置 type
		pd.setType(Param.INSERT.toString());
		// 输出流
		out.writeObject(pd);
		out.flush();
//		out.close();//会报Socket错误
	}
//	出库
	public void deleteProduct() throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要出库的产品id：");
		String id = input.nextLine();
		Product delete = new Product();
		delete.setId(id);
		delete.setType(Param.DELETE.toString());
		out.writeObject(delete);
		out.flush();
	}
	public void updateProduct() throws IOException{
		Scanner input = new Scanner(System.in);
		Product update = new Product();//当一个对象update被写入流之后，这个对象便不能再在客户端被修改，
		update.setType(Param.UPDATE.toString());
		System.out.println("请输入要修改的产品id：");
		String id = input.nextLine();
		update.setId(id);
//		System.out.println("请输入产品id：");
//		String id2 = input.nextLine();
		System.out.print("请输入新的产品名称：");
		String name = input.nextLine();
		System.out.print("请输入新的新产品介绍：");
		String introduction = input.nextLine();
		System.out.println("请输入新的生产日期:");
		String factoryDate = input.nextLine();
		update.setName(name);
		update.setIntroduction(introduction);
		update.setFactoryDate(factoryDate);
		out.writeObject(update);
		out.flush();
	}
}
