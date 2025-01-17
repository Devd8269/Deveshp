package dataDrivenTek;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;
import com.comcast.crm.objectrepositoryutility.Organization;
import com.comcast.crm.objectrepositoryutility.OrganizationInfo;

public class DeleteOrgTest {
	public static void main(String[] args) throws IOException {
		
	
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
//Step 1 Login to app
//Login lp =PageFactory.initElements(driver, Login.class);

Login lp= new Login(driver);
//lp.login("admin", "admin");
//Step 2 navigate to org modul
Home hp= new Home(driver);
hp.getOrglink().click();
//step3 click on create new organization button
Organization op= new Organization(driver);
//op.getCreateNewOrganizationBtn().click();
CreatingNewOrganization cnp= new CreatingNewOrganization(driver);
cnp.createOrg(orgname);
//Step 4 Verify header msg
OrganizationInfo oip= new OrganizationInfo(driver);
String actorgname= oip.getHeadrmsg().getText();
if(actorgname.contains(orgname)) {
	System.out.println(orgname+" is verified == pass");
}
else {
	System.out.println(orgname+" is  not  verified ==fail");
	
}


//go bback organization page
//Home hp= new Home(driver);
hp.getOrglink().click();
//search for  organization 
oip.getSearchEdt().sendKeys(orgname);
wlib.select(oip.getSearchdropdown(), "Organization Name");
op.getSearchbtn().click();

//in dynamic webtable select & delete org
driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();


//Step logout
//Step logout
hp.logout();







}
}