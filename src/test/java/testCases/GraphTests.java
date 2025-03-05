package testCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.TestBase;
import pages.GraphPage;
import pages.LoginPage;
import pages.StackPage;
import utilities.ConfigReader;
import utilities.DataProviderClass;
import utilities.ExcelReader;

public class GraphTests extends TestBase {
	static ConfigReader configReader;
	GraphPage graphPage;
	LoginPage loginPage;
	StackPage stackpage;
	
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
		loginPage= new LoginPage();
		graphPage=new GraphPage();
		stackpage=new StackPage();
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


	@Test(groups = {"graph"}, priority =1)
	public void testGraphGetStarted() {
		graphPage.clickGetStartedGraph();
		Assert.assertTrue(graphPage.getCurrentUrl().contains("/notgraph"), "Graph Get Started navigation failed!");

	}
///graph
	@Test(groups = {"graph"}, priority =2)
	public void testGraphNavigation() {
		graphPage.insideGrapghPage();
		Assert.assertTrue(graphPage.getCurrentUrl().contains("/graph/graph"), "Inside Graphlink navigation failed");
	}

	@Test(groups = {"graph"}, priority =3)
	public void testGraphRepresentaionNavg() {
		
		graphPage.clickGetStartedGraph();
		graphPage.clickGraphRepresenation();
		Assert.assertTrue(graphPage.getCurrentUrl().contains("/graph-representations"),"GraphRepresenation navigation failed");

	}

	@Test(groups = {"graph"}, priority =4)
	public void testPractiseQuestionNavg() {
		graphPage.insideGrapghPage();
		graphPage.clickPracticeQuestion();
		Assert.assertTrue(graphPage.getCurrentUrl().contains("/practice"), "Practice question navigation failed");

	}
///practice
	@Test(groups = {"graph"}, priority =5)
	public void testGraphtryHerebutton() {
		graphPage.gettryEditorPage();
		Assert.assertTrue(graphPage.getCurrentUrl().contains("/tryEditor"),"Tryhere navigation failed");

	}

	//Method to test tryEditor with data in Graph page
	@Test(groups = {"graph"}, priority =5,dataProvider = "tryHereData",dataProviderClass = DataProviderClass.class)
    public void testTryHere(String inputCode, String expectedOutput) {
       // driver.findElement(By.xpath("//a[text()='Try here']")).click(); // Click Try Here
		graphPage.gettryEditorPage();// Click Try Here
		stackpage.enterCode(inputCode);
		stackpage.clickRunButton();
		try
		{
		Alert alert=stackpage.alert();
		String alertText=alert.getText();
		Assert.assertFalse(alertText.isEmpty(), "Console output should not be empty, but it is.");
		//Assert.assertTrue(alertText.contains("error"), "Expected alert with an error message.");
         alert.accept(); // Close alert
		}
		catch(Exception e)
		{
		 String actualOutput = stackpage.getConsoleOutput();
        Assert.assertEquals(actualOutput, expectedOutput.trim(), "Output mismatch!");
        }
		
		//Assert.fail("Expected an alert with an error message, but no alert appeared.");
        }
	}
		           
        
    


