package activities;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

public class Activity5 extends baseClass{
  @Test
  public void loginToSite() throws InterruptedException {
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  driver.findElement(By.id("txtUsername")).sendKeys("orange");
	  driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	  driver.findElement(By.id("btnLogin")).click();
	  Reporter.log("Clicked on login button", true);
	  
	  String text = driver.findElement(By.xpath("//div[@id='panel_draggable_1_0']/fieldset/legend")).getText();
	  Assert.assertEquals("Employee Distribution by Subunit", text);
	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Assign Leave")));
	  Reporter.log("User is navigated to Dashboard", true);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewMyDetails']")));
	  driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	  driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	  Reporter.log("User is navigated to My Info page", true);
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='personalDetails']/div/h1")));
	  driver.findElement(By.xpath("//input[@value='Edit']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpMiddleName")));
	  
	  String editFirstName = "Jill";
	  String editLastName = "New";
	  
	  WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
	  firstName.clear();
	  firstName.sendKeys(editFirstName);
	  Reporter.log("Edited firstName to"+" "+editFirstName, true);
	  
	  WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
	  lastName.clear();
	  lastName.sendKeys(editLastName);
	  Reporter.log("Edited lastName to"+" "+editLastName, true);
	  
	  driver.findElement(By.id("personal_optGender_2")).click();
	  driver.findElement(By.id("personal_cmbNation")).sendKeys("Canadian");
	  driver.findElement(By.xpath("//input[@value='Save']")).click();
	  Reporter.log("Edited user information", true);
	  
	  System.out.println(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"));
	  System.out.println(driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value"));
  }

}

