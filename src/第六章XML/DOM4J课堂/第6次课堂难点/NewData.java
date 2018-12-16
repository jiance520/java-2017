package ������XML.DOM4J����.��6�ο����ѵ�;

import java.io.*;
import java.util.*;

/**
 * @version ʱ�䣺2018-1-6 ����8:54:23
 *
 */
public class NewData implements Serializable{
	private String title;
	private String author;
	private String content;
	private String flag;// ��ʾ �ɹ� �� ʧ��
	private String type;// ��ʾ ���������� �� ���� �� ��ѯ �� �޸� ��ɾ�� ,�˳� 
	private List<NewData> list = new ArrayList<NewData>();//���xml���µ�������Ϣ
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	public List<NewData> getList() {
		return list;
	}
	public void setList(List<NewData> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "NewsData [title=" + title + ", author=" + author + ", content="
				+ content + "]";
	}
	
}
