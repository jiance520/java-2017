package XML_DOM4J��TCP��ɾ�Ĳ����;

import java.io.*;
import java.util.*;
public class Product implements Serializable{
	private String id;
	private String name;
	private String factoryDate;
	private String introduction;
	private String flag;// ��ʾ �ɹ� �� ʧ��
	private String type;// ��ʾ ���������� �� ���� �� ��ѯ �� �޸� ��ɾ�� ,�˳� 
	private List<Product> list = new ArrayList<Product>();//���xml���µ���Ϣ
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFactoryDate() {
		return factoryDate;
	}
	public void setFactoryDate(String factoryDate) {
		this.factoryDate = factoryDate;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", ����=" + name + ", ��������="
				+ factoryDate + ", ��Ʒ����=" + introduction+ "]";
	}
	
	
}
