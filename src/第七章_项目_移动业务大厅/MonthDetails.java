package 第七章_项目_移动业务大厅;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @version 时间：2017-12-21 下午8:14:01
 *
 */
public class MonthDetails implements Serializable{
	private int monthTimes;//累积通话时长
	private int monthDuanXin;//累积短信条数=allDuanXin,月初初始化
	private double monthLiuLiang;//累积流量 MB
	private double monthBalances;//累积累积话费
	
	public MonthDetails() {
		super();
	}
	
	public MonthDetails(int monthTimes, int monthDuanXin, double monthLiuLiang,
			double monthBalances) {
		super();
		setMonthTimes(monthTimes);
		setMonthDuanxin(monthDuanXin);
		setMonthLiuliang(monthLiuLiang);
		setMonthBalances(monthBalances);
	}
	
	public int getMonthTimes() {
		return monthTimes;
	}
	
	public void setMonthTimes(int monthTimes) {
		this.monthTimes = monthTimes;
	}
	
	public int getMonthDuanxin() {
		return monthDuanXin;
	}
	
	public void setMonthDuanxin(int monthDuanXin) {
		this.monthDuanXin = monthDuanXin;
	}
	
	public double getMonthLiuliang() {
		return monthLiuLiang;
	}
	
	public void setMonthLiuliang(double monthLiuLiang) {
		this.monthLiuLiang = monthLiuLiang;
	}
	
	public double getMonthBalances() {
		return monthBalances;
	}
	
	public void setMonthBalances(double monthBalances) {
		this.monthBalances = monthBalances;
	}
	
	public String toString(){
		String str = monthTimes+"\t"+monthDuanXin+"\t"+monthLiuLiang+"\t"+monthBalances;
		return str;
	}
}
