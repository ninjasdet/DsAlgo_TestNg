package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class DriverManager {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ConfigReader configReader;

	public DriverManager() {
		configReader = new ConfigReader();
	}

	public static void createDriver(String browser, boolean headless) {
		WebDriver webDriver;// = null;
		LoggerLoad.info("Inside DriverManager: " + browser + ", Headless: " + headless);
		// boolean headlessValue = configReader.isHeadless();
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			if (headless) {
				chromeOptions.addArguments("--headless=new");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.addArguments("--disable-extensions");
			}
			webDriver = new ChromeDriver(chromeOptions);
			break;
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			firefoxOptions.addArguments("--start-maximized");
//			if (headless) {
//				firefoxOptions.addArguments("--headless");
//				firefoxOptions.addArguments("--disable-gpu");
//			}
//			webDriver = new FirefoxDriver(firefoxOptions);
//			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");
			if (headless) {
				edgeOptions.addArguments("--headless");
				edgeOptions.addArguments("--disable-gpu");
			}
			webDriver = new EdgeDriver(edgeOptions);
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.set(webDriver);
	}

	public static WebDriver getDriver() {

		return driver.get();
	}

	public static void quitDriver() {
		WebDriver webDriver = driver.get();
		if (webDriver != null) {
			webDriver.quit();
			driver.remove();
		}
	}

}
