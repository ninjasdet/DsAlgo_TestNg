package pages;


	 import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
		import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import utilities.ConfigReader;
	import driverManager.DriverManager;
	import utilities.ExcelReader;
	import utilities.LoggerLoad;
		public class ArrayPage {
			public WebDriver driver = DriverManager.getDriver();
			LoginPage loginPage = new LoginPage();
			ExcelReader excelUtils;
			
	JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
			 
			 public ArrayPage() {
			        
			        PageFactory.initElements(driver, this);
			    }	
		
		     @FindBy(xpath="//button[normalize-space()='Get Started']")
		       WebElement btnGetStarted;
		     
		     @FindBy(xpath="//h4[normalize-space()='Array']")
		     WebElement arraypageHeading;
		     @FindBy(xpath = "//a[@href='array']")
		 	WebElement getStarted;                                             
		     @FindBy(xpath="//a[normalize-space()='Arrays in Python']")
			WebElement btnArraysinPython;
		     @FindBy(xpath="///p[normalize-space()='Arrays in Python']")
		       WebElement arraysinpython;
		   @FindBy(xpath="//a[normalize-space()='Arrays Using List']")
			WebElement btnArraysUsingList;
		  
		   @FindBy(xpath="//a[normalize-space()='Basic Operations in Lists']")
			WebElement btnBasicOperationsinLists;
		  
		   @FindBy(xpath="//a[normalize-space()='Applications of Array']")
			WebElement btnApplicationsofArray;
		   
		   @FindBy(xpath="//a[normalize-space()='Try here>>>']")
			WebElement btnTryhere;
		   
		   @FindBy(xpath = "//a[normalize-space()='Try Editor']")
		   WebElement tryEditorLink;
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   @FindBy(xpath = "//textarea[@tabindex='0']") // Assuming the editor has an ID
		    WebElement editorTextArea;

		   
		   @FindBy(xpath="//button[normalize-space()='Run']")
			WebElement btnRun;
		   
		   @FindBy(xpath="//pre[@role='presentation']")
		  	WebElement txtpythoncode;
		   
		   @FindBy(id = "output") // Assuming console output appears in <pre> tag
		    WebElement consoleOutput;
		     
		   @FindBy(xpath="//a[normalize-space()='Practice Questions']")
			WebElement btnPracticeQuestions;
		   
		   @FindBy(xpath="//a[normalize-space()='Search the array']")
			WebElement btnSearchthearray;
		   
		   @FindBy(xpath="//a[normalize-space()='Max Consecutive Ones']")
			WebElement btnMaxConsecutiveOnes;
		   
		   @FindBy(xpath="//a[normalize-space()='Find Numbers with Even Number of Digits']")
			WebElement btnFindNumberswithEvenNumberofDigits;
		   

		   @FindBy(xpath="//a[contains(text(),'Squares of')]")
			WebElement btnSquaresofasortedArray;
		   
		   @FindBy(xpath="//input[@value='Submit']")
			WebElement btnSubmit;
		   
		   @FindBy(xpath="//a[normalize-space()='Data Structures']")
			WebElement DataStructures;      
		   @FindBy(xpath = "//*[@id=\"answer_form\"]")
			WebElement answerform;
		   
		   @FindBy(xpath = "//form[@id='answer_form']")
			WebElement txtanswerform;
		   
		   @FindBy(xpath = "//*[@id=\"answer_form\"]")
			WebElement TextArea;
		   
		   @FindBy(xpath = "//textarea[@tabindex='0']")
			WebElement inputTextArea;
		   
		   @FindBy(xpath = "//textarea[@autocorrect='off']")
			WebElement inputarea;
		   
		   @FindBy(xpath = "//*[@id=\"answer_form\"]/div")
		   		
			WebElement autocorrecttext;
		   @FindBy(xpath = "//div[@class='CodeMirror-scroll']")
	  		
			WebElement CodeMirror;
		   
		   
		   public void clickGetStartedButton()
		   {
		   	btnGetStarted.click();
		   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click();
			btnGetStarted.click();
		   }
		  
		   
		   
		// getstarted button of Array click
			public void clickGetStartedArray() {
							getStarted.click();
			}
			
			 public void array()
			  {
				 arraypageHeading.click();
				  
			  }
			 
			 public boolean isDataStructuresDisplayed()
			 {
				 return DataStructures.isDisplayed();
			 }

		   public  boolean isarraysinpythondisplayed()
			 {
				 			return arraysinpython.isDisplayed(); 
			 }
		   public boolean isArrayPageDisplayed()
			 {
				 return arraypageHeading.isDisplayed();
			 }
		   	public void clickArraysinPython()
			    {
			    	btnArraysinPython.click();

			    }
		   	
		   	public void clickArraysUsingList()
		    {
		    	btnArraysUsingList.click();

		    }
		   
		   	public void clickBasicOperationsinLists()
		    {
		    	btnBasicOperationsinLists.click();

		    }
		   	
		   	public void clickApplicationsofArray()
		    {
		    	btnApplicationsofArray.click();

		    }
		   	
		   	public void getBackBasicOperationsinLists() {
		    	loginPage.getHomeURL();
		    	getStarted();
		    	clickBasicOperationsinLists();
		    	
		    }
		   
		   	public void clickTryhere()
		    {
		    	btnTryhere.click();

		    }
		   	
		   	public void clickTryEditorLink() {
		        tryEditorLink.click();
		    }
		   
		   	public void clickRun()
		    {
		    	btnRun.click();

		    }
		   
		   	public void clickPracticeQuestions()
		    {
		    	btnPracticeQuestions.click();

		    }
		   
		   	public void clickSearchthearray()
		    {
		    	btnSearchthearray.click();

		    }
		   
		   	public void clickMaxConsecutiveOnes()
		    {
		    	btnMaxConsecutiveOnes.click();

		    }
		   
		   	public void clickFindNumberswithEvenNumberofDigits()
		    {
		    	btnFindNumberswithEvenNumberofDigits.click();

		    }
		   
		   	public void clickSquaresof()
		    {
		    	btnSquaresofasortedArray.click();

		    }
		   	
		   	public void getainpArrayURL() {
		   		
				
		   		btnArraysinPython.click();
				
			}
		   
		   	public void clickSubmit()
		    {
		    	btnSubmit.click();

		    }
		    public String getConsoleOutput() {
		        return consoleOutput.getText();
		    }
		    public void getBackOPS()
		    {loginPage.getHomeURL();
		    getStarted();
		    getainpArrayURL();
		    	
		    }
//		    public Alert alert() {
//				 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//				return driver.switchTo().alert();
//			}
		    	
		    	public void enterCodePractice(String code, WebElement element) {
	                new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).perform();
	                String[] str1 = code.split("\n");
	                for (int i = 0; i < str1.length; i++) {
	                        if (str1[i].equalsIgnoreCase("\\b")) {
	                                element.sendKeys(Keys.BACK_SPACE);
	                        } else {
	                                element.sendKeys(str1[i]);
	                                element.sendKeys(Keys.RETURN);
	                        
	                }
	                }
		    	}
		    	
		
		    	public void enterCode(String code) {

					wait.until(ExpectedConditions.visibilityOf(answerform));

					
					editorTextArea.sendKeys(code);
					LoggerLoad.info("code entered!");
				}

		    	public Alert alert() {
					 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
					return driver.switchTo().alert();
				}
		    	
		    	
		    	public void gettryEditorURL()
				{ 
				
					//driver.get("https://dsportalapp.herokuapp.com/tryEditor"); //TBD
					loginPage.getHomeURL();
					getStarted();
					getoptsSlackURL();
					clickTryhere();
				}

		    	
		    	
	                private void getoptsSlackURL() {
					// TODO Auto-generated method stub
					
				}



					public void pythoncode(String code) {
		    	wait.until(ExpectedConditions.visibilityOf(answerform));
		    
				
				LoggerLoad.info("code entered!");
			}


			public static void getStarted() {
				// TODO Auto-generated method stub
				
			}



			public String isErrorDisplayed() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getCurrentUrl() {
		         return driver.getCurrentUrl();
		     }
		}
			
			

		   
		   
		   
		   
		  
		   
		   
		   
		   
		   
		   
		   
		  
		 
		   
		   
		   
		   
		   
		






