package ������XML.DOM4J����.��6�ο����ѵ�;

import org.apache.log4j.Logger;

/**
 * @version ʱ�䣺2018-1-6 ����10:00:29
 *
 */
public class TestServer {
	static Logger log = Logger.getLogger(TestServer.class.getName());
	public static void main(String[] args){
		ServerSys ss = new ServerSys();
		ss.start();
	}		

}
