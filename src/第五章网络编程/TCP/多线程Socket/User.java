package ������������.TCP.���߳�Socket;

import java.io.Serializable;

/**
 * @version ʱ�䣺2017-12-3 ����3:45:49
 *
 */
public class User implements Serializable{//���������л�
	private String name;
	private int psw;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPsw() {
		return psw;
	}
	public void setPsw(int psw) {
		this.psw = psw;
	}
}