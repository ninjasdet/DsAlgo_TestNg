package pages;

import java.time.Duration;


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
	@FindBy(xpath = "//button[@class='btn']")
	private WebElement getStartedBtn;

	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	private WebElement loginBtn;
	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/form/input[4]")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement successMsg;

	@FindBy(xpath = "/html/body/div[2]")
	private WebElement signOutMsg;
	@FindBy(xpath = "//a[@href='/logout']")

	private WebElement signOutclick;

	public WebDriver driver = DriverManager.getDriver();

	public LoginPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
//	public LoginPage() {
//    	this.driver = DriverManager.getDriver();
//    	if (this.driver == null) {
//            throw new IllegalStateException("WebDriver is null in LoginPage!");
//        }
//    	  PageFactory.initElements(driver, this);
//    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	}

	public void getUStartedButtonClick() {
		getStartedBtn.click();
		LoggerLoad.info("Clicked Get started");
	}

	public void getHomeURL() {

		driver.get(ConfigReader.getProperty("baseUrl"));
		getUStartedButtonClick();
		LoggerLoad.info("in Home url");
	}

	public void getExcelPath(String excelPath) {
		driver.get(ConfigReader.getProperty("excelPath"));

	}

	public String getSuccessMsg() {

		return successMsg.getText();
	}

	public void getLoginBtn() {
		loginBtn.click();
		LoggerLoad.info("Clicked login button");
	}

	public void getLoginBtnURL() {

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

		wait.until(ExpectedConditions.visibilityOf(signOutclick)).click();

	}

	public String getLogoutSuccessMessage() {
		return signOutMsg.getText();

	}

	// Method to get the current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String validatePageTitle() {

		return driver.getTitle();
	}
}
