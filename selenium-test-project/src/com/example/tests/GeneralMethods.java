package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GeneralMethods {

	public WebDriver driver;
	public String baseUrl = "http://localhost";;
	
	public void StartApplication() {
		driver.get(baseUrl + "/php4dvd/");
	}

}
