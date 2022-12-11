package com.objectRepo;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardObjectRepo {
	
	@FindBy(xpath = "//h3")
	public List<WebElement> languages;
	
	@FindBy(xpath = "//div[@class='small-box bg-aqua']")
	public List<WebElement> aquaBox;
	
	@FindBy(xpath = "//div[@class='small-box bg-green']")
	public WebElement greenBox;
	
	@FindBy(xpath = "//a[@href='../pdf/python-syllabus.pdf']")
	public List<WebElement> pythonMoreInfo;
	
	@FindBy(xpath = "//div[@class='col-lg-3 col-xs-6']")
	public List<WebElement> allDashboard;
	
	@FindBy(partialLinkText  = "More info")
	public List<WebElement> moreInfo;

}
