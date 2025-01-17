package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganization {
	WebDriver driver;
	public CreatingNewOrganization  (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industrydropdown;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(id="phone")
	private WebElement orgPhonNoEdt;
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}
	public WebElement getOrgPhonNoEdt() {
		return orgPhonNoEdt;
	}
	public void createOrg(String orgname) {
		orgNameEdt.sendKeys(orgname);
		savebtn.click();
	}

	public void createOrg(String orgname,String industry) {
		orgNameEdt.sendKeys(orgname);
		Select sel= new Select(industrydropdown);
		sel.selectByVisibleText(industry);
		savebtn.click();
	}
	public void createOrgWithphno(String orgname, double  PhoneNo) {
		String phno=Double.toString(PhoneNo);
		orgNameEdt.sendKeys(orgname);
	    orgPhonNoEdt.sendKeys(phno);
		savebtn.click();
	}
}
