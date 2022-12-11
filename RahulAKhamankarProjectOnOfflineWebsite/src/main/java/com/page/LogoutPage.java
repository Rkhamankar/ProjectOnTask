package com.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.objectRepo.LogoutObjectRepo;
import com.utility.PageUtility;

public class LogoutPage extends LogoutObjectRepo {
	
	WebDriver driver = null;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void LogoutToApplication() throws Exception
	{
		Thread.sleep(2000);
		PageUtility.click(logout);// logout application
	}
	
	public static Logger log = Logger.getLogger(LogoutPage.class);
	
	public boolean toCheckFooterOfMainPage()
	{
		String actFooter=footer.getText();
		log.info("Actual footer is :- "+actFooter);
		String expFooter="Design for Selenium Automation Test V 2.3.0\nCopyright © 2005-2019 JavaByKiran. All rights reserved.";
		log.info("Expected footer is :- "+expFooter);
		
		if(actFooter.equals(expFooter))
		{
			log.info("Actual Footer is match with Expected Footer");
			return true;
		}
		else
		{
			log.info("Actual Footer is match with Expected Footer");
			return false;
		}
	}
	
	public boolean toCheckHeaderOfMainPage()
	{
		String actHeader=header.getText();
		log.info("Actual Header is :- "+actHeader);
		String expHeader="Java By Kiran\nLOGOUT";
		log.info("Expected Header is :- "+expHeader);
		
		if(actHeader.equals(expHeader))
		{
			log.info("Actual Header is match with Expected Header");
			return true;
		}
		else
		{
			log.info("Actual Header is match with Expected Header");
			return false;
		}
	}
	
	public boolean toCheckSpellingOfKiranIsOnline()
	{
		String actspelling=online.getText();
		log.info("Actual spelling (Online) is :- "+actspelling);
		String expspelling="Kiran\nOnline";
		log.info("Expected spelling (Online) is :- "+expspelling);
		
		if(actspelling.equals(expspelling))
		{
			log.info("Actual spelling (Online) is match with Expected spelling (Online)");
			return true;
		}
		else
		{
			log.info("Actual spelling (Online) is match with Expected spelling (Online)");
			return false;
		}
	}
	
	public boolean toCheckSpellingOfMainNavigation()
	{
		String actspelling=mainNav.getText();
		log.info("Actual spelling (Navigation) is :- "+actspelling);
		String expspelling="MAIN NAVIGATION";
		log.info("Expected spelling (Navigation) is :- "+expspelling);
		
		if(actspelling.equals(expspelling))
		{
			log.info("Actual spelling (Navigation) is match with Expected spelling (Online)");
			return true;
		}
		else
		{
			log.info("Actual spelling (Navigation) is match with Expected spelling (Online)");
			return false;
		}
	}

}
