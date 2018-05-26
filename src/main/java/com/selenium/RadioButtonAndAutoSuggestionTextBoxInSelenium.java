package com.selenium;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtonAndAutoSuggestionTextBoxInSelenium {
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
		// enter first Name
		driver.findElement(By.xpath("//*[@id='firstName_id']")).sendKeys("firstName");
		
		driver.findElement(By.xpath("//*[@id='lastName_id']")).sendKeys("lastName");
		// enter email address
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test7676767@gmail.com");
		// click on password to get email continue button
		driver.findElement(By.id("passwd_id")).click();
		// wait for 5 second to load continue button
		Thread.sleep(5000);
		
		// highlight object in selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(By.xpath("//*[@id='email_msg']/a/img")));
	    Thread.sleep(2000);
		//**************how you should try click when normal selenium click API is not working**************
		
	    /*
		// click on continue button through action class
		Actions action = new Actions(driver);
		// by using click method of action class (did not work)
		action.click(driver.findElement(By.xpath("//*[@id='email_msg']/a/img")));
		
		// by using moveToElement and click (did not work)
		action.moveToElement(driver.findElement(By.xpath("//*[@id='email_msg']/a/img"))).click();
		
		// click on continue button through selenium Click API (did not work)
		driver.findElement(By.xpath("//*[@id='email_msg']/a/img")).click();
		*/
		// java script click (worked)
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='email_msg']/a/img")));
		
		//****************************************************************************************************
		
		// enter password
		driver.findElement(By.xpath("//*[@id='passwd_id']")).sendKeys("password");
		// click on current location object
		driver.findElement(By.xpath("//*[@id='select2-chosen-1']")).click();
		// enter Bang, it will auto populate all location based on matching
		driver.findElement(By.xpath("//*[@id='s2id_autogen1_search']")).sendKeys("Bang");
		// click on desired location
		driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]")).click();
		// click on total experience 
		driver.findElement(By.xpath("//*[@id='expYrMonth']/div[2]")).click();
		
		driver.findElement(By.xpath("//*[@id='expYrMonth_popup']/div/div[4]//div[text()='3']/preceding-sibling::div/input")).click();
		
		driver.findElement(By.xpath("//*[@id='expYrMonth_popup']/div/div[5]//div[text()='5']/preceding-sibling::div/input")).click();
		
		driver.findElement(By.xpath("//*[@id='expYrMonth']/div[2]")).click();
		
		// click on key skills text box
		driver.findElement(By.xpath("//*[@id='skills']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='skills']")).sendKeys("jav");
		//driver.findElement(By.xpath("//*[@id='skills']")).sendKeys(Keys.SPACE);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Java OR C']")).click();

		
	}
}
