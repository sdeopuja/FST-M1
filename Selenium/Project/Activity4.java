package activities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity4 extends baseClass{
  @Test
  public void addEmployee() throws InterruptedException {
	  driver.get("http://alchemy.hguy.co/orangehrm");
	  driver.findElement(By.id("txtUsername")).sendKeys("orange");
	  driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	  driver.findElement(By.id("btnLogin")).click();
	  Reporter.log("Clicked on login button", true);
	  String dashboard = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
	  Assert.assertEquals(dashboard, "Dashboard");
	  Reporter.log("User is navigated to Home page", true);
	  
	  Thread.sleep(5000);
	  driver.findElement(By.id("menu_pim_viewPimModule")).click();
	  String EmployeeInformation = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
	  Assert.assertEquals(EmployeeInformation, "Employee Information");
	  driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
	  Reporter.log("Adding new employee details", true);
	  
	  String firstName = "Robert";
	  String lastName = "Junior";
	  driver.findElement(By.id("firstName")).sendKeys(firstName);
	  driver.findElement(By.id("lastName")).sendKeys(lastName);
	  String id = driver.findElement(By.id("employeeId")).getAttribute("value");
	  driver.findElement(By.id("btnSave")).click();
	  String PersonalInformation = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
	  Assert.assertEquals(PersonalInformation, "Personal Details");
	  Reporter.log("Added a new employee", true);
	  
	  driver.findElement(By.id("menu_pim_viewPimModule")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(firstName+" "+lastName);
	  driver.findElement(By.id("searchBtn")).click();
	  
	  String resultid = driver.findElement(By.xpath("//td[@class='left']/a")).getText();
	  Assert.assertEquals(resultid, id);
	  Reporter.log("Employee added successfully with details as follows:"+" "+"ID="+id+","+" "+"First Name="+firstName+","+" "+"LastName="+","+lastName, true);
	  
  }
}
