package testCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.TestBase;
import driverManager.DriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class RegisterTests extends TestBase {
	private static final String Passwordconfirmation = null;
	static ConfigReader configReader;
	LoginPage loginPage;
    RegisterPage registerpage;
    List<Map<String, String>> excelData;
    ExcelReader reader = new ExcelReader();

	@BeforeClass(alwaysRun = true)
	public void beforeSuite() throws InvalidFormatException, IOException {
		System.out.println("BeforeSuite: Setting up the config reader");
		configReader = new ConfigReader();
		ExcelReader reader = new ExcelReader();
		reader = new ExcelReader();

	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(@Optional("chrome") String browser) {

		registerpage = new RegisterPage();
		registerpage.getbaseUrl();
		registerpage.clickGetStartedButton();
		registerpage.clickRegister();
	}

	@Test(groups = { "register", "smoke", "regression" }, priority = 1, dataProvider = "RegisterValid")
	public void testRegisterValid(Map<String, String> data) {
		// 1. Navigate to the registration page

		LoggerLoad.info("RegisterValid");
		registerpage.getbaseUrl();
		registerpage.clickGetStartedButton();

		registerpage.clickRegister();

		String username = data.get("UserName"); // Note: Key is "UserName" in your Excel
		String password = data.get("password"); // Note: Key is "password" in your Excel
		String confirmPassword = data.get("Password Confirmation"); // Note: Key is "Password Confirmation" in your
																	// Excel
		String expectedMessage = data.get("Expectedmessage"); // Note: Key is "Expectedmessage" in your Excel

		// 3. Enter registration details
		registerpage.setUsername(username);
		registerpage.setPassword(password);
		registerpage.setConfirmPassword(confirmPassword);

		// 4. Click the Register button
		registerpage.getnewRegister();

		// 5. Get the actual success message
		String actualMessage = registerpage.getconfirmation(); // Assuming 'getErrorMsg()' returns the success message

		// 6. Assert that the actual message matches the expected message
		Assert.assertEquals(actualMessage, expectedMessage, "Registration failed for: " + username);
	}

	@Test(groups = { "register", "smoke", "regression" }, priority = 2, dataProvider = "RegisterInvalid")
	public void testRegisterInvalid(Map<String, String> data) {
		LoggerLoad.info("RegisterInvalid");
		registerpage.getbaseUrl();
		registerpage.clickGetStartedButton();

		registerpage.clickRegister();

		String username = data.get("UserName");
		String password = data.get("password");
		String confirmPassword = data.get("Password Confirmation");
		String expectedMessage = data.get("Expectedmessage");
		registerpage.setUsername(username);
		registerpage.setPassword(password);
		registerpage.setConfirmPassword(confirmPassword);
		// Add a null check for confirmPassword
		if (username != null) {
			registerpage.setUsername(username);
		}
		if (password != null) {
			registerpage.setPassword(password);
		}
		if (confirmPassword != null) {
			registerpage.setConfirmPassword(confirmPassword);

		}
		// 4. Click the Register button
		registerpage.getnewRegister();

		String actualMessage = registerpage.getErrorMsg();
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Error message does not contain expected text: " + expectedMessage);
		LoggerLoad.info("Actual message: " + actualMessage + ", Expected message: " + expectedMessage); // Keep this for
																										// logging

	}

	@DataProvider(name = "RegisterValid")
	public Object[][] RegistrationData() throws InvalidFormatException, IOException {
		// 1. Read data from Excel using your ExcelReader
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> excelData = reader.getData(ConfigReader.getProperty("excelPath"), "RegisterValid");
		// 2. Convert to Object
		Object[][] data = new Object[excelData.size()][1];
		for (int i = 0; i < excelData.size(); i++) {
			data[i][0] = excelData.get(i);
		}
		return data; // Return the 2D array
	}

	@DataProvider(name = "RegisterInvalid")
	public Object[][] registerInvalidData() throws InvalidFormatException, IOException {
		// 1. Read data from Excel using your ExcelReader
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> excelData = reader.getData(ConfigReader.getProperty("excelPath"), "RegisterInvalid");
		// 2. Convert to Object
		Object[][] data = new Object[excelData.size()][1];
		for (int i = 0; i < excelData.size(); i++) {
			data[i][0] = excelData.get(i);
		}
		return data; // Return the 2D array
	}
}
