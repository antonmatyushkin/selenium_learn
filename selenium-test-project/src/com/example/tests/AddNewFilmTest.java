package com.example.tests;

import org.junit.*;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.*;
import ru.esteru.selenium.factory.WebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewFilmTest {
  private WebDriver driver;
  private WebDriverWait wait;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
	wait = new WebDriverWait(driver, 10);
    baseUrl = "http://localhost";
  }

  @Test
  public void testAddNewFilm() throws Exception {
	  goToMainPage();
	  loginAs("admin", "admin");
	  goToMovieAddPage();
	  addNewMovieWriteInRequeredFields("Test", "2016", "D:\\Selenium\\test.jpg");
	  logout();
  }

  private void goToMainPage() {
		driver.get(baseUrl + "/php4dvd/");
  }
  
  private void loginAs(String username, String password) {
		WebElement userNameField = wait.until(visibilityOfElementLocated(By.id("username")));
		userNameField.clear();
	    userNameField.sendKeys(username);
	    WebElement passwordField = wait.until(visibilityOfElementLocated(By.name("password")));
		passwordField.clear();
	    passwordField.sendKeys(password);
	    wait.until(visibilityOfElementLocated(By.name("submit"))).click();
  }

  private void goToMovieAddPage() {
	  driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
  }
  
  private void addNewMovieWriteInRequeredFields(String movieName, String year, String localPathToCover) {
	WebElement movieNameField = wait.until(visibilityOfElementLocated(By.name("name")));
	movieNameField.clear();
	movieNameField.sendKeys(movieName);
	WebElement movieYearFieald = wait.until(visibilityOfElementLocated(By.name("year")));
	movieYearFieald.clear();
	movieYearFieald.sendKeys(year);
	WebElement movieCoverField = wait.until(visibilityOfElementLocated(By.id("cover")));
	movieCoverField.clear();
	movieCoverField.sendKeys(localPathToCover);
	wait.until(visibilityOfElementLocated(By.id("submit")));
  }
  
  public void logout() {
	  wait.until(visibilityOfElementLocated(By.linkText("Log out"))).click();
	  wait.until(alertIsPresent()).accept();
  }

  @After
  public void tearDown() throws Exception {
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}