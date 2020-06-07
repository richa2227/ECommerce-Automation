package com.testCases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageObjects.RegistrationPage;
import com.utilities.BrowserSetUp;
import com.utilities.CommonFunctions;
import com.utilities.ReadWriteExcel;

public class RegistrationTest extends BrowserSetUp {
	
	CommonFunctions page = new CommonFunctions();
	ReadWriteExcel excel = new ReadWriteExcel();

	
	//Generate random email address
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(1000);
	public String randomEmail = "username"+ randomInt +"@yopmail.com";

//	emailTextBx.sendKeys("username"+ randomInt +"@gmail.com"); 
	
	@Parameters({"URL"})
	@Test
	public void registration(String baseUrl) throws IOException {
		
		RegistrationPage registration = new RegistrationPage(driver);
	
		Sheet sheet = excel.readExcel("TestData.xls", "registrationData");
		Row row = sheet.getRow(1);
		
		page.clickElement(registration.signIn_btn);
		String url = page.getCurrentUrl(driver);
		page.verifyText(url, baseUrl+"/index.php?controller=authentication&back=my-account");
		
		page.waitTillElementVisibility(driver, registration.createEmail_txb);
		page.sendDataToElement(registration.createEmail_txb, randomEmail);
		page.clickElement(registration.submit_btn);
		
		page.waitTillElementVisibility(driver, registration.firstName_txb);
		
		page.sendDataToElement(registration.firstName_txb, row.getCell(0).getStringCellValue().trim());
		page.sendDataToElement(registration.lastName_txb, row.getCell(1).getStringCellValue().trim());
		page.sendDataToElement(registration.pwd_txb, row.getCell(2).getStringCellValue().trim());
		page.sendDataToElement(registration.addressFirstName_txb, row.getCell(3).getStringCellValue().trim());
		page.sendDataToElement(registration.adressLastName_txb, row.getCell(4).getStringCellValue().trim());
		page.sendDataToElement(registration.address_txb, row.getCell(5).getStringCellValue().trim());
		page.sendDataToElement(registration.city_txb, row.getCell(6).getStringCellValue().trim());
		
		row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
		String zip = row.getCell(8).getStringCellValue();
		page.sendDataToElement(registration.postCode_txb, zip);
		
		row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
		String mobile = row.getCell(9).getStringCellValue();
		page.sendDataToElement(registration.mob_txb, mobile);
		
		page.selectListValueByText(registration.state_dropDown,row.getCell(7).getStringCellValue().trim());
		
		page.clickElement(registration.registration_btn);
		
		page.waitTillElementVisibility(driver, registration.verificationText);
		String loggedInUrl = page.getCurrentUrl(driver);
		page.verifyText(loggedInUrl, baseUrl+"/index.php?controller=my-account");


	}
	
	

}
