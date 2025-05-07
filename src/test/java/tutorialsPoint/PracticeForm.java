package tutorialsPoint;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeForm {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();
	}

	@Test
	public void studentRegistrationForm() {
		// Enter Name
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Roronoa Zoro");

		// Enter Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("zoro.sword@gmail.com");

		// Select Gender
		driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[1]")).click();

		// Enter Mobile Number
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("1234567890");
		
		// Enter Date of Birth
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("12-02-2026");

		// Enter subjects
		driver.findElement(By.xpath("//input[@id='subjects']")).sendKeys("Java, Selenium, MySQL");

		// Select Hobbies
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement cb : checkBoxes) {
			cb.click();
		}

		// Choose Picture
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='picture']"));
		chooseFile.sendKeys(System.getProperty("user.dir") + "//testDataImages//@Getsesko.jpeg");

		// Enter Current address
		driver.findElement(By.xpath("//textarea[@id='picture']")).sendKeys("Tokyo, Japan");

		// Select State
		WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
		Select sl = new Select(state);
		sl.selectByIndex(2);

		// Select City
		WebElement city = driver.findElement(By.xpath("//select[@id='city']"));
		Select sc = new Select(city);
		sc.selectByIndex(2);

		// Click Login Button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
