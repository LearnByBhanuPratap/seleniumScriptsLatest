package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HowToHandelCalendarORTextBoxORSelectBox {
	
	WebDriver driver;
	String month = "November 2018";
	String checkMonth = "December 2018";
	String date = "21";
	
	@Test
	public void enterText() throws InterruptedException{
		
		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");
		// create driver object	
		driver = new ChromeDriver();
		// navigate to site
		driver.get("http://www.phptravels.net/");
		// click on location text box
		driver.findElement(By.xpath("//*[@id='s2id_autogen10']/a/span[1]")).click();
		Thread.sleep(1000);
		// enter block text then matching text will show as list
		driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("Block");
		// waiting for 5 seconds to make sure list is loaded
		Thread.sleep(5000);
		List<WebElement> data = driver.findElements(By.xpath("//ul[@class='select2-result-sub']/li"));
		// Run for loop on list of data and see given text is there in list or not
		for(int i = 0; i<data.size(); i++){
			WebElement element = data.get(i);
			String text = data.get(i).getText();
			System.out.println(text);
			// Whenever given data matched in list we will click on web element and break for loop
			if(text.equals("Block Island, United States")){
				element.click();
				break;
			}	
		}
		// Click on Calendar
		driver.findElement(By.xpath("//*[@id='dpd1']/input")).click();
		// get web element of month in Calendar
		WebElement mon = driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[2]"));
		while(true){
			// if given month matched break the while loop
			if(mon.getText().equals(month)){
				break;
			}
			else{
				// if given month not matched click on next icon
				driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(1000);
			}
		}
		// click on date 
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/tbody/tr/td[contains(text(),'"+date+"')]")).click();
		WebElement checkoutMonth = driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][2]/div[1]/table/thead/tr[1]/th[2]"));
		while(true){
			System.out.println(checkoutMonth.getText());
			// if given month matched break the while loop
			if(checkoutMonth.getText().equals(checkMonth)){
				break;
			}
			else{
				// if given month not matched click on next icon
				driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][2]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(1000);
			}
		}
		// click on date
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][2]/div[1]/table/tbody/tr/td[contains(text(),'"+date+"')]")).click();
		
		// to select data from select box make object of select class
		Select select = new Select(driver.findElement(By.xpath("//*[@id='adults']")));
		// it will select three adults
		select.selectByVisibleText("3");
		
		// to select data from select box make object of select class
		WebElement child = driver.findElement(By.xpath("//*[@id='child']"));
		select = new Select(child);
		// it will select second data in select box since select box index start from 0
		select.selectByIndex(1);
	}
    
}
