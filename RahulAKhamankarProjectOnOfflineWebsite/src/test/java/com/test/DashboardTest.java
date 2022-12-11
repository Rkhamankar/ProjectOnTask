package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.listeners.MyListeners;
import com.page.DashboardPage;

@Listeners(MyListeners.class)
public class DashboardTest extends BaseClass {
	
	    DashboardPage dp ;
		
		
		
		@BeforeMethod
		public void beforeMethod() throws Exception
		{
			
			log.info(" Initialization Browser");
			initialization();
			log.info("Load a LoginPage");
			loadLoginPage();
			dp= new DashboardPage(driver);
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
		public void verifyThatAllCources() throws Exception
		{
			log.info("Test Case no:- 01 of DashBoard Functionality"
					+ " (verifyThatAllCources)");
			Assert.assertTrue(dp.toCheckCourcesList());
		}
		
		@Test(priority = 2)
		public void verifyThatAllCourcesDetails() throws Exception
		{
			log.info("Test Case no:- 02 of DashBoard Functionality"
					+ " (verifyThatAllCourcesDetails)");
			Assert.assertTrue(dp.toCheckAllCourcesDetails());
		}
		
		@Test(priority = 3)
		public void verifyThatPythonMoreInformation() throws Exception
		{
			log.info("Test Case no:- 03 of DashBoard Functionality"
					+ " (verifyThatPythonMoreInformation)");
			Assert.assertTrue(dp.driverSwitchToPython());
			
		}
		
		@Test(priority = 4)
		public void verifyThatAquaBoxContainsAutomationCourse() throws Exception
		{
			log.info("Test Case no:- 04 of DashBoard Functionality"
					+ " (verifyThatAquaBoxContainsAutomationCourse)");
			Assert.assertTrue(dp.toCheckAquaBoxContainsAutomation());
		}
		
		@Test(priority = 5)
		public void verifyThatColoroOfGreenBox() throws Exception
		{
			log.info("Test Case no:- 05 of DashBoard Functionality"
					+ " (verifyThatColoroOfGreenBox)");
			Assert.assertTrue(dp.toCheckColourOfGreenBox());
		}

}
