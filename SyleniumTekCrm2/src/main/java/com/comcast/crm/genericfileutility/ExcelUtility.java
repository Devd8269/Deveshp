package com.comcast.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new  FileInputStream("./tstData/TestDataForCrm1.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
String data=	wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	return data ;
}
public double getDataFromExcelNumeric(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream("./tstData/TestDataForCrm1.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	double data= wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
	return data;
}
public int  getRowcount(String sheetname) throws EncryptedDocumentException, IOException
{FileInputStream fis=new  FileInputStream("./tstData/TestDataForCrm1.xlsx");
Workbook wb=WorkbookFactory.create(fis);
int rowcount= wb.getSheet(sheetname).getLastRowNum();
wb.close();
return rowcount;

	}
public void setDataIntoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException
{FileInputStream fis=new  FileInputStream("./tstData/TestDataForCrm1.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
wb.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);

FileOutputStream fos= new FileOutputStream("./tstData/TestDataForCrm1.xlsx");
wb.write(fos);
fos.close();
	}
}
