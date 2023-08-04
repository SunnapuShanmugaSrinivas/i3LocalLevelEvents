package com.chimera.i3LocalLevelEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	public WebDriver driver;
	public static int TIMEOUT = 20;
	
	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "(//a[@class='btn btn-default btn-hvr hvr-shutter-out-horizontal margin-clear'])[1]")
	protected WebElement LLESangram;
	
	public void getLLESangram() {
		LLESangram.click();
	}
	
	
}
