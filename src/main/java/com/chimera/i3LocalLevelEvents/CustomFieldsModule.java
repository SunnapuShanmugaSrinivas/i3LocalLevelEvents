package com.chimera.i3LocalLevelEvents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomFieldsModule {
	public WebDriver driver = null;
	public static int TIMEOUT =20;
	protected WebDriverWait wait;
	
	public CustomFieldsModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public WebElement webdriverWaitForElement(WebElement element) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}
	
	@FindBy(how = How.XPATH, using = "(//a[@class='btn btn-success'])[4]")
	protected WebElement addCustomField;
	
	@FindBy(how = How.XPATH, using = "//select[@id='field_type_id']")
	protected WebElement fieldType;
	
	@FindBy(how = How.XPATH, using = "//select[@id='display_name']")
	protected WebElement displayName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='label']")
	protected WebElement fieldLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	protected WebElement description;
	
	@FindBy(how = How.XPATH, using = "(//input[@name='quicksale_display'])[2]")
	protected WebElement quickSalePageCheckBox;
	
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	protected WebElement saveCustomFieldButton;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	protected WebElement continueToLogoButton;
	
	
	
	
	public void customFieldsModuleActions() throws Throwable {
		
		GetExcelSheetData getExcelSheetData = new GetExcelSheetData();
		
		String FieldType = getExcelSheetData.getSheetData("i3", 32, 0);
		String DisplayName = getExcelSheetData.getSheetData("i3", 32, 1);
		String FieldLable = getExcelSheetData.getSheetData("i3", 32, 2);
		String Description = getExcelSheetData.getSheetData("i3", 32, 3);
		
		
		webdriverWaitForElement(addCustomField);
		clickElement(addCustomField);
		
		Select fieldtype = new Select(fieldType);
		fieldtype.selectByVisibleText(FieldType);
		
		Thread.sleep(2000);
		Select fieldname = new Select(displayName);
		fieldname.selectByVisibleText(DisplayName);
		
		webdriverWaitForElement(fieldLabel);
		fieldLabel.sendKeys(FieldLable);
		
		webdriverWaitForElement(description);
		description.sendKeys(Description);
		
		webdriverWaitForElement(quickSalePageCheckBox);
		clickElement(quickSalePageCheckBox);
		
		webdriverWaitForElement(saveCustomFieldButton);
		clickElement(saveCustomFieldButton);
		
		webdriverWaitForElement(continueToLogoButton);
		clickElement(continueToLogoButton);
		
	}
}
