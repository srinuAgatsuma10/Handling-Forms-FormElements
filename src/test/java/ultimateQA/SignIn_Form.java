package ultimateQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignIn_Form {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://courses.ultimateqa.com/users/sign_in");
		driver.manage().window().maximize();
	}

	@Test
	public void signIn() {
		WebElement email = driver.findElement(By.xpath("//div[@class='sign-in__wrapper']//div[1]//input[1]"));
		WebElement password = driver.findElement(By.xpath("//div[@class='sign-in__wrapper']//div[1]//input[1]"));
		WebElement checkBox = driver.findElement(By.xpath("//div[@class='form__group form__remember-me']//input[contains(@id,'user')]"));

		email.sendKeys("thundergod123@gmail.com");
		password.sendKeys("thunderClap123");
		if (!checkBox.isSelected()) {
			checkBox.click();
		}
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

		WebElement warningText = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
		if (warningText.isDisplayed()) {
			driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
			driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("thundergod123@gmail.com");
			driver.findElement(By.xpath("//input[@name='commit']")).click();
			System.out.println(driver.findElement(By.xpath("//p[contains(text(),'If a user account is found,')]")).getText());
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
