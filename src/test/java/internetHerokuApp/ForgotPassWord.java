package internetHerokuApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPassWord {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/forgot_password");
		driver.manage().window().maximize();
	}

	@Test
	public void forgotPassword() {
		// Email Box
		WebElement emailBox = driver.findElement(By.xpath("//input[@id='email']"));
		emailBox.sendKeys("alexander@gmail.com");

		driver.findElement(By.xpath("//button[@id='form_submit']")).click();

		String text = "Internal Server Error";
		String resultText = driver.findElement(By.xpath("//h1[normalize-space()='Internal Server Error']")).getText();
		if (resultText == text) {
			Assert.assertTrue(false);
		}
		Assert.assertTrue(true);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
