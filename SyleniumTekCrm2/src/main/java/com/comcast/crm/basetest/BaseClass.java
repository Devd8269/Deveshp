package com.comcast.crm.basetest;

import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;

public class BaseClass {
	
	public FileUtility fil= new FileUtility();
	public JavaUtility jlib= new JavaUtility();
	public ExcelUtility elib= new ExcelUtility();
	public WebDriverUtility wlib= new WebDriverUtility();
	public WebDriver driver= null;
	public static WebDriver sdriver= null;
	// Databseutility dblib= new DatabaseUtility();
	FileUtility flib= new FileUtility();
	
@BeforeSuite
public void configBs() {
	System.out.println(" connect to db, report config");
//dblib.getDbConnection();
	
}
@BeforeClass
public void configBC() throws IOException {
	System.out.println(" Launch the browser");
	String Browser=flib.getDataFromProperties("Browser");
	
	if(Browser.equals("Chrome"))
	{driver= new ChromeDriver();
		}
	if(Browser.equals("Edge"))
	{driver= new EdgeDriver();
		}
	if(Browser.equals("Firefox"))
	{driver= new FirefoxDriver();
		}
	sdriver=driver;
	UtilityClassObject.setDriver(driver);
	
}
@BeforeMethod
public void configBM() throws IOException{
	System.out.println("==login to app====");
	String url=flib.getDataFromProperties("Url");
	String username=flib.getDataFromProperties("Username");
	String password=flib.getDataFromProperties("Password");
	Login lp= new Login(driver);
	lp.login(username, password, url);
	
}
@AfterMethod
public void configAM() {
	System.out.println("==logout==");
	Home hp= new Home(driver);
	hp.logout();
}
@AfterSuite
public void AS() {
	//dblib.closeDbconnection();
	
}
@AfterClass
public void configAC(){
	System.out.println("==close the browser==");
	driver.quit();
}
}
