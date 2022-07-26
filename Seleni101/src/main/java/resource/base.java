package resource;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class base {
	public WebDriver driver;

	@Parameters({"browser"})
	@BeforeClass
	public WebDriver initializeDriver(String browser) throws IOException {
		System.out.println("Browser name is:" + browser);
		if (browser.equals("chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Seleni101\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver.get("https://www.lambdatest.com/selenium-playground/");
		}

				else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium\\Seleni101\\BrowserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	@AfterClass
	
	public void Teardown() {
		driver.close();
	}
}
