package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity3 extends baseClass{
  @Test
  public void loginToSite() {
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  driver.findElement(By.id("txtUsername")).sendKeys("orange");
	  driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	  driver.findElement(By.id("btnLogin")).click();
	  Reporter.log("Clicked on login button", true);
	  String dashboard = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
	  Assert.assertEquals(dashboard, "Dashboard");
	  Reporter.log("User is navigated to Home page", true);
	  
  }
 }
