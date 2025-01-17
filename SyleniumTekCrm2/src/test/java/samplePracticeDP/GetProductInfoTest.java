package samplePracticeDP;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.genericfileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandname,String productName) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
	//Search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	String	x="//span[text()='"+productName+"']/../../../..//span[@class='a-price-whole']";
		//capture product info
	String price= driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelUtility elib= new ExcelUtility();
		int rowcount=elib.getRowcount("product");
		
		Object[][] objarr=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++) {
		
		objarr[i][0]=elib.getDataFromExcel("product", i+1, 0);
		objarr[i][1]=elib.getDataFromExcel("product", i+1, 1);
		}
				return objarr;
		
	}

}
