package ������_��Ŀ_�ƶ�ҵ�����;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @version ʱ�䣺2017-12-21 ����8:14:01
 *
 */
public class MonthDetails implements Serializable{
	private int monthTimes;//�ۻ�ͨ��ʱ��
	private int monthDuanXin;//�ۻ���������=allDuanXin,�³���ʼ��
	private double monthLiuLiang;//�ۻ����� MB
	private double monthBalances;//�ۻ��ۻ�����
	
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
