package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import ru.esteru.selenium.factory.WebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AddNewFilmTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
    baseUrl = "http://localhost";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys(username);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("submit")).click();
  }

  private void goToMovieAddPage() {
	  driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
}
  
  private void addNewMovieWriteInRequeredFields(String movieName, String year, String localPathToCover) {
	  driver.findElement(By.name("name")).clear();
	  driver.findElement(By.name("name")).sendKeys(movieName);
	  driver.findElement(By.name("year")).clear();
	  driver.findElement(By.name("year")).sendKeys(year);
	  driver.findElement(By.id("cover")).clear();
	  driver.findElement(By.id("cover")).sendKeys(localPathToCover);
	  driver.findElement(By.id("submit")).click();
}
  
  public void logout() {
	driver.findElement(By.linkText("Log out")).click();
	driver.switchTo().alert().accept();
  }

  @After
  public void tearDown() throws Exception {
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}