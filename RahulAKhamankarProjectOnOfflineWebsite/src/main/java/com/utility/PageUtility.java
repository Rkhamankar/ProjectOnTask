package com.utility;

import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class PageUtility {
	
	static Logger log= Logger.getLogger(PageUtility.class);
	
	static WebDriver driver;
	
	public PageUtility(WebDriver driver)
	{
		PageUtility.driver=driver;
		
	}
	
	public static void sendKeys(WebElement element, String value)
	{

		element.clear();
		element.sendKeys(value);
	}
	
	public static void sendKeys(By by, String value)// method overloading
	{
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	
	public static void click(WebElement element)
	{
		element.click();
	}
	
	public static void selectRadioButton(List<WebElement> element, String value)
	{
		for(WebElement ele:element)
		{
			if(ele.getAttribute("value").equalsIgnoreCase(value))
			{
				ele.click();
				break;
			}
		}
		
		
	}
	
	public static void selectOptionFromDropDown(WebElement dropdown, String option)
	{
		Select select= new Select(dropdown);
		select.selectByVisibleText(option);
		
	}
	
	public static void switchToWindow(WebDriver driver, String parentWin, Set<String> allWin, String title )
	{

		for(String windows:allWin)
		{
			if(!windows.equals(parentWin))
			{
	             driver.switchTo().window(windows);
	             if(driver.getTitle().equalsIgnoreCase(title))
	            	log.info("Actual Title of Child Window is :- "+driver.getTitle()); 
	            	System.out.println("Title:- "+driver.getTitle());
				    System.out.println("Title:- "+driver.getCurrentUrl());
				    System.out.println("Title:- "+driver.getWindowHandle());
				    driver.close();
				}
			
			driver.switchTo().window(parentWin);
			}
		}
	
	public static void alertAccept(WebDriver driver) throws InterruptedException
	{
		Alert al=driver.switchTo().alert();
		log.info("Alert message :- "+al.getText());
		Thread.sleep(2000);
		al.accept();
	}
	
	}
			


