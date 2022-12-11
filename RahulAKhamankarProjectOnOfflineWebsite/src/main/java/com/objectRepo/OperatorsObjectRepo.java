package com.objectRepo;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OperatorsObjectRepo {

	@FindBy(xpath = "//span[text()='Operators']")
	public WebElement operators;
	
	@FindBy(xpath = "//td")
	public List<WebElement> element;
	
	@FindBy(xpath ="//td[4]//preceding::td[2]")
	public WebElement personName;
	
	@FindBy(xpath = "//td[3]")
	public List<WebElement> connect;
	
	@FindBy(xpath ="//tr[4]//td[2]")
	public WebElement techPerson;
}
