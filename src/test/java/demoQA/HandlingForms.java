package demoQA;

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

public class HandlingForms {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
	}

	@Test
	public void practiceForm() {

		// Enter First name
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Monkey D");

		// Enter Last name
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Luffy");

		// Enter email
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("thundergod@gmail.com");

		// Select gender
		List<WebElement> gender = driver
				.findElements(By.xpath("//div[@id='genterWrapper']//div[contains(@class,'col-md-9 col-sm-12')]//div"));
		for (WebElement gen : gender) {
			if (gen.getText().equals("Male")) {
				gen.click();
			}
		}

		// Enter Mobile number
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("1234567892");

		// Enter Date of Birth
		DateOfBirth(driver);

		// Enter subjects
//		Subjects(driver);

		// Enter Hobbies
		List<WebElement> hobbie = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement hb : hobbie) {
			hb.click();
		}

		// Enter photo
		driver.findElement(By.xpath("//input[@id='uploadPicture']"))
				.sendKeys(System.getProperty("user.dir")+"\\ImagesForTest.jpeg");

		// Enter current Address
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Vijayawada, Andhra Pradesh, India");

		// Enter state
		WebElement stateSelct = driver.findElement(
				By.xpath("//div[@class=' css-yk16xz-control']//div[@class=' css-tlfecz-indicatorContainer']"));
		Select state = new Select(stateSelct);
		state.selectByVisibleText("Uttar Pradesh");

		// Enter city
		WebElement citySelect = driver
				.findElement(By.xpath("//div[@id='city']//div[contains(@class,'css-tlfecz-indicatorContainer')]"));
		Select city = new Select(citySelect);
		city.selectByVisibleText("Agra");

		// Click Submit
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void DateOfBirth(WebDriver driver) {
		String reqMonth = "July";
		String reqYear = "2022";
		String reqDate = "15";
		// Click on datePicker
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		// Select Month and Year
		WebElement monthDrp = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		WebElement yearDrp = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select month = new Select(monthDrp);
		month.selectByVisibleText(reqMonth);
		Select year = new Select(yearDrp);
		year.selectByVisibleText(reqYear);
		// Select Date
		List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div//div"));
		for (WebElement ad : allDates) {
			if (ad.getText().equals(reqDate)) {
				ad.click();
				break;
			}
		}
	}

	public static void Subjects(WebDriver driver) {
//		WebElement subject = driver.findElement(By.xpath(
//				"//div[@class='subjects-auto-complete__control css-yk16xz-control']"));
		WebElement subject = driver.findElement(By.cssSelector(".subjects-auto-complete__control.css-yk16xz-control"));
		subject.sendKeys("Maths");
		driver.findElement(By.xpath("//div[@id='react-select-2-option-0']")).click();
		subject.sendKeys("English");
		driver.findElement(By.xpath("//div[@id='react-select-2-option-0']")).click();
		
		
	}

}
