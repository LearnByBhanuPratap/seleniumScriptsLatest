package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iFrameInselenium {

	WebDriver driver;
	
	@Test
	public void enterText(){
		
		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		
		// Create Object of driver.
		driver = new ChromeDriver();
		
		// An implicit wait tells WebDriver to poll the DOM for a certain amount of time when trying to find an element
		// or elements if they are not immediately available.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("file:///Users/bsingh5/Downloads/startbootstrap-sb-admin-2-gh-pages/pages/forms.html");
		driver.switchTo().frame(0);
		//driver.switchTo().frame("nameOfIframe");
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='frame.html']")));
		//driver.switchTo().frame(0).switchTo().frame(2);
		//driver.switchTo().frame("nameOfIframe").switchTo().frame("name");
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='frame.html']"))).switchTo().frame("name");
		
		driver.findElement(By.xpath("/html/body/div/form/div/input[1]")).sendKeys("userName");
		
		driver.findElements(By.xpath("//input[@name='textbox1']")).get(0).sendKeys("userName");
		driver.switchTo().defaultContent();
		
	}
}
