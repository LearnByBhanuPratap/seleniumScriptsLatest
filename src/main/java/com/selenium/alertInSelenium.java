package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class alertInSelenium {

	WebDriver driver;
	
	@Test
	public void enterText() throws InterruptedException, ParseException{

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		// create chrome object	
		driver = new ChromeDriver();
		// navigate to site
		driver.get("file:///Users/bsingh5/Downloads/startbootstrap-sb-admin-2-gh-pages/pages/index.html");
		// An implicit wait tells WebDriver to poll the DOM for a certain amount of time when trying to find an element
		// or elements if they are not immediately available.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='side-menu']/li[7]/a")).click();
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		String data = driver.findElement(By.xpath("//*[@id='demo']")).getText();
		if(data.equals("You pressed Cancel!")){
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue(false, "actual text is: "+ data);
		}
		driver.get("file:///Users/bsingh5/Downloads/startbootstrap-sb-admin-2-gh-pages/pages/index.html");
		driver.findElement(By.xpath("//a[@href='alert.html']")).click();
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
}
