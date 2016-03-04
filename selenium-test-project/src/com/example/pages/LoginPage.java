package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AnyPage {
	
	@FindBy(id = "loginForm")
	public WebElement loginForm;
	
	@FindBy(id = "username")
	public WebElement userNameField;
	
	@FindBy(name = "password")
	public WebElement passwordField;
	
	@FindBy(name = "submit")
	public WebElement loginButton;
	
	public boolean isOnLoginPage() {
		return loginForm.isDisplayed();
  }
	
}
