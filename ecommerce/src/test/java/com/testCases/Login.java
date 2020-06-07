package com.testCases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.pageObjects.RegistrationPage;
import com.utilities.BrowserSetUp;
import com.utilities.CommonFunctions;
import com.utilities.ReadWriteExcel;

public class Login extends BrowserSetUp {

	CommonFunctions page = new CommonFunctions();
	ReadWriteExcel excel = new ReadWriteExcel();

	public void userLogin(String baseUrl,String un,String pwd) throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		RegistrationPage registration = new RegistrationPage(driver);
		
		Sheet sheet = excel.readExcel("TestData.xls", "registrationData");
		Row row = sheet.getRow(1);

		page.clickElement(registration.signIn_btn);
		page.waitTillElementVisibility(driver, lp.loginEmail_txb);
		page.sendDataToElement(lp.loginEmail_txb, un);
		page.sendDataToElement(lp.loginPwd_txb, pwd);
		page.clickElement(lp.login_btn);
		
		page.waitTillElementVisibility(driver, lp.loggedInUserName);
		String loggedInUrl = page.getCurrentUrl(driver);
		page.verifyText(loggedInUrl,baseUrl+"/index.php?controller=my-account");
		page.verifyText(lp.loggedInUserName.getText(), row.getCell(0).getStringCellValue().trim()+" "+row.getCell(1).getStringCellValue().trim());
	}

}
