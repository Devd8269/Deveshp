package dataDrivenTek;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.listenerutility.ListenerImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;
import com.comcast.crm.objectrepositoryutility.Organization;
import com.comcast.crm.objectrepositoryutility.OrganizationInfo;
@Listeners(ListenerImpClass.class)
public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrganizationtest() throws IOException {
		
	
	//FileUtility fil= new FileUtility();
	//JavaUtility jlib= new JavaUtility();
	//ExcelUtility elib= new ExcelUtility();
	//WebDriverUtility wlib= new WebDriverUtility();
	
	//read common data from properties file
	//String browser=fil.getDataFromProperties("Browser");
	//String url=fil.getDataFromProperties("Url");
//System.out.println(browser);
UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
// read  test script data from excel file
String orgname= elib.getDataFromExcel("Sheet1",1, 2)+jlib.getRandomNumber();
System.out.println(orgname);
 
//Enter all details & create new organization
String startdate= jlib.getSystemDateYYYYDDMM();
String enddate=jlib.getrequiredDateYYYYDDMM(30);

//if(browser.equals("Chrome"))
//{driver= new ChromeDriver();
	//}
//if(browser.equals("Edge"))
//{driver= new EdgeDriver();
	//}
//if(browser.equals("Firefox"))
//{driver= new FirefoxDriver();
	//}

wlib.waitForPageToLoad(driver);
//driver.get(url);
//Step 1 Login to app
//Login lp =PageFactory.initElements(driver, Login.class);

//Login lp= new Login(driver);
//lp.login("admin","admin");
//Step 2 navigate to org modul
UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
Home hp= new Home(driver);
hp.getOrglink().click();
//step3 click on create new organization button
UtilityClassObject.getTest().log(Status.INFO, "navigate to create new org page");
Organization opp= new Organization(driver);
opp.getCreateNewOrgBtn().click();
CreatingNewOrganization cnp= new CreatingNewOrganization(driver);
cnp.createOrg(orgname);
UtilityClassObject.getTest().log(Status.INFO,orgname +"create new org");
//Step 4 Verify header msg
OrganizationInfo oip= new OrganizationInfo(driver);
String actorgname= oip.getHeadrmsg().getText();
boolean status= actorgname.contains(orgname);
Assert.assertEquals(status, true);


//hp.logout();







}
}