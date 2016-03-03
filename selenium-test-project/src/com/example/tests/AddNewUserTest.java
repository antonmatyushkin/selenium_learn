package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ru.esteru.selenium.factory.WebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AddNewUserTest {
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
  public void addNewUserTest() {
	goToMainPage();
	loginAs("admin", "admin");
    goToUserManagmentPage();
    //addNewUser("tester", "test@test.ru", "123456");
    addNewUser("", "", "");
    //assertTrue("Не заполнены обязательные поля!", fieldIsNotRequired());
    assertTrue("Пользователь не создан!", findCreatedUser());
    assertFalse("Пользователь уже существует!", duplicateToCreatedUser());
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

  public void addNewUser(String username, String email, String password) {
	  driver.findElement(By.id("username")).clear();
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("email")).sendKeys(email);
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.id("password2")).clear();
	  driver.findElement(By.id("password2")).sendKeys(password);
	  new Select(driver.findElement(By.name("permission"))).selectByVisibleText("Editor");
	  driver.findElement(By.name("submit")).click();
}

  public void goToUserManagmentPage() {
	  driver.findElement(By.linkText("User management")).click();
}
  
  public void logout() {
	driver.findElement(By.linkText("Log out")).click();
	driver.switchTo().alert().accept();
  }
/*//В данном методе не получается определить getText! 
  public boolean fieldIsNotRequired() {
	return driver.findElements(By.name("username")).get(0).getText("This field is required");
  }
*/
  private boolean findCreatedUser() {
	return driver.findElements(By.linkText("tester")).size() > 0;
  }
  
  private boolean duplicateToCreatedUser() {
	return driver.findElements(By.className("error")).size() > 0;
  }

  @After
  public void tearDown() throws Exception {
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}