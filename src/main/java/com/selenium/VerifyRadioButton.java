package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyRadioButton {

	// Create instance of web driver
	WebDriver driver;

	@Test
	public void verifyRadioButton() throws InterruptedException{

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver","/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver","/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");

		// Create Object of driver.
		driver = new ChromeDriver();
		//Launch the first URL
		driver.get("http://jqueryui.com/checkboxradio/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(7000);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.xpath("//div[@class='widget']/fieldset/label[@for='radio-1']/span[1]")).click();
		String className = driver.findElement(By.xpath("//div[@class='widget']/fieldset/label[@for='radio-1']")).getAttribute("class");
        System.out.println(className);
        if(className.contains("ui-checkboxradio-checked ui-state-active")){
        	   Assert.assertTrue(true, "Test verifyRadioButton is PASS");
        }
        else{
        	 Assert.assertTrue(false, "Test verifyRadioButton is PASS");
        }
	}
}
