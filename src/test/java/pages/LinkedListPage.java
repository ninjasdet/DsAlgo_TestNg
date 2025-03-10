package pages;


	import java.time.Duration;
	import java.util.List;
	import java.util.Map;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;


	import driverManager.DriverManager;
	import utilities.ExcelReader;
	import utilities.LoggerLoad;
	public class LinkedListPage {
		public WebDriver driver=DriverManager.getDriver();
	    LoginPage loginPage = new LoginPage();
	    ExcelReader excelUtils;
		
		
		
		//WebDriver driver;
	    
		public LinkedListPage() {
			PageFactory.initElements(driver, this);
	   
	}
		
		String currentUrl;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Locators using @FindBy annotations
		@FindBy(xpath = "//a[@href='linked-list']")
		WebElement getStarted; 
		@FindBy(xpath = "//h4[normalize-space()='Linked List']")
		WebElement LinkedListpageheader; 
		@FindBy(xpath = "//a[normalize-space()='Introduction']")
		WebElement Introduction; 
		@FindBy(xpath = "//a[normalize-space()='Try here>>>']")
		WebElement Tryhere; 
		@FindBy(xpath = "//pre[@role='presentation']")
		WebElement presentation;
		@FindBy(xpath = "//button[normalize-space()='Run']")
		WebElement Run;
		@FindBy(xpath = "//a[normalize-space()='Creating Linked LIst']")
		WebElement CreatingLinkedList;
		@FindBy(xpath = "//a[normalize-space()='Types of Linked List']")
		WebElement TypesofLinkedList;
		@FindBy(xpath = "//a[normalize-space()='Implement Linked List in Python']")
		WebElement ImplementLinkedListinPython;
		@FindBy(xpath = "//a[normalize-space()='Traversal']")
		WebElement Traversal;
		@FindBy(xpath = "//a[normalize-space()='Insertion']")
		WebElement Insertion;
		@FindBy(xpath = "//a[normalize-space()='Deletion']")
		WebElement Deletion;
		@FindBy(xpath = "//a[normalize-space()='Practice Questions']")
		WebElement PracticeQuestions;
		@FindBy(xpath = "//a[normalize-space()='Introduction']")
		WebElement navigateToIntroductionPage;
		@FindBy(xpath = "//pre[@role='presentation']")
		WebElement tryEditor;
		 @FindBy(xpath =  "//textarea[@tabindex='0']") // Assuming the editor has an ID
		    WebElement editorTextArea;
		 @FindBy(id = "output") // Assuming console output appears in <pre> tag
		    WebElement consoleOutput;
		 @FindBy(xpath = "//a[normalize-space()='Try Editor']")
		   WebElement tryEditorLink;
		 @FindBy(xpath = "//*[@id=\"answer_form\"]")
			WebElement answerform;
		 
		 
		public boolean isLinkedListPageDisplayed() {
			return LinkedListpageheader.isDisplayed();
	    }

		public  void getStartedlinkedlist() {
			//getStarted.click();
			wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click(); 
			
		}
		
		public void clickGetStartedLinkedList() {
	        //if (getStarted != null) {
	            //getStarted.click();
	            wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click();
	        //} else {
	           // System.out.println("Error: getStartedLinkedList WebElement is NULL");}
	        }
		
		public void clickGetstartedIntroduction() {
			Introduction.click();
			
		}
		
		public void clickOverviewOfIntroduction() {
			wait.until(ExpectedConditions.elementToBeClickable(Introduction)).click();
			
			
		}
		
		public void getOverviewOfPage() {
			loginPage.getHomeURL();
			clickGetstartedIntroduction();
			clickOverviewOfIntroduction();
		}
		public void enterCode(String code) {

			wait.until(ExpectedConditions.visibilityOf(answerform));

			
			editorTextArea.sendKeys(code);
			LoggerLoad.info("code entered!");
		}
			
			
		
		public void Tryhere() {
			Tryhere.click();
			
		}
		public void presentation() {
			presentation.click();
			
		}
		
		public void clickTryEditorLink() {
	        tryEditorLink.click();
	    }
		
		public void Run() {
			Run.click();
			
		}
		
		public void CreatingLinkedList() {
			wait.until(ExpectedConditions.elementToBeClickable(CreatingLinkedList)).click();		
		}
		public void TypesofLinkedList(){
			loginPage.getHomeURL();
			getStartedlinkedlist();
			TypesofLinkedList.click();
			
		}
		
		public void ImplementLinkedListinPython() {
			loginPage.getHomeURL();
			getStartedlinkedlist();
			ImplementLinkedListinPython.click();
			
		}
		
		public void Traversal() {
			loginPage.getHomeURL();
			getStartedlinkedlist();
			Traversal.click();
			
		}	
		public void Insertion() {
			loginPage.getHomeURL();
			getStartedlinkedlist();
			Insertion.click();
			
		}	
		
		public void Deletion() {
			//loginPage.getHomeURL();
			//getStartedlinkedlist();
			Deletion.click();
			//wait.until(ExpectedConditions.elementToBeClickable(Deletion)).click();
			//wait.until(ExpectedConditions.elementToBeClickable(Tryhere)).click();
		}	
		
		public void PracticeQuestions() {
		
			PracticeQuestions.click();
			
		}	
		
			
		public String getConsoleOutput() {
	        return consoleOutput.getText();
	    }

		public void getIntroductionURL() {
	   		
			
			navigateToIntroductionPage.click();
			
		}
		public void gettryEditorURL()
		{ 
			loginPage.getHomeURL();
			getStartedlinkedlist();
			navigateToIntroductionPage();
			
			Tryhere();
		}

		public boolean isTryEditorPageDisplayed() {
		        return tryEditor.isDisplayed() && Run.isDisplayed();
		    }
			public boolean isIntroductionPageDisplayed() {
		        return driver.getCurrentUrl().contains("linked-list/introduction");  
		    }
		    public void navigateToIntroductionPage() {
		        driver.get("https://dsportalapp.herokuapp.com/linked-list/introduction"); 
		    }
		    
		    public void getBackOPS() {
		    loginPage.getHomeURL();
		    getStartedlinkedlist();
		    navigateToIntroductionPage();
		    	
		    }


			public boolean isIntroductionDisplayed() {
				
				return driver.getTitle().contains("Introduction");
			}
			public String getAlertMessage() {
			    try {
			        Alert alert = driver.switchTo().alert(); // Switch to the alert
			        String alertMessage = alert.getText();  // Get the alert message text
			        alert.accept();  // Close the alert
			        return alertMessage;
			    } catch (Exception e) {
			        return null; // Return null if no alert is present
			    }
			    
			   
			    
			
	}
			
			 public String getCurrentUrl() {
		         return driver.getCurrentUrl();
		     }


			public Alert alert() {
				 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				return driver.switchTo().alert();
			}



			

	}	





