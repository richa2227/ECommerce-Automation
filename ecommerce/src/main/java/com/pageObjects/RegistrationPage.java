package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[@class='login']")
	public WebElement signIn_btn;
	
	@FindBy(id = "email_create")
	public WebElement createEmail_txb;
	
	@FindBy(id = "SubmitCreate")
	public WebElement submit_btn;
	
	@FindBy(id = "customer_firstname")
	public WebElement firstName_txb;

	@FindBy(id = "customer_lastname")
	public WebElement lastName_txb;

	@FindBy(id = "email")
	public WebElement email_txb;

	@FindBy(id = "passwd")
	public WebElement pwd_txb;
	
	@FindBy(id = "firstname")
	public WebElement addressFirstName_txb;

	@FindBy(id = "lastname")
	public WebElement adressLastName_txb;

	@FindBy(id = "address1")
	public WebElement address_txb;

	@FindBy(id = "city")
	public WebElement city_txb;
	
	@FindBy(id = "id_state")
	public WebElement state_dropDown;
	
	@FindBy(id = "postcode")
	public WebElement postCode_txb;

	@FindBy(id = "id_country")
	public WebElement country_dropDown;

	@FindBy(id = "phone_mobile")
	public WebElement mob_txb;

	@FindBy(id = "submitAccount")
	public WebElement registration_btn;
	
	@FindBy(xpath = "//h1[text()='My account']")
	public WebElement verificationText;


	public RegistrationPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
