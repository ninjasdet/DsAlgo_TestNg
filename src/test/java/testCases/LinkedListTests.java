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
import pages.LinkedListPage;
import pages.LoginPage;
import pages.StackPage;
import utilities.ConfigReader;
import utilities.DataProviderClass;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class LinkedListTests extends TestBase {

	LoginPage loginPage;
	LinkedListPage linkedlistpage;
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
		linkedlistpage = new LinkedListPage();
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

	@Test(groups = { "linkedlistpage" }, priority = 1)
	public void testLinkedList() {
		linkedlistpage.clickGetStartedLinkedList();
		Assert.assertTrue(linkedlistpage.isLinkedListPageDisplayed(), "Failed to navigate to the LinkedList page.");
		LoggerLoad.info("Redirected to LinkedList page");
	}

	@Test(groups = { "linkedlistpage" }, priority = 2)
	public void testIntroduction() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.clickGetstartedIntroduction();
		LoggerLoad.info(" Introduction button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("introduction"),
				"Failed to navigate to the introduction page.");
		LoggerLoad.info("redirected to introduction page");
	}

	@Test(groups = { "linkedlistpage" }, priority = 3)
	public void testTryhere() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.clickGetstartedIntroduction();
		linkedlistpage.Tryhere();
		LoggerLoad.info(" Tryhere button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("tryEditor"),
				"Failed to navigate to the tryEditor page.");
		LoggerLoad.info("redirected to tryEditor page");
	}

	@Test(groups = { "linkedlistpage" }, priority = 4)
	public void testCreatinglinkedlist() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.clickGetstartedIntroduction();
		linkedlistpage.CreatingLinkedList();
		LoggerLoad.info(" Creating linked list button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("creating-linked-list"),
				"Failed to navigate to the creating-linked-list page.");
		LoggerLoad.info("redirected to creating-linked-list page");
	}

	@Test(groups = { "linkedlistpage" }, priority = 5)
	public void testTypesoflinkedlist() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.TypesofLinkedList();
		LoggerLoad.info(" Types of linkedlist button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("types-of-linked-list"),
				"Failed to navigate to the types-of-linked-list page.");
		LoggerLoad.info("redirected to types-of-linked-list page");
	}

	@Test(groups = { "linkedlistpage" }, priority = 6)
	public void testImplementLinkedListinPython() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.clickGetstartedIntroduction();
		linkedlistpage.ImplementLinkedListinPython();
		LoggerLoad.info("  Implement Linked List in Python button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("implement-linked-list-in-python"),
				"Failed to navigate to the implement-linked-list-in-python page.");
		LoggerLoad.info("redirected to implement-linked-list-in-python page");
	}

	@Test(groups = { "linkedlistpage" }, priority = 7)
	public void testTraversal() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.clickGetstartedIntroduction();
		linkedlistpage.Traversal();
		LoggerLoad.info("Traversal button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("traversal"),
				"Failed to navigate to the traversal page.");
		LoggerLoad.info("redirected to traversal page");
	}

	@Test(groups = { "linkedlistpage" }, priority = 8)
	public void testInsertion() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.clickGetstartedIntroduction();
		linkedlistpage.Insertion();
		LoggerLoad.info("Insertion button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("insertion"),
				"Failed to navigate to the insertion-in-linked-list page.");
		LoggerLoad.info("redirected to insertion-in-linked-list page");
	}

	@Test(groups = { "linkedlistpage" }, priority = 9)
	public void testDeletion() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.clickGetstartedIntroduction();
		linkedlistpage.Deletion();
		LoggerLoad.info("Deletion button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("deletion"),
				"Failed to navigate to the deletion page.");
		LoggerLoad.info("redirected to deletion-in-linked-list");
	}

	@Test(groups = { "linkedlistpage" }, priority = 10)
	public void testPracticequestions() {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.Deletion();
		linkedlistpage.PracticeQuestions();
		LoggerLoad.info(" PracticeQuestions button clicked");
		Assert.assertTrue(linkedlistpage.getCurrentUrl().contains("practice"), "Failed to navigate to the practice");
		LoggerLoad.info("redirected to practice");
	}

	@Test(groups = {
			"linkedlistpage" }, priority = 11, dataProvider = "tryHereData", dataProviderClass = DataProviderClass.class)
	public void testTryHere(String inputCode, String expectedOutput) {
		linkedlistpage.clickGetStartedLinkedList();
		linkedlistpage.Deletion();
		linkedlistpage.Tryhere();
		linkedlistpage.enterCode(inputCode);
		linkedlistpage.Run();

		try {
			Alert alert = linkedlistpage.alert();
			String alertText = alert.getText();
			Assert.assertFalse(alertText.isEmpty(), "Console output should not be empty, but it is.");

			alert.accept(); // Close alert
		} catch (Exception e) {
			String actualOutput = linkedlistpage.getConsoleOutput();
			Assert.assertEquals(actualOutput, expectedOutput.trim(), "Output mismatch!");
		}

	}
}
