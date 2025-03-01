package testCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import utilities.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import base.TestBase;
import utilities.ConfigReader;

public class LoginTests extends TestBase{
	
	static ConfigReader configReader;
	String url ;
	HomePage homePage;
	LoginPage loginPage;
	List<Map<String,String>> excelData;

	@BeforeSuite
	public void beforeSuite() throws InvalidFormatException, IOException {
		System.out.println("BeforeSuite: Setting up the config reader");
		configReader=new ConfigReader();
		ExcelReader reader=new ExcelReader();
		excelData = reader.getData(ConfigReader.getProperty("excelPath"),"LoginValid");
	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(@Optional("chrome") String browser) {
		System.out.println("inside before method");
		//setUp(browser);
		System.out.println("setup browser");
		loginPage= new LoginPage();
		
		loginPage.getLoginBtnURL();
		
	}
	
	@Test(groups = {"login","smoke","regression"}, priority =1 ,dataProvider = "loginpage")
	public void testValidLogin(Map<String,String> data) {
		System.out.println("Test (login): Executing testLogin valid.");	       
		String username=data.get("Username");
		String password=data.get("Password");
		String message=data.get("ExpectedMessage");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

		// Click login button
		loginPage.clickLogin();
//		String actualMessage = loginObj.getErrorMsg();
//		System.out.println(actualMessage);
//		String expectedMessage= message;
		//Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	
	@DataProvider (name="loginpage") 
	public Object[][] loginpage(ITestNGMethod testContext) throws Exception {
		ExcelReader reader=new ExcelReader();
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
	
//	@AfterMethod
//	public void tearDownDriver() {
//		tearDown();
//
//	}
	
	
}
