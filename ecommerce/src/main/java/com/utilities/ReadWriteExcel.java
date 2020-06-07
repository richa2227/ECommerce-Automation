package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadWriteExcel {
	
	public Sheet readExcel(String fileName, String sheetName) throws IOException {

		// Create an object of File class to open xlsx file
		String dataFilePath = System.getProperty("user.dir");

		File file = new File(dataFilePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xls file

		if (fileExtensionName.equals(".xls")) {

		// If it is xls file then create object of HSSFWorkbook class
		workbook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name

		Sheet sheet = workbook.getSheet(sheetName);
		return sheet;
		// Find number of rows in excel file
		}

		public String getData(Sheet sheet, String columnName) {
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it

		String name = "";
		for (int i = 0; i < rowCount + 1; i++) {

		Row row = sheet.getRow(i);
		if (row.getCell(0).getStringCellValue().equals(columnName)) {
		name = row.getCell(1).getStringCellValue();
		break;
		}
		}
		return name;
		}

		public void setData(String fileName,String sht,int rn,int cn,String val) throws Exception{

		String dataFilePath = System.getProperty("user.dir");// Create an object of File class to open xlsx file
		File file = new File(dataFilePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);// Create an object of FileInputStream class to read excel file

		Workbook wb = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));



		if (fileExtensionName.equals(".xls")) { // Check condition if the file is xls file

		// If it is xls file then create object of HSSFWorkbook class

		wb = new HSSFWorkbook(inputStream);//Access the workbook

		}

		Sheet worksheet = wb.getSheet(sht); //Access the worksheet, so that we can update / modify it.

		Cell cell = null; // declare a Cell object

		cell = worksheet.getRow(rn).createCell(cn); // Access the second cell in second row to update the value

		cell.setCellValue(val); // Get current cell value value and overwrite the value

		inputStream.close(); //Close the InputStream

		FileOutputStream output_file =new FileOutputStream(file); //Open FileOutputStream to write updates

		wb.write(output_file); //write changes

		output_file.close(); //close the stream
		}

	

}
