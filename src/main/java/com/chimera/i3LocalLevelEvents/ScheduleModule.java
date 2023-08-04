package com.chimera.i3LocalLevelEvents;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleModule {
	public WebDriver driver = null;
	public static int TIMEOUT = 20;
	protected WebDriverWait wait;
	
	public ScheduleModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public WebElement webdriverWaitForElement(WebElement element) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='start_date']")
	protected WebElement startDate;
	
	@FindBy(how = How.XPATH, using = "//input[@name='end_date']")
	protected WebElement endDate;
	
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	protected WebElement addButton;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='span5'])[1]")
	protected WebElement startTime;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='span5'])[2]")
	protected WebElement endTime;
	
	@FindBy(how = How.XPATH, using = "//span[@class='btn btn-success btn-mini update_times']")
	protected WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//input[@name='continue']")
	protected WebElement continueButton;
	
	public void scheduleActions() throws Throwable {
		
		GetExcelSheetData getExcelSheetData = new GetExcelSheetData();
		String StartDate = getExcelSheetData.getSheetData("i3", 20, 0);
		String EndDate = getExcelSheetData.getSheetData("i3", 20, 1);
		String StartTime = getExcelSheetData.getSheetData("i3", 20, 2);
		String EndTime = getExcelSheetData.getSheetData("i3", 20, 3);
		
		Thread.sleep(2000);
		webdriverWaitForElement(startDate);
		startDate.sendKeys(Keys.CONTROL + "a");
		startDate.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		webdriverWaitForElement(startDate);
		startDate.sendKeys(StartDate);
		
		Thread.sleep(2000);
		webdriverWaitForElement(endDate);
		endDate.sendKeys(Keys.CONTROL + "a");
		endDate.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		webdriverWaitForElement(endDate);
		endDate.sendKeys(EndDate);
		
		webdriverWaitForElement(addButton);
		clickElement(addButton);
		
		Thread.sleep(3000);
		webdriverWaitForElement(startTime);
		startTime.sendKeys(StartTime);
		
		webdriverWaitForElement(endTime);
		endTime.sendKeys(EndTime);
		
		webdriverWaitForElement(saveButton);
		clickElement(saveButton);
		
		webdriverWaitForElement(continueButton);
		clickElement(continueButton);
		
	}
}
