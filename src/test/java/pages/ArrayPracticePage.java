package pages;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
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

public class ArrayPracticePage {
	
	
	public WebDriver driver = DriverManager.getDriver();
	
	 public ArrayPracticePage() {
	        
	        PageFactory.initElements(driver, this);
	    }	
	 LoginPage loginPage = new LoginPage();
		ExcelReader excelUtils;
		JavascriptExecutor js = (JavascriptExecutor) driver;

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
 @FindBy(tagName = "textarea")
 private WebElement codeEditor;

 @FindBy(xpath = "//button[text()='Run']")
 private WebElement runButton;

 @FindBy(id = "output")
 private WebElement outputElement;
 @FindBy(xpath = "//a[normalize-space()='Arrays in Python']")
	WebElement lnk_ArraysinPython;
 @FindBy(xpath = "//a[text()='Max Consecutive Ones']")
	WebElement lnk_MaxConsecutiveOnes;
 
 @FindBy(xpath = "//a[text()='Squares of  a Sorted Array']")
	WebElement lnk_SquaresofaSortedArray;
 @FindBy(xpath = "//a[text()='Search the array']")
	WebElement lnk_Searchthearray;

 @FindBy(xpath = "//a[normalize-space()='Find Numbers with Even Number of Digits']")
	WebElement lnk_FindNumbers;


 
 
 public void clickGetStartedButton()
 {
 	btnGetStarted.click();
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(getStarted)).click();
	btnGetStarted.click();
 }
 public void clicklnk_ArraysinPython() {
		lnk_ArraysinPython.click();
}
 public void clicklnk_MaxConsecutiveOnes() {
	 lnk_MaxConsecutiveOnes.click();
}
 public void clicklnk_SquaresofaSortedArray() {
	 lnk_SquaresofaSortedArray.click();
}
 public void clicklnk_FindNumbers() {
	 lnk_FindNumbers.click();
}
 public void clicklnk_Searchthearray() {
	 lnk_Searchthearray.click();
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
 
// 	public void clickRun()
//  {
//  	btnRun.click();
//
//  }
 
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
		codeEditor.clear(); // Clear the editor first
        codeEditor.sendKeys(code);
        LoggerLoad.info("Entered code: " + code);

		}
  	
  	public void clickRun() {
        runButton.click();
        LoggerLoad.info("Clicked Run button");
    }

  	
  	public String getOutput() {
        wait.until(ExpectedConditions.visibilityOf(outputElement));
        String output = outputElement.getText();
        LoggerLoad.info("Output: " + output);
        return output;
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



	public void enterCodePractice(String pythonCode) {
		// TODO Auto-generated method stub
		
	}
	
	public void checkArrayPracticePageLink(String pageName) {
		if(pageName.equalsIgnoreCase("Search the array")) {
			
			lnk_Searchthearray.click();
			LoggerLoad.info("Clicking the Search the array link of array page");
		}
		else if(pageName.equalsIgnoreCase("Max Consecutive Ones")) {
			
			 lnk_MaxConsecutiveOnes.click();
			LoggerLoad.info("Clicking the Max Consecutive Ones link of array page");
		}
		else if(pageName.equalsIgnoreCase("Find Numbers with Even Number of Digits"))
			
			 lnk_FindNumbers.click();
		
		else if(pageName.equalsIgnoreCase("Squares of a Sorted Array"))
			
			lnk_SquaresofaSortedArray.click();
		}
	//Action methods
			public void Enter_inputCode(String code)   {
				

		By def=By.xpath("//*[@class=\"CodeMirror-code\"]");
		
		 StringSelection stringSelection = new StringSelection(code);
	     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	     clipboard.setContents(stringSelection, null);
				
				
		Actions actions=new Actions(driver);
				actions.moveToElement(driver.findElement(def)).click();
		      
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
		
			
		
	}
			public void click_run() {
				runButton.click();
		    	
				
			}
			public boolean isAlertPresent() {
				try {
					driver.switchTo().alert();  
					return true; 
				} catch (NoAlertPresentException e) {
					return false;  
				}
			}
			
			public void click_submit() {
				btnSubmit.click();
				
			}
			public String get_outputText()
			{
				return consoleOutput.getText();
				
			}
			public String validateArrayPracticePageTitles() {
				List<WebElement> list=driver.findElements(By.xpath("//input[@type='submit']"));
				if(list.size()>0)
				return driver.getTitle();
				return null;
			}
}

	
	

 
 
 
 

