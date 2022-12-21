
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

	Logger logger = Logger.getLogger("mylogger");
	private static MyLogger instance = new MyLogger();

	public static MyLogger getLogger() {
		return instance;
	}

	public void log(String msg) {
		logger.info(msg);
	}
}