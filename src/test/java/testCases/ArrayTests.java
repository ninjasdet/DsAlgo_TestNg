package testCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ArrayPage;
import pages.LoginPage;
import pages.StackPage;
import utilities.ConfigReader;
import utilities.DataProviderClass;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class ArrayTests extends TestBase {

	LoginPage loginPage;
	ArrayPage arraypage;
	static ConfigReader configReader;
	List<Map<String, String>> excelData;
	ExcelReader reader = new ExcelReader();

	@BeforeClass(alwaysRun = true)
	public void beforeSuite() throws InvalidFormatException, IOException {
		System.out.println("BeforeSuite: Setting up the config reader");
		configReader = new ConfigReader();
		excelData = reader.getData(ConfigReader.getProperty("excelPath"), "LoginValid");

	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(@Optional("chrome") String browser) throws IOException, InvalidFormatException {
		loginPage = new LoginPage();
		arraypage = new ArrayPage();
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

	@Test(groups = { "array" }, priority = 1)

	public void testArray() {
		arraypage.clickGetStartedArray();
		Assert.assertTrue(arraypage.isArrayPageDisplayed(), "Failed to navigate to the Array page.");
		LoggerLoad.info("Redirected to Array page");
	}

	@Test(groups = { "array" }, priority = 2)
	public void testArraysinpython() {
		arraypage.clickGetStartedArray();
		arraypage.clickArraysinPython();
		LoggerLoad.info("Arrays in python page button clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("arrays-in-python"),
				"Failed to navigate to the arrays-in-python page.");
		LoggerLoad.info("redirected to Arrays in python page");
	}

	@Test(groups = { "array" }, priority = 3)
	public void testTryhere() {
		arraypage.clickGetStartedArray();
		arraypage.clickArraysinPython();
		arraypage.clickTryhere();
		LoggerLoad.info("Tryhere clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("tryEditor"),
				"Failed to navigate to the try_Editor page.");
		LoggerLoad.info("redirected to tryEditor page");
	}

	@Test(groups = { "array" }, priority = 4)
	public void arraysusingist() {
		arraypage.clickGetStartedArray();
		arraypage.clickArraysUsingList();
		LoggerLoad.info("arrays-using-list clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("arrays-using-list"),
				"Failed to navigate to the arrays-using-list page.");
		LoggerLoad.info("redirected to arrays-using-list page");

	}

	@Test(groups = { "array" }, priority = 5)
	public void basicoperationsinlists() {
		arraypage.clickGetStartedArray();
		arraypage.clickBasicOperationsinLists();
		LoggerLoad.info("basic-operations-in-lists clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("basic-operations-in-lists"),
				"Failed to navigate to the basic-operations-in-lists page.");
		LoggerLoad.info("redirected to basic-operations-in-lists page");

	}

	@Test(groups = { "array" }, priority = 6)
	public void applicationsofarray() {
		arraypage.clickGetStartedArray();
		arraypage.clickApplicationsofArray();
		LoggerLoad.info("applications-of-array clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("applications-of-array"),
				"Failed to navigate to the basic-operations-in-lists page.");
		LoggerLoad.info("redirected to applications-of-array page");

	}

	@Test(groups = { "array" }, priority = 7)
	public void practice() {
		arraypage.clickGetStartedArray();
		arraypage.clickApplicationsofArray();
		arraypage.clickPracticeQuestions();
		LoggerLoad.info("practice clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("practice"), "Failed to navigate to the practice page.");
		LoggerLoad.info("redirected to practice page");

	}

	@Test(groups = { "array" }, priority = 8)
	public void Searchthearray() {
		arraypage.clickGetStartedArray();
		arraypage.clickApplicationsofArray();
		arraypage.clickPracticeQuestions();
		arraypage.clickSearchthearray();
		LoggerLoad.info("Searchthearrayclicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("question/1"),
				"Failed to navigate to the question/1 page.");
		LoggerLoad.info("redirected to question/1 page");

	}

	@Test(groups = { "array" }, priority = 9)
	public void Maxconsecutiveones() {
		arraypage.clickGetStartedArray();
		arraypage.clickApplicationsofArray();
		arraypage.clickPracticeQuestions();
		arraypage.clickMaxConsecutiveOnes();
		LoggerLoad.info("MaxconsecutiveOnes clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("question/2"),
				"Failed to navigate to the question/2 page.");
		LoggerLoad.info("redirected to question/2 page");

	}

	@Test(groups = { "array" }, priority = 10)
	public void Findnumberwithevennumberofdigits() {
		arraypage.clickGetStartedArray();
		arraypage.clickApplicationsofArray();
		arraypage.clickPracticeQuestions();
		arraypage.clickFindNumberswithEvenNumberofDigits();
		LoggerLoad.info("Findnumberwithevennumber clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("question/3"),
				"Failed to navigate to the question/3 page.");
		LoggerLoad.info("redirected to question/3 page");

	}

	@Test(groups = { "array" }, priority = 11)
	public void Squaresofasortedarray() {
		arraypage.clickGetStartedArray();
		arraypage.clickApplicationsofArray();
		arraypage.clickPracticeQuestions();
		arraypage.clickSquaresof();
		LoggerLoad.info(" Squaresofasortedarray clicked");
		Assert.assertTrue(arraypage.getCurrentUrl().contains("question/4"),
				"Failed to navigate to the question/4 page.");
		LoggerLoad.info("redirected to question/4 page");

	}

	@Test(groups = {
			"arraypage" }, priority = 12, dataProvider = "tryHereData", dataProviderClass = DataProviderClass.class)
	public void testTryHere(String inputCode, String expectedOutput) {
		arraypage.clickGetStartedArray();
		arraypage.clickArraysinPython();
		arraypage.clickTryhere();
		arraypage.enterCode(inputCode);
		arraypage.clickRun();

		try {
			Alert alert = arraypage.alert();
			String alertText = alert.getText();
			Assert.assertFalse(alertText.isEmpty(), "Console output should not be empty, but it is.");

			alert.accept(); // Close alert
		} catch (Exception e) {
			String actualOutput = arraypage.getConsoleOutput();
			Assert.assertEquals(actualOutput, expectedOutput.trim(), "Output mismatch!");
		}

	}

}
