package utility;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	public static Logger log = LogManager.getLogger();
	
	public void info(String msg) {
		log.info(msg);
	}
	
	public void warn(String msg) {
		log.warn(msg);
		
	}
	
}
