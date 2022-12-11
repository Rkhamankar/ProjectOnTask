package com.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutObjectRepo {
	
	@FindBy(xpath = "//footer[@class='main-footer']")
	public WebElement footer;
	
	@FindBy(xpath = "//header[@class='main-header']")
	public WebElement header;
	
	@FindBy(xpath = "//div[@class='pull-left info']")
	public WebElement online;
	
	@FindBy(xpath = "//li[contains(text(),'MAIN NAVIGATION')]")
	public WebElement mainNav;
	
	@FindBy(xpath = "//a[text()='LOGOUT']")
	public WebElement logout;

}
