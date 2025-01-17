package dataDrivenTek;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream("C:\\Users\\deves\\OneDrive\\Documents\\Book1.xlsx\\");
Workbook workbook= WorkbookFactory.create(fis);
Sheet sheet= workbook.getSheet("RegisterCredentials");
int rowcount= sheet.getLastRowNum();
Random random = new Random();
int randomint=random.nextInt(200);
for(int i = 1;i<=rowcount;i++)
{Row row = sheet.getRow(i);
String coulmn4data= row.getCell(4).toString();
String coulmn3data= row.getCell(3).toString() +randomint;
System.out.println(coulmn4data +"\t"+coulmn3data);
	}
workbook.close();
}
}
