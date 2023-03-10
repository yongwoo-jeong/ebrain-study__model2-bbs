package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

	Logger logger = Logger.getLogger("mylogger");
	private static MyLogger instance = new MyLogger();

	private MyLogger(){ // 싱글톤 패턴
		logger.setLevel(Level.ALL);
	}
	public static MyLogger getLogger(){
		return instance;
	}
	/**
	 * 실행중인 클래스 이름을 취득
	 * @return 클래스명
	 */
	public static String getClassName() {
		return Thread.currentThread().getStackTrace()[2].getClassName();
	}
	public void info(String msg){
		logger.fine(msg);
	}
	public void warning(String msg){
		logger.warning(msg);
	}

	public void severe(String msg){
		logger.severe(msg);
	}

}