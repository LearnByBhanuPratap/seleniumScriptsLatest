package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class calender {
	WebDriver driver;
	
	@Test
	public void enterText(){
		
		String month = "November 2018";
		String day = "20";
		
		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
				
		driver = new ChromeDriver();
		
		driver.get("http://www.phptravels.net/");
		
		driver.findElement(By.xpath("//*[@id='dpd1']/input")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(true){
			String text = driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div/table/thead/tr/th[2]")).getText();
			System.out.println(text);
			if(text.equals("month")){
				break;
			}
			else{
				driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div/table/thead/tr/th[3]")).click();
			}
		}
		
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div/table/tbody/tr/td[contains(text(),'21')]")).click();
		
		
		
		
	}
}
