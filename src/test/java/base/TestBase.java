package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driverManager.DriverManager;
import utilities.LoggerLoad;

public class TestBase extends DriverManager{

	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) {
       	LoggerLoad.info("Loading the driver in  "+browser);
	
        // Set the URL for navigation
        String url = configReader.getApplicationUrl();
        System.out.println("inside testbase config reader");
        DriverManager.createDriver(browser);
        System.out.println(browser);
        WebDriver driver = DriverManager.getDriver();
        System.out.println("getting driver");
        driver.get(url);
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(configReader.getImplicitlyWait()));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}

   @AfterMethod
    public void tearDown() {
    	
    	LoggerLoad.info("-------------------------------------------------------");
    	DriverManager.quitDriver();
    	
    }
	
}
