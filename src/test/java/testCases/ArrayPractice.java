package testCases;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Links;

import base.TestBase;
import pages.ArrayPage;
import pages.ArrayPracticePage;
import pages.LoginPage;
import pages.StackPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class ArrayPractice extends TestBase{
	
		
		LoginPage loginPage ;
		ArrayPracticePage arrayPracticepage;
		
		static ConfigReader configReader;
		List<Map<String,String>> excelData;
		ExcelReader reader=new ExcelReader();
		

@Parameters("browser")
@BeforeMethod(alwaysRun = true)
public void beforeMethod(@Optional("chrome") String browser) throws IOException, InvalidFormatException {
	configReader = new ConfigReader();
    excelData = reader.getData(ConfigReader.getProperty("excelPath"), "LoginValid");
	loginPage= new LoginPage();
	arrayPracticepage= new ArrayPracticePage();
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
        arrayPracticepage.clickGetStartedArray();
        arrayPracticepage.clickApplicationsofArray();
        arrayPracticepage.clickPracticeQuestions();
	}
	
	}
	


@DataProvider (name="arrayPracticepage") 
public Object[][] arrayPracticepage() throws Exception {
	ExcelReader reader=new ExcelReader();
    excelData = reader.getData(ConfigReader.getProperty("excelPath"),"PracticePage");
	Object[][] objArray=new Object[excelData.size()][];
	for(int i=0;i< excelData.size();i++){
        objArray[i] = new Object[1];
        objArray[i][0] = excelData.get(i);
      } 
     return objArray;
}

@Test (dataProvider = "arrayPracticepage",priority =1)		
public void checkArrayPracticePageLinksTest(Map<String,String> data) {
		String pageName=data.get("Links");
		String expectedResult=data.get("Expected Result");
		arrayPracticepage.checkArrayPracticePageLink(pageName);
		Assert.assertEquals(arrayPracticepage.validateArrayPracticePageTitles(), expectedResult);
	
}
@Test (dataProvider = "arrayPracticepage",priority =2)		    

public void checkArrayPracticePageTryEditorLinkswithInvalidCodeandClickRun(Map<String,String> data) throws InterruptedException{
	String pageName=data.get("Links");
	String invalidCode=data.get("InvalidCode");
	if(invalidCode!=null) {
		arrayPracticepage.checkArrayPracticePageLink(pageName);
		arrayPracticepage.Enter_inputCode(invalidCode);
		arrayPracticepage.click_run();
		Assert.assertEquals(arrayPracticepage.isAlertPresent(), true);
	}
}

@Test (dataProvider = "arrayPracticepage",priority =3)			
public void checkArrayPracticePageTryEditorLinkswithInvalidCodeandClickSubmit(Map<String,String> data)  {
String pageName=data.get("Links");
String invalidCode=data.get("InvalidCode");
if(invalidCode!=null) {
	arrayPracticepage.checkArrayPracticePageLink(pageName);
	arrayPracticepage.Enter_inputCode(invalidCode);
	arrayPracticepage.click_submit();

Assert.assertEquals(arrayPracticepage.get_outputText(), "Error occurred during submission");

}
}
@Test (dataProvider = "arrayPracticepage",priority =4)

public void checkArrayPageTryEditorLinkswithValidCodeTestandClickRunBTn(Map<String,String> data)   {
	String pageName=data.get("Links");
	String validCode=data.get("ValidCode");
	String expectedResult=data.get("Expected Result for Code");
	if(validCode!=null) {
		
		arrayPracticepage.checkArrayPracticePageLink(pageName);
		
		arrayPracticepage.Enter_inputCode(validCode);
		

		arrayPracticepage.click_run();
	    
		Assert.assertEquals(arrayPracticepage.get_outputText(), expectedResult);
	}
}

@Test (dataProvider = "arrayPracticepage",priority =5)
public void checkArrayPageTryEditorLinkswithValidCodeandClickSubmitBtn(Map<String,String> data)   {
	String pageName=data.get("Links");
	String validCode=data.get("ValidCode");

	if(validCode!=null) {
		arrayPracticepage.checkArrayPracticePageLink(pageName);
		arrayPracticepage.Enter_inputCode(validCode);
		//arrayPracticepage.click_run();
	
		arrayPracticepage.click_submit();
		Assert.assertEquals(arrayPracticepage.get_outputText(), "Submission Successful");
	}
}




}




