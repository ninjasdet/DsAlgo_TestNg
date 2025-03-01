package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import driverManager.DriverManager;

public class ScreenshotUtil {
	
	 public static void takeScreenshot(ITestResult result) {
		 WebDriver driver = DriverManager.getDriver();
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            // Save the screenshot with the scenario name
	            FileUtils.copyFile(screenshot, new File("target/screenshots/" + result.getName() + ".png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
}


