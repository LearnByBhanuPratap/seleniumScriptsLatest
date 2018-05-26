package com.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToWorkWithMultipleWindows {

	WebDriver driver;
	
	@Test
	public void enterText(){
		
		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
				
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		// click on youtube link
		driver.findElement(By.xpath("//*[@id='social_block']/ul/li[3]/a")).click();
		
		// Here we will get all windows id's
		Set<String> windowsId = driver.getWindowHandles();
		
		Iterator<String> itr = windowsId.iterator();
		
		String parentId = itr.next();
		String childId = itr.next();
		
		// Switch to youtube window
		// without switching to child window , we can not work on child window object
		driver.switchTo().window(childId);
		
		// Just sleep for 3 second to see how new window is opening.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Close the youtube window
		driver.close();
		
		// Switch to parent application window 
		// Without switching to parent window, we can not work on parent window object
		driver.switchTo().window(parentId);
		
		// Click on women link
		driver.findElement(By.xpath("//*[@id='footer']/div/section[2]/div/div/ul/li/a")).click();
		
	}
}
