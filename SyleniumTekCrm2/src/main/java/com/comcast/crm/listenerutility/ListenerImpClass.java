package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;

public class ListenerImpClass implements ITestListener , ISuiteListener {
	
	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configuration");
		String time=new Date().toString().replace(" ","_").replace(":","_");
		//ISuiteListener.super.onStart(suite);
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		
		spark.config().setDocumentTitle("Crm Test suite Result");
		spark.config().setReportName("Crm Report");
		spark.config().setTheme(Theme.DARK);
		// add env env information and create test
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "windows_10");
		report.setSystemInfo("Browser","Chrome-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Backup");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========="+result.getMethod().getMethodName()+"======start=======");
		UtilityClassObject.setTest(test);
	 test= report.createTest(result.getMethod().getMethodName());
	 test.log(Status.INFO,result.getMethod().getMethodName()+"====Started======");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSuccess(result);
		System.out.println("=========="+result.getMethod().getMethodName()+"=======end======");
        test.log(Status.PASS, result.getMethod().getMethodName()+"=====Completed========");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String time=new Date().toString().replace(" ","_").replace(":","_");
	String testname=result.getMethod().getMethodName();
	TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
	// File screenshot= ts.getScreenshotAs(OutputType.FILE);
	 String filepath= ts.getScreenshotAs(OutputType.BASE64);
	//File dest= new File("C:\\Users\\deves\\eclipse-workspace\\SyleniumTekCrm\\src\\test\\resources\\errorshots"+testname+time+"screenshot.png");
	test.addScreenCaptureFromBase64String(filepath,testname+time);
	test.log(Status.FAIL, result.getMethod().getMethodName()+"=====Failed========");
	
	}
	
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		//test.log(Status.SKIP, result.getMethod().getMethodName()+"=====Skipped========");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		report.flush();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	

}
