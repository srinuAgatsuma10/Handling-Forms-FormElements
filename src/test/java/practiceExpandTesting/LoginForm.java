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

//	@Test(priority = 1)
	public void loginFormValidCredens() {
		WebElement userId = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

		String title = driver.getTitle();

		userId.sendKeys("practice");
		password.sendKeys("SuperSecretPassword!");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']//b")).getText());

		driver.findElement(By.xpath("//a[@class='button secondary radius btn btn-danger']")).click();

		Assert.assertEquals("Test Login Page for Automation Testin Practice", title);
	}

//	@Test(priority = 2)
	public void loginFormInValidCredens()throws Exception {
		WebElement userId = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

		userId.sendKeys("practice");
		password.sendKeys("WrongPassword");

		driver.findElement(By.xpath("//button[@class=\"btn btn-bg btn-primary d-block w-100\"]")).click();
		
		Thread.sleep(3000);
		
		String resultMessage = driver.findElement(By.xpath("//div[@id='flash']//b")).getText();
		System.out.println(resultMessage);
		Assert.assertEquals("Your password is invalid!", resultMessage);
	}

	@Test(priority = 3)
	public void loginFormInValidCredens2()throws Exception {
		WebElement userId = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

		userId.sendKeys("WrongUserName");
		password.sendKeys("SuperSecretPassword!");
		
		driver.findElement(By.xpath("//button[@class='btn btn-bg btn-primary d-block w-100']")).click();
		
		Thread.sleep(3000);
		
		String resultMessage = driver.findElement(By.xpath("//div[@id='flash']//b")).getText();
		System.out.println(resultMessage);
		Assert.assertEquals("Your username is invalid!", resultMessage);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
