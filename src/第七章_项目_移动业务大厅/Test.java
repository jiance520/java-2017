package 第七章_项目_移动业务大厅;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

/**
 * @version 时间：2017-12-22 下午3:06:51
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
		log.debug("程序开始。");
		try{
			Sys sys = new Sys();
			sys.start();
			//清空用户列表数据--------------------------------
//			sys.clear();
			//----------------------------------------
//			sys.clearUserMap();
//			sys.iteratorAllUser();

//			套餐介绍
//			sys.state();
//			使用服务
//			sys.useSys();
		}
		catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.debug("程序结束");
	}
}

