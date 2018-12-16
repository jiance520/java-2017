package XML_DOM4J��TCP��ɾ�Ĳ����;

import java.io.*;
import java.net.*;
import java.util.*;

import org.dom4j.*;
//client �ͻ��� 
/*
 * ʹ�� socket �� dom4j ��д 1 �� C/S �ܹ��� �ֿ����ϵͳ(warehouse)
1.	Ҫ��ʹ�� xml �ļ� �Բ�Ʒ(product)���д洢:
��ţ�id�������ƣ�name�����������ڣ�factory Date������ϸ���ܣ�introduction��
Xml �ļ��Ľṹ���£�
<?xml version="1.0" encoding="UTF-8"?>

<products>
<product>
		<id>1</id>
		<name>ƻ��</name>
		<factoryDate>2017-05-04</factoryDate>
		<introduction>�ó�</introduction>
	 </product>
</products>

2.	ʵ�ֲ�Ʒչʾ�Ĺ��ܣ�Ҫ������ʾ�ֿ������еĲ�Ʒ��

3.	ʵ�� ��Ʒ ���(���浽xml) �� ����(��xml��ɾ��,��id�ж�) �Ĺ��ܡ�

4.	Ҫ����Զ�����Ĳ�Ʒ�����޸�(��id���޸�name,factoryDate,introduction)

 * */
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
	private File ff = new File("products.xml");//ָ����д��xml
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
				Product rs = (Product)robj;
				if(rs.getType().equals(Param.EXIT.toString())){
					System.out.println("������˳�");
					break;
				}
				if(rs.getType().equals(Param.INSERT.toString())){
					System.out.println("����");
					Document doc = tools.read(ff);
//					���ò���Ĳ�Ʒ���󣬲���ӵ�doc�ļ��ڵ���
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
//					�������˽ڵ�����doc��Ϊxml�ļ�
					tools.write(ff, doc);//docҪ������ļ���ff���·��
					Product td = new Product();
						td.setType(Param.INSERT.toString());
						td.setFlag(Param.SUCCESS.toString());
//					�Ѹ��º��doc��xml��Ϣ��ͨ��������������ͻ��ˡ�
					out.writeObject(td);
					out.flush();
				}
//				������տͻ��˵�����Ϣ�ǲ�ѯ
				if(rs.getType().equals(Param.SELECT.toString())){
					Product select = new Product();
						select.setType(Param.SELECT.toString());
//						��ǲ�ѯ�ɹ�
					select.setFlag(Param.SUCCESS.toString());
					select.setList(productList());
//					д����
					out.writeObject(select);
					out.flush();
				}
//				������տͻ��˳������Ϣ
				if(rs.getType().equals(Param.DELETE.toString())){
					Document doc = tools.read(ff);
					Product delete = new Product();//д��Ķ��󣬶�ȡ�Ķ�����rs��
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
						System.out.println("����ɹ�������Ĳ�Ʒ�ǣ�"+rs.getName());
					}
					else{
						delete.setFlag(Param.FAIL.toString());
						System.out.println("����ʧ��");
					}
					delete.setList(productList());
					out.writeObject(delete);
					out.flush();
				}
//				������޸Ĳ�Ʒ
				if(rs.getType().equals(Param.UPDATE.toString())){
					System.out.println("��ʼ����");
					Document doc = tools.read(ff);
					Product update = new Product();//�������ظ��ͻ���
					update.setType(Param.UPDATE.toString());
					List<Node> list = doc.selectNodes("//id");
					for(Node n:list){
						Element element = (Element)n;
						if(element.getTextTrim().equals(rs.getId())){//��idԪ�ؼ����ҵ�Ҫ�޸ĵ�idԪ��
							Element element1 = element.getParent();//�ҵ����ڵ㣬��ƻ��
							List<Node> list1 = element1.elements();//ͨ�����ڵ��ȡ�����ӽڵ㣬id,���ƣ����ܣ���������
							for(Node n1:list1){
								Element element2 = (Element)n1;
								if(element2.getName().equals("id")){//���id�ڵ��id
									element2.setText(rs.getId()) ;
								}
								if(element2.getName().equals("name")){//������ƽڵ��������
									element2.setText(rs.getName()) ;
								}
								if(element2.getName().equals("introduction")){//������ܽڵ���½���
									element2.setText(rs.getIntroduction());
								}
								if(element2.getName().equals("factoryDate")){//����������ڽڵ������������
									element2.setText(rs.getFactoryDate());
									
								}
							}
							update.setFlag(Param.SUCCESS.toString());
							tools.write(ff, doc);
							System.out.println("�޸ĳɹ����޸ĵĲ�Ʒ�ǣ�"+rs.getName());
						}
						else{
							System.out.println("û���ҵ�Ҫ�޸ĵĲ�Ʒid");
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
//	��xml�ļ��ж�ȡ���µ��ļ��������ͻ������
	public ArrayList<Product> productList(){
		Document doc = tools.read(ff);
		ArrayList<Product> arrayList = new ArrayList<Product>();
		if(doc!=null){
			List<Node> nlist = doc.selectNodes("//product");
			for(Node n:nlist){
				Product t1 = new Product();
				Element e = (Element)n;
				List<Element> clist = e.elements();
				//����ż���
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
