package com.chimera.i3.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPageElements {
	
	@FindBy(how = How.XPATH, using = "//a[@id='login-tab']")
	protected WebElement existingUserTab;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary btn-sm']")
	private WebElement loginButtonInHomepage;

	@FindBy(how = How.XPATH, using = "//input[@id='em']")
	protected WebElement EmailAddress;

	@FindBy(how = How.XPATH, using = "//input[@id='pw']")
	protected WebElement Password;

	@FindBy(how = How.XPATH, using = "//input[@name='login_submit']")
	protected WebElement signInButton;


	public WebElement getExistingUserTab() {
		return existingUserTab;
	}
	
	public WebElement getLoginButtonInHomepage() {
		return loginButtonInHomepage;
	}
	
	public WebElement getEmailAddress() {
		return EmailAddress;
	}
	
	public WebElement getPassword() {
		return Password;
	}
	
	public WebElement getSignInButton() {
		return signInButton;
	}
}
