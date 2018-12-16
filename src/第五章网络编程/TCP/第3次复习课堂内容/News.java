package ������������.TCP.��3�θ�ϰ��������;

import java.io.Serializable;

/**
 * @version ʱ�䣺2018-1-2 ����11:42:19
 *
 */
public class News implements Serializable{
	String title;
	String author;
	String details;
	String flag = "default";
	
	public News(String title, String author, String details) {
		super();
		setTitle(title);
		setAuthor(author);
		setDetails(details);
	}
	public News() {
		super();
	}
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
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", author=" + author + ", details="
				+ details + "]";
	}
	
}
