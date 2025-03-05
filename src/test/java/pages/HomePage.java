package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import driverManager.DriverManager;
import utilities.LoggerLoad;

public class HomePage {

	public WebDriver driver = DriverManager.getDriver();

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[normalize-space()='You are at the right place']") 															
	WebElement portalLabel;

	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	WebElement dataStructuresDropdown;
	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement datastructures;
	@FindBy(xpath = "//a[@href='array']")
	WebElement getArray;
	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement getlinkedList;
	@FindBy(xpath = "//a[@href='tree']")
	WebElement getTree;
	@FindBy(xpath = "//a[@href='graph']")
	WebElement getGraph;

	public WebElement getDropdownOption(String option) {

		return driver.findElement(By.xpath("//a[normalize-space()='" + option + "']"));

	}

	@FindBy(xpath = "//div[@role='alert']") // Example element, modify as per actual page element
	WebElement notLoggedInMessage;

	public void getbaseUrl() {

		driver.get(ConfigReader.getProperty("baseUrl"));
		LoggerLoad.info("get the base url");
	}

	public boolean isOnDSAlgoPortal() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl().contains("dsportalapp"); // Check if "dsalgo" is part of the URL;
	}

	public boolean isNotLoggedInMessageDisplayed() {
		return notLoggedInMessage.isDisplayed();
	}

	public void getStartedDatastructure() {
		datastructures.click();

	}

	public void getArray() {
		getArray.click();

	}

	public void getlinkedList() {
		getlinkedList.click();

	}

	public void getTree() {
		getTree.click();

	}

	public void getGraph() {
		getGraph.click();

	}

}
