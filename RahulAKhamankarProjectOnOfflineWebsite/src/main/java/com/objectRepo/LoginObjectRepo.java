package com.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjectRepo {
	
	//for encapsulation
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement pass;
	
	@FindBy(xpath =  "//button")
	private WebElement loginbutn;

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getPass() {
		return pass;
	}

	public void setPass(WebElement pass) {
		this.pass = pass;
	}

	public WebElement getLoginbutn() {
		return loginbutn;
	}

	public void setLoginbutn(WebElement loginbutn) {
		this.loginbutn = loginbutn;
	}
	
	@FindBy(id = "email_error")
	public WebElement emailErrorMsg;
	
	@FindBy(id = "password_error")
	public WebElement passwordErrorMsg;
	
	
	
	
	
	

}
