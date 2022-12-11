package com.page;

import java.util.ArrayList;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepo.UsefulLinksObjectRepo;
import com.utility.PageUtility;

public class UsefulLinksPage extends UsefulLinksObjectRepo {
	
	WebDriver driver = null;
	
	public UsefulLinksPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log= Logger.getLogger(UsefulLinksPage.class);
	
	public void clickOnUsefulLinks()
	{
		PageUtility.click(useful);
	}
	
	public boolean toCheckOutAllContentsElement()
	{
        ArrayList<String> actContents = new ArrayList<String>();
		
		for(WebElement ele: content)
		{
			String data=ele.getText();
			actContents.add(data);
			
		}
		
		log.info("The Actual contents are :- "+actContents);
		
	    ArrayList<String> expContents= new ArrayList<String>();
	    expContents.add("Schedule"); expContents.add("Video Lactures All Topics"); expContents.add("Selenium Interview Questions");
		expContents.add("Java Interview Questions"); expContents.add("Courses"); expContents.add("Placement");
		log.info("The Expected contents are :- "+expContents);
		
		if(actContents.equals(expContents))
		{
			log.info("Actual contents are match with Expected contens ");
			return true;
		}
		else
		{
			log.info("Actual contents are not match with Expected contens ");
			return false;
		}
	}
	
	public boolean toCheckOutWholeTableIsPrint()
	{
        boolean status = false;
		
		for(WebElement tb: tableData)
		{
			String element=tb.getText();
			
			log.info("Table element is print :- "+element);
			
			status=true;
		}
		
		return status;
	}
	
	public boolean switchToDriver() throws InterruptedException
	{
		String parentWin=driver.getWindowHandle();
		PageUtility.click(schedule);
		Set<String> allWin=driver.getWindowHandles();
		String title="www.javabykiran.com";
		PageUtility.switchToWindow(driver, parentWin, allWin, title);
		
		driver.switchTo().window(parentWin);
		Thread.sleep(2000);
		String actTitle=driver.getTitle();
		String expTitle="JavaByKiran | Useful Links";
		
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
	
	public boolean toCheckCountOfTableData()
    {
    	int actCountOfElement=tableData.size();
    	log.info("Actual count of element is :- "+actCountOfElement);
    	int expCountOfElement=18;
    	
    	if(actCountOfElement==expCountOfElement)
    	{
    		log.info("The Actual count is match with Expected count");
    		return true;
    	}
    	else
    	{
    		log.info("The Actual count is not match with Expected count");
    		return false;
    	}
    }
	
	public boolean toCheckOutSpellingOfText()
	{
        String actText=spell.getText();
		
		log.info("The actual spelling of Text is :- "+actText);
		
		String expText="* Internet Required";
		
		log.info("The expected spelling of Text is :- "+expText);
		
		if(actText.equals(expText))
    	{
    		log.info("The Actual text is match with Expected text");
    		return true;
    	}
    	else
    	{
    		log.info("The Actual text is not match with Expected text");
    		return false;
    	}
	}
	
	
	

}
