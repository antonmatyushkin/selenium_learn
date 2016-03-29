package com.example.tests;

import org.junit.*;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import ru.esteru.selenium.factory.WebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.example.pages.MovieListPage;

public class EditMovie {
	  private WebDriver driver;
	  private WebDriverWait wait;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private MovieListPage movieListPage;

	  @Before
	  public void setUp() throws Exception {
		  //driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
		  driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  wait = new WebDriverWait(driver, 10); 
		  baseUrl = "http://localhost";
	  }

	  @Test
	  public void testEditFilm() throws Exception {
		  goToMainPage();
		  loginAs("admin", "admin");
		  goToMovie();
		  assertTrue("Отсутствует форма логина!", movieListPage.isOnMoviePage());
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

	  private void goToMovie() {
		  movieListPage.linksToMovies.get(1).click();
	  }
	  
	  public void logout() {
		  wait.until(visibilityOfElementLocated(By.linkText("Log out"))).click();
		  wait.until(alertIsPresent()).accept();
	  }

	  @After
	  public void tearDown() throws Exception {
		//driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}
