package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import utilities.LoggerLoad;

public class TreePage {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	WebDriver driver = DriverManager.getDriver();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	@FindBy(xpath = "//a[@href='tree']")
	WebElement treeGetStarted;

	@FindBy(xpath = "//h4[@class='bg-secondary text-white']")
	WebElement treeHeading;

	@FindBy(xpath = "//a[normalize-space()='Tree']")
	WebElement dropdownTree;

	@FindBy(xpath = "//a[normalize-space()='Overview of Trees']")
	WebElement overviewTree;
	@FindBy(xpath = "//p[normalize-space()='Overview of Trees']")
	WebElement overviewTreeHeading;

	// tryherebutton
	@FindBy(xpath = "//a[@class='btn btn-info']") // a[normalize-space()='Try here>>>']
	WebElement tryhereButn;
	// runButton
	@FindBy(xpath = "//button[@type='button']")
	WebElement runBtn;

	@FindBy(xpath = "//a[normalize-space()='Terminologies']")
	WebElement terminalogies;
//	@FindBy(xpath = "//p[normalize-space()='Terminologies']")
//	WebElement terminalogiesHeading;

	@FindBy(xpath = "//a[normalize-space()='Types of Trees']")
	WebElement typesofTree;
	@FindBy(xpath = "//p[normalize-space()='Types of Trees']")
	WebElement typesofTreesHeading;

	@FindBy(xpath = "//a[normalize-space()='Tree Traversals']") // a[normalize-space()='Tree Traversals']
	WebElement treeTraversals;
	@FindBy(xpath = "//p[normalize-space()='Terminologies']")
	WebElement treeTraversalHeading;

	@FindBy(xpath = "//a[normalize-space()='Traversals-Illustration']") //// a[normalize-space()='Traversals-Illustration']
	WebElement traversIllustration;
	@FindBy(xpath = "//p[normalize-space()='Traversals-Illustration']")
	WebElement traversalIllustrationHeading;

	@FindBy(xpath = "//a[normalize-space()='Binary Trees']") //// a[normalize-space()='Binary Trees']
	WebElement binaryTreeLnk;
	@FindBy(xpath = "//p[normalize-space()='Binary Trees']")
	WebElement binaryTreeHeading;

	@FindBy(xpath = "//a[normalize-space()='Types of Binary Trees']")
	WebElement typesofBinaryTree;
	@FindBy(xpath = "//p[normalize-space()='Types of Binary Trees']")
	WebElement typesofBinaryTressHeading;

	@FindBy(xpath = "//a[normalize-space()='Implementation in Python']")
	WebElement implementPython;
	@FindBy(xpath = "//p[normalize-space()='Implementation in Python']")
	WebElement implementPythonHeading;

	@FindBy(xpath = "//a[normalize-space()='Binary Tree Traversals']") // a[normalize-space()='Binary Tree Traversals']
	WebElement binaryTreeTraversal;
	@FindBy(xpath = "//p[contains(text(),'Binary Tree Traversals')]")
	WebElement binaryTreeTraversalHeading;

	@FindBy(xpath = "//a[normalize-space()='Implementation of Binary Trees']")
	WebElement implOfBinaryTree;
	@FindBy(xpath = "//p[normalize-space()='Implementation of Binary Trees']")
	WebElement implOfBinaryTreeHeading;

	@FindBy(xpath = "//a[normalize-space()='Applications of Binary trees']")
	WebElement appliOfBinaryTree;
	@FindBy(xpath = "//p[normalize-space()='Applications of Binary trees']")
	WebElement appliOfBinaryTreeHeading;

	@FindBy(xpath = "//a[normalize-space()='Binary Search Trees']")
	WebElement binarySearchTree;
	@FindBy(xpath = "//p[normalize-space()='Binary Search Trees']")
	WebElement binarySearchTreeHeading;

	@FindBy(xpath = "//a[normalize-space()='Implementation Of BST']")
	WebElement implOfBst;
	@FindBy(xpath = "//p[normalize-space()='Implementation Of BST']")
	WebElement implOfBstHeading;

	@FindBy(xpath = "//a[normalize-space()='Practice Questions']")
	WebElement practiceQuestions;

	@FindBy(xpath = "//a[normalize-space()='Try here>>>']")
	WebElement tryherebutton;

	public TreePage() {

		PageFactory.initElements(driver, this);
	}

	// method to getstarted tree
	public void clickGetstartedTree() {
		wait.until(ExpectedConditions.elementToBeClickable(treeGetStarted)).click();
		
	}

	// Method to display TreePageHeading
	public boolean isTreePageHeading() {
		return treeHeading.isDisplayed();

	}

	public boolean isTypesofBinaryTressHeading() {
		return typesofBinaryTressHeading.isDisplayed();
	}

	// Method to navigate to overviewOfTree
	public void clickOverviewOfTree() {
		wait.until(ExpectedConditions.elementToBeClickable(overviewTree)).click();
	}

	// method to navigate to tryeditorpageof overview Tree
	public void getOverviewOfPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickOverviewOfTree();
	}

	// method for tryeditor page navigation
	public void clickOverViewTryeditor() {
		wait.until(ExpectedConditions.elementToBeClickable(tryhereButn)).click();
	}

	// method for terminologies navigation page
	public void clickTerminoligiesLnk() {
		wait.until(ExpectedConditions.elementToBeClickable(terminalogies)).click();
	}

	// method for TermonologiesPage
	public void terminologiesPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickTerminoligiesLnk();
	}

	public void tryherePage() {
		wait.until(ExpectedConditions.elementToBeClickable(tryhereButn)).click();
	}

	// Method to navigate to overviewOfTree
	public void clickTypeOfTrees() {
		wait.until(ExpectedConditions.elementToBeClickable(typesofTree)).click();
	}

	// method for TypesOfTreePage
	public void typesOfTreePage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickTypeOfTrees();
	}

	// Method to navigate to Tree Traversals
	public void clickTreTraversals() {
		wait.until(ExpectedConditions.elementToBeClickable(treeTraversals)).click();
	}

	// method for TreTraversals
	public void treTraversalsPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickTreTraversals();
	}

	// Method to navigate to Traversals-Illustration
	public void clickTraversalsIllustration() {
		wait.until(ExpectedConditions.elementToBeClickable(traversIllustration)).click();
	}

	// method for Traversals-IllustrationPage
	public void traversalsIllustrationPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickTraversalsIllustration();
	}

	// Method to navigate to Binary Trees
	public void clickBinaryTrees() {
		wait.until(ExpectedConditions.elementToBeClickable(binaryTreeLnk)).click();
		LoggerLoad.info("navigating to BinaryTrees page");
	}

	// method for Binary Trees
	public void binaryTreesPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickBinaryTrees();
	}

	// Method to navigate to Types of Binary Trees
	public void clickTypesofBinaryTrees() {
		wait.until(ExpectedConditions.elementToBeClickable(typesofBinaryTree)).click();
	}

	// method for Types of Binary Trees Page
	public void typesofBinaryTreesPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickTypesofBinaryTrees();
	}

	// Method to navigate to Implementation in Python
	public void clickImplementationinPython() {
		wait.until(ExpectedConditions.elementToBeClickable(implementPython)).click();
		LoggerLoad.info("clicking the implementation in python");
	}

	// method for Implementation in Python Page
	public void implementationinPythonPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickImplementationinPython();
	}

	// Method to navigate to Binary Tree Traversals
	public void clickBinaryTreeTraversals() {
		wait.until(ExpectedConditions.elementToBeClickable(binaryTreeTraversal)).click();
	}

	// method for Binary Tree Traversals
	public void binaryTreeTraversalsPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickBinaryTreeTraversals();
	}

	// Method to navigate to Implementation of Binary Trees
	public void clickImplementationofBinaryTrees() {
		wait.until(ExpectedConditions.elementToBeClickable(implOfBinaryTree)).click();
	}

	// method for Implementation of Binary Trees
	public void implementationofBinaryTreesPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickImplementationofBinaryTrees();
	}

	// Method to navigate to Applications of Binary trees
	public void clickApplicationsofBinarytrees() {
		wait.until(ExpectedConditions.elementToBeClickable(appliOfBinaryTree)).click();
	}

	// method for Applications of Binary trees
	public void applicationsofBinarytreesPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickApplicationsofBinarytrees();
	}

	// Method to navigate to Binary Search Trees
	public void clickBinarySearchTrees() {
		wait.until(ExpectedConditions.elementToBeClickable(binarySearchTree)).click();
	}

	// method for BinarySearchTrees Page
	public void binarySearchTreesPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickBinarySearchTrees();
	}

	// Method to navigate to Implementation Of BST
	public void clickImplementationOfBST() {
		wait.until(ExpectedConditions.elementToBeClickable(implOfBst)).click();
	}

	// method for Implementation Of BST Page
	public void implementationOfBSTPage() {
		//loginPage.getHomeURL();
		clickGetstartedTree();
		clickImplementationOfBST();
	}

	// Method to navigate to practiceQuestions
	public void clickpracticeQuestions() {
		wait.until(ExpectedConditions.elementToBeClickable(practiceQuestions)).click();
	}

	// method for tryeditor page navigation
	public void clickTypeOfTreeTryeditor() {
		wait.until(ExpectedConditions.elementToBeClickable(tryherebutton)).click();
	}

	public void clicktryhereOfTypesOfTree() {
		wait.until(ExpectedConditions.elementToBeClickable(tryhereButn)).click();
	}
	
	public void getPracticequestionsPage()
	{
		clickGetstartedTree();
		clickOverviewOfTree();
		clickpracticeQuestions();
		
	}
	

	 // Method to get the current URL
   public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
