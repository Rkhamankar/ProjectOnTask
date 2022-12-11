package com.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepo.LoginObjectRepo;
import com.utility.PageUtility;
import com.utility.ReadExcelLoginUtils;

public class LoginPage extends LoginObjectRepo {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log = Logger.getLogger(LoginPage.class);
	
	public void LoginToApplication() throws Exception //for baseclass and use for each test class
	{
		String emailid=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 1, 0);
		setEmail(getEmail());
		WebElement email =getEmail();
		PageUtility.sendKeys(email, emailid);
		
		String pass=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 1, 1);
		setPass(getPass());
		WebElement password =getPass();
		PageUtility.sendKeys(password, pass);
		
		setLoginbutn(getLoginbutn());
		WebElement button=getLoginbutn();
		PageUtility.click(button);
	}
	

	public boolean loginWithValidCredential() throws Exception
	{
		String emailid=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 1, 0);
		setEmail(getEmail());
		WebElement email =getEmail();
		PageUtility.sendKeys(email, emailid);
		log.info("Valid Email :- "+emailid);
		
		String pass=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 1, 1);
		setPass(getPass());
		WebElement password =getPass();
		PageUtility.sendKeys(password, pass);
		log.info("Valid Password :- "+pass);
		
		setLoginbutn(getLoginbutn());
		WebElement button=getLoginbutn();
		PageUtility.click(button);
		
		String actTitle=driver.getTitle();
		log.info("Actual Title of Page :- "+actTitle);
		
		String expTitle="JavaByKiran | Dashboard";
		log.info("Expected Title of Page :- "+expTitle);
		
		if(actTitle.equals(expTitle))
		{
			log.info("Actual Title is Match with Expected Title");
		return true;
		}
		
		else
		{
			log.info("Actual Title is not Match with Expected Title there fore our Test Case is fail");
		return false;
		}
		
		
	}
	
	public boolean loginWithInvalidEmailCredential() throws Exception
	{
		String emailid=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 2, 0);
		setEmail(getEmail());
		WebElement email =getEmail();
		PageUtility.sendKeys(email, emailid);
		log.info("Invalid Email :- "+emailid);
		
		String pass=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 2, 1);
		setPass(getPass());
		WebElement password =getPass();
		PageUtility.sendKeys(password, pass);
		log.info("Valid Password :- "+pass);
		
		setLoginbutn(getLoginbutn());
		WebElement button=getLoginbutn();
		PageUtility.click(button);
		
		String actError=emailErrorMsg.getText();
		log.info("Actual Invalid Email Cradential Error msg :- "+actError);
		
		String expError="Please enter email as kiran@gmail.com";
		log.info("Expected Invalid Email Cradential Error msg :- "+actError);
		
		if(actError.equals(expError))
		{
			log.info("Actual Email Error Message is Match with Expected Email Error Message");
		return true;
		}
		
		else
		{
			log.info("Expected Eamil Error Message is not Match with Expected Email Error Message");
		return false;
		}
		
		}
	
	
	
	public boolean loginWithInvalidPasswordCredential() throws Exception
	{
		String emailid=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 3, 0);
		setEmail(getEmail());
		WebElement email =getEmail();
		PageUtility.sendKeys(email, emailid);
		log.info("Valid Email :- "+emailid);
		
		String pass=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 3, 1);
		setPass(getPass());
		WebElement password =getPass();
		PageUtility.sendKeys(password, pass);
		log.info("Invalid Password :- "+pass);
		
		setLoginbutn(getLoginbutn());
		WebElement button=getLoginbutn();
		PageUtility.click(button);
		
		String actError=passwordErrorMsg.getText();
		log.info("Actual Invalid Password Cradential Error msg :- "+actError);
		
		String expError="Please enter password 123456";
		log.info("Expected Invalid Password Cradential Error msg :- "+actError);
		
		if(actError.equals(expError))
		{
			log.info("Actual Password Error Message is Match with Expected Password Error Message");
		return true;
		}
		
		else
		{
			log.info("Expected Password Error Message is not Match with Expected Password Error Message");
		return false;
		}
	}
	
	public boolean loginWithInvalidCredential() throws Exception
	{
		String emailid=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 4, 0);
		setEmail(getEmail());
		WebElement email =getEmail();
		PageUtility.sendKeys(email, emailid);
		log.info("Invalid Email :- "+emailid);
		
		String pass=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 4, 1);
		setPass(getPass());
		WebElement password =getPass();
		PageUtility.sendKeys(password, pass);
		log.info("Invalid Password :- "+pass);
		
		setLoginbutn(getLoginbutn());
		WebElement button=getLoginbutn();
		PageUtility.click(button);
		
		String actError1=emailErrorMsg.getText();
		String actError2=passwordErrorMsg.getText();
		String actError =actError1+"\n"+actError2;
		log.info("Actual Invalid Cradential Error msg :- "+actError);
		
		String expError="Please enter email as kiran@gmail.com\nPlease enter password 123456";
		log.info("Expected Invalid Cradential Error msg :- "+actError);
		
		if(actError.equals(expError))
		{
			log.info("Actual Invalid Credential Error Message is Match with Expected Invalid Cradential Error Message");
		return true;
		}
		
		else
		{
			log.info("Actual Invalid Error Message is not Match with Expected Invalid Cradential Error Message");
		return false;
		}
	}
	
	public boolean loginWithBlankCredential() throws Exception
	{
		String emailid=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 5, 0);
		setEmail(getEmail());
		WebElement email =getEmail();
		PageUtility.sendKeys(email, emailid);
		log.info("Blank Email :- "+emailid);
		
		String pass=ReadExcelLoginUtils.readExcelSheet("LoginData.xlsx", "Sheet1", 5, 1);
		setPass(getPass());
		WebElement password =getPass();
		PageUtility.sendKeys(password, pass);
		log.info("Blank Password :- "+pass);
		
		setLoginbutn(getLoginbutn());
		WebElement button=getLoginbutn();
		PageUtility.click(button);
		
		String actError1=emailErrorMsg.getText();
		String actError2=passwordErrorMsg.getText();
		String actError =actError1+"\n"+actError2;
		log.info("Actual Blank Cradential Error msg :- "+actError);
		
		String expError="Please enter email.\nPlease enter password.";
		log.info("Expected Blank Cradential Error msg :- "+actError);
		
		if(actError.equals(expError))
		{
			log.info("Actual Blank Credential Error Message is Match with Expected Blank Cradential Error Message");
		return true;
		}
		
		else
		{
			log.info("Actual Blank Error Message is not Match with Expected Blank Cradential Error Message");
		return false;
		}
	}

}
