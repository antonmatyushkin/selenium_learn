package com.example.tests;

import org.junit.*;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.*;
import ru.esteru.selenium.factory.WebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
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
  public void loginTest() {
    goToMainPage();
    loginAs("admin", "admin");
    logout();
    assertTrue("Отсутствует форма логина!", isOnLoginPage());
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

  public void logout() {
	wait.until(visibilityOfElementLocated(By.linkText("Log out"))).click();
	wait.until(alertIsPresent()).accept();
  }
  
  private boolean isOnLoginPage() {
		return driver.findElements(By.id("loginform")).size() > 0;
  }

  @After
  public void tearDown() throws Exception {
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}