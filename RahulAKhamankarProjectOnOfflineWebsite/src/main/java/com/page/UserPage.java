package com.page;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import com.objectRepo.UserObjectRepo;
import com.utility.PageUtility;

public class UserPage extends UserObjectRepo {
	
	WebDriver driver=null;
	
	public UserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log= Logger.getLogger(UserPage.class);
	
	public void clickOnUsersPage()
	{
		PageUtility.click(userPage);
		
    }
	public boolean toCheckMahaStateUser()
	{
         ArrayList<String> actUser = new ArrayList<String>();
		
		 for (WebElement mh : uNameMaha) {
			
			String data=mh.getText();
			
			actUser.add(data);
			
			System.out.println(data);
			
		 }
		 
		 log.info("The Actaul Maharashtra State user is :- "+actUser);
		 
		 ArrayList<String> expUser = new ArrayList<String>();
		 expUser.add("Kiran");
		 expUser.add("Monica");
		 
		 log.info("Expected Maharashtra State user is :- "+expUser);
		 
		 if(actUser.equals(expUser))
		 {
			 log.info("The actual user is match with expected user ");
			 return true;
		 }
		 else
		 {
			 log.info("The actual user is not match with expected user ");
			 return false; 
		 }
		 
	}
	
	public boolean toCheckOutWrongGenderUser()
	{
		boolean status = false;
		String expGender ="Female1";
		
		log.info("Expected wrong gender type is  :- "+expGender);
		
		 for (WebElement we : gender) {
			 
			String actGender =we.getText();
			
			log.info("Actula wrong gender type is :- "+actGender);
			
			if(actGender.equals(expGender))
			{
				
				log.info("The wrong gender name is :- "+uNameGender.getText());
				
				status=true;
				
			}
			
		}
		 
		 return status;
	}
	
	public boolean toAcceptAlert() throws InterruptedException
	{
		PageUtility.click(delUser);
		PageUtility.alertAccept(driver);
		Thread.sleep(2000);
		PageUtility.alertAccept(driver);
		
		
        log.info("Alert is accepted");
        
        int actRow=row.size();
        log.info("The actual Row count is :- "+actRow);
        int expRow=5;
        
        if(actRow==(expRow))
        {
        	log.info("Actual Row count is match with Expected Row count");
            return true;
        }
        else
        {
        	log.info("Actual Row count is not match with Expected Row count");
            return false;
        }
        
        }
	
	public boolean toCheckOutCorrectMobileNumberUser()
	{
		boolean status = false;
		String expMobileNum ="9898989898";
		
		log.info("Expected mobile number is  :- "+expMobileNum);
		
		 for (WebElement we : mobile) {
			 
			String actMobileNum =we.getText();
			
			log.info("Actula mobile number is :- "+actMobileNum);
			
			if(actMobileNum.equals(expMobileNum))
			{
				
				log.info("The Correct Mobile Number user Name is :- "+uNameMobile.getText());
				
				status=true;
				
			}
			
		}
		 
		 return status;

	}
	
	public boolean toCheckTheBackGroundColorofAddUserElement()
	{
		String rgbaValue=addUser.getCssValue("background-color");
		log.info("The rgba Value is :- "+rgbaValue);
		String actBackgroungColor=Color.fromString(rgbaValue).asHex();
		log.info("The Background Color is :- "+actBackgroungColor);
		String expBackgroungColor="#3c8dbc";
		
		if(actBackgroungColor.equals(expBackgroungColor))
		{
			log.info("Actual color is match with Expected color");
			return true;
		}
		
		else
		{
			log.info("Actual color is not match with Expected color");
			return false;
		}
	}
	
	
}
