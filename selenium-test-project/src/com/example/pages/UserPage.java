package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends InternalPage {

	@FindBy(id = "username")
	public WebElement userNameField;	//ƒанное поле так же описано в LoginPage.java
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(name = "password")
	public WebElement passwordField;	//ƒанное поле так же описано в LoginPage.java
										//но дл€ данного пол€ есть еще id = "password"
	
	@FindBy(name = "password2")
	public WebElement passwordAgainField;
	
	@FindBy(name = "permission")
	public WebElement permissionField;
	
	@FindBy(name = "submit")
	public WebElement saveButton;
}
