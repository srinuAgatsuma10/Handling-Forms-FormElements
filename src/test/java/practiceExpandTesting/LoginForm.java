package practiceExpandTesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginForm {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://practice.expandtesting.com/login");
		driver.manage().window().maximize();
	}

	@Test
	public void loginForm() {
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
