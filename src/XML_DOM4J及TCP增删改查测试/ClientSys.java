package XML_DOM4J��TCP��ɾ�Ĳ����;

import java.util.*;
import java.net.*;
import java.io.*;
//client �ͻ��� 
public class ClientSys {
	private Socket st;// ͨ�Ŷ���
	// ��д
	private OutputStream os;
	private ObjectOutputStream out;
	// ���
	private InputStream is;
	private ObjectInputStream in;
	public ClientSys(){
		try {
			st = new Socket("127.0.0.1",9999);// ��Ӧ������
			System.out.println("----�ͷ�����----");
			// ������ �����
			os = st.getOutputStream();
			out = new ObjectOutputStream(os);
			// ������������
			is = st.getInputStream();
			in = new ObjectInputStream(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ������ ���� 
	public void start(){
		System.out.println("---��ӭ������Ʒ����ϵͳ---");
		Scanner input = new Scanner(System.in);
		try {
			while(true){
				System.out.println("1.����Ʒ");
				System.out.println("2.��ѯ��Ʒ");
				System.out.println("3.�޸Ĳ�Ʒ");
				System.out.println("4.�����Ʒ");
				System.out.println("5.�˳�ϵͳ");
				System.out.println("��ѡ��");
				String cnum1 = input.nextLine();
				if(cnum1.equals("1")){// ���
					insertProduct();
				}
				else if(cnum1.equals("2")){// ��ѯ
				Product select = new Product();
				select.setType(Param.SELECT.toString());
				out.writeObject(select);
				out.flush();
				}
				else if(cnum1.equals("3")){// �޸�
					updateProduct();
				}
				else if(cnum1.equals("4")){// ����
					deleteProduct();
				}else{// �˳�ϵͳ
					// �ȷ����� ���ѷ���� �˳� 
					Product nd = new Product();
					nd.setType(Param.EXIT.toString());
					out.writeObject(nd);
					out.flush();
					System.out.println("----�˳��ͻ��ˡ�");
					// ���ѭ��   
					break;
				}
//				����ɾ�Ĳ�������
				Object robj = in.readObject();
				Product rs = (Product)robj;// ת��
				// �����ж�
				if(rs.getType().equals(Param.INSERT.toString())){// ���
					if(rs.getFlag().equals(Param.SUCCESS.toString())){
						System.out.println("-----���ɹ���");
					}else{
						System.out.println("-----���ʧ�ܣ���");
					}
				}
				if(rs.getType().equals(Param.SELECT.toString())){// ��ѯ
					List<Product> list = rs.getList();
					System.out.println("----��Ʒ��Ϣ���£�");
					for(Product n:list){
						System.out.println(n);// ���
					}
				}
				else{
					for(Product nd:rs.getList()){
						System.out.println(nd);
					}
				}
			}
			// �ر���
			out.close();
			in.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ����Ʒ 
	public void insertProduct() throws IOException{
		Scanner input = new Scanner(System.in);
		Product pd = new Product();// ������
		System.out.print("�������Ʒid��");
		String id = input.nextLine();
		System.out.print("�������Ʒ���ƣ�");
		String name = input.nextLine();
		System.out.print("�������Ʒ���ܣ�");
		String introduction = input.nextLine();
		System.out.println("��������������:");
		String factoryDate = input.nextLine();
		// ����ֵ
		pd.setId(id);
		pd.setName(name);
		pd.setIntroduction(introduction);
		pd.setFactoryDate(factoryDate);
		// ���� type
		pd.setType(Param.INSERT.toString());
		// �����
		out.writeObject(pd);
		out.flush();
//		out.close();//�ᱨSocket����
	}
//	����
	public void deleteProduct() throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ����Ĳ�Ʒid��");
		String id = input.nextLine();
		Product delete = new Product();
		delete.setId(id);
		delete.setType(Param.DELETE.toString());
		out.writeObject(delete);
		out.flush();
	}
	public void updateProduct() throws IOException{
		Scanner input = new Scanner(System.in);
		Product update = new Product();//��һ������update��д����֮���������㲻�����ڿͻ��˱��޸ģ�
		update.setType(Param.UPDATE.toString());
		System.out.println("������Ҫ�޸ĵĲ�Ʒid��");
		String id = input.nextLine();
		update.setId(id);
//		System.out.println("�������Ʒid��");
//		String id2 = input.nextLine();
		System.out.print("�������µĲ�Ʒ���ƣ�");
		String name = input.nextLine();
		System.out.print("�������µ��²�Ʒ���ܣ�");
		String introduction = input.nextLine();
		System.out.println("�������µ���������:");
		String factoryDate = input.nextLine();
		update.setName(name);
		update.setIntroduction(introduction);
		update.setFactoryDate(factoryDate);
		out.writeObject(update);
		out.flush();
	}
}
