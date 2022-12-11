package com.objectRepo;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserObjectRepo {
	
	@FindBy(xpath = "//span[text()='Users']")
	public WebElement userPage;
	
	@FindBy(xpath = "//td[text()='Maharashtra']//preceding::td[5]")
	public List<WebElement> uNameMaha;
	
	@FindBy(xpath = "//td[6]")
	public List<WebElement> gender;
	
	@FindBy(xpath = "//td[6]//preceding::td[text()='Monica']")
	public WebElement uNameGender;
	
	@FindBy(xpath = "//td[4]")
	public List<WebElement> mobile;
	
	@FindBy(xpath = "//td[4]//preceding::td[text()='Kiran']")
	public WebElement uNameMobile;
	
	@FindBy(xpath = "//td[text()='4']//following::td[7]")
	public WebElement delUser;
	
	@FindBy(xpath = "//button[text()='Add User']")
	public WebElement addUser;
	
	@FindBy(xpath = "//tr")
	public List<WebElement> row;

}
