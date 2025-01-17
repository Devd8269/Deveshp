package practice;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.objectrepositoryutility.Login;

public class PPP {
	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		TakesScreenshot ts= (TakesScreenshot)driver;
		 File screenshot= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\deves\\eclipse-workspace\\SyleniumTekCrm\\src\\test\\resources\\errorshots"+"screenshot.png");
		org.openqa.selenium.io.FileHandler.copy(screenshot, dest);
	
	Login lp= new Login(driver);
	
	}

}
