package dataDrivenTek;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;
import com.comcast.crm.objectrepositoryutility.Organization;
import com.comcast.crm.objectrepositoryutility.OrganizationInfo;

public class CreateOrganizationWithIndustryTest extends BaseClass{
@Test
	public void CreateOrganizationWithIndustryTest() throws IOException {
		//object
	
	
		
		
		
		// read  test script data from excel file
		String orgname= elib.getDataFromExcel("Sheet1",1,2)+jlib.getRandomNumber();
		String industry= elib.getDataFromExcel("Sheet1",1,3);
		System.out.println(industry);
		System.out.println(orgname);
		//launch the browser
		
		wlib.waitForPageToLoad(driver);
		
		//Step 1 Login to appp
	
		//Step 2 navigate to org modul
		Home hp= new Home(driver);
		hp.getOrglink().click();
		//step3 click on create new organization button
		Organization opp= new Organization(driver);
		opp.getCreateNewOrgBtn().click();
		CreatingNewOrganization cnp= new CreatingNewOrganization(driver);
		cnp.createOrg(orgname,industry);
		//Step 4 Verify header msg
		OrganizationInfo oip= new OrganizationInfo(driver);
		String actorgname= oip.getHeadrmsg().getText();
		boolean status=actorgname.contains(orgname);
		//System.out.println(actorgname);
		Assert.assertEquals(status, true);
		//if(actorgname.contains(orgname)) {
			//System.out.println(orgname+" is verified == pass");
		//}
		//else {
			//System.out.println(orgname+" is  not  verified ==fail");
		//}

	

		
		
	
	}

}
