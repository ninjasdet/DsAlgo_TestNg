package testCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;

import pages.LoginPage;
import pages.StackPage;
import utilities.ConfigReader;
import utilities.DataProviderClass;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class StackTests extends TestBase {
	LoginPage loginPage;
	StackPage stackPage;
	static ConfigReader configReader;
	List<Map<String, String>> excelData;
	ExcelReader reader = new ExcelReader();

	
	@BeforeSuite
	public void beforeSuite() throws InvalidFormatException, IOException {
		System.out.println("BeforeSuite: Setting up the config reader");
		configReader = new ConfigReader();
		excelData = reader.getData(ConfigReader.getProperty("excelPath"), "LoginValid");
		System.out.println("Excel file path: " + excelData);
	}

	@Parameters("browser")
	@BeforeMethod

	public void beforeMethod(@Optional("chrome") String browser) throws IOException, InvalidFormatException {
		loginPage = new LoginPage();
		stackPage = new StackPage();
		loginPage.getLoginBtnURL();
		if (!excelData.isEmpty()) {
			Map<String, String> firstRow = excelData.get(0); // Get the first row (index 0)
			String username = firstRow.get("Username"); // Extract Username
			String password = firstRow.get("Password"); // Extract Password

			System.out.println("Username: " + username);
			System.out.println("Password: " + password);
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickLogin();

		}
	}

	@Test(groups = { "stack" }, priority = 1)
	public void testStack() {
		stackPage.getStartStack();
		Assert.assertTrue(stackPage.isStackPageDisplayed(), "Failed to navigate to the Stack Data Structure page.");
		LoggerLoad.info("Redirected to stack page");
	}

	@Test(groups = { "stack" }, priority = 2)
	public void testOperationsinStacklink() {
		stackPage.getStartStack();
		stackPage.getoptsSlackURL();
		LoggerLoad.info("Operations in Stack button clicked");
		Assert.assertTrue(loginPage.getCurrentUrl().contains("operations-in-stack"), "not in operations_in_stack_page");
		LoggerLoad.info("redirected to Operations in Stack page");
	}

	@Test(groups = { "stack" }, priority = 3)
	public void testimplementationlink() {
		stackPage.getStartStack();
		stackPage.Implementation();
		LoggerLoad.info("Clicked the Implementation button");
		Assert.assertTrue(loginPage.getCurrentUrl().contains("implementation"), "not in implementation");
		LoggerLoad.info("redirected to Implementation page");
	}

	@Test(groups = { "stack" }, priority = 4)
	public void testapplicationslink() {
		stackPage.getStartStack();
		stackPage.applications();
		LoggerLoad.info("clicked Applications button");
		Assert.assertTrue(loginPage.getCurrentUrl().contains("applications"), "not in applications");
		LoggerLoad.info("Redirected to Applications page");
	}

	@Test(groups = { "stack" }, priority = 5)
	public void testpracticequestionslink() {
		stackPage.getStartStack();
		stackPage.applications();
		stackPage.clickPracticeQuestionsButton();
		LoggerLoad.info("clicked Practice Questions button");

	}

	@Test(groups = { "stack" }, priority = 6, dataProvider = "tryHereData", dataProviderClass = DataProviderClass.class)
	public void testTryHere(String inputCode, String expectedOutput) {

		stackPage.getStartStack();
		stackPage.getoptsSlackURL();
		stackPage.clickTryHere();
		stackPage.enterCode(inputCode);
		stackPage.clickRunButton();
		try {
			Alert alert = stackPage.alert();
			String alertText = alert.getText();
			Assert.assertFalse(alertText.isEmpty(), "Console output should not be empty, but it is.");

			alert.accept();
		} catch (Exception e) {
			String actualOutput = stackPage.getConsoleOutput();
			Assert.assertEquals(actualOutput, expectedOutput.trim(), "Output mismatch!");
		}

	}

}
