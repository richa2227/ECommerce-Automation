package com.testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageObjects.CheckOutPage;
import com.pageObjects.LoginPage;
import com.utilities.BrowserSetUp;
import com.utilities.CommonFunctions;

public class CheckOut extends BrowserSetUp{
	
	CommonFunctions page = new CommonFunctions();
	
	@Parameters({"URL","username","password"})
	@Test
	public void CheckOutOrder(String baseUrl,String un,String pwd) throws IOException {
		
		Login login = new Login();
		LoginPage lp = new LoginPage(driver);
		CheckOutPage order = new CheckOutPage(driver);
		
		login.userLogin(baseUrl, un, pwd);
		
		page.clickElement(order.logo);
		page.waitTillElementVisibility(driver, order.women_btn);
		page.clickElement(order.women_btn);
		page.waitTillElementVisibility(driver, order.firstItem);
		page.hoverElement(driver, order.firstItem);
		page.isElementVisible(order.itemPopUp);
		page.switchToFrame(driver, order.frame);
		page.clickElement(order.addQuantity);
		page.clickElement(order.addToCart_btn);
		
		driver.switchTo().defaultContent();

		page.clickElement(order.ProceedToCheckOut_btn1);
		page.clickElement(order.ProceedToCheckOut_btn2);
		page.clickElement(order.ProceedToCheckOut_btn3);
		page.clickElement(order.agree_checkBox);
		page.verifyBooleanAssert(page.verifyElementCheckedOrUnchecked(order.agree_checkBox), true);
		page.clickElement(order.ProceedToCheckOut_btn4);
		String priceAtCart = page.getDataFromElement(order.totalPriceAtCheckOut);
		page.clickElement(order.bankWirePaymentOption);
		page.clickElement(order.confirmOrder_btn);
		page.verifyText(page.getDataFromElement(order.orderComplete_txt), "Your order on My Store is complete.");
		page.clickElement(lp.loggedInUserName);
		page.clickElement(order.orderHistory_btn);
		String priceInOrderHistory = page.getDataFromElement(order.priceOfFirstItemInHistory);
		page.verifyText(priceInOrderHistory, priceAtCart);
		
		


		
		
	}

}
