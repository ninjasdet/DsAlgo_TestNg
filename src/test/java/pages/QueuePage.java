package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import driverManager.DriverManager;
import utilities.LoggerLoad;

public class QueuePage {
	public WebDriver driver = DriverManager.getDriver();
	LoginPage loginPage = new LoginPage();

	public QueuePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='queue']")
	WebElement getStartedQueue;

	@FindBy(xpath = "//a[normalize-space()='Implementation of Queue in Python']")
	WebElement implementationQueuePythonButton;

	@FindBy(xpath = "//a[normalize-space()='Implementation using collections.deque']")
	WebElement implementationCollectionsDequeButton;
	@FindBy(xpath = "//a[normalize-space()='Implementation using array']")
	WebElement implementationUsingArrayButton;
	@FindBy(xpath = "//a[normalize-space()='Queue Operations']")
	WebElement queueOperationsButton;
	@FindBy(xpath = "//a[@href='/queue/practice']")
	WebElement practiceQuestionsButtonQ;
	@FindBy(xpath = "//*[@id=\"answer_form\"]")
	WebElement answerform;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath = "//textarea[@tabindex='0']")
	WebElement editorTextArea;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement runButton;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement TryHere;
	@FindBy(id = "output")
	WebElement consoleOutput;
	public void getStartQueue() {
		getStartedQueue.click();

	}

	public void clickImplementationQueuePython() {
		implementationQueuePythonButton.click();
	}

//	public void getBackQueue() {
//		loginPage.getHomeURL();
//		getStartQueue();
//
//	}

	public void gettryEditorURLqueue() {

		loginPage.getHomeURL();
		getStartQueue();

	}

	public void clickImplementationCollectionsDeque() {
		implementationCollectionsDequeButton.click();
	}

	public void clickImplementationUsingArray() {
		implementationUsingArrayButton.click();
	}

	public void clickQueueOperationsButton() {
		queueOperationsButton.click();
	}

	public void clickPracticeQuestionsButtonQueue() {
		practiceQuestionsButtonQ.click();
		LoggerLoad.info("PracticeQuestions clicked");
	}
	public void enterCode(String code) {

		wait.until(ExpectedConditions.visibilityOf(answerform));

		
		editorTextArea.sendKeys(code);
		LoggerLoad.info("code entered!");
	}

	public void clickRunButton() {
		wait.until(ExpectedConditions.visibilityOf(runButton));
		runButton.click();
	}
	public Alert alert() {
		 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	public void clickTryHere() {
		TryHere.click();

	}
	public String getConsoleOutput() {
		//wait.until(ExpectedConditions.visibilityOf(answerform));
		return consoleOutput.getText();
	}

}
