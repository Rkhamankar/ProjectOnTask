package com.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepo.OperatorsObjectRepo;
import com.utility.PageUtility;

public class OperatorsPage extends OperatorsObjectRepo {
	
	WebDriver driver = null;
	
	public OperatorsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public static Logger log= Logger.getLogger(OperatorsPage.class);

    public void clickOnOperatorsPage()
	{
		PageUtility.click(operators);
		
    }
    
    public boolean toCheckOutHeaderOfTable()
    {
        boolean status = false;
		
		for(int i=1; i<=6; i++)
		{
			String tableHeader=driver.findElement(By.xpath("//tbody/tr[1]/th["+i+"]")).getText();
			
			log.info(tableHeader+" ");
			
		    status=true;
		}
		
		log.info("All Table heading is display");
		
		return status;
    }
    
    public boolean toCheckCountOfTableData()
    {
    	int actCountOfElement=element.size();
    	log.info("Actual count of element is :- "+actCountOfElement);
    	int expCountOfElement=30;
    	
    	if(actCountOfElement==expCountOfElement)
    	{
    		log.info("The Actual result is match with Expected Result");
    		return true;
    	}
    	else
    	{
    		log.info("The Actual result is not match with Expected Result");
    		return false;
    	}
    }
    
    public boolean toCheckText()
    {
         boolean status = false;
         
         String expText="Monday to Friday and Sunday";
		
		for(WebElement we : element)
		{
			String actText=we.getText();
			
			if(actText.contains(expText))
			{
				log.info("The actual text is :- "+actText);
				status=true;
				
				break;
			}
		}
		
		return status;
    }
    
    public boolean toCheckTheWhatsAppUserName()
    {
        boolean status = false;
        
        String expText="Whats App Only";
		
		for(WebElement we : element)
		{
			String actText=we.getText();
			
			if(actText.contains(expText))
			{
				String person=personName.getText();
				
				log.info("The Whats app user name is :- "+person);
				
				status = true;
				
				break;
			}
		}
		
		return status;
    }
    
    public boolean toCheckTheTechnicalPersonName()
    {
        boolean status = false;
        
        String expText="Administration";
		
		for(WebElement we : connect)
		{
			String actText=we.getText();
			
			if(actText.contains(expText))
			{
				String person=techPerson.getText();
				
				log.info("The technical person name is :- "+person);
				
				status = true;
				
				break;
			}
			
			}
		
		return status;
    }
}
