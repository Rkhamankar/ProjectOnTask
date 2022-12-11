package com.page;

import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepo.DownloadsObjectRepo;
import com.utility.PageUtility;

public class DownloadsPage extends DownloadsObjectRepo{
	
	WebDriver driver = null;
	
	public DownloadsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public static Logger log = Logger.getLogger(DownloadsPage.class);
	
	public void toClickOnDownlodPage()
	{
		PageUtility.click(downlods);
	}
	
	public boolean toCheckCountOfTableData()
	{
		int actCountOfElement=allElemenet.size();
		
		log.info("Actual count of element is :- "+actCountOfElement);
    	int expCountOfElement=56;
    	
    	if(actCountOfElement==expCountOfElement)
    	{
    		log.info("The Actual element count is match with Expected element count");
    		return true;
    	}
    	else
    	{
    		log.info("The Actual element count is not match with Expected element count");
    		return false;
    	}
	}
	
	public boolean toCheckCountOfRow()
	{
        int actCountOfRow=row.size();
		
        log.info("Actual count of row is :- "+actCountOfRow);
    	int expCountOfRow=8;
    	
    	if(actCountOfRow==expCountOfRow)
    	{
    		log.info("The Actual row count is match with Expected row count");
    		return true;
    	}
    	else
    	{
    		log.info("The Actual row count is not match with Expected row count");
    		return false;
    	}
	}
	
	public boolean toCheckTheVendorList()
	{
      boolean status= false;
		
		for(WebElement we: vendorList)
		{
			String vendor=we.getText();
			
			if(vendor.contains("Java Development Kit (JDK)"))
			{
				status = true;
				log.info("The Vendor List are display :- "+vendor);
				
				break;
			}
		}
		
		return status;
	}

	public boolean switchToDriver() throws InterruptedException
	{
		String parentWin=driver.getWindowHandle();
		
		for(WebElement ele: seleniumJar)
		{
			String str=ele.getText();
			
			if(str.contains("Selenium Server Standalon Jar"))
			{
				clickButton.click();
				
				break;
			}
		}
		Set<String> allWin=driver.getWindowHandles();
		String title="www.javabykiran.com";
	    PageUtility.switchToWindow(driver, parentWin, allWin, title);
		
		driver.switchTo().window(parentWin);
		Thread.sleep(2000);
		String actTitle=driver.getTitle();
		log.info("Actual Title of Downloads page :- "+actTitle);
		String expTitle="JavaByKiran | Downloads";
		
		if(actTitle.equals(expTitle))
		{
			log.info("Actual tile is match with Expected Title");
			return true;
		}
		
		else
		{
			log.info("Actual tile is not match with Expected Title");
			return false;
		}
		
	}
	
	public boolean toCheckCountOfToolElement()
	{
        int actCountOfTool=allTool.size();
		
        log.info("Actual count of Tool element is :- "+actCountOfTool);
    	int expCountOfTool=7;
    	
    	if(actCountOfTool==expCountOfTool)
    	{
    		log.info("The Actual count of Tool element is match with Expected count of Tool element");
    		return true;
    	}
    	else
    	{
    		log.info("The Actual count of Tool element is not match with Expected count of Tool element");
    		return false;
    	}
	}
}
