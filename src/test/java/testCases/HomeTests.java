package testCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.QueuePage;
import pages.StackPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class HomeTests extends TestBase{
	LoginPage loginPage ;
	HomePage homePage;
	StackPage stackPage;
	QueuePage queuePage;
	static ConfigReader configReader;
	List<Map<String,String>> excelData;
	ExcelReader reader=new ExcelReader();
	@BeforeClass(alwaysRun = true)
	public void beforeSuite() throws InvalidFormatException, IOException {
		System.out.println("BeforeSuite: Setting up the config reader");
		configReader=new ConfigReader();
		excelData = reader.getData(ConfigReader.getProperty("excelPath"),"LoginValid");
		System.out.println("Excel file path: " + excelData);
	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)

	public void beforeMethod(@Optional("chrome") String browser) throws IOException, InvalidFormatException {
		loginPage= new LoginPage();
		homePage = new HomePage();
		stackPage = new StackPage();
		queuePage = new QueuePage();
		loginPage.getHomeURL();
	}

	@Test(groups = {"home"}, priority =1)
	public void getStack() {
		stackPage.getStartStack();

		 Assert.assertTrue(homePage.isNotLoggedInMessageDisplayed(), "Error: 'You are not logged in' message is NOT displayed.");
		 LoggerLoad.info("Got the log out message");
	}
	@Test(groups = {"home"}, priority =2)
	public void getQueue() {
		queuePage.getStartQueue();
		 Assert.assertTrue(homePage.isNotLoggedInMessageDisplayed(), "Error: 'You are not logged in' message is NOT displayed.");
		 LoggerLoad.info("Got the log out message");
	}
	@Test(groups = {"home"}, priority =3)
	public void getDatastructure() {
		homePage.getStartedDatastructure();
		 Assert.assertTrue(homePage.isNotLoggedInMessageDisplayed(), "Error: 'You are not logged in' message is NOT displayed.");
		 LoggerLoad.info("Got the log out message");
	}
	@Test(groups = {"home"}, priority =4)
	public void getArray() {
		homePage.getArray();
		 Assert.assertTrue(homePage.isNotLoggedInMessageDisplayed(), "Error: 'You are not logged in' message is NOT displayed.");
		 LoggerLoad.info("Got the log out message");
	}
	@Test(groups = {"home"}, priority =5)
	public void getlinkedList() {
		homePage.getlinkedList();
		 Assert.assertTrue(homePage.isNotLoggedInMessageDisplayed(), "Error: 'You are not logged in' message is NOT displayed.");
		 LoggerLoad.info("Got the log out message");
	}
	@Test(groups = {"home"}, priority =6)
	public void getTree() {
		homePage.getTree();
		 Assert.assertTrue(homePage.isNotLoggedInMessageDisplayed(), "Error: 'You are not logged in' message is NOT displayed.");
		 LoggerLoad.info("Got the log out message");
	}
	@Test(groups = {"home"}, priority =7)
	public void getGraph() {
		homePage.getGraph();
		 Assert.assertTrue(homePage.isNotLoggedInMessageDisplayed(), "Error: 'You are not logged in' message is NOT displayed.");
		 LoggerLoad.info("Got the log out message");
	}
	@Test(groups = {"home"}, priority =8)
	public void getStartedStack() {
		perfLogin();
		stackPage.getStartStack();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("dsportalapp"), "User did not land on DSAlgo web application!");
		LoggerLoad.info("able to land on the DSAlgo web application");
           
		}
	@Test(groups = {"home"}, priority =9)
	public void getStartedQueuePage() {
		perfLogin();
		queuePage.getStartQueue();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("dsportalapp"), "User did not land on DSAlgo web application!");
		LoggerLoad.info("able to land on the DSAlgo web application");
           
		}
	
	@Test(groups = {"home"}, priority =10)
	public void getStartedArrayPage() {
		perfLogin();
		homePage.getArray();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("dsportalapp"), "User did not land on DSAlgo web application!");
		LoggerLoad.info("able to land on the DSAlgo web application");
           
		}
	@Test(groups = {"home"}, priority =11)
	public void getlinkedListPage() {
		perfLogin();
		homePage.getlinkedList();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("dsportalapp"), "User did not land on DSAlgo web application!");
		LoggerLoad.info("able to land on the DSAlgo web application");
           
		}
	
	@Test(groups = {"home"}, priority =12)
	public void getTreePage() {
		perfLogin();
		homePage.getTree();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("dsportalapp"), "User did not land on DSAlgo web application!");
		LoggerLoad.info("able to land on the DSAlgo web application");
           
		}
	
	@Test(groups = {"home"}, priority =13)
	public void getGraphPage() {
		perfLogin();
		homePage.getGraph();
		Assert.assertTrue(loginPage.getCurrentUrl().contains("dsportalapp"), "User did not land on DSAlgo web application!");
		LoggerLoad.info("able to land on the DSAlgo web application");
           
		}
   public void perfLogin()
   {
	   loginPage.getLoginBtn();
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
	@DataProvider (name="homepage") 
	public Object[][] homepage(ITestNGMethod testContext) throws Exception {
		ExcelReader reader=new ExcelReader();
		//ExcelReader reader = new ExcelReader(ConfigReader.getProperty("excelPath"));
		excelData = reader.getData(ConfigReader.getProperty("excelPath"),"LoginValid");
		Object[][] xlData=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
			xlData[i] = new Object[1];
			xlData[i][0] = excelData.get(i);
		} 
		return xlData;
	}
}
