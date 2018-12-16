package XML_DOM4J及TCP增删改查测试;

import java.io.*;
import java.net.*;
import java.util.*;

import org.dom4j.*;
//client 客户端 
/*
 * 使用 socket 和 dom4j 编写 1 个 C/S 架构的 仓库管理系统(warehouse)
1.	要求使用 xml 文件 对产品(product)进行存储:
编号（id），名称（name），出厂日期（factory Date），详细介绍（introduction）
Xml 文件的结构如下：
<?xml version="1.0" encoding="UTF-8"?>

<products>
<product>
		<id>1</id>
		<name>苹果</name>
		<factoryDate>2017-05-04</factoryDate>
		<introduction>好吃</introduction>
	 </product>
</products>

2.	实现产品展示的功能，要求能显示仓库中所有的产品。

3.	实现 产品 入库(保存到xml) 和 出库(从xml中删除,按id判断) 的功能。

4.	要求可以对入库后的产品进行修改(按id来修改name,factoryDate,introduction)

 * */
public class ServerSys {
	private ServerSocket ss;// 通信对象
	// 先写
	private Socket st;
	private InputStream is;
	// 后读
	private ObjectInputStream in;
	private OutputStream os;
	private ObjectOutputStream out;
	private XmlTools tools = new XmlTools();//读写xml的方法
	private File ff = new File("products.xml");//指定读写的xml
	public ServerSys(){
		try {
			ss = new ServerSocket(9999);// 对应服务器
			System.out.println("----服务端起动----");
			// 先生成 输出流
			st = ss.accept();
			os = st.getOutputStream();
			out = new ObjectOutputStream(os);
			// 后生成输入流
			is = st.getInputStream();
			in = new ObjectInputStream(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void start(){
		try {
			while(true){
				Object robj = in.readObject();
				Product rs = (Product)robj;
				if(rs.getType().equals(Param.EXIT.toString())){
					System.out.println("服务端退出");
					break;
				}
				if(rs.getType().equals(Param.INSERT.toString())){
					System.out.println("新增");
					Document doc = tools.read(ff);
//					设置插入的产品对象，并添加到doc文件节点中
					if(doc == null){
						doc = DocumentHelper.createDocument();
						Element root = doc.addElement("products");
						Element new1 = root.addElement("product");
						Element id = new1.addElement("id");
							id.setText(rs.getId());
						Element name = new1.addElement("name");
							name.setText(rs.getName());
						Element introduction = new1.addElement("introduction");
							introduction.setText(rs.getIntroduction());
						Element factoryDate = new1.addElement("factoryDate");
							factoryDate.setText(rs.getFactoryDate());
					}
					else{
						Node nd = doc.selectSingleNode("//product");
						Element root = (Element)nd;
						Element new1 = root.addElement("product");

						Element id = new1.addElement("id");
							id.setText(rs.getId());
						Element name = new1.addElement("name");
							name.setText(rs.getName());
						Element introduction = new1.addElement("introduction");
							introduction.setText(rs.getIntroduction());
						Element factoryDate = new1.addElement("factoryDate");
							factoryDate.setText(rs.getFactoryDate());
					}
//					把新增了节点对象的doc存为xml文件
					tools.write(ff, doc);//doc要存入的文件，ff存放路径
					Product td = new Product();
						td.setType(Param.INSERT.toString());
						td.setFlag(Param.SUCCESS.toString());
//					把更新后的doc或xml信息，通过输出流反馈给客户端。
					out.writeObject(td);
					out.flush();
				}
//				如果接收客户端的流信息是查询
				if(rs.getType().equals(Param.SELECT.toString())){
					Product select = new Product();
						select.setType(Param.SELECT.toString());
//						标记查询成功
					select.setFlag(Param.SUCCESS.toString());
					select.setList(productList());
//					写对象
					out.writeObject(select);
					out.flush();
				}
//				如果接收客户端出库的信息
				if(rs.getType().equals(Param.DELETE.toString())){
					Document doc = tools.read(ff);
					Product delete = new Product();//写入的对象，读取的对象是rs，
					delete.setType(Param.DELETE.toString());
					List<Node> list = doc.selectNodes("//id");
					for(Node n:list){
						Element element = (Element)n;
						if(element.getTextTrim().equals(rs.getId())){
							element.getParent().getParent().remove(element.getParent());
							delete.setFlag(Param.SUCCESS.toString());
							tools.write(ff, doc);
						}
					}
					if(delete.getFlag().equals(Param.SUCCESS.toString())){
						System.out.println("出库成功，出库的产品是："+rs.getName());
					}
					else{
						delete.setFlag(Param.FAIL.toString());
						System.out.println("出库失败");
					}
					delete.setList(productList());
					out.writeObject(delete);
					out.flush();
				}
//				如果是修改产品
				if(rs.getType().equals(Param.UPDATE.toString())){
					System.out.println("开始更新");
					Document doc = tools.read(ff);
					Product update = new Product();//用来返回给客户端
					update.setType(Param.UPDATE.toString());
					List<Node> list = doc.selectNodes("//id");
					for(Node n:list){
						Element element = (Element)n;
						if(element.getTextTrim().equals(rs.getId())){//在id元素集中找到要修改的id元素
							Element element1 = element.getParent();//找到父节点，如苹果
							List<Node> list1 = element1.elements();//通过父节点获取所有子节点，id,名称，介绍，生产日期
							for(Node n1:list1){
								Element element2 = (Element)n1;
								if(element2.getName().equals("id")){//如果id节点改id
									element2.setText(rs.getId()) ;
								}
								if(element2.getName().equals("name")){//如果名称节点改新名称
									element2.setText(rs.getName()) ;
								}
								if(element2.getName().equals("introduction")){//如果介绍节点改新介绍
									element2.setText(rs.getIntroduction());
								}
								if(element2.getName().equals("factoryDate")){//如果生产日期节点改新生产日期
									element2.setText(rs.getFactoryDate());
									
								}
							}
							update.setFlag(Param.SUCCESS.toString());
							tools.write(ff, doc);
							System.out.println("修改成功，修改的产品是："+rs.getName());
						}
						else{
							System.out.println("没有找到要修改的产品id");
						}
					}
					update.setList(productList());
					out.writeObject(update);
					out.flush();
				}
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	从xml文件中读取最新的文件反馈给客户端输出
	public ArrayList<Product> productList(){
		Document doc = tools.read(ff);
		ArrayList<Product> arrayList = new ArrayList<Product>();
		if(doc!=null){
			List<Node> nlist = doc.selectNodes("//product");
			for(Node n:nlist){
				Product t1 = new Product();
				Element e = (Element)n;
				List<Element> clist = e.elements();
				//对象放集合
				for (Element e1:clist) {
					if(e1.getName().equals("id")){
						t1.setId(e1.getTextTrim());
					}
					if(e1.getName().equals("name")){
						t1.setName(e1.getTextTrim());
					}
					if(e1.getName().equals("introduction")){
						t1.setIntroduction(e1.getTextTrim());
					}
					if(e1.getName().equals("factoryDate")){
						t1.setFactoryDate(e1.getTextTrim());
					}
				}
				arrayList.add(t1);
			}
		}
		return arrayList;
	}
}
