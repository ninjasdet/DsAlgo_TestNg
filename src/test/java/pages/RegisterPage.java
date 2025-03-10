package pages;


	import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.ConfigReader;
import driverManager.DriverManager;
import utilities.ExcelReader;
import utilities.LoggerLoad;
public class RegisterPage {
	
	public WebDriver driver = DriverManager.getDriver();
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
		//WebDriver driver;
		RegisterPage registerpage;
	    String baseUrl = ConfigReader.getProperty("baseUrl"); // You can use the URL from config file
	 
		
		 ExcelReader excelUtils;
		 String currentUrl;
	
		// Locate the iframe
	    @FindBy(xpath = "//iframe[@id='iframe_id_or_index']")
	    WebElement iframe;
	    // Locate the Register link inside the iframe
	           @FindBy(xpath = "//a[text()='Register']")
	            WebElement registerLink;
	    @FindBy(xpath = "//a[normalize-space()='Register']")
		 WebElement btnRegisterLink;
	  
	  
		       @FindBy(xpath="'//a[normalize-space()='Register']")
			    WebElement btnregisterLink;
		     
			   @FindBy(xpath="//button[normalize-space()='Get Started']")
			    WebElement btnGetStarted;
			
			   @FindBy(xpath="//input[@id='id_username']")
				WebElement txtusername;
			 
			   @FindBy(xpath="//input[@id='id_password1']")
				WebElement txtpassword1;
			 
			   @FindBy(xpath="//input[@id='id_password2']")
				WebElement txtpassword2;
			 
			   @FindBy(xpath="//a[@href='/register']")
				WebElement btnRegister;
			   
			   @FindBy(xpath="//input[@value='Register']")
				WebElement btnfornewRegister;
			 
			   @FindBy(xpath="//div[@role='alert']")
				WebElement msgConfirmation;
			   @FindBy(xpath=" //div[@role='alert']")
			   WebElement txterrormessage;
			   @FindBy(id = "usernameError")
			   WebElement usernameError; // Error for username field
			    @FindBy(id = "passwordError")
			    WebElement passwordError; // Error for password field
			    @FindBy(id = "confirmPasswordError")
			    WebElement confirmPasswordError; // Error for confirm password field
			    @FindBy( xpath= "//div[@role='alert']")
			    WebElement messageElement; // Global error message
			    @FindBy(xpath = "//button[normalize-space()='Get Started']")
				 WebElement getStartedBtn;

			    public void getbaseUrl() {
					driver.get(ConfigReader.getProperty("baseUrl"));
					//getStartedBtn.click();
					LoggerLoad.info("in baseUrl");
				}
			  
			 
			   public void getRegisterURL() {
			    	
			    	driver.get(ConfigReader.getProperty("registerUrl"));
			    	
			    }
			   public void getUStartedButtonClick() {
					getStartedBtn.click();
					LoggerLoad.info("Clicked Get started");
				}
			   public void getnewRegister() {
				   btnfornewRegister.click();
					LoggerLoad.info("Clicked Get started");
				}
			 
			   public void clickGetStartedButton()
			    {
				   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    	//btnGetStarted
			    	wait.until(ExpectedConditions.visibilityOf(btnGetStarted)).click();
			    }
			 
			   public void switchToIframe() {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
			    }
			   public void clickRegisterLink() {
				   //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				   btnRegisterLink.click();
			        //driver.switchTo().defaultContent(); // Switch back to the main page
			    }
			   public boolean isUserOnRegisterPage() {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			        return wait.until(ExpectedConditions.urlToBe("https://dsportalapp.herokuapp.com/register"));
			    }
			    public void setUsername(String uname)
			    {
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        wait.until(ExpectedConditions.visibilityOf(txtusername));
			        try {
			            JavascriptExecutor js = (JavascriptExecutor) driver;
			            js.executeScript("arguments[0].value = '" + uname + "';", txtusername);
			            LoggerLoad.info("Entered username: " + uname);
			        } catch (Exception e) {
			            LoggerLoad.error("Error entering username: " + e.getMessage());
			            // Handle the exception appropriately (e.g., throw a custom exception)
			        }
			  

			    }
			  
			    public void setPassword(String pwd)
			    {
			    txtpassword1.sendKeys(pwd);
			 // Use JavascriptExecutor to set the password
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].value = '" + pwd + "';", txtpassword1);
			    	
			    }
			  
			    public void setConfirmPassword(String pwdConfirm)
			    {
			    txtpassword2.sendKeys(pwdConfirm);
			 // Use JavascriptExecutor to set the confirmation password
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].value = '" + pwdConfirm + "';", txtpassword2);
			    	
			    }
			  
			    public void clickRegister()
			    {
			    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		            wait.until(ExpectedConditions.visibilityOf(btnRegister));
			    btnRegister.click();		    	
			    }
			  
			  
			    public String getconfirmation(){
			    	try {
			    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			            wait.until(ExpectedConditions.visibilityOf(msgConfirmation));
			    		return (msgConfirmation.getText());
			    	}catch (Exception e) {
			    		return "Error: " + e.getMessage();
			    	}
			    }
			    	// Method to get the global error message
			        public String getGlobalMessageText() {
			        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        	wait.until(ExpectedConditions.visibilityOf(messageElement)); 
			        	return messageElement.getText();
			        }
			        // Method to get specific field error messages
			        public String getUsernameError() {
			            return usernameError.getText();
			        }
			        public String getPasswordError() {
			            return passwordError.getText();
			        }
			        public String getConfirmPasswordError() {
			            return confirmPasswordError.getText();
			        }
			        public String messageElement() {
					
					
					return txterrormessage.getText();
					}
			  
				public String getRegistrationMessage() {
					
					return null;
				}
				public void EnterValues(String username, String password, String passwordconfirmation) {
					  if (username != null && !username.isEmpty()) {
				        	registerpage.setUsername(username);
				        }
				        // Entering values in registration form
				        registerpage.setUsername(username); // Enter username
				        registerpage.setPassword(password); // Enter password
				        registerpage.setConfirmPassword(passwordconfirmation); // Enter confirmation password

				        // Click Register button
				        registerpage.clickRegister();
				        LoggerLoad.info("Register button clicked");

				       
				}
				
				public String getErrorMsg() {
				    try {
				        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']"))); // Replace with your locator
				        return errorMessageElement.getText();
				    } catch (Exception e) {
				        return null; // Or handle the exception appropriately
				    }
				}
				
			  
			  
	}

