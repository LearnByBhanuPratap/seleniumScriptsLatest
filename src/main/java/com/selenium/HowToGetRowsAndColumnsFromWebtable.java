package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToGetRowsAndColumnsFromWebtable {
	WebDriver driver;
	
	@Test
	public void enterText() throws InterruptedException{
		
		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
	    // create browser object	
		driver = new ChromeDriver();
		// navigate to site
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		// An implicit wait tells WebDriver to poll the DOM for a certain amount of time when trying to find an element
		// or elements if they are not immediately available.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// get total number of rows in table
		int rowsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
		System.out.println("number of rows are: "+rowsNumber);
		// get total number of columns in given row
		int colsNumber = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).size();
		System.out.println("number of cols are: "+colsNumber);
	}
}
