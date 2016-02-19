package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Add_new_film {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddNewFilm() throws Exception {
	  driver.get(baseUrl + "/php4dvd/");
	  driver.findElement(By.id("username")).clear();
	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.name("submit")).click();
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