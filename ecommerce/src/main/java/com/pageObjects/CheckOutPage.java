package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	@FindBy(xpath = "//a[@title = 'Women']")
	public WebElement women_btn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
	public WebElement firstItem;

	@FindBy(className = "quick-view")
	public WebElement quickView_btn;

	@FindBy(name = "Submit")
	public WebElement addToCart_btn;

	@FindBy(xpath = "//span[@class='ajax_block_cart_total']")
	public WebElement totalAmountInCart;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	public WebElement ProceedToCheckOut_btn1;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	public WebElement ProceedToCheckOut_btn2;

	@FindBy(xpath = "//button[@name='processAddress']")
	public WebElement ProceedToCheckOut_btn3;

	@FindBy(xpath = "//button[@name='processCarrier']")
	public WebElement ProceedToCheckOut_btn4;


	@FindBy(xpath = "//td[@id='total_price_container']")
	public WebElement totalPriceAtCheckOut;

	@FindBy(id = "cgv")
	public WebElement agree_checkBox;

	@FindBy(className = "bankwire")
	public WebElement bankWirePaymentOption;

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	public WebElement confirmOrder_btn;

	@FindBy(className = "cheque-indent")
	public WebElement orderComplete_txt;
	
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	public WebElement orderHistory_btn;

	@FindBy(xpath = "//tr[contains(@class,'first_item')]//td[@class='history_price']")
	public WebElement priceOfFirstItemInHistory;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	public WebElement logo;

	@FindBy(xpath = "//body[@id='product']/div")
	public WebElement itemPopUp;

	@FindBy(tagName = "iframe")
	public WebElement frame;

	@FindBy(className = "icon-plus")
	public WebElement addQuantity;

	public CheckOutPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


}
