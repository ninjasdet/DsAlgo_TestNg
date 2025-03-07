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


import utilities.ExcelReader;
import utilities.LoggerLoad;

import pages.LoginPage;
import base.TestBase;
import utilities.ConfigReader;

public class LoginTests extends TestBase{
	
	static ConfigReader configReader;
	//String url ;
	//HomePage homePage;
	LoginPage loginPage;
	List<Map<String,String>> excelData;

	@BeforeClass(alwaysRun = true)
	public void beforeSuite() throws InvalidFormatException, IOException {
		System.out.println("BeforeSuite: Setting up the config reader");
		configReader=new ConfigReader();
		ExcelReader reader=new ExcelReader();
		excelData = reader.getData(ConfigReader.getProperty("excelPath"),"LoginValid");
	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(@Optional("chrome") String browser) {
		loginPage= new LoginPage();
		loginPage.getLoginBtnURL();
		
	}
	
	@Test(groups = {"login","smoke","regression"}, priority =1 ,dataProvider = "loginpage")
	public void testValidLogin(Map<String,String> data) {
		LoggerLoad.info("Valid Login test.");	       
		String username=data.get("Username");
		String password=data.get("Password");
		String message=data.get("ExpectedMessage");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

		// Click login button
		loginPage.clickLogin();
		String actualMessage = loginPage.getSuccessMsg();
		System.out.println(actualMessage);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test(groups = {"login","regression"}, priority =2 ,dataProvider = "loginpage")
	public void testInValidLogin(Map<String,String> data) {
		LoggerLoad.info("Invalid Login test");	        
		String username=data.get("Username");
		String password=data.get("Password");
		String message=data.get("ExpectedMessage");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		String actualMessage = loginPage.getSuccessMsg();
		LoggerLoad.info(actualMessage);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	@Test(groups = {"login"}, priority =3)
	public void testEmptyLogin() {
		LoggerLoad.info("Empty Login test");	        
		String username="";
		String password="";
		String message="Login";
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		String title = loginPage.validatePageTitle();
		LoggerLoad.info(title);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, title);
	}
	@Test(groups = {"login","smoke","regression"}, priority =4,dataProvider = "loginpage")
	public void testSignout(Map<String,String> data) {
		LoggerLoad.info("Signout test.");	        
		String username=data.get("Username");
		String password=data.get("Password");
		String message="Logged out successfully";
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		loginPage.signOutBtnClick();
		String title = loginPage.getLogoutSuccessMessage();
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, title);
	}
	@DataProvider (name="loginpage") 
	public Object[][] loginpage(ITestNGMethod testContext) throws Exception {
		ExcelReader reader=new ExcelReader();
		//ExcelReader reader = new ExcelReader(ConfigReader.getProperty("excelPath"));
		if((testContext.getMethodName().equals("testValidLogin"))||(testContext.getMethodName().equals("testSignout")))
		{
			excelData = reader.getData(ConfigReader.getProperty("excelPath"),"LoginValid");
		}
		else
		{

			excelData = reader.getData(ConfigReader.getProperty("excelPath"),"LoginInvalid");
		}
		Object[][] xlData=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
			xlData[i] = new Object[1];
			xlData[i][0] = excelData.get(i);
		} 
		return xlData;
	}
	

	
	
}
