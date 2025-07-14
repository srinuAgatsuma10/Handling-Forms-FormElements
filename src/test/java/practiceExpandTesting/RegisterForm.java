package practiceExpandTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterForm {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://practice.expandtesting.com/register");
		driver.manage().window().maximize();
	}

	@Test
	public void registerForm()throws Exception {
		// User name
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		String user = "kingluffy";
		username.sendKeys(user.toLowerCase());
		// Password
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("KingLuffy!");
		// Confirm Password
		WebElement confPassword = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
		String pass = "KingLuffy!";
		confPassword.sendKeys(pass);
		Thread.sleep(3000);
		try {
		// Register
		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
		loginFunctionality(driver, user, pass);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Please check the WebElment Xpath");
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void loginFunctionality(WebDriver driver, String user, String pass)throws Exception {
		WebElement userId = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

		String title = driver.getTitle();

		userId.sendKeys(user);
		password.sendKeys(pass);
		try {
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			System.out.println(driver.findElement(By.xpath("//div[@id='flash']//b")).getText());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='button secondary radius btn btn-danger']")).click();

			Assert.assertEquals("Test Login Page for Automation Testin Practice", title);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Please check element's xpath");
		}
	}

}
