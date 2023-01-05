package com.page;

import java.util.ArrayList;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import com.objectRepo.DashboardObjectRepo;
import com.utility.PageUtility;

public class DashboardPage extends DashboardObjectRepo {
	
	
   WebDriver driver=null;
   
  
    public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public static Logger log = Logger.getLogger(DashboardPage.class);
	
	public boolean toCheckCourcesList()
	{
		ArrayList<String> expCourcesList = new ArrayList<String>();
		expCourcesList.add("Selenium"); expCourcesList.add("Java / J2EE"); 
		expCourcesList.add("Python"); expCourcesList.add("Php"); 
		
		log.info("Expected List :- "+expCourcesList);
		
		 ArrayList<String> actCourcesList = new ArrayList<String>();
		
		languages.forEach(langName -> actCourcesList.add(langName.getText()));
		 
//		 for (WebElement langName : languages) {
//			 
//			 String text=langName.getText();
//			 
//			 actCourcesList.add(text);
//			 
//			 System.out.println("Languages Name :- "+text);
			
//		}
		 
		 log.info("Actual List :- "+actCourcesList);
		 
		 if(actCourcesList.equals(expCourcesList))
		 {
			 log.info("All the cources are available on Dashboard Page");
			 return true;
		 }
		 
		 else 
		 {
			 log.info("Not matching the expected list of cources");
			 return false;
		 }
		
	}
	
	public boolean toCheckAllCourcesDetails()
	{
		ArrayList<String> expCourcesDetails = new ArrayList<String>();
		expCourcesDetails.add("Selenium\nAutomation Testing\nMore info"); 
		expCourcesDetails.add("Java / J2EE\nSoftware Development\nMore info"); 
		expCourcesDetails.add("Python\nData Science\nMore info"); 
		expCourcesDetails.add("Php\nWeb Development\nMore info"); 
		
		log.info("Expected Cource Details :- "+expCourcesDetails);
		
		 ArrayList<String> actCourcesDetails = new ArrayList<String>();
		
		//languages.forEach(langName -> actCourcesList.add(langName.getText()));
		 
		 for (WebElement details : allDashboard) {
			 
			 String text=details.getText();
			 
			 actCourcesDetails.add(text);
			 
			 System.out.println("Cources Details :- "+text);
			
		}
		 
		 log.info("Actual Cources Details :- "+actCourcesDetails);
		 
		 if(actCourcesDetails.equals(expCourcesDetails))
		 {
			 log.info("All the cources details are available on Dashboard Page");
			 return true;
		 }
		 
		 else 
		 {
			 log.info("Not matching the expected details of cources");
			 return false;
		 }
		
	}
	
	public boolean driverSwitchToPython()
	{
		String parentwind=driver.getWindowHandle();
		
		
		for (WebElement link : pythonMoreInfo ) {
			
			PageUtility.click(link);
		}
		
		log.info("Actual Title of ParentWindow "+driver.getTitle());

        Set<String> allWind=driver.getWindowHandles();
		
        PageUtility.switchToWindow(driver, parentwind, allWind, "");
		
		return true;
		
	}
	
	public boolean toCheckAquaBoxContainsAutomation()
	{
		boolean status = false;
		String expContains ="Automation Testing";
		log.info("Expected Value :- "+expContains);
		
		for (WebElement we : aquaBox) {
			
			String actContains=we.getText();
			
			if(actContains.contains(expContains))
			{
				log.info("Aqua box is having Automation Testing");
				log.info("Actual Value :- "+actContains);
				status =true;
				break;
				
			}
			
			
			
		}
		
		return status;
		
		}
	
	public boolean toCheckColourOfGreenBox()
	{
		String rgbaValue=greenBox.getCssValue("color");
		log.info("RGBA Value :- "+rgbaValue);
		String actColor=Color.fromString(rgbaValue).asHex();
		log.info("Actual Color is "+actColor);
		
		String expColor ="#ffffff";
		log.info("Expected Color is :- "+expColor);
		
		if(actColor.equals(expColor))
		{
			log.info("Actual Result is match with Expected Result");
			return true;
		}
		
		else
		{
			log.info("Actual is not match with Expected");
			return false;
		}
		
		
	
	}
	
	
	
	

}
