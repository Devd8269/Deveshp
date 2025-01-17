package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
/**
 * @author deves
 * contains Login page element lib like login
 */
public class Login extends WebDriverUtility {
	WebDriver driver;
	public Login(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	// rule 2 object creation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
//Rule 3 object initilization
	//Rule 4 getter and setter() Encaptulation object

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Rule provide action
	/**
	 * Login to application based on username, password, url arguments
	 * @param username
	 * @param password
	 * @param url
	 */
	public void login(String username,String password,String url) {
		waitForPageToLoad(driver);
		driver.get(url);		
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
}
