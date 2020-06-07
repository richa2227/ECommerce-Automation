package com.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonFunctions {

	public void uploadFile(WebElement element, String data) {

		element.sendKeys(data);
		}

		// This method sends data to element
		public void sendDataToElement(WebElement element, String data) {

		element.click();
		element.clear();
		element.sendKeys(data);
		element.sendKeys(Keys.TAB);
		}

		// This method returns element data
		public String getDataFromElement(WebElement element) {

		return element.getText();
		} 
		
		//This method hover the element 
		public void hoverElement(WebDriver driver,WebElement element) {
			
			Actions action = new Actions(driver);
			WebElement toHoverElement = element;
			action.moveToElement(toHoverElement);
			action.click().build().perform();
		}
		
		//This method switch the frame
		public void switchToFrame(WebDriver driver, WebElement element) {
			
			driver.switchTo().frame(element);
			
		}

		// This method returns element data which is not visible
		public String getDataFromElementInList(WebElement element) {

		return element.getAttribute("textContent").trim();
		}

		// This method clicks on element
		public void clickElement(WebElement element) {

		element.click();
		}

		// This method checks element visibility
		public Boolean isElementVisible(WebElement element) {
		try {
		return element.isDisplayed();
		} catch (Exception ex) {
		return false;
		}
		}

		// This method scroll Element Into View
//		public void scrollElementIntoView(WebDriver driver, WebElement element) throws InterruptedException {
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//		Thread.sleep(5000);
//		}

		// This method scroll Element Into View
		public void scrollToRight(WebDriver driver,WebElement element) throws InterruptedException {

	
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		// hoverOverRegistrar.perform();

		// Actions actions = new Actions(driver);
		// actions.moveToElement(element).build().perform();
		}

		// This method select value from list by text
		public void selectListValueByText(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);
		}

		// This method wait till element visibility
		public void waitTillElementVisibility(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		}

		// This method verifies element text
		public void verifyText(String actual, String expected) {
		Assert.assertEquals(actual, expected);
		}

		// This method gets Current Url
		public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
		}

		// This method checks element is checked or unchecked
		public Boolean verifyElementCheckedOrUnchecked(WebElement element) {

		if (element.isSelected())
		return true;
		else
		return false;
		}

		// THis method navigates back
		public void navigateBack(WebDriver driver) {
		driver.navigate().back();
		}

		public void verifyBooleanAssert(boolean actual, boolean expected) {
			// TODO Auto-generated method stub
			Assert.assertEquals(actual, expected);
			
		}
		
		public void pageDown(WebDriver driver) {
			
			Actions action = new Actions(driver);
			action.sendKeys(Keys.END).build().perform();
		}
}
