package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends AnyPage {

	@FindBy(linkText = "Home")
	public WebElement menuHomeLink;
	
	@FindBy(linkText = "My profile")
	public WebElement menuMyProfileLink;
	
	@FindBy(linkText = "User managment")
	public WebElement menuUserManagmentLink;

	@FindBy(linkText = "Log out")
	public WebElement menuLogoutLink;
}
