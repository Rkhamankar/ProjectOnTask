package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.listeners.MyListeners;
import com.page.DownloadsPage;


@Listeners(MyListeners.class)
public class DownloadsTest extends BaseClass {
	
    DownloadsPage dp = null;
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		log.info(" Initialization Browser");
		initialization();
		log.info("Load a LoginPage");
		loadLoginPage();
		dp= new DownloadsPage(driver);
		dp.toClickOnDownlodPage();;
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
	public void toVerifyThatCountOfTableElement()
	{
		log.info("Test Case no:- 01 of Downloads Page Functionality"
				+ " (toVerifyThatToCheckCountOfTableElement)");
		Assert.assertTrue(dp.toCheckCountOfTableData());
	}
	
	@Test(priority = 2)
	public void toVerifyThatCountOfTableRowNumber()
	{
		log.info("Test Case no:- 02 of Downloads Page Functionality"
				+ " (toVerifyThatToCheckCountOfTableRowNumber)");
		Assert.assertTrue(dp.toCheckCountOfRow());
	}
	
	@Test(priority = 3)
	public void toVerifyThatVendorContainsElementJDK()
	{
		log.info("Test Case no:- 03 of Downloads Page Functionality"
				+ " (toVerifyThatVendorContainsElementJDK)");
		Assert.assertTrue(dp.toCheckTheVendorList());
	}
	
	@Test(priority = 4)
	public void toVerifyThatDriverSwitchToStandaloneJar() throws InterruptedException
	{
		log.info("Test Case no:- 04 of Downloads Page Functionality"
				+ " (toVerifyThatDriverSwitchToStandaloneJar)");
		Assert.assertTrue(dp.switchToDriver());
	}
	
	@Test(priority = 5)
	public void toVerifyThatCountOfToolColumnElement() throws InterruptedException
	{
		log.info("Test Case no:- 05 of Downloads Page Functionality"
				+ " (toVerifyThatCountOfToolColumnElement)");
		Assert.assertTrue(dp.toCheckCountOfToolElement());
	}

}
