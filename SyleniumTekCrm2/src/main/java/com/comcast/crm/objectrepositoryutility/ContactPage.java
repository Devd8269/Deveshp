package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
WebDriver driver;
public ContactPage(WebDriver driver)
{this.driver= driver;
PageFactory.initElements(driver,this);
	}
@FindBy(xpath = "//img[@title='Create Organization...']")
private WebElement createNewOrgBtn;
@FindBy(className="dvHeaderText")
private WebElement headermsg;

public WebElement getCreateNewOrgBtn() {
	return createNewOrgBtn;
}
@FindBy(xpath = "//input[@name='accountname']")
private WebElement orgNameEdt;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;
public WebElement getOrgNameEdt() {
	return orgNameEdt;
}
public WebElement getSavebtn() {
	return savebtn;
}
public WebElement getHeadermsg() {
	return headermsg;
}
@FindBy(xpath = "//a[text()='Contacts']")
private WebElement contactlink;
@FindBy(xpath = "//img[@title='Create Contact...']")
private WebElement newContatctBtn;
public WebDriver getDriver() {
	return driver;
}
public WebElement getContactlink() {
	return contactlink;
}
public WebElement getNewContatctBtn() {
	return newContatctBtn;
}
public void createorg(String orgname)
{orgNameEdt.sendKeys(orgname);
savebtn.click();


	}
}
