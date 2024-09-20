package activities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity8 extends baseClass{
  @Test
  public void applyLeave() {
	  
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  driver.findElement(By.id("txtUsername")).sendKeys("orange");
	  driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	  driver.findElement(By.id("btnLogin")).click();
	  Reporter.log("Clicked on login button", true);
	  
	  String text = driver.findElement(By.xpath("//div[@id='panel_draggable_1_0']/fieldset/legend")).getText();
	  Assert.assertEquals("Employee Distribution by Subunit", text);
	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Assign Leave")));
	  Reporter.log("User is navigated to Dashboard", true);
	  
	  driver.findElement(By.linkText("Apply Leave")).click();
	  driver.findElement(By.linkText("Apply Leave")).click();
	  Select objSelect = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
	  objSelect.selectByValue("1");
	  
	  WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
	  fromDate.clear();
	  String fromDateValue = "2024-10-21";
	  fromDate.sendKeys(fromDateValue);
	  fromDate.sendKeys(Keys.TAB);
	  
	  WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
	  toDate.clear();
	  String toDateValue = "2024-10-25";
	  toDate.sendKeys(toDateValue);
	  toDate.sendKeys(Keys.TAB);
	  
	  driver.findElement(By.id("applyBtn")).click();
	  
	  driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
	  driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
	  
	  WebElement calFromDate = driver.findElement(By.id("calFromDate"));
	  calFromDate.clear();
	  calFromDate.sendKeys(fromDateValue);
	  calFromDate.sendKeys(Keys.TAB);
	  
	  WebElement calToDate = driver.findElement(By.id("calToDate"));
	  calToDate.clear();
	  calToDate.sendKeys(toDateValue);
	  calToDate.sendKeys(Keys.TAB);
	  
	  driver.findElement(By.id("btnSearch")).click();
	  
	  WebElement cell = driver.findElement(By.xpath("//table[@id=\"resultTable\"]/tbody/tr/td[1]"));
	  String cellValue = cell.getText();
	  Assert.assertEquals(cellValue, fromDateValue+ " "+"to"+" "+toDateValue);
	  
	  
  }
}
