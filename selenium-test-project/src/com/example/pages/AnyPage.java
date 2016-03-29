package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnyPage extends BasePage {
	
	@FindBy(xpath = "//a[contains(@href, './?lang=en_US')]")
	public WebElement programLanguageEn;
	
	@FindBy(xpath = "//a[contains(@href, './?lang=nl_NL')]")
	public WebElement programLanguageNed;
	
}
