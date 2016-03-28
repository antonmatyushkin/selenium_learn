package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends AnyPage {

	@FindBy(xpath = "//a[@href='http://localhost/php4dvd/']")
	public WebElement menuHomeLink;
	
	@FindBy(xpath = "//a[@href='http://localhost/php4dvd/?go=profile']")
	public WebElement menuMyProfileLink;
	
	@FindBy(xpath = "//a[@href='http://localhost/php4dvd/?go=users']")
	public WebElement menuUserManagmentLink;

	@FindBy(xpath = "//a[@href='http://localhost/php4dvd/?logout']")
	public WebElement menuLogoutLink;
}
