package activities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity7 extends baseClass{
  @Test
  public void addQualifications() {
	  
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
	  
	  driver.findElement(By.linkText("Qualifications")).click();
	  driver.findElement(By.id("addWorkExperience")).click();
	  
	  driver.findElement(By.id("experience_employer")).sendKeys("IBM");
	  driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");
	  driver.findElement(By.id("btnWorkExpSave")).click();
	  
  }
}
