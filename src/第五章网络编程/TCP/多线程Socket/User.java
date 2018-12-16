package 第五章网络编程.TCP.多线程Socket;

import java.io.Serializable;

/**
 * @version 时间：2017-12-3 下午3:45:49
 *
 */
public class User implements Serializable{//老忘记序列化
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