package Device;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditDevice {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://d3upskqh949jf6.cloudfront.net/sign-in");
	}

	@Test
	public void loginAndAddDeviceTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Login
		driver.findElement(By.name("email")).sendKeys("kavita1@yopmail.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.xpath("(//button[normalize-space()='Sign in'])[1]")).click();
		Thread.sleep(3000);

		// Sidebar toggle (if needed)
		try {
			WebElement toggleBtn = driver.findElement(By.xpath("//button[@aria-label='open drawer']"));
			toggleBtn.click();
		} catch (Exception e) {
			System.out.println("Sidebar already open or toggle not found.");
		}

		// Device Management
		WebElement deviceMgmtBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Device Management']")));
		deviceMgmtBtn.click();
		System.out.println("✅ Clicked on Device Menu");

		WebElement svgIcon = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/button[1]//*[name()='svg']"));

		if (svgIcon.isDisplayed() && svgIcon.isEnabled()) {
			svgIcon.click();
			System.out.println("SVG icon clicked successfully.");
		} else {
			System.out.println("SVG icon not clickable.");
		}

		
		   WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement editOption = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li[.//span[normalize-space()='Edit']]")
	        ));
	        editOption.click();
	        System.out.println("✅ 'Edit' option clicked successfully.");
	        
		
	}
}
