package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resource.base;


public class Scenario3 extends base{


 @Test(priority=1)
	public void inputFormSubmit() throws Throwable {
		//driver=base.initializeDriver("browser");
		String originalTitle = "Please fill out this field";
		String expectedTitle = "Please fill in this field";
		
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.findElement(By.xpath("//a[text()='Input Form Submit']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals(originalTitle, expectedTitle);
		System.out.println("Assert is working as Expected");
		driver.findElement(By.id("name")).sendKeys("HEllo");
		driver.findElement(By.id("inputEmail4")).sendKeys("HEllo@123.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("HEllo@123");
		driver.findElement(By.id("company")).sendKeys("HEllo123");
		driver.findElement(By.id("websitename")).sendKeys("HEllo123.com");
		WebElement country = driver.findElement(By.name("country"));
		country.click();
		String expectedCountry = "United States";
		Select scountry = new Select(country);
		scountry.selectByVisibleText(expectedCountry);
		driver.findElement(By.id("inputCity")).sendKeys("MyCity");
		driver.findElement(By.id("inputAddress1")).sendKeys("MyAddress1");
		driver.findElement(By.id("inputAddress2")).sendKeys("MyAddress2");
		driver.findElement(By.id("inputState")).sendKeys("MyState");
		driver.findElement(By.id("inputZip")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3);
		String expSuccessMsg = "Thanks for contacting us, we will get back to you shortly.";
		String actSuccessMsg = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
		Assert.assertEquals(actSuccessMsg, expSuccessMsg);
		System.out.println("Success Message is as Expected");
		System.out.println("Scenario3 working as Expected");
		driver.close();
		
	}
}
