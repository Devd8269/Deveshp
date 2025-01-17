package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContact {
	WebDriver driver;
	public CreatingNewContact  (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}
	@FindBy(xpath = "//img[@title='Select'][1]")
	private WebElement orgnamedropdown;

	public WebElement getStartdateEdt() {
		return startdateEdt;
	}

	public WebElement getEnddateEdt() {
		return enddateEdt;
	}

	public WebElement getOrgnamedropdown() {
		return orgnamedropdown;
	}
	@FindBy(name="support_start_date")
	private WebElement startdateEdt;
	@FindBy(name="support_end_date")
	private WebElement enddateEdt;
	@FindBy(id="search_txt")
	private WebElement searchEdt;

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	@FindBy(xpath = "//input[@type='button']")
	private WebElement searchBtn;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	@FindBy(xpath = "//input[@name='account_name']")
	private WebElement orgnameEdt;
	public void Createcontact(String lastname) {
		lastnameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	public void createcontact(String lastname,String orgname) {
		lastnameEdt.sendKeys(lastname);
		orgnameEdt.sendKeys(orgname);
		saveBtn.click();
	}

}
