package dataDrivenTek;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Organization;
import com.comcast.crm.objectrepositoryutility.OrganizationInfo;

public class CreateOrganizationWithPhNoTest extends BaseClass {
	@Test
	public void createOrganizationWithPhno() throws EncryptedDocumentException, IOException {
		String orgname= elib.getDataFromExcel("Sheet1",1,2)+jlib.getRandomNumber();
	double Phno=elib.getDataFromExcelNumeric("Sheet1",1,4);
	System.out.println(Phno);
	wlib.waitForPageToLoad(driver);
	Home hp= new Home(driver);
	hp.getOrglink().click();
	Organization opp= new Organization(driver);
	opp.getCreateNewOrgBtn().click();
	CreatingNewOrganization cnp= new CreatingNewOrganization(driver);
	cnp.createOrgWithphno(orgname,Phno);
	OrganizationInfo oip= new OrganizationInfo(driver);
	String actorgname= oip.getHeadrmsg().getText();
	boolean status=actorgname.contains(orgname);
	Assert.assertEquals(status, true);
	
	}
	
	
	
	

}
