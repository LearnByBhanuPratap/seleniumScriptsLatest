package com.selenium.logAndReports;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentTest extentTest;
	public ExtentReports extentReports;
	
	@BeforeClass
	public void beforeClass(){
		extentHtmlReporter = new ExtentHtmlReporter("extent.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentTest = extentReports.createTest(getClass().getSimpleName());
	}
	
	@BeforeMethod
	public void beforeMethod(Method result){
		extentTest.log(Status.INFO, result.getName()+" started...");
	}
	
	@Test
	public void testLogin(){
		extentTest.log(Status.INFO, "test1 started");
		extentTest.log(Status.INFO, "test1 started");
	}
	@Test
	public void testLogout(){
		extentTest.log(Status.INFO, "test2 started");
		extentTest.log(Status.INFO, "test2 started");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result){
		logReport(result);
	}
	
	public void logReport(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(Status.ERROR, result.getName()+" Failed");
			extentTest.log(Status.ERROR, result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(Status.SKIP, result.getName()+" Skipped");
			extentTest.log(Status.SKIP, result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(Status.INFO, result.getName()+"PASSED");
		}
	}
	
	@AfterClass
	public void afterClass(){
		extentReports.flush();
	}

}
