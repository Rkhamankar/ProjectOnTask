package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.listeners.MyListeners;
import com.page.UsefulLinksPage;

@Listeners(MyListeners.class)
public class UsefulLinksTest extends BaseClass{
	
	 UsefulLinksPage ulp = null;
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		log.info(" Initialization Browser");
		initialization();
		log.info("Load a LoginPage");
		loadLoginPage();
		ulp= new UsefulLinksPage(driver);
		ulp.clickOnUsefulLinks();
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		log.info("Logout To Application");
		loadLogoutPage();
		Thread.sleep(2000);
		log.info("Closing the Browser");
		driver.close();
		log.info("Browser Closed");
	}
	
	@Test(priority = 1)
	public void toVerifyThatAllContentsElementDisplay()
	{
		log.info("Test Case no:- 01 of UsefulLinks Page Functionality"
				+ " (toVerifyThatAllContentsElementDisplay)");
		Assert.assertTrue(ulp.toCheckOutAllContentsElement());
	}
	
	@Test(priority = 2)
	public void toVerifyThatWholeTableElementDisplay()
	{
		log.info("Test Case no:- 02 of UsefulLinks Page Functionality"
				+ " (toVerifyThatWholeTableElementDisplay)");
		Assert.assertTrue(ulp.toCheckOutWholeTableIsPrint());
	}
	
	@Test(priority = 3)
	public void toVerifyThatDriverSwitchToScheduleLink() throws InterruptedException
	{
		log.info("Test Case no:- 03 of UsefulLinks Page Functionality"
				+ " (toVerifyThatDriverSwitchToScheduleLink)");
		Assert.assertTrue(ulp.switchToDriver());
	}
	
	@Test(priority = 4)
	public void toVerifyThatCountOfTableElement() throws InterruptedException
	{
		log.info("Test Case no:- 04 of UsefulLinks Page Functionality"
				+ " (toVerifyThatCountOfTableElement)");
		Assert.assertTrue(ulp.toCheckCountOfTableData());
	}
	
	@Test(priority = 5)
	public void toVerifyThatToCheckOutSpellingOfInternetRequired() throws InterruptedException
	{
		log.info("Test Case no:- 05 of UsefulLinks Page Functionality"
				+ " (toVerifyThatToCheckOutSpellingOfInternetRequired)");
		Assert.assertTrue(ulp.toCheckOutSpellingOfText());
	}

}
