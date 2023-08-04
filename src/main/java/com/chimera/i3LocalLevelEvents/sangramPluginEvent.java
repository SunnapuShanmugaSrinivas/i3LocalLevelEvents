package com.chimera.i3LocalLevelEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sangramPluginEvent {

	public WebDriver driver;
	public static int TIMEOUT = 20;
	
	public sangramPluginEvent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickElement(WebElement element) {
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	
	@FindBy(how = How.XPATH, using = "//h2[text()='Sangram_Plugin Event']")
	protected WebElement title;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='cutoff'])[1]")
	protected WebElement addEvent;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='cutoff'])[2]")
	protected WebElement findEvents;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='cutoff'])[3]")
	protected WebElement myAccount;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='cutoff'])[4]")
	protected WebElement support;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='cutoff'])[5]")
	protected WebElement Notifications;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='cutoff'])[6]")
	protected WebElement Logout;
	
	
	public void sangramActions() {
		clickElement(addEvent);
	}
	
}
