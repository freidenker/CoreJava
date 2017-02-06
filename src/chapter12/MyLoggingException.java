package chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException1 extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("LoggingException1");
	public LoggingException1(){
		StringWriter trace=new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

class LoggingException2 extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("LoggingException2");
	public LoggingException2(){
		StringWriter trace=new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class MyLoggingException {
	public static void main(String[] args){
		try{
			throw new LoggingException1();
		}catch(LoggingException1 e){
			System.err.println("Caught " + e); 
		}
		
		try{
			throw new LoggingException2();
		}catch(LoggingException2 e){
			System.err.println("Caught " + e); 
		}
	}


}
