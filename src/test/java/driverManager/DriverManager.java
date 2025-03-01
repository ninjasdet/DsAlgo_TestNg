package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;

import utilities.ConfigReader;

public class DriverManager {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ConfigReader configReader;
	
	public DriverManager()
	{
		configReader=new ConfigReader();
	}
	
	public static WebDriver getDriver() {
		   return driver.get();
	}
	
	public static void createDriver(String browser) {
	    	WebDriver webDriver = null;
	    	System.out.println("inside driver manager:" +browser);
	        switch (browser.toLowerCase()) {
	            case "chrome":
	                webDriver = new ChromeDriver();
	                break;
	            case "firefox":
	                webDriver = new FirefoxDriver();
	                break;
	            case "edge":
	                webDriver = new EdgeDriver();
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported browser: " + browser);
	        }
	       
	        driver.set(webDriver);
	    }
	    public static void quitDriver() {
	        WebDriver webDriver = driver.get();
	        if (webDriver != null) {
	            webDriver.quit();
	            driver.remove();
	        }
	    }

}
