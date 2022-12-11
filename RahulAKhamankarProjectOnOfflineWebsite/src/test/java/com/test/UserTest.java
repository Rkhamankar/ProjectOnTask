package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.listeners.MyListeners;
import com.page.UserPage;

@Listeners(MyListeners.class)
public class UserTest extends BaseClass {
	
	UserPage up= null;
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		
		log.info(" Initialization Browser");
		initialization();
		log.info("Load a LoginPage");
		loadLoginPage();
		up= new UserPage(driver);
		up.clickOnUsersPage();
		
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
	public void toVerifyThatMaharashtaStateUser()
	{
		log.info("Test Case no:- 01 of User Page Functionality"
				+ " (toVerifyThatMaharashtaStateUser)");
		
		Assert.assertTrue(up.toCheckMahaStateUser());
	}
	
	@Test(priority = 2)
	public void toVerifyThatOddmanGenderUser()
	{
		log.info("Test Case no:- 02 of User Page Functionality"
				+ " (toVerifyThatOddmanGenderUser)");
		
		Assert.assertTrue(up.toCheckOutWrongGenderUser());
	}
	
	@Test(priority = 3)
	public void toVerifyThatAlertIsAccepted() throws InterruptedException
	{
		log.info("Test Case no:- 03 of User Page Functionality"
				+ " (toVerifyThatAlertIsAccepted)");
		
		Assert.assertTrue(up.toAcceptAlert());
	}
	
	@Test(priority = 4)
	public void toVerifyThatTenDigitMobileNumberUser()
	{
		log.info("Test Case no:- 04 of User Page Functionality"
				+ " (toVerifyThatTenDigitMobileNumberUser)");
		
		Assert.assertTrue(up.toCheckOutCorrectMobileNumberUser());
	}
	
	@Test(priority = 5)
	public void toVerifyThatBackgroundColorOfAddUser()
	{
		log.info("Test Case no:- 05 of User Page Functionality"
				+ " (toVerifyThatBackgroundColor)");
		
		Assert.assertTrue(up.toCheckTheBackGroundColorofAddUserElement());
	}
			
	
	

}
