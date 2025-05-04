package tutorialsPoint;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterForm {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
		driver.manage().window().maximize();
	}

	@Test
	public void registerForm() {
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
		WebElement enterEmail = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement enterPassword = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Register']"));
		firstName.sendKeys("Naruto");
		lastName.sendKeys("Uzumaki");
		enterEmail.sendKeys("narutouzumaki7@gmail.com");
		enterPassword.sendKeys("7Hokage");
		registerBtn.click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
