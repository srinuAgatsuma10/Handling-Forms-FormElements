package ultimateQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		driver.get("https://ultimateqa.com/filling-out-forms/");
		driver.manage().window().maximize();
	}

	@Test
	public void formOne() {
		driver.findElement(By.xpath("//input[@id='et_pb_contact_name_0']")).sendKeys("Monkey D Luffy");
		driver.findElement(By.xpath("//textarea[@id='et_pb_contact_message_0']"))
				.sendKeys("I'll became the king of the pirates");
		driver.findElement(By.xpath(
				"//div[@id='et_pb_contact_form_0']//button[@name='et_builder_submit_button'][normalize-space()='Submit']"))
				.click();
		String greet = driver
				.findElement(
						By.xpath("//div[@id='et_pb_contact_form_0']//p[contains(text(),'Thanks for contacting us')]"))
				.getText();
		System.out.println("Form One" + greet);
	}

	@Test
	public void fromTwo() {
		driver.findElement(By.xpath("//input[@id='et_pb_contact_name_1']")).sendKeys("Monkey D Luffy");
		driver.findElement(By.xpath("//textarea[@id='et_pb_contact_message_1']"))
				.sendKeys("I'll became the king of the pirates");

		WebElement condition = driver.findElement(By.xpath("//span[@class='et_pb_contact_captcha_question']"));
		int a = Integer.parseInt(condition.getText().substring(1, 2));
		int b = Integer.parseInt(condition.getText().substring(0, 1));
		int result = a + b;
		String res = String.valueOf(result);
		driver.findElement(By.xpath("//input[@name='et_pb_contact_captcha_1']")).sendKeys(res);
		driver.findElement(By.xpath(
				"//div[@id='et_pb_contact_form_1']//button[@name='et_builder_submit_button'][normalize-space()='Submit']"))
				.click();
		String greet = driver
				.findElement(
						By.xpath("//div[@id='et_pb_contact_form_1']//p[contains(text(),'Thanks for contacting us')]"))
				.getText();
		System.out.println("Form One" + greet);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
