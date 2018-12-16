package XML_DOM4J及TCP增删改查测试;

import java.io.*;
import java.util.*;
public class Product implements Serializable{
	private String id;
	private String name;
	private String factoryDate;
	private String introduction;
	private String flag;// 表示 成功 或 失败
	private String type;// 表示 操作的类型 ： 新增 ， 查询 ， 修改 ，删除 ,退出 
	private List<Product> list = new ArrayList<Product>();//存放xml最新的信息
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
		return "Product [id=" + id + ", 名称=" + name + ", 生产日期="
				+ factoryDate + ", 产品介绍=" + introduction+ "]";
	}
	
	
}
