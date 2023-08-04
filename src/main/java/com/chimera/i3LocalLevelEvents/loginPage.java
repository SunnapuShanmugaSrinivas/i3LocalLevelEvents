package com.chimera.i3LocalLevelEvents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.chimera.i3.elements.loginPageElements;

public class loginPage  {

	public WebDriver driver = null;
	public static int TIMEOUT = 20;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public WebElement webdriverWaitForElement(WebElement element) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void loginPageActions() throws Throwable {
		
		GetExcelSheetData getExcelSheetData = new GetExcelSheetData();
		String username = getExcelSheetData.getSheetData("i3", 2, 0);
		String password = getExcelSheetData.getSheetData("i3", 2, 1);
		loginPageElements lpe = PageFactory.initElements(driver, loginPageElements.class);
		
		lpe.getEmailAddress().sendKeys(username);
		
		lpe.getPassword().sendKeys(password);
		
		lpe.getSignInButton().click();
	}
	
	
}
