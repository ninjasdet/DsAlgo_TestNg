package testCases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;

import base.TestBase;
import pages.GraphPage;

import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelReader;



public class GraphTests extends TestBase{
	//static ConfigReader configReader;
	
	//Map<String, String> keyPair;
		
	
		
	@BeforeClass
	public void excelLoginData() throws IOException, InvalidFormatException {
		LoginPage loginPage=new LoginPage();
		GraphPage graphPage;
		String username;
		String password;
		ConfigReader configReader;
		configReader=new ConfigReader();
		List<Map<String,String>> excelData;
		ExcelReader reader=new ExcelReader();
		excelData = reader.getData(ConfigReader.getProperty("excelPath"),"LoginValid");
		username = reader.getCellData("LoginValid", 1, 0);
		password = reader.getCellData("LoginValid", 1, 1);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

		// Click login button
		loginPage.clickLogin();
		
	}
	
}


	
	
