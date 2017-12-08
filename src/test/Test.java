package test;
import org.apache.log4j.Logger;

public class Test {

	private static Logger logger = Logger.getLogger(Test.class);
	@org.junit.Test
	public void test() {
		logger.debug("this id debug message!");
		logger.info("this is info message");
		logger.error("this id error message");
	}
	

}
