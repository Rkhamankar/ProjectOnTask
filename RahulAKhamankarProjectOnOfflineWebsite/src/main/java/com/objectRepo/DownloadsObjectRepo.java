package com.objectRepo;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadsObjectRepo {
	
	@FindBy(xpath = "//span[text()='Downloads']")
	public WebElement downlods;
	
	@FindBy(xpath="//td")
	public List<WebElement> allElemenet;
	
	@FindBy(xpath="//tr")
	public List<WebElement> row;
	
	@FindBy(xpath="//td[3]")
	public List<WebElement> vendorList;
	
	@FindBy(xpath="//tr[3]")
	public List<WebElement> seleniumJar;
	
	@FindBy(xpath = "//tr[3]//td[8]")
	public WebElement clickButton;
	
	@FindBy(xpath="//td[4]")
	public List<WebElement> allTool;
	
	

}
