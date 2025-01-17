package dataDrivenTek;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.comcast.crm.genericfileutility.ExcelUtility;

public class PracScript {
public static void main(String[] args) throws IOException {
	ExcelUtility elib= new ExcelUtility();
	elib.setDataIntoExcel("Sheet1",1,7,"dubey");
  
}
}
