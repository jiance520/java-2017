package ������_��Ŀ_�ƶ�ҵ�����;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 * @version ʱ�䣺2017-12-22 ����3:06:51
 *
 */
public class Test{
	private static Logger log = Logger.getLogger(Test.class.getName());
	
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		Test.log = log;
	}

	public static void main(String[] args){
		log.debug("����ʼ��");
		try{
			Sys sys = new Sys();
			sys.start();
			//����û��б�����--------------------------------
//			sys.clear();
			//----------------------------------------
//			sys.clearUserMap();
//			sys.iteratorAllUser();

//			�ײͽ���
//			sys.state();
//			ʹ�÷���
//			sys.useSys();
		}
		catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.debug("�������");
	}
}

