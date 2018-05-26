package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckboxInSelenium {
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
		driver.get("http://my.monsterindia.com/create_account.html?");
		// An implicit wait tells WebDriver to poll the DOM for a certain amount of time when trying to find an element
		// or elements if they are not immediately available.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='cat']/div[2]")).click();
		
		// check the check box
		driver.findElement(By.xpath("//*[text()='Admin/Secretarial']/preceding-sibling::div")).click();
		// check the check box
		driver.findElement(By.xpath("//*[text()='Customer Service/ Call Centre/ BPO']/preceding-sibling::div")).click();
		//driver.findElement(By.xpath("//*[text()='Human Resources']/preceding-sibling::div")).click();
		
		// when we use compound class as class name we will get exception
		//org.openqa.selenium.InvalidSelectorException: invalid selector: Compound class names not permitted
		//driver.findElement(By.className("right clip_image closedropdown")).click();
		driver.findElement(By.xpath("//*[@class='right clip_image closedropdown']")).click();
	}
}
