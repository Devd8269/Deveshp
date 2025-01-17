package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	WebDriver driver;
	public OrganizationInfo (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getHeadrmsg() {
		return headrmsg;
	}
	@FindBy(className="dvHeaderText")
	private WebElement headrmsg;
	@FindBy(name="search_text")
	private WebElement searchEdt;
	@FindBy(name="search_field")
	private WebElement searchdropdown;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchdropdown() {
		return searchdropdown;
	}

}
