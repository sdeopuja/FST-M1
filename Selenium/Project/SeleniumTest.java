package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Download the Gecko driver
		WebDriverManager.firefoxdriver().setup();
		
		//Initialize the driver
		WebDriver driver = new FirefoxDriver();
		
		//Open the URL
		driver.get("https://v1.training-support.net/");
		
		System.out.println("Title of the page is: "+driver.getTitle());
		
		//Close the browser
		driver.quit();

	}

}
