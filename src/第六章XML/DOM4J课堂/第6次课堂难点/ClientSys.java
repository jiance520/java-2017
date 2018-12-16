package ������XML.DOM4J����.��6�ο����ѵ�;

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
		System.out.println("---��ӭ�������Ź���ϵͳ---");
		Scanner input = new Scanner(System.in);
		try {
			while(true){
				System.out.println("1.��������");
				System.out.println("2.��ѯ����");
				System.out.println("3.�޸�����");
				System.out.println("4.ɾ������");
				System.out.println("5.�˳�ϵͳ");
				System.out.println("��ѡ��");
				String cnum1 = input.nextLine();
				if(cnum1.equals("1")){// ��������
					insertNews();
				}
				else if(cnum1.equals("2")){// ��ѯ����
				NewData select = new NewData();
				select.setType(Param.SELECT.toString());
				out.writeObject(select);
				out.flush();
				}
				else if(cnum1.equals("3")){// �޸�����
					updateNews();
				}
				else if(cnum1.equals("4")){// ɾ������
					deleteNews();
				}else{// �˳�ϵͳ
					// �ȷ����� ���ѷ���� �˳� 
					NewData nd = new NewData();
					nd.setType(Param.EXIT.toString());
					out.writeObject(nd);
					out.flush();
					System.out.println("----�˳��ͻ��ˡ�");
					// ���ѭ��   
					break;
				}
//				����ɾ�Ĳ��������������Է�����������Ϣ�����Ǵ�xml��ȡ������Ϣ��
				Object robj = in.readObject();
				NewData rs = (NewData)robj;// ת��
				// �����ж�
				if(rs.getType().equals(Param.INSERT.toString())){// ����
					if(rs.getFlag().equals(Param.SUCCESS.toString())){
						System.out.println("-----�����ɹ���");
					}else{
						System.out.println("-----����ʧ�ܣ���");
					}
				}
				if(rs.getType().equals(Param.SELECT.toString())){// ��ѯ
					List<NewData> list = rs.getList();
					System.out.println("----������Ϣ���£�");
					for(NewData n:list){
						System.out.println(n);// �������
					}
				}
				else{
					for(NewData nd:rs.getList()){
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
	// �������� 
	public void insertNews() throws IOException{
		Scanner input = new Scanner(System.in);
		NewData nd = new NewData();// ������
		System.out.println("��������⣺");
		String title = input.nextLine();
		System.out.println("���������ߣ�");
		String author = input.nextLine();
		System.out.println("���������ݣ�");
		String content = input.nextLine();
		// ����ֵ
		nd.setTitle(title);
		nd.setAuthor(author);
		nd.setContent(content);
		// ���� type
		nd.setType(Param.INSERT.toString());
		// �����
		out.writeObject(nd);
		out.flush();
//		out.close();//�ᱨSocket����
	}
//	ɾ������
	public void deleteNews() throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫɾ�������ű��⣺");
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
		System.out.println("������Ҫ�޸ĵ����ű��⣺");
		String title1 = input.nextLine();
		update.setTitle(title1);
		update.setType(Param.UPDATE.toString());
		out.writeObject(update);
		out.flush();
		
		NewData update1 = new NewData();//��һ������update��д����֮���������㲻�����ڿͻ��˱��޸ģ�����ʹ��һ���¶���update1
		System.out.println("�������µ����ű��⣺");
		String title2 = input.nextLine();
		System.out.println("�������µ��������ߣ�");
		String author = input.nextLine();
		System.out.println("�������µ��������ݣ�");
		String content = input.nextLine();
		update1.setTitle(title2);
		update1.setAuthor(author);
		update1.setContent(content);
		out.writeObject(update1);
		out.flush();
	}
}
