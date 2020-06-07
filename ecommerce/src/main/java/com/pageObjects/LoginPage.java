package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id = "email")
	public WebElement loginEmail_txb;
	
	@FindBy(id = "passwd")
	public WebElement loginPwd_txb;

	@FindBy(id = "SubmitLogin")
	public WebElement login_btn;

	@FindBy(className = "account")
	public WebElement loggedInUserName;

	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
