package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resource.base;



public class Scenario1 extends base {
	
    
	@Parameters({"browser"})
	@Test(priority = 1)
	public void simpleFormDemo() throws IOException, Throwable {
		System.out.println(driver);
		System.out.println("Hello");
		String EnteredText = "Welcome to LambdaTest";
		//driver=base.initializeDriver("browser");
		driver.get("https://www.lambdatest.com/selenium-playground/");
		try {
		driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();
		}
		catch(Exception e) {
			e.getMessage();
		}
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.contains("simple-form-demo")) {
			System.out.println("Contains Expected URL");

		} else {
			System.out.println("UnExected URL");
		}

		driver.findElement(By.id("user-message")).sendKeys(EnteredText);
		driver.findElement(By.id("showInput")).click();
		System.out.println(driver.findElement(By.id("message")).getText().equals(EnteredText));
		System.out.println("Scenario1 working as Expected");
		//driver.close();

	}
}
