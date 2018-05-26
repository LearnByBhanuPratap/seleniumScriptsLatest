package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToGetRowDataFromDynamicWebTable {
	WebDriver driver;
	
	@Test
	public void enterText() throws InterruptedException{

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		// create driver object		
		driver = new ChromeDriver();
		// navigate to site
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		// An implicit wait tells WebDriver to poll the DOM for a certain amount of time when trying to find an element
		// or elements if they are not immediately available.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// to get data from particular row and column
		String rowData = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[4]")).getText();
		System.out.println("data of row is : "+rowData);
		// to get data from particular row and column based on some text reference
		rowData = driver.findElement(By.xpath("//a[contains(text(),'Bank of India')]/parent::*/following-sibling::td[3]")).getText();
		
		System.out.println("data of row is : "+rowData);
	}
}
