package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ru.esteru.selenium.factory.WebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AddNewFilmTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
    baseUrl = "http://localhost";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void addNewFilmTest() {
	  goToMainPage();
	  loginAs("admin", "admin");
	  driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
	  driver.findElement(By.name("name")).clear();
	  driver.findElement(By.name("name")).sendKeys("Test");
	  driver.findElement(By.name("aka")).clear();
	  driver.findElement(By.name("aka")).sendKeys("sdfh sdfg sazgh");
	  driver.findElement(By.name("year")).clear();
	  driver.findElement(By.name("year")).sendKeys("2016");
	  driver.findElement(By.name("duration")).clear();
	  driver.findElement(By.name("duration")).sendKeys("90");
	  driver.findElement(By.name("rating")).clear();
	  driver.findElement(By.name("rating")).sendKeys("1");
	  driver.findElement(By.id("cover")).clear();
	  driver.findElement(By.id("cover")).sendKeys("C:\\Users\\Lenovo\\Desktop\\test.jpg");
	  driver.findElement(By.id("submit")).click();
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

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
