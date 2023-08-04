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


public class DiscountsModule {
	
	public WebDriver driver = null;
	public static int TIMEOUT = 20;
	protected WebDriverWait wait;
	
	public DiscountsModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public WebElement webdriverWaitForElement(WebElement element) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}
	
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='discount_text']")
	protected WebElement discountTextField;
	
	@FindBy(how = How.XPATH, using = "(//a[@class='btn btn-mini btn-primary'])[1]")
	protected WebElement addDiscountCodes;
	
	@FindBy(how = How.XPATH, using = "//input[@id='code']")
	protected WebElement code;
	
	@FindBy(how = How.XPATH, using = "//input[@id='label']")
	protected WebElement label;
	
	@FindBy(how = How.XPATH, using = "//input[@id='value']")
	protected WebElement amount;
	
	@FindBy(how = How.XPATH, using = "//input[@name='expires']")
	protected WebElement expirationDate;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ticket_type_all']")
	protected WebElement ticketTypeAllCheckBox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='code_use']")
	protected WebElement noOfTimesCodeUse;
	
	@FindBy(how = How.XPATH, using = "//input[@id='code_use_user']")
	protected WebElement noOfTimesCodeUseByUser;
	
	@FindBy(how = How.XPATH, using = "//select[@name='discount_application_id']")
	protected WebElement applyToEntireOrder;
	
	@FindBy(how = How.XPATH, using = "//input[@id='discount_button']")
	protected WebElement saveButtonInDicountCodes;
	
	
	@FindBy(how = How.XPATH, using = "(//a[@class='btn btn-mini btn-primary'])[2]")
	protected WebElement addGroupDiscountCodes;
	
	@FindBy(how = How.XPATH, using = "//input[@id='value']")
	protected WebElement amountInGroupDiscounts;
	
	@FindBy(how = How.XPATH, using = "//select[@name='discount_application_id']")
	protected WebElement applyToEntireOrderInGroupDiscounts;
	
	@FindBy(how = How.XPATH, using = "//input[@id='required_qty']")
	protected WebElement requiredQuantity;
	
	@FindBy(how = How.XPATH, using = "//input[@name='expires']")
	protected WebElement expirationDateInGroupDiscounts;
	
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	protected WebElement saveButtonInGroupDicountCodes;
	
	
	public void discountModuleActions() throws Throwable {
		

		GetExcelSheetData getExcelSheetData = new GetExcelSheetData();
		String DiscountText = getExcelSheetData.getSheetData("i3", 38, 0);
		String Code = getExcelSheetData.getSheetData("i3", 38, 1);
		String Label = getExcelSheetData.getSheetData("i3", 38, 2);
		String Amount = getExcelSheetData.getSheetData("i3", 38, 3);
		String ExpirationDate = getExcelSheetData.getSheetData("i3", 38, 4);
		String NoOfTimesDiscountCanBeUsed = getExcelSheetData.getSheetData("i3", 38, 5);
		String NoOfTimesDiscountCanBeUsedByUser = getExcelSheetData.getSheetData("i3", 38, 6);
		String ApplyToEntireOrder = getExcelSheetData.getSheetData("i3", 38, 7);
//		String AmountInGroupDiscounts = getExcelSheetData.getSheetData("i3", 38, 8);
//		String ApplyToEntireOrdersInGroupDiscounts = getExcelSheetData.getSheetData("i3", 38, 9);
//		String RequiredQuantity = getExcelSheetData.getSheetData("i3", 38, 10);
//		String ExpirationDateInGroupDiscounts = getExcelSheetData.getSheetData("i3", 38, 11);
		
		webdriverWaitForElement(discountTextField);
		discountTextField.sendKeys(DiscountText);
		
		webdriverWaitForElement(addDiscountCodes);
		clickElement(addDiscountCodes);
		
		webdriverWaitForElement(code);
		code.sendKeys(Code);
		
		webdriverWaitForElement(label);
		label.sendKeys(Label);
		
		webdriverWaitForElement(amount);
		amount.sendKeys(Amount);
		
		webdriverWaitForElement(expirationDate);
		expirationDate.sendKeys(ExpirationDate);
		
		webdriverWaitForElement(ticketTypeAllCheckBox);
		clickElement(ticketTypeAllCheckBox);
		
		webdriverWaitForElement(noOfTimesCodeUse);
		noOfTimesCodeUse.sendKeys(Keys.CONTROL + "a");
		noOfTimesCodeUse.sendKeys(Keys.DELETE);
		noOfTimesCodeUse.sendKeys(NoOfTimesDiscountCanBeUsed);
		
		webdriverWaitForElement(noOfTimesCodeUseByUser);
		noOfTimesCodeUseByUser.sendKeys(Keys.CONTROL + "a");
		noOfTimesCodeUseByUser.sendKeys(Keys.DELETE);
		noOfTimesCodeUseByUser.sendKeys(NoOfTimesDiscountCanBeUsedByUser);
		
		Select applyTo = new Select(applyToEntireOrder);
		applyTo.selectByVisibleText(ApplyToEntireOrder);
		
		webdriverWaitForElement(saveButtonInDicountCodes);
		clickElement(saveButtonInDicountCodes);
		
//		webdriverWaitForElement(addGroupDiscountCodes);
//		clickElement(addGroupDiscountCodes);
//		
//		webdriverWaitForElement(amountInGroupDiscounts);
//		amountInGroupDiscounts.sendKeys(AmountInGroupDiscounts);
//		
//		Select applyToInGroupDiscounts = new Select(applyToEntireOrderInGroupDiscounts);
//		applyToInGroupDiscounts.selectByVisibleText(ApplyToEntireOrdersInGroupDiscounts);
//		
//		webdriverWaitForElement(requiredQuantity);
//		requiredQuantity.sendKeys(RequiredQuantity);
//		
//		webdriverWaitForElement(expirationDateInGroupDiscounts);
//		expirationDateInGroupDiscounts.sendKeys(ExpirationDateInGroupDiscounts);
//		
//		webdriverWaitForElement(saveButtonInGroupDicountCodes);
//		clickElement(saveButtonInGroupDicountCodes);
//		
	}
	
	
}
