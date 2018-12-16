package 第六章XML.DOM4J课堂.第6次课堂难点;

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
		System.out.println("---欢迎来到新闻管理系统---");
		Scanner input = new Scanner(System.in);
		try {
			while(true){
				System.out.println("1.新增新闻");
				System.out.println("2.查询新闻");
				System.out.println("3.修改新闻");
				System.out.println("4.删除新闻");
				System.out.println("5.退出系统");
				System.out.println("请选择：");
				String cnum1 = input.nextLine();
				if(cnum1.equals("1")){// 新增新闻
					insertNews();
				}
				else if(cnum1.equals("2")){// 查询新闻
				NewData select = new NewData();
				select.setType(Param.SELECT.toString());
				out.writeObject(select);
				out.flush();
				}
				else if(cnum1.equals("3")){// 修改新闻
					updateNews();
				}
				else if(cnum1.equals("4")){// 删除新闻
					deleteNews();
				}else{// 退出系统
					// 先发对象， 提醒服务端 退出 
					NewData nd = new NewData();
					nd.setType(Param.EXIT.toString());
					out.writeObject(nd);
					out.flush();
					System.out.println("----退出客户端。");
					// 后断循环   
					break;
				}
//				把增删改查的新闻输出，所以反馈过来的信息必须是从xml读取的新信息，
				Object robj = in.readObject();
				NewData rs = (NewData)robj;// 转型
				// 类型判断
				if(rs.getType().equals(Param.INSERT.toString())){// 新增
					if(rs.getFlag().equals(Param.SUCCESS.toString())){
						System.out.println("-----新增成功。");
					}else{
						System.out.println("-----新增失败！！");
					}
				}
				if(rs.getType().equals(Param.SELECT.toString())){// 查询
					List<NewData> list = rs.getList();
					System.out.println("----新闻信息如下：");
					for(NewData n:list){
						System.out.println(n);// 输出新闻
					}
				}
				else{
					for(NewData nd:rs.getList()){
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
	// 新增新闻 
	public void insertNews() throws IOException{
		Scanner input = new Scanner(System.in);
		NewData nd = new NewData();// 建对象
		System.out.println("请输入标题：");
		String title = input.nextLine();
		System.out.println("请输入作者：");
		String author = input.nextLine();
		System.out.println("请输入内容：");
		String content = input.nextLine();
		// 对象赋值
		nd.setTitle(title);
		nd.setAuthor(author);
		nd.setContent(content);
		// 设置 type
		nd.setType(Param.INSERT.toString());
		// 输出流
		out.writeObject(nd);
		out.flush();
//		out.close();//会报Socket错误
	}
//	删除新闻
	public void deleteNews() throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要删除的新闻标题：");
		String title = input.nextLine();
		NewData delete = new NewData();
		delete.setTitle(title);
		delete.setType(Param.DELETE.toString());
		out.writeObject(delete);
		out.flush();
	}
	public void updateNews() throws IOException{
		Scanner input = new Scanner(System.in);
		NewData update = new NewData();
		BufferedOutputStream fos = new BufferedOutputStream(os);
		System.out.println("请输入要修改的新闻标题：");
		String title1 = input.nextLine();
		update.setTitle(title1);
		update.setType(Param.UPDATE.toString());
		out.writeObject(update);
		out.flush();
		
		NewData update1 = new NewData();//当一个对象update被写入流之后，这个对象便不能再在客户端被修改，必须使用一个新对象update1
		System.out.println("请输入新的新闻标题：");
		String title2 = input.nextLine();
		System.out.println("请输入新的新闻作者：");
		String author = input.nextLine();
		System.out.println("请输入新的新闻内容：");
		String content = input.nextLine();
		update1.setTitle(title2);
		update1.setAuthor(author);
		update1.setContent(content);
		out.writeObject(update1);
		out.flush();
	}
}
