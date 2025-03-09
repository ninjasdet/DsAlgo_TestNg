package testCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.TestBase;
import pages.DataStructurePage;
import pages.LoginPage;
import pages.StackPage;
import utilities.ConfigReader;
import utilities.DataProviderClass;
import utilities.ExcelReader;
import utilities.LoggerLoad;
public class DataStructureTests extends TestBase {

	static ConfigReader configReader;

	DataStructurePage dataStructure;

	LoginPage loginPage;
	StackPage stackPage;
	List<Map<String, String>> excelData;
	ExcelReader reader = new ExcelReader();

	@BeforeClass(alwaysRun = true)
	public void beforeSuite() throws InvalidFormatException, IOException {
		configReader = new ConfigReader();
		excelData = reader.getData(ConfigReader.getProperty("excelPath"), "LoginValid");
	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(@Optional("chrome") String browser) throws IOException, InvalidFormatException {
		loginPage = new LoginPage();
		dataStructure = new DataStructurePage();
		stackPage = new StackPage();
		loginPage.getLoginBtnURL();
		if (!excelData.isEmpty()) {
			Map<String, String> firstRow = excelData.get(0); // Get the first row (index 0)
			String username = firstRow.get("Username"); // Extract Username
			String password = firstRow.get("Password"); // Extract Password
			LoggerLoad.info("Username:" + username);
		    LoggerLoad.info("Password: " + password);
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
		}
	}

	@Test(groups = { "datastructure" }, priority = 1)
	public void testDataStructureStart() {
		dataStructure.clickGetStarted();
		Assert.assertTrue(dataStructure.getCurrentUrl().contains("/data-structures-introduction"),
				"Data Structure Get Started navigation failed!");
	}

	@Test(groups = { "datastructure" }, priority = 2)
	public void testTimeComplexity() {
		dataStructure.getTimeComplixityPage();
		Assert.assertTrue(dataStructure.getCurrentUrl().contains("/time-complexity"),
				"Time Complexity navigation failed!");
	}

	@Test(groups = { "datastructure" }, priority = 3)
	public void testTryEditor() {
		dataStructure.getTimeComplixityPage();
		dataStructure.clickTryHere();
		Assert.assertTrue(dataStructure.getCurrentUrl().contains("/tryEditor"), "TryEditor navigation failed!");
	}

	@Test(groups = { "datastructure" }, priority = 4)
	public void testPracticeQuestions() {
		dataStructure.getPracticequestionPage();
		Assert.assertTrue(dataStructure.getCurrentUrl().contains("/practice"), "Practice questions navigation failed!");
	}

	// Method to test Tryeditor code for DataStructure
	@Test(groups = {"datastructure" }, priority = 3, dataProvider = "tryHereData", dataProviderClass = DataProviderClass.class)
	public void testTryHere(String inputCode, String expectedOutput) {
		dataStructure.getTimeComplixityPage();
		dataStructure.clickTryHere();// Click Try Here
		stackPage.enterCode(inputCode);
		stackPage.clickRunButton();
		try {
			Alert alert = stackPage.alert();
			String alertText = alert.getText();
			Assert.assertFalse(alertText.isEmpty(), "Console output should not be empty, but it is.");
			alert.accept(); // Close alert
		} catch (Exception e) {
			String actualOutput = stackPage.getConsoleOutput();
			Assert.assertEquals(actualOutput, expectedOutput.trim(), "Output mismatch!");
		}
		
			
	}
	
  
}

