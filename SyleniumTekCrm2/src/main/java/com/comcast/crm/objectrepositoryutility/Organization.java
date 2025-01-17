package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	WebDriver driver;
	public Organization  (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	@FindBy(name= "submit")
	private WebElement searchbtn;

}
