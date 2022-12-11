package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.listeners.MyListeners;
import com.page.OperatorsPage;

@Listeners(MyListeners.class)
public class OperatorsTest extends BaseClass {
	
	OperatorsPage op = null;
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		log.info(" Initialization Browser");
		initialization();
		log.info("Load a LoginPage");
		loadLoginPage();
		op= new OperatorsPage(driver);
		op.clickOnOperatorsPage();
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
	public void toVerifyThatAllHeaders()
	{
		log.info("Test Case no:- 01 of Operators Page Functionality"
				+ " (toVerifyThatAllHeaders)");
		Assert.assertTrue(op.toCheckOutHeaderOfTable());
	}
	
	@Test(priority = 2)
	public void toVerifyThatCountOfTableData()
	{
		log.info("Test Case no:- 02 of Operators Page Functionality"
				+ " (toVerifyThatSizeofTableData)");
		Assert.assertTrue(op.toCheckCountOfTableData());
	}
	
	@Test(priority = 3)
	public void toVerifyThatTableContainingElement()
	{
		log.info("Test Case no:- 03 of Operators Page Functionality"
				+ " (toVerifyThatTableContainingElement)");
		Assert.assertTrue(op.toCheckText());
	}
	
	@Test(priority = 4)
	public void toVerifyThatWhatsAppUserOnly()
	{
		log.info("Test Case no:- 04 of Operators Page Functionality"
				+ " (toVerifyThatWhatsAppUserOnly)");
		Assert.assertTrue(op.toCheckTheWhatsAppUserName());
	}
	
	@Test(priority = 5)
	public void toVerifyThatTechnicalPersonName()
	{
		log.info("Test Case no:- 05 of Operators Page Functionality"
				+ " (toVerifyThatTechnicalPersonName)");
		Assert.assertTrue(op.toCheckTheTechnicalPersonName());
	}

}
