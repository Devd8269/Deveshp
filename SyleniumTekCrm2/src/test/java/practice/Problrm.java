package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.comcast.crm.genericfileutility.ExcelUtility;

public class Problrm {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\deves\\Downloads\\Book1.xlsx");
		ExcelUtility elib= new ExcelUtility();
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		System.out.println(data);
	}

}
