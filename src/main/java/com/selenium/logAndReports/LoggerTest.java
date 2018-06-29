package com.selenium.logAndReports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoggerTest {
	
	static String projectLocation = System.getProperty("user.dir");
	
	static String configFilename = projectLocation+"/log4j.properties";
	
	public static final Logger logger = Logger.getLogger(LoggerTest.class.getName());
	
	@BeforeClass
	public static void getlogger(){
		System.out.println(configFilename);
		PropertyConfigurator.configure(configFilename);
	}
	
	@Test
	public void testLogger(){
		//getlogger();
		logger.info("log test1");
		logger.info("log test2");
		logger.info("log test3");
		logger.info("log test4");
		
		logger.info("log testA");
		logger.info("log testB");
		logger.info("log testC");
		logger.info("log test4");
	}

}
