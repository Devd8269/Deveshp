package dataDrivenTek;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContact;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.OrganizationInfo;

public class CreateContactWithOrgTest extends BaseClass {
	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		String lastname= elib.getDataFromExcel("Sheet1",1,5)+jlib.getRandomNumber();
		String orgname= elib.getDataFromExcel("Sheet1",1,2)+jlib.getRandomNumber();
		wlib.waitForPageToLoad(driver);
		Home hp= new Home(driver);
		hp.getOrglink().click();
		ContactPage cp= new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();
		cp.createorg(orgname);
		OrganizationInfo oip= new OrganizationInfo(driver);
		String actorgname= oip.getHeadrmsg().getText();
		boolean status=actorgname.contains(orgname);
		Assert.assertEquals(status, true);
		cp.getContactlink().click();
		cp.getNewContatctBtn().click();
	CreatingNewContact cnp= new CreatingNewContact(driver);
	cnp.getLastnameEdt().sendKeys(lastname);
	cnp.getOrgnamedropdown().click();
	wlib.switchToTabOnUrl(driver, "module=Accounts&action");
	cnp.getSearchEdt().sendKeys(orgname);
    cnp.getSearchBtn().click();
	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	wlib.switchToTabOnUrl(driver, "module=Contacts&action");
	cnp.getSaveBtn().click();
	ContactInfoPage cip=new  ContactInfoPage(driver);
	String Actinfo=cip.getHeadrmsg().getText();
	boolean status2=Actinfo.contains(lastname);
	Assert.assertEquals(status2,true);
	
	
	
		
		
		
		
		
		
	}

}
