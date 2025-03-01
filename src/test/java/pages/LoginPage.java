package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class LoginPage {

	String currentUrl;
    WebDriverWait wait;
    
  // Using Page Factory annotations
    @FindBy (xpath = "//button[@class='btn']")
    private WebElement getStartedBtn;
  
    @FindBy (xpath = "//a[normalize-space()='Sign in']")
    private WebElement loginBtn;
    @FindBy(name = "username") 
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/form/input[4]")
    private WebElement loginButton;

  
 //   @FindBy(xpath = "//a[normalize-space()='Sign out']")
    @FindBy(xpath = "//a[@href='/logout' and text()='Sign out']")
 
    private WebElement signOutBtn;
    
    @FindBy(xpath="/html/body/div[2]")
    private WebElement signOutMsg;
    public WebDriver driver=DriverManager.getDriver();
    
    public LoginPage() {
    	  PageFactory.initElements(driver, this);
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
    public void getUStartedButtonClick()
    {
    	getStartedBtn.click();
    	LoggerLoad.info("Clicked Get started");
    }
	public void getHomeURL() {
    	
    	driver.get(ConfigReader.getProperty("baseUrl"));
    	getUStartedButtonClick();
    	LoggerLoad.info("in Home url");
    }
	
	public void getExcelPath(String excelPath)
	{
		driver.get(ConfigReader.getProperty("excelPath"));
		
		
	}
   
    public void getLoginBtn()
    {
    	loginBtn.click();
    	LoggerLoad.info("Clicked login button");
    }
    public void getLoginBtnURL()
    {  
    	//driver.get(ConfigReader.getProperty("baseUrl"));
    	getUStartedButtonClick();
    	getLoginBtn();
    }
    
    
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        LoggerLoad.info("entered username");
    }
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        LoggerLoad.info("entered password");
    }
    
    public void clickLogin() {
  
        loginButton.click();
    }
    
   
	public void signOutBtnClick() {
		//wait.until(ExpectedConditions.visibilityOf(signOutBtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement signOutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarCollapse\"]/div[2]/ul/a[3]")));
		signOutLink.click();
		//signOutBtn.click();
		 LoggerLoad.info("clicked sign out button");
	}
    public String getLogoutSuccessMessage()
    {
    	return signOutMsg.getText();
    	
    }	
 
 // Method to get the current URL
   public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
