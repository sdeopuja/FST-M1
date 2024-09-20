package activities;

import java.lang.System.Logger;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Activity9 extends baseClass{
  @Test
  public void emegrencyContacts() {
	  
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
	  
	  driver.findElement(By.linkText("Emergency Contacts")).click();
	  driver.findElement(By.id("emgcontact_list"));
	  
	  List<WebElement> tableValues = driver.findElements(By.xpath("//table[@id=\"emgcontact_list\"]/tbody/tr"));
	  for(WebElement element: tableValues) {
		  System.out.println(element.getText());  
	  }
	  
	  
	 
  }
}
