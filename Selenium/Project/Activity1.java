package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 extends baseClass{
	WebDriver driver;
  @Test
  public void verifyWebsiteTitle() {
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  String title = driver.getTitle();
	  Assert.assertEquals(title, "OrangeHRM");
  }
}
