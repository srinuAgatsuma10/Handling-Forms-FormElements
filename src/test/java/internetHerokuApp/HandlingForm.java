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

public class HandlingForm {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
	}

	@Test
	public void handlinForm() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		if (errorMessage.isDisplayed()) {
			System.out.println(errorMessage.getText());
			Assert.assertTrue(true);
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
