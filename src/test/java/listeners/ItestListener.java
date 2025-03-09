package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import driverManager.DriverManager;
import utilities.ExtentReportManager;
import utilities.LoggerLoad;
import utilities.ScreenshotUtil;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ItestListener implements ITestListener
{

//--------extent report listeners code-----------	
	@Override
    public void onStart(ITestContext context) {
        LoggerLoad.info("Initializing Extent Reports...");
        ExtentReportManager.initReports();
    }
	
	@Override
    public void onTestStart(ITestResult result) {
        LoggerLoad.info("Starting Test: " + result.getName());
        ExtentReportManager.createTest(result.getName());
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
    }
	//----------end os extent report--------
	
	public void onTestSuccess(ITestResult result) {
		LoggerLoad.info("onTestSuccess Method" +result.getName());
		ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
	}
	
	
	public void onTestFailure(ITestResult result) {
		
		LoggerLoad.info("onTestFailure Method" +result.getName());
		 WebDriver driver = DriverManager.getDriver(); 
		 if (driver != null) {
		try {
			 LoggerLoad.info("Taking screenshot for failed test: " + result.getName());	
			 String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
			 LoggerLoad.info("Screenshot saved at: " + screenshotPath);
			 // Add screenshot to Extent Report
			 ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
	            ExtentReportManager.getTest().fail("Screenshot", 
	                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		
		}catch(Exception e) {
			e.printStackTrace();
		}
		 }
	
	}
	public void onTestSkipped(ITestResult result) {
		LoggerLoad.info("onTestSkipped Method" +result.getName());
		ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	}
	
	@Override
    public void onFinish(ITestContext context) {
        LoggerLoad.info("Finalizing Extent Reports...");
        ExtentReportManager.flushReports();
    }
}
