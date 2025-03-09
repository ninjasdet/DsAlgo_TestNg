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

public class DataStructurePage {

	public WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	LoginPage loginpage = new LoginPage();

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement getStartedButton;

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement dataStructure;

	@FindBy(xpath = "//h4[normalize-space()='Data Structures-Introduction']")
	WebElement datastructurePage;

	@FindBy(xpath = "//a[@class='list-group-item']")
	WebElement timeComplexitylink;

	@FindBy(xpath = "//p[normalize-space()='Time Complexity']")
	WebElement timeComplexityheadingpage;

	@FindBy(xpath = "//a[@class='btn btn-info']")
	WebElement tryhereButn;

	@FindBy(xpath = "//button[@type='button']")
	WebElement datastructureRun;

	@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")
	WebElement practiceQuestionsDsLnk;

	// Constructor
	public DataStructurePage() {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Navigate to base URL
	public void navigateToBaseUrl() {
		driver.get(ConfigReader.getProperty("baseUrl"));
	}

	// Click on Get Started button
	public void clickGetStarted() {
		wait.until(ExpectedConditions.elementToBeClickable(getStartedButton)).click();
	}

	// Verify Data Structure Introduction Page is displayed
	public boolean isDataStructurePageDisplayed() {
		return datastructurePage.isDisplayed();
	}

	// Click Time Complexity link
	public void clickTimeComplexity() {
		wait.until(ExpectedConditions.elementToBeClickable(timeComplexitylink)).click();
		LoggerLoad.info("User is in TimeComplixity page");
	}

	public void getTimeComplixityPage() {
		clickGetStarted();
		clickTimeComplexity();
	}

	public boolean istimecomplixityPageDisplayed() {
		return timeComplexityheadingpage.isDisplayed();
	}

	// Click Try Here button
	public void clickTryHere() {
		tryhereButn.click();
	}

	// Click Run button in Try Editor
	public void clickRunButton() {
		datastructureRun.click();
	}

	// Click Practice Questions link
	public void clickPracticeQuestions() {
		practiceQuestionsDsLnk.click();
		LoggerLoad.info("User is navigated to practice questions page");
	}

	public void getPracticequestionPage() {
		clickGetStarted();
		clickTimeComplexity();
		clickPracticeQuestions();
	}

	// Method to get the current URL
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url" + currentUrl);
		return driver.getCurrentUrl();
	}
}
