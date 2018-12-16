package XML_DOM4J及TCP增删改查测试;

import org.apache.log4j.Logger;

/**
 * @version 时间：2018-1-6 上午10:00:29
 *
 */
public class TestServer {
	static Logger log = Logger.getLogger(TestServer.class.getName());
	public static void main(String[] args){
		ServerSys ss = new ServerSys();
		ss.start();
	}		

}
