package tutorialsPoint;

import java.time.Duration;

import org.openqa.selenium.By;
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
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
		driver.manage().window().maximize();
	}

	@Test
	public void Login() {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("monkey.d.luffy@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("OnePieceHunter");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
