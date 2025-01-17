package com.comcast.crm.genericwebdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(  WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
public void switchToTabOnUrl(WebDriver driver, String partialURL) {
	Set<String> set= driver.getWindowHandles();
	Iterator<String> it= set.iterator();
	while(it.hasNext()){
		String windowId=it.next();
		driver.switchTo().window(windowId);
		String acturl=driver.getCurrentUrl();
		if(acturl.contains(partialURL)) {
			break;
		}}}
public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
	Set<String> set= driver.getWindowHandles();
	Iterator<String> it= set.iterator();
	while(it.hasNext()){
		String windowId=it.next();
		driver.switchTo().window(windowId);
		String acturl=driver.getTitle();
		if(acturl.contains(partialTitle)) {
			break;
		}}}
public void switchToFrame(WebDriver driver, int index)
{driver.switchTo().frame(index);
	}
public void switchToFrame(WebDriver driver, String nameId)
{driver.switchTo().frame(nameId);
	}
public void switchToFrame(WebDriver driver, WebElement element)
{driver.switchTo().frame(element);
	}
public void SwitchToAleartAndCancel(WebDriver driver)
{driver.switchTo().alert().dismiss();
	}
public void switchToAleartAndAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
	}
public void select(WebElement element,String text) {
	Select sel= new Select(element);
	sel.selectByVisibleText(text);
	
}
public void select(WebElement element, int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
	}
public void mouseMoveOnElement(WebDriver driver, WebElement element) {
	Actions actions= new Actions(driver);
	actions.moveToElement(element);
	
}
public void doubleClick(WebDriver driver, WebElement element) {
	Actions actions= new Actions(driver);
	actions.doubleClick(element);
}


}