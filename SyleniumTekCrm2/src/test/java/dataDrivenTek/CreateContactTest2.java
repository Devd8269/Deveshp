package dataDrivenTek;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContact;
import com.comcast.crm.objectrepositoryutility.Home;

public class CreateContactTest2 extends BaseClass {
	@Test
	public void createcontact() throws EncryptedDocumentException, IOException {
		String lastname= elib.getDataFromExcel("Sheet1",1,5)+jlib.getRandomNumber();
	wlib.waitForPageToLoad(driver);
	Home hp= new Home(driver);
	hp.getContactlink().click();
	ContactPage cp= new ContactPage(driver);
	cp.getNewContatctBtn().click();
	CreatingNewContact cnp= new CreatingNewContact(driver);
	cnp.getLastnameEdt().sendKeys(lastname);
	cp.getSavebtn().click();
	ContactInfoPage cip=new  ContactInfoPage(driver);
	String Actinfo=cip.getHeadrmsg().getText();
	boolean status=Actinfo.contains(lastname);
	Assert.assertEquals(status,true);
	
	

}
}