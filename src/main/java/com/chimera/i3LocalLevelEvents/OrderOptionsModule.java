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

public class OrderOptionsModule {
	public WebDriver driver = null;
	public static int TIMEOUT = 20;
	protected WebDriverWait wait;
	
	public OrderOptionsModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public WebElement webdriverWaitForElement(WebElement element) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[@class='pull-left btn btn-mini btn-primary']")
	protected WebElement addType;
	
	@FindBy(how = How.XPATH, using = "//input[@id='title']")
	protected WebElement ticketTypeName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='price']")
	protected WebElement price;
	
	@FindBy(how = How.XPATH, using = "//input[@id='max_allowed']")
	protected WebElement maxAvailableTickets;
	
	@FindBy(how = How.XPATH, using = "//input[@id='max_per_user']")
	protected WebElement maxPerUser;
	
	@FindBy(how = How.XPATH, using = "//input[@id='display_available_tickets']")
	protected WebElement displayItemRemainingCheckBox;
	
	@FindBy(how = How.XPATH, using = "(//input[@id='saveTicketType'])[1]")
	protected WebElement saveTicketType;
	
	@FindBy(how = How.XPATH, using = "(//input[@id='saveTicketType'])[2]")
	protected WebElement yesButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='photo']")
	protected WebElement uploadImageChooseFile;
	
	@FindBy(how = How.XPATH, using = "//input[@id='starting_ticket_number']")
	protected WebElement startingTicketNumber;
	
	@FindBy(how = How.XPATH, using = "//input[@id='max_ticket_ceiling']")
	protected WebElement maximumEventTickets;
	
	@FindBy(how = How.XPATH, using = "//select[@name='max_ticket_option']")
	protected WebElement maxTicketOptions;
	
	@FindBy(how = How.XPATH, using = "//input[@id='expected_volume']")
	protected WebElement expectedTicketVolume;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='notification_email']")
	protected WebElement notificationEmail;
	
	@FindBy(how = How.XPATH, using = "//input[@id='sale_summary_type_1']")
	protected WebElement sendEmailCopyOfEachOrder;
	
	@FindBy(how = How.XPATH, using = "//input[@id='sale_summary_type_2']")
	protected WebElement sendNightlySummery;
	
	@FindBy(how = How.XPATH, using = "//span[@id='save_summary_notofication']")
	protected WebElement addButton;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='note-btn note-btn-bold'])[1]")
	protected WebElement boldInDisclaimerText;

	@FindBy(how = How.XPATH, using = "(//i[@class='note-icon-underline'])[1]")
	protected WebElement underlineInDisclaimerText;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='note-editable'])[1]")
	protected WebElement disclaimerTextField;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='ticket_fine_print']")
	protected WebElement textFinePrint;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='note-btn note-current-color-button'])[2]")
	protected WebElement colorInConfirmationMessageText;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='note-editable'])[2]")
	protected WebElement confirmationMessageTextField;
	
	@FindBy(how = How.XPATH, using = "(//i[@class='note-icon-italic'])[3]")
	protected WebElement italicInCustomEmailConfirmationText;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='note-editable'])[3]")
	protected WebElement customEmailConfirmationText;
	
	@FindBy(how = How.XPATH, using = "(//input[@name='multiple_scan'])[2]")
	protected WebElement checkBox1;
	
	@FindBy(how = How.XPATH, using = "(//input[@name='display_price'])[2]")
	protected WebElement checkBox2;
	
	@FindBy(how = How.XPATH, using = "//input[@name='continue']")
	protected WebElement saveAndContinueButton;
	
	
	
	public void orderOptionsModuleActions() throws Throwable {
		
		GetExcelSheetData getExcelSheetData = new GetExcelSheetData();
		String TicketTypeName = getExcelSheetData.getSheetData("i3", 26, 0);
		String Price = getExcelSheetData.getSheetData("i3", 26, 1);
		String MaxAvailableTickets = getExcelSheetData.getSheetData("i3", 26, 2);
		String MaxPerUser = getExcelSheetData.getSheetData("i3", 26, 3);
		String StartingTicketNumber = getExcelSheetData.getSheetData("i3", 26, 4);
		String MaximumEventTickets = getExcelSheetData.getSheetData("i3", 26, 5);
		String MaxTicketOptions= getExcelSheetData.getSheetData("i3", 26, 6);
		String ExpectedTicketVolume = getExcelSheetData.getSheetData("i3", 26, 7);
		String NotificationEmail = getExcelSheetData.getSheetData("i3", 26, 8);
		String DisclaimerText = getExcelSheetData.getSheetData("i3", 26, 9);
		String TextFinePrint = getExcelSheetData.getSheetData("i3", 26, 10);
		String ConfirmationTextField = getExcelSheetData.getSheetData("i3", 26, 11);
		String CustomEmailConfirmationText = getExcelSheetData.getSheetData("i3", 26, 12);

		
		
		webdriverWaitForElement(addType);
		clickElement(addType);
		
		webdriverWaitForElement(ticketTypeName);
		ticketTypeName.sendKeys(TicketTypeName);
		
		webdriverWaitForElement(price);
		price.sendKeys(Price);
		
		webdriverWaitForElement(maxAvailableTickets);
		maxAvailableTickets.sendKeys(Keys.CONTROL + "a");
		maxAvailableTickets.sendKeys(Keys.DELETE);
		maxAvailableTickets.sendKeys(MaxAvailableTickets);
		
		webdriverWaitForElement(maxPerUser);
		maxPerUser.sendKeys(Keys.CONTROL + "a");
		maxPerUser.sendKeys(Keys.DELETE);
		maxPerUser.sendKeys(MaxPerUser);
		
		webdriverWaitForElement(displayItemRemainingCheckBox);
		clickElement(displayItemRemainingCheckBox);
		
		webdriverWaitForElement(saveTicketType);
		clickElement(saveTicketType);
		
		Thread.sleep(2000);
		webdriverWaitForElement(yesButton);
		clickElement(yesButton);
		
		Thread.sleep(3000);

		webdriverWaitForElement(uploadImageChooseFile);
		uploadImageChooseFile.sendKeys("C:\\Users\\ShanmugaSrinivasS\\Downloads\\1111.jpg");
		
		webdriverWaitForElement(startingTicketNumber);
		startingTicketNumber.sendKeys(Keys.CONTROL + "a");
		startingTicketNumber.sendKeys(Keys.DELETE);
		startingTicketNumber.sendKeys(StartingTicketNumber);
		
		webdriverWaitForElement(maximumEventTickets);
		maximumEventTickets.sendKeys(Keys.CONTROL + "a");
		maximumEventTickets.sendKeys(Keys.DELETE);
		maximumEventTickets.sendKeys(MaximumEventTickets);
		
		Select fee = new Select(maxTicketOptions);
		fee.selectByVisibleText(MaxTicketOptions);
		
		webdriverWaitForElement(expectedTicketVolume);
		expectedTicketVolume.sendKeys(ExpectedTicketVolume);
		
		webdriverWaitForElement(notificationEmail);
		notificationEmail.sendKeys(NotificationEmail);
		
		webdriverWaitForElement(sendEmailCopyOfEachOrder);
		clickElement(sendEmailCopyOfEachOrder);
	
		webdriverWaitForElement(sendNightlySummery);
		clickElement(sendNightlySummery);
		
		webdriverWaitForElement(addButton);
		clickElement(addButton);
		
		webdriverWaitForElement(boldInDisclaimerText);
		clickElement(boldInDisclaimerText);
		
		webdriverWaitForElement(underlineInDisclaimerText);
		clickElement(underlineInDisclaimerText);
		
		webdriverWaitForElement(disclaimerTextField);
		disclaimerTextField.sendKeys(DisclaimerText);
		
		webdriverWaitForElement(textFinePrint);
		textFinePrint.sendKeys(TextFinePrint);
		
		webdriverWaitForElement(colorInConfirmationMessageText);
		clickElement(colorInConfirmationMessageText);
		
		webdriverWaitForElement(confirmationMessageTextField);
		confirmationMessageTextField.sendKeys(ConfirmationTextField);
		
		webdriverWaitForElement(italicInCustomEmailConfirmationText);
		clickElement(italicInCustomEmailConfirmationText);
		
		webdriverWaitForElement(customEmailConfirmationText);
		customEmailConfirmationText.sendKeys(CustomEmailConfirmationText);
		
		webdriverWaitForElement(checkBox1);
		clickElement(checkBox1);
		
		webdriverWaitForElement(checkBox2);
		clickElement(checkBox2);
		
		webdriverWaitForElement(saveAndContinueButton);
		clickElement(saveAndContinueButton);
		
	}
	
}
