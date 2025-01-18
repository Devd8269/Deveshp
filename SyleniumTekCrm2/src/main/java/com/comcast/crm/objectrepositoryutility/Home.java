package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[text()='Sign Out']")
	private	WebElement signoutlink;
	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getAdmninimage() {
		return admninimage;
	}
	@FindBy(linkText = "Organizations")
private	WebElement orglink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private	WebElement admninimage;
	@FindBy(linkText = "Contacts")
	private	WebElement contactlink;
	@FindBy(linkText = "Campaigns")
	private	WebElement campaignlink;
	@FindBy(linkText = "More")
	private	WebElement morelink;
	@FindBy(linkText="products")
private WebElement productlink;	
	public WebElement getProductlink() {
		return productlink;
	}

	public void naviagteToCampaignlink()
	{Actions acts= new Actions(driver);
	acts.moveToElement(morelink).perform();
	campaignlink.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}
	public void logout() {
		Actions act= new Actions(driver);
		act.moveToElement(admninimage).perform();
		signoutlink.click();
	}
}
