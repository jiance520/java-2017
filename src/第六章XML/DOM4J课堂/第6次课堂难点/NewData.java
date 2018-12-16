package 第六章XML.DOM4J课堂.第6次课堂难点;

import java.io.*;
import java.util.*;

/**
 * @version 时间：2018-1-6 上午8:54:23
 *
 */
public class NewData implements Serializable{
	private String title;
	private String author;
	private String content;
	private String flag;// 表示 成功 或 失败
	private String type;// 表示 操作的类型 ： 新增 ， 查询 ， 修改 ，删除 ,退出 
	private List<NewData> list = new ArrayList<NewData>();//存放xml最新的新闻信息
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
