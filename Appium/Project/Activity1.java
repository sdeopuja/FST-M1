package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity"); 
		options.noReset();
		
		URL serverUrl = new URL("http://localhost:4723/");
		
		driver = new AndroidDriver(serverUrl, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	@Test
	public void googleTasks() {
		
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		String task1toadd = "Complete Activity with Google Tasks";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.tasks:id/add_task_title")));
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task1toadd);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_task_done")));
		driver.findElement(AppiumBy.id("add_task_done")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		String task2toadd = "Complete Activity with Google Keep";
		driver.findElement(AppiumBy.id("add_task_title")).sendKeys(task2toadd);
		driver.findElement(AppiumBy.id("add_task_done")).click();
				
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		String task3toadd = "Complete Activity with Google Tasks";
		driver.findElement(AppiumBy.id("add_task_title")).sendKeys(task3toadd);
		driver.findElement(AppiumBy.id("add_task_done")).click();
		
		String task1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity with Google Tasks\").instance(0)")).getText();
		Assert.assertEquals(task1, task1toadd);
		
		String task2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity with Google Keep\")")).getText();
		Assert.assertEquals(task2, task2toadd);

		String task3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity with Google Tasks\").instance(1)")).getText();
		Assert.assertEquals(task3, task3toadd);
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
