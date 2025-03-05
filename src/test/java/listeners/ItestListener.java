package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import driverManager.DriverManager;
import utilities.LoggerLoad;
import utilities.ScreenshotUtil;

public class ItestListener implements ITestListener
{

	public void onTestSuccess(ITestResult result) {
		LoggerLoad.info("onTestSuccess Method" +result.getName());
	}
	public void onTestFailure(ITestResult result) {
		
		LoggerLoad.info("onTestFailure Method" +result.getName());
		 WebDriver driver = DriverManager.getDriver(); 
		 if (driver != null) {
		try {
			 LoggerLoad.info("Taking screenshot for failed test: " + result.getName());	
		ScreenshotUtil.takeScreenshot(driver, result.getName());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		 }
	
	}
	public void onTestSkipped(ITestResult result) {
		LoggerLoad.info("onTestSkipped Method" +result.getName());
	}
	
}
