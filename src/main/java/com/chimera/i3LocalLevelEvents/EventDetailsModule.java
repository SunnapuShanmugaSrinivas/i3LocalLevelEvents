package com.chimera.i3LocalLevelEvents;
	

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventDetailsModule {
	
	public WebDriver driver = null;
	public static int TIMEOUT = 20;
	protected WebDriverWait wait;
	
	public EventDetailsModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public WebElement webdriverWaitForElement(WebElement element) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='title']")
	protected WebElement eventName;
	
	@FindBy(how = How.XPATH, using = "(//i[@class='note-icon-bold'])[1]")
	protected WebElement eventDescriptionBoldButton;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='note-editable'])[1]")
	protected WebElement eventDescriptionTextField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='category-1']")
	protected WebElement eventCatagoriesArts;
	
	@FindBy(how = How.XPATH, using = "//input[@id='category-3']")
	protected WebElement eventCatagoriesSports;
	
	@FindBy(how = How.XPATH, using = "//input[@id='venue_name']")
	protected WebElement locationVenueName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	protected WebElement locationAddress;
	
	@FindBy(how = How.XPATH, using = "//input[@id='address2']")
	protected WebElement locationAddress2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	protected WebElement city;
	
	@FindBy(how = How.XPATH, using = "//select[@name='state']")
	protected WebElement state;
	
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	protected WebElement zipcode;
	
	@FindBy(how = How.XPATH, using = "//input[@id='contact_name']")
	protected WebElement contactNameInEventContactInfo;
	
	@FindBy(how = How.XPATH, using = "//input[@id='contact_email']")
	protected WebElement contactEmailInEventContactInfo;
	
	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	protected WebElement contactPhoneInEventContactInfo;
	
	@FindBy(how = How.XPATH, using = "(//i[@class='note-icon-bold'])[2]")
	protected WebElement eventFinePrintBoldButton;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='note-editable'])[2]")
	protected WebElement eventFinePrintTextField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='document_description']")
	protected WebElement documentNameOrDescription;
	
	@FindBy(how = How.XPATH, using = "//select[@name='cc_fee']")
	protected WebElement creditCardFee;
	
	@FindBy(how = How.XPATH, using = "//input[@id='document']")
	protected WebElement uploadDocument;
	
	@FindBy(how = How.XPATH, using = "(//input[@name='validate_attendance'])[1]")
	protected WebElement validateAttendenceMobileAndPrint;
	
	@FindBy(how = How.XPATH, using = "//input[@id='saveEventcontinue']")
	protected WebElement saveAndContinueInEventDetails;
	
	public void eventDetailsActions(String FILE_PATH) throws Throwable {
		
		GetExcelSheetData getExcelSheetData = new GetExcelSheetData();
		
		String EventName = getExcelSheetData.getSheetData("i3", 14, 0);
		String EventDescription = getExcelSheetData.getSheetData("i3", 14, 1);
		String LocationVenueName = getExcelSheetData.getSheetData("i3", 14, 2);
		String LocationAddress = getExcelSheetData.getSheetData("i3", 14, 3);
		String LocationAddress2 = getExcelSheetData.getSheetData("i3", 14, 4);
		String City = getExcelSheetData.getSheetData("i3", 14, 5);
		String State = getExcelSheetData.getSheetData("i3", 14, 6);
		String Zipcode = getExcelSheetData.getSheetData("i3", 14, 7);
		String ContactName = getExcelSheetData.getSheetData("i3", 14, 8);
		String ContactEmail = getExcelSheetData.getSheetData("i3", 14, 9);
		String ContactPhone = getExcelSheetData.getSheetData("i3", 14, 10);
		String EventFinePrint = getExcelSheetData.getSheetData("i3", 14, 11);
		String DocumentNameOrDescription = getExcelSheetData.getSheetData("i3", 14, 12);
		String CreditCardFee = getExcelSheetData.getSheetData("i3", 14, 13);
		
		webdriverWaitForElement(eventName);
		eventName.sendKeys(EventName);
		
		webdriverWaitForElement(eventDescriptionBoldButton);
		clickElement(eventDescriptionBoldButton);
		
		webdriverWaitForElement(eventDescriptionTextField);
		eventDescriptionTextField.sendKeys(EventDescription);
		
		webdriverWaitForElement(eventCatagoriesArts);
		clickElement(eventCatagoriesArts);
		
		webdriverWaitForElement(eventCatagoriesSports);
		clickElement(eventCatagoriesSports);
		
		webdriverWaitForElement(locationVenueName);
		locationVenueName.sendKeys(LocationVenueName);
		
		webdriverWaitForElement(locationAddress);
		locationAddress.sendKeys(LocationAddress);
		
		webdriverWaitForElement(locationAddress2);
		locationAddress2.sendKeys(LocationAddress2);
		
		webdriverWaitForElement(city);
		city.sendKeys(City);
		
		Select stateValue = new Select(state);
		stateValue.selectByVisibleText(State);
		
		webdriverWaitForElement(zipcode);
		zipcode.sendKeys(Zipcode);
		
		webdriverWaitForElement(contactNameInEventContactInfo);
		contactNameInEventContactInfo.sendKeys(ContactName);
		
		Thread.sleep(2000);
		webdriverWaitForElement(contactEmailInEventContactInfo);
		contactEmailInEventContactInfo.sendKeys(ContactEmail);
		
		webdriverWaitForElement(contactPhoneInEventContactInfo);
		contactPhoneInEventContactInfo.sendKeys(ContactPhone);
		
		webdriverWaitForElement(eventFinePrintBoldButton);
		clickElement(eventFinePrintBoldButton);
		
		webdriverWaitForElement(eventFinePrintTextField);
		eventFinePrintTextField.sendKeys(EventFinePrint);
		
		webdriverWaitForElement(documentNameOrDescription);
		documentNameOrDescription.sendKeys(DocumentNameOrDescription);
		
		uploadDocument.sendKeys("C:\\Users\\ShanmugaSrinivasS\\Downloads\\1111.jpg");
		
		Select fee = new Select(creditCardFee);
		fee.selectByVisibleText(CreditCardFee);
		
		webdriverWaitForElement(validateAttendenceMobileAndPrint);
		clickElement(validateAttendenceMobileAndPrint);
		
		webdriverWaitForElement(saveAndContinueInEventDetails);
		clickElement(saveAndContinueInEventDetails);
		
	}
}
