package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.listeners.MyListeners;
import com.page.LogoutPage;

@Listeners(MyListeners.class)
public class LogoutTest extends BaseClass {

	LogoutPage lp = null;
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		
		log.info(" Initialization Browser");
		initialization();
		log.info("Load a LoginPage");
		loadLoginPage();
		lp= new LogoutPage(driver);
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		Thread.sleep(2000);
		log.info("Closing the Browser");
		driver.close();
		log.info("Browser Closed");
	}
	
	@Test(priority = 1)
	public void toVerifyTheFooter() throws Exception
	{
		log.info("Test Case no:- 01 of Logout Functionality"
				+ " (toVerifyTheFooter)");
		Assert.assertTrue(lp.toCheckFooterOfMainPage());
		log.info("Logout To Application");
		lp.LogoutToApplication();
	}
	
	@Test(priority = 2)
	public void toVerifyTheHeader() throws Exception
	{
		log.info("Test Case no:- 02 of Logout Functionality"
				+ " (toVerifyTheHeader)");
		Assert.assertTrue(lp.toCheckHeaderOfMainPage());
		log.info("Logout To Application");
		lp.LogoutToApplication();
	}
	
	@Test(priority = 3)
	public void toVerifyTheSpellOfKiranIsOnline() throws Exception
	{
		log.info("Test Case no:- 03 of Logout Functionality"
				+ " (toVerifyTheSpellOfKiranIsOnline)");
		Assert.assertTrue(lp.toCheckSpellingOfKiranIsOnline());
		log.info("Logout To Application");
		lp.LogoutToApplication();
	}
	
	@Test(priority = 4)
	public void toVerifyTheSpellOfMainNavigation() throws Exception
	{
		log.info("Test Case no:- 04 of Logout Functionality"
				+ " (toVerifyTheSpellOfMainNavigation)");
		Assert.assertTrue(lp.toCheckSpellingOfKiranIsOnline());
		log.info("Logout To Application");
		lp.LogoutToApplication();
	}
	
	
}
