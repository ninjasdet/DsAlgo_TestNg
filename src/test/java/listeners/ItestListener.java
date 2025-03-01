package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.LoggerLoad;
import utilities.ScreenshotUtil;

public class ItestListener implements ITestListener
{

	public void onTestSuccess(ITestResult result) {
		LoggerLoad.info("onTestSuccess Method" +result.getName());
	}
	public void onTestFailure(ITestResult result) {
		
		LoggerLoad.info("onTestFailure Method" +result.getName());
		try {
		ScreenshotUtil.takeScreenshot(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	public void onTestSkipped(ITestResult result) {
		LoggerLoad.info("onTestSkipped Method" +result.getName());
	}
	
}
