package ������XML.DOM4J����.��6�ο����ѵ�;

import java.io.*;
import java.net.*;
import java.util.*;

import org.dom4j.*;
//client �ͻ��� 
public class ServerSys {
	private ServerSocket ss;// ͨ�Ŷ���
	// ��д
	private Socket st;
	private InputStream is;
	// ���
	private ObjectInputStream in;
	private OutputStream os;
	private ObjectOutputStream out;
	private XmlTools tools = new XmlTools();//��дxml�ķ���
	private File ff = new File("news.xml");//ָ����д��xml
	public ServerSys(){
		try {
			ss = new ServerSocket(9999);// ��Ӧ������
			System.out.println("----�������----");
			// ������ �����
			st = ss.accept();
			os = st.getOutputStream();
			out = new ObjectOutputStream(os);
			// ������������
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
					System.out.println("������˳�");
					break;
				}
				if(rs.getType().equals(Param.INSERT.toString())){
					System.out.println("����");
					Document doc = tools.read(ff);
//					���ò�������Ŷ��󣬲���ӵ�doc�ļ��ڵ���
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
//					�������˽ڵ�����doc��Ϊxml�ļ�
					tools.write(ff, doc);//docҪ������ļ���ff���·��
					NewData td = new NewData();
						td.setType(Param.INSERT.toString());
						td.setFlag(Param.SUCCESS.toString());
//					�Ѹ��º��doc��xml��Ϣ��ͨ��������������ͻ��ˡ�
					out.writeObject(td);
					out.flush();
				}
//				������տͻ��˵�����Ϣ�ǲ�ѯ
				if(rs.getType().equals(Param.SELECT.toString())){
					NewData select = new NewData();
						select.setType(Param.SELECT.toString());
//						��ǲ�ѯ�ɹ�
					select.setFlag(Param.SUCCESS.toString());
					select.setList(newDataList());
//					д����
					out.writeObject(select);
					out.flush();
				}
//				������տͻ���ɾ������Ϣ
				if(rs.getType().equals(Param.DELETE.toString())){
					Document doc = tools.read(ff);
					NewData delete = new NewData();//д��Ķ��󣬶�ȡ�Ķ�����rs��
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
						System.out.println("ɾ���ɹ���ɾ���������ǣ�"+rs.getTitle());
					}
					else{
						delete.setFlag(Param.FAIL.toString());
						System.out.println("ɾ��ʧ��");
					}
					delete.setList(newDataList());
					out.writeObject(delete);
					out.flush();
				}
//				������޸�����
				if(rs.getType().equals(Param.UPDATE.toString())){
					System.out.println("��ʼ����");
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
							System.out.println("�޸ĳɹ����޸ĵ������ǣ�"+rs.getTitle());
						}
						else{
							System.out.println("û���ҵ�Ҫ�޸ĵ����ű���");
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
//	��xml�ļ��ж�ȡ���µ��ļ��������ͻ������
	public ArrayList<NewData> newDataList(){
		Document doc = tools.read(ff);
		ArrayList<NewData> arrayList = new ArrayList<NewData>();
		if(doc!=null){
			List<Node> nlist = doc.selectNodes("//newsinfo");
			for(Node n:nlist){
				NewData t1 = new NewData();
				Element e = (Element)n;
				List<Element> clist = e.elements();
				//����ż���
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
