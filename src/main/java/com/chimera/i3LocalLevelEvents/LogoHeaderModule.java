package com.chimera.i3LocalLevelEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoHeaderModule {
	public WebDriver driver = null;
	public static int TIMEOUT = 20;
	protected WebDriverWait wait;
	
	public LogoHeaderModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public WebElement webdriverWaitForElement(WebElement element) {
		return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@name='header_preference'])[3]")
	protected WebElement orgDefaultHeader;
	
	@FindBy(how = How.XPATH, using = "//input[@id='photo']")
	protected WebElement uploadImage;
	
	@FindBy(how = How.XPATH, using = "(//input[@name='submit'])[1]")
	protected WebElement addPhotoBtn;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	protected WebElement discountsButton;
	
	
	
	public void LogoHeaderModuleActions() {
		
		webdriverWaitForElement(orgDefaultHeader);
		clickElement(orgDefaultHeader);
		
		webdriverWaitForElement(uploadImage);
		uploadImage.sendKeys("C:\\Users\\ShanmugaSrinivasS\\Downloads\\1111.jpg");
		
		webdriverWaitForElement(addPhotoBtn);
		clickElement(addPhotoBtn);
		
		webdriverWaitForElement(discountsButton);
		clickElement(discountsButton);
		
	}
	
}
