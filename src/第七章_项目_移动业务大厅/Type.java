package ������_��Ŀ_�ƶ�ҵ�����;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * @version ʱ�䣺2017-12-12 ����7:45:00
 *
 */
public class Type implements Serializable{
	private String name;//�ײ�����
	private int times;//���ͨ��ʱ��
	private double flow;//������� G
	private int count;//��Ѷ�������
	private double price;//�ײ͹̶��ʷ�
	
	public Type(String name, int times, int count, int price) {
		super();
		setName(name);
		setTimes(times);
		setCount(count);
		setPrice(price);
	}
	
	public Type(String name, int flow, int price) {
		super();
		setName(name);
		setFlow(flow);
		setPrice(price);
	}
	
	public Type(String name, int times, int flow, int count, int price) {
		super();
		setName(name);
		setTimes(times);
		setFlow(flow);
		setCount(count);
		setPrice(price);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTimes() {
		return times;
	}
	
	public void setTimes(int times) {
		this.times = times;
	}
	
	public double getFlow() {
		return flow;
	}
	
	public void setFlow(double flow) {
		this.flow = flow;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){//String str = "���\t�ײ�����\tͨ��ʱ��\t��������\t��������\t�ʷ�";
		String str = name+"\t"+times+"\t"+flow+"\t"+count+"\t"+price;
		return str;
	}
	
}
