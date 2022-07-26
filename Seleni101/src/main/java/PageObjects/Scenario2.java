package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resource.base;



public class Scenario2 extends base {
 
	
	
	@Test(priority=1)
	public void dragAndDropSliders1() throws IOException {
		System.out.println(driver);
		String expectedValue = "95";
	//	driver=base.initializeDriver("browser");
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']")).click();
		WebElement slider = driver.findElement(By.xpath("(//input[@class='sp__range'])[3]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 102, 0).build().perform();
		String actualValue = driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
		SoftAssert Assert=new SoftAssert();
		Assert.assertEquals(expectedValue, actualValue);
		System.out.println("Scenario2 working as Expected");
		driver.close();
		
	}
}
