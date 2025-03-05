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

import pages.GraphPage;
import pages.LoginPage;
import pages.StackPage;
import pages.TreePage;
import utilities.ConfigReader;
import utilities.DataProviderClass;
import utilities.ExcelReader;

public class TreeTests extends TestBase {

	static ConfigReader configReader;

	TreePage treePage;
	GraphPage graphPage;
	LoginPage loginPage;
	StackPage stackPage;
	List<Map<String, String>> excelData;
	ExcelReader reader = new ExcelReader();

	@BeforeSuite
	public void beforeSuite() throws InvalidFormatException, IOException {
		configReader = new ConfigReader();
		excelData = reader.getData(ConfigReader.getProperty("excelPath"), "LoginValid");
	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(@Optional("chrome") String browser) throws IOException, InvalidFormatException {
		loginPage = new LoginPage();
		loginPage.getLoginBtnURL();
		stackPage = new StackPage();
		treePage = new TreePage();

		if (!excelData.isEmpty()) {
			Map<String, String> firstRow = excelData.get(0);
			String username = firstRow.get("Username");
			String password = firstRow.get("Password");
			System.out.println("Username:" + username);
			System.out.println("Password:" + password);
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
		}
	}

	@Test(groups = { "tree" }, priority = 1)
	public void testTreeGetstarted() {
		treePage.clickGetstartedTree();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/tree"), "Tree Page Get Started navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 2)
	public void testOverviewoftreesNavg() {
		treePage.getOverviewOfPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/overview-of-trees"),
				"overview-of-trees Get Started navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 5)
	public void testTerminologiesNavg() {
		treePage.terminologiesPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/terminologies"), "terminologies navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 6)
	public void testTypesoftreesNavg() {
		treePage.typesOfTreePage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/types-of-trees"), "types-of-trees navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 7)
	public void testTreetraversalsNavg() {
		treePage.treTraversalsPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/tree-traversals"), "tree-traversals navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 8)
	public void testTraversalsillustrationNavg() {
		treePage.traversalsIllustrationPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/traversals-illustration"),
				"traversals-illustration navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 9)
	public void testBinarytreesNavg() {
		treePage.binaryTreesPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/binary-trees"), "binary-trees navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 10)
	public void testTypesofbinarytreesNavg() {
		treePage.typesofBinaryTreesPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/types-of-binary-trees"),
				"types-of-binary-trees navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 11)
	public void testImplementationinpythonNavg() {
		treePage.implementationinPythonPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/implementation-in-python"),
				"implementation-in-python navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 12)
	public void testBinarytreetraversalsNavg() {
		treePage.binaryTreeTraversalsPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/binary-tree-traversals"),
				"binary-tree-traversals navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 13)
	public void testImplementationofbinarytreesNavg() {
		treePage.implementationofBinaryTreesPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/implementation-of-binary-trees"),
				"implementation-of-binary-trees navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 14)
	public void testApplicationsofbinarytreesNavg() {
		treePage.applicationsofBinarytreesPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/applications-of-binary-trees"),
				"applications-of-binary-trees navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 15)
	public void testBinarysearchtreesNavg() {
		treePage.binarySearchTreesPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/binary-search-trees"),
				"binary-search-trees navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 16)
	public void testImplementationofbstNavg() {
		treePage.implementationOfBSTPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/implementation-of-bst"),
				"implementation-of-bst navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 3)
	public void testTryhereNavg() {
		treePage.getOverviewOfPage();
		treePage.tryherePage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/tryEditor"), "tryHere navigation failed!");
	}

	@Test(groups = { "tree" }, priority = 4)
	public void testPracticeNavg() {
		treePage.getPracticequestionsPage();
		Assert.assertTrue(treePage.getCurrentUrl().contains("/practice"), "practice questions navigation failed!");
	}

	// Method to test tryEditor with data in Tree page
	@Test(groups = { "tree" }, priority = 17, dataProvider = "tryHereData", dataProviderClass = DataProviderClass.class)
	public void testTryHere(String inputCode, String expectedOutput) {
		// driver.findElement(By.xpath("//a[text()='Try here']")).click(); // Click Try
		// Here
		treePage.getOverviewOfPage();
		treePage.tryherePage();// Click Try Here
		stackPage.enterCode(inputCode);
		stackPage.clickRunButton();
		try {
			Alert alert = stackPage.alert();
			String alertText = alert.getText();
			Assert.assertFalse(alertText.isEmpty(), "Console output should not be empty, but it is.");
			// Assert.assertTrue(alertText.contains("error"), "Expected alert with an error
			// message.");
			alert.accept(); // Close alert
		} catch (Exception e) {
			String actualOutput = stackPage.getConsoleOutput();
			Assert.assertEquals(actualOutput, expectedOutput.trim(), "Output mismatch!");
		}

		// Assert.fail("Expected an alert with an error message, but no alert
		// appeared.");
	}
}
