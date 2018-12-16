package 第七章_项目_移动业务大厅;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * @version 时间：2017-12-12 下午7:45:00
 *
 */
public class Type implements Serializable{
	private String name;//套餐名字
	private int times;//免费通话时长
	private double flow;//免费流量 G
	private int count;//免费短信条数
	private double price;//套餐固定资费
	
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
	
	public String toString(){//String str = "序号\t套餐类型\t通话时长\t上网流量\t短信条数\t资费";
		String str = name+"\t"+times+"\t"+flow+"\t"+count+"\t"+price;
		return str;
	}
	
}
