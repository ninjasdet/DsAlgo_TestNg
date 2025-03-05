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
import pages.QueuePage;

import utilities.ConfigReader;
import utilities.DataProviderClass;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class QueueTests extends TestBase {
	LoginPage loginPage;
	QueuePage queuePage;
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
		queuePage = new QueuePage();
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

	@Test(groups = { "queue" }, priority = 1)
	public void testStack() {
		queuePage.getStartQueue();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("queue"), "not In Queue page");
		LoggerLoad.info("Redirected to Queue page");

	}

	@Test(groups = { "queue" }, priority = 2)
	public void clickImplementationQueuePython() {
		queuePage.getStartQueue();
		queuePage.clickImplementationQueuePython();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("implementation-lists"),
				"User is not redirected to Implementation of Queue in Python page.");
		LoggerLoad.info("redirected to implementation of queue in python");
	}

	@Test(groups = { "queue" }, priority = 3)
	public void clickImplementationCollectionsDeque() {
		queuePage.getStartQueue();
		queuePage.clickImplementationCollectionsDeque();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("implementation-collections"),
				"User is not redirected to Implementation using collections.deque page page");
		LoggerLoad.info("redirected to implementation using collections.deque");
	}

	@Test(groups = { "queue" }, priority = 4)
	public void clickImplementationUsingArray() {
		queuePage.getStartQueue();
		queuePage.clickImplementationUsingArray();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("Implementation-array"),
				"User is not redirected to Implementation using array");
		LoggerLoad.info("redirected to Implementation using array page");
	}

	@Test(groups = { "queue" }, priority = 5)
	public void clickQueueOperationsButton() {
		queuePage.getStartQueue();
		queuePage.clickQueueOperationsButton();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("QueueOp"), "User is not redirected to Queue Operations");
		LoggerLoad.info("redirected back to Queue Operations page");
	}

	@Test(groups = { "queue" }, priority = 6)
	public void clickPracticeQuestionsButtonQueue() {
		queuePage.getStartQueue();
		queuePage.clickQueueOperationsButton();
		queuePage.clickPracticeQuestionsButtonQueue();

		Assert.assertTrue(loginPage.getCurrentUrl().contains("practice"),
				"User is not redirected to the Practice page.");
		LoggerLoad.info("redirected to Practice page");
	}

	@Test(groups = { "queue" }, priority = 7, dataProvider = "tryHereData", dataProviderClass = DataProviderClass.class)
	public void testTryHere(String inputCode, String expectedOutput) {

		queuePage.getStartQueue();
		queuePage.clickQueueOperationsButton();
		queuePage.clickTryHere();
		queuePage.enterCode(inputCode);
		queuePage.clickRunButton();
		try {
			Alert alert = queuePage.alert();
			String alertText = alert.getText();
			Assert.assertFalse(alertText.isEmpty(), "Console output should not be empty, but it is.");

			alert.accept(); // Close alert
		} catch (Exception e) {
			String actualOutput = queuePage.getConsoleOutput();
			Assert.assertEquals(actualOutput, expectedOutput.trim(), "Output mismatch!");
		}

	}

}
