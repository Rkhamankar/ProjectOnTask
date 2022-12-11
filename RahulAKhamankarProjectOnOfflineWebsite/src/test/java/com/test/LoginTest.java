package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.listeners.MyListeners;
import com.page.LoginPage;

@Listeners(MyListeners.class)
public class LoginTest extends BaseClass {
	
	LoginPage lp ;
	
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		
		log.info(" Initialization Browser");
		initialization();
		log.info("Load a LoginPage");
		lp = new LoginPage(driver);
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		log.info("Closing the Browser");
		Thread.sleep(2000);
		driver.close();
		log.info("Browser Closed");
	}
	
	@Test(priority = 1)
	public void verifyTheLogingWithValidCredentials() throws Exception
	{
		log.info("Test Case no:- 01 of Login Functionality"
				+ " (verifyTheLogingWithValidCredentials)");
		Assert.assertTrue(lp.loginWithValidCredential());
		log.info("Logout To Application");
		loadLogoutPage();
	}
	
	@Test(priority = 2)
	public void verifyTheLogingWithInValidEmailCredentials() throws Exception
	{
		log.info("Test Case no:- 02 of Login Functionality"
				+ " (verifyTheLogingWithInValidEmailCredentials)");
		Assert.assertTrue(lp.loginWithInvalidEmailCredential());
	}
	
	@Test(priority = 3)
	public void verifyTheLogingWithInValidPasswordCredentials() throws Exception
	{
		log.info("Test Case no:- 03 of Login Functionality"
				+ " (verifyTheLogingWithInValidPasswordCredentials)");
		Assert.assertTrue(lp.loginWithInvalidPasswordCredential());
	}
	
	@Test(priority = 4)
	public void verifyTheLogingWithInValidCredentials() throws Exception
	{
		log.info("Test Case no:- 04 of Login Functionality"
				+ " (verifyTheLogingWithInValidCredentials)");
		Assert.assertTrue(lp.loginWithInvalidCredential());
	}
	
	@Test(priority = 5)
	public void verifyTheLogingWithBlankCredentials() throws Exception
	{
		log.info("Test Case no:- 05 of Login Functionality"
				+ " (verifyTheLogingWithBlankCredentials)");
		Assert.assertTrue(lp.loginWithBlankCredential());
	}
	
	

}
