package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.page.LoginPage;
import com.page.LogoutPage;



public class BaseClass {
	
	public static WebDriver driver = null;
	FileInputStream fis = null;
	public static Logger log=Logger.getLogger(BaseClass.class);
	
	// reading config.file
	public String readProperty(String key)
	{
		String path = System.getProperty("user.dir")+"/src/main/resources/config.properties";
		Properties prop= new Properties();
		
		try {
			fis=new FileInputStream(path);
			
			prop.load(fis);
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
	
	public void launchApplication()
	{
		driver.get(readProperty("url"));
		
		log.info("::::Maximizing Window::::");
		driver.manage().window().maximize();
		
		log.info(":::::Applying Waits::::");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		log.info("User Launching JBK offline Application");
		
	}
	
	public WebDriver initialization()
	{
		log.info("Reading a property file for a browser name");
		
		if(readProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
			driver= new ChromeDriver();
			log.info("Opening Browser as found in file");
			log.info("User Launching Chrome Browser");
			launchApplication();
			return driver;
		}
		
		else
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
			log.info("Opening Browser as found in file");
			log.info("User Launching Chrome Browser");
			launchApplication();
			return driver;
		}
	}
	
	public static void loadLoginPage() throws Exception
    {
		LoginPage lp = new LoginPage(driver);
		
		lp.LoginToApplication();
	}
	
	public static void loadLogoutPage() throws Exception
    {
		LogoutPage lp = new LogoutPage(driver);
		
		lp.LogoutToApplication();
	}
	
	
	
	

}
