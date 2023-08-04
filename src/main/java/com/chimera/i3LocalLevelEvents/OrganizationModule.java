package com.chimera.i3LocalLevelEvents;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrganizationModule {
	
	public WebDriver driver = null;
	public static int TIMEOUT = 20;
	protected WebDriverWait wait;
	
	public OrganizationModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public WebElement webdriverWaitForElement(WebElement element) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}
	
	
	@FindBy(how = How.XPATH, using = "//span[text()='Select an Option']")
	protected WebElement selectOrganization;
	
	@FindBy(how = How.XPATH, using = "//select[@id='org_merchant_account']")
	protected WebElement selectAccount;
	
	@FindBy(how = How.XPATH, using = "//input[@id='account_identifier']")
	protected WebElement eventOrAccountIdentifier;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Select an Option']")
	protected WebElement selectOrgDropdown;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[1]")
	protected WebElement selectOrgTextField;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-success addnew']")
	protected WebElement addButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='continue']")
	protected WebElement saveAndContinueInOrg;
	
	public void orgActions() throws Throwable {
		
		GetExcelSheetData getExcelSheetData = new GetExcelSheetData();
		String AccountType = getExcelSheetData.getSheetData("i3", 8, 0);
		String EventOrAccountIdentifier = getExcelSheetData.getSheetData("i3", 8, 1);
		
		Thread.sleep(3000);
		selectOrganization.click();
		selectOrgTextField.sendKeys("S");
		selectOrgTextField.sendKeys(Keys.TAB);
		
		Select accountType = new Select(selectAccount);
		accountType.selectByVisibleText(AccountType);
		
		webdriverWaitForElement(eventOrAccountIdentifier);
		eventOrAccountIdentifier.sendKeys(EventOrAccountIdentifier);
		
		webdriverWaitForElement(saveAndContinueInOrg);
		clickElement(saveAndContinueInOrg);
		
	}
}
