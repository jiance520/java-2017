package 第六章XML.DOM4J课堂.第6次课堂难点;

import java.io.*;
import java.net.*;
import java.util.*;

import org.dom4j.*;
//client 客户端 
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
	private File ff = new File("news.xml");//指定读写的xml
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
				NewData rs = (NewData)robj;
				if(rs.getType().equals(Param.EXIT.toString())){
					System.out.println("服务端退出");
					break;
				}
				if(rs.getType().equals(Param.INSERT.toString())){
					System.out.println("新增");
					Document doc = tools.read(ff);
//					设置插入的新闻对象，并添加到doc文件节点中
					if(doc == null){
						doc = DocumentHelper.createDocument();
						Element root = doc.addElement("news");
						Element new1 = root.addElement("newsinfo");
						Element title = new1.addElement("title");
							title.setText(rs.getTitle());
						Element author = new1.addElement("author");
							author.setText(rs.getAuthor());
						Element content = new1.addElement("content");
							content.setText(rs.getContent());
					}
					else{
						Node nd = doc.selectSingleNode("//news");
						Element root = (Element)nd;
						Element new1 = root.addElement("newsinfo");

						Element title = new1.addElement("title");
							title.setText(rs.getTitle());
						Element author = new1.addElement("author");
							author.setText(rs.getAuthor());
						Element content = new1.addElement("content");
							content.setText(rs.getContent());
					}
//					把新增了节点对象的doc存为xml文件
					tools.write(ff, doc);//doc要存入的文件，ff存放路径
					NewData td = new NewData();
						td.setType(Param.INSERT.toString());
						td.setFlag(Param.SUCCESS.toString());
//					把更新后的doc或xml信息，通过输出流反馈给客户端。
					out.writeObject(td);
					out.flush();
				}
//				如果接收客户端的流信息是查询
				if(rs.getType().equals(Param.SELECT.toString())){
					NewData select = new NewData();
						select.setType(Param.SELECT.toString());
//						标记查询成功
					select.setFlag(Param.SUCCESS.toString());
					select.setList(newDataList());
//					写对象
					out.writeObject(select);
					out.flush();
				}
//				如果接收客户端删除的信息
				if(rs.getType().equals(Param.DELETE.toString())){
					Document doc = tools.read(ff);
					NewData delete = new NewData();//写入的对象，读取的对象是rs，
					delete.setType(Param.DELETE.toString());
					List<Node> list = doc.selectNodes("//title");
					for(Node n:list){
						Element element = (Element)n;
						if(element.getTextTrim().equals(rs.getTitle())){
							element.getParent().getParent().remove(element.getParent());
							delete.setFlag(Param.SUCCESS.toString());
							tools.write(ff, doc);
						}
					}
					if(delete.getFlag().equals(Param.SUCCESS.toString())){
						System.out.println("删除成功，删除的新闻是："+rs.getTitle());
					}
					else{
						delete.setFlag(Param.FAIL.toString());
						System.out.println("删除失败");
					}
					delete.setList(newDataList());
					out.writeObject(delete);
					out.flush();
				}
//				如果是修改新闻
				if(rs.getType().equals(Param.UPDATE.toString())){
					System.out.println("开始更新");
					BufferedInputStream dis = new BufferedInputStream(is);
					Scanner input = new Scanner(System.in);
					Document doc = tools.read(ff);
					NewData update = new NewData();
					update.setType(Param.UPDATE.toString());
					List<Node> list = doc.selectNodes("//title");
					for(Node n:list){
						Element element = (Element)n;
						if(element.getTextTrim().equals(rs.getTitle())){
							robj = in.readObject();
							rs = (NewData)robj;
							Element element1 = element.getParent();
							List<Node> list1 = element1.elements();
							for(Node n1:list1){
								Element element2 = (Element)n1;
								if(element2.getName().equals("title")){
									element2.setText(rs.getTitle()) ;
								}
								if(element2.getName().equals("author")){
									element2.setText(rs.getAuthor()) ;
								}
								if(element2.getName().equals("content")){
									element2.setText(rs.getContent());
								}								
							}
							update.setFlag(Param.SUCCESS.toString());
							tools.write(ff, doc);
							System.out.println("修改成功，修改的新闻是："+rs.getTitle());
						}
						else{
							System.out.println("没有找到要修改的新闻标题");
						}
					}
					update.setList(newDataList());
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
	public ArrayList<NewData> newDataList(){
		Document doc = tools.read(ff);
		ArrayList<NewData> arrayList = new ArrayList<NewData>();
		if(doc!=null){
			List<Node> nlist = doc.selectNodes("//newsinfo");
			for(Node n:nlist){
				NewData t1 = new NewData();
				Element e = (Element)n;
				List<Element> clist = e.elements();
				//对象放集合
				for (Element e1:clist) {
					if(e1.getName().equals("title")){
						t1.setTitle(e1.getTextTrim());
					}
					if(e1.getName().equals("author")){
						t1.setAuthor(e1.getTextTrim());
					}
					if(e1.getName().equals("content")){
						t1.setContent(e1.getTextTrim());
					}
				}
				arrayList.add(t1);
			}
		}
		return arrayList;
	}
}
