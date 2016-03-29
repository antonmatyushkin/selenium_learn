package com.example.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieListPage extends InternalPage {
	/*
	@FindBy(xpath = "//div[@id='results']/a[1]")
	public WebElement linksToMovie;
	*/
	@FindBy(xpath = "//div[@id='results']//img")
	public List<WebElement> linksToMovies;
	
	@FindBy(id = "movie")
	public WebElement movieForm;
	
	public boolean isOnMoviePage() {
		return movieForm.isDisplayed();
	}
}
