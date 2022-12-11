package com.objectRepo;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsefulLinksObjectRepo {
	
	@FindBy(xpath = "//span[text()='     Useful Links']")
	public WebElement useful;
	
	@FindBy(xpath = "//td[2]")
	public List<WebElement> content;
	
	@FindBy(xpath = "//td")
	public List<WebElement> tableData;
	
	@FindBy(xpath = "//tr[1]//following::td[3]")
	public WebElement schedule;
	
	@FindBy(xpath = "//h3[text()='* Internet Required']")
	public WebElement spell;
	

}
