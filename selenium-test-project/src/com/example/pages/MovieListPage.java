package com.example.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieListPage extends InternalPage {

	private WebDriver driver;
    
    public MovieListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.setDriver(driver);
    }
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@id='results']//img")
	public List<WebElement> linksToMovies;
	
}