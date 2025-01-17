package dataDrivenTek;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Login;

public class CreateContactTest {
public static void main(String[] args) throws IOException {
	//create object*
	FileUtility fil= new FileUtility();
	JavaUtility jlib= new JavaUtility();
	ExcelUtility elib= new ExcelUtility();
	WebDriverUtility wlib= new WebDriverUtility();
	
	//read common data from properties file
	String browser=fil.getDataFromProperties("Browser");
	String url=fil.getDataFromProperties("Url");
System.out.println(browser);

// read  test script data from excel file
String orgname= elib.getDataFromExcel("OrgName", 1, 2)+jlib.getRandomNumber();
 
//Enter all details & create new organization
String startdate= jlib.getSystemDateYYYYDDMM();
String enddate=jlib.getrequiredDateYYYYDDMM(30);
WebDriver driver= null;
if(browser.equals("Chrome"))
{driver= new ChromeDriver();
	}
if(browser.equals("Edge"))
{driver= new EdgeDriver();
	}
if(browser.equals("Firefox"))
{driver= new FirefoxDriver();
	}

wlib.waitForPageToLoad(driver);
driver.get(url);
//username passs submit button click
//2 navigate to organizaton module
//click on create organizaton button
// 4 enter all the details and create new ogrni acc name click
// verify header phone number info expected result
// 5 navigate to org module
// 6 click on create org button
//7 enter all the details and create new org 
// switch to child window
//wlib.switchToTabOnUrl(driver, "module=Accounts");
// switch to parent window
// verify header phone num info expected result
// verify header orgname info expected result 
//
// Step1 Login to app
Login lp= PageFactory.initElements(driver,Login.class);

}
}
