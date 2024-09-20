package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity2 extends baseClass{
	WebDriver driver;
  @Test
  public void headerImage() {
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  WebElement image = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
	  String URL = image.getAttribute("src");
	  System.out.println("URL of the header image: "+ URL);
  }
}
