package com.example.tests;

import org.junit.*;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.esteru.selenium.factory.WebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AddNewUserTest {
  private WebDriver driver;
  private WebDriverWait wait;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
	driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
	wait = new WebDriverWait(driver, 10);
    baseUrl = "http://localhost";
  }

  @Test
  public void addNewUserTest() {
	goToMainPage();
	loginAs("admin", "admin");
    goToUserManagmentPage();
    addNewUser("tester", "test@test.ru", "123456");
    assertTrue("Пользователь не создан!", findCreatedUser());
    assertFalse("Пользователь уже существует!", duplicateToCreatedUser());
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

  public void addNewUser(String username, String email, String password) {
	  WebElement userNameField = wait.until(visibilityOfElementLocated(By.id("username")));
	  userNameField.clear();
	  userNameField.sendKeys(username);
	  WebElement emailField = wait.until(visibilityOfElementLocated(By.name("email")));
	  emailField.clear();
	  emailField.sendKeys(email);
	  WebElement passwordField = wait.until(visibilityOfElementLocated(By.name("password")));
	  passwordField.clear();
	  passwordField.sendKeys(password);
	  WebElement passwordAgainField = wait.until(visibilityOfElementLocated(By.name("password2")));
	  passwordAgainField.clear();
	  passwordAgainField.sendKeys(password);
	  new Select(driver.findElement(By.name("permission"))).selectByVisibleText("Editor");
	  wait.until(visibilityOfElementLocated(By.name("submit"))).click();
  }

  public void goToUserManagmentPage() {
	  driver.findElement(By.linkText("User management")).click();
  }
  
  public void logout() {
	  wait.until(visibilityOfElementLocated(By.linkText("Log out"))).click();
	  wait.until(alertIsPresent()).accept();
  }

  private boolean findCreatedUser() {
	return driver.findElements(By.linkText("tester")).size() > 0;
  }
  
  private boolean duplicateToCreatedUser() {
	return driver.findElements(By.className("error")).size() > 0;
  }
}