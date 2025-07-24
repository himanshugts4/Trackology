package UserManagement;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditRole {

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

		// User Management
		WebElement usermanagement = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='User Management']")));
		usermanagement.click();
		System.out.println("✅ Clicked on User Management Menu");

		// Click Role & Permission Menu
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement usersMenu = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Roles & Permissions']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", usersMenu);
		System.out.println("✅ Clicked on Role & Permission menu");

		WebElement svgIcon = driver.findElement(By.xpath("//tbody/tr[4]/td[4]/button[1]//*[name()='svg']"));

		if (svgIcon.isDisplayed() && svgIcon.isEnabled()) {
			svgIcon.click();
			System.out.println("SVG icon clicked successfully.");
		} else {
			System.out.println("SVG icon not clickable.");
		}

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement editOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[.//span[normalize-space()='Edit']]")));
		editOption.click();
		System.out.println("✅ 'Edit' option clicked successfully.");

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the toggle switch to be clickable
		WebElement toggle = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[contains(@class, 'MuiFormControlLabel-root')])[3]")));

		// Click the toggle switch
		toggle.click();

		System.out.println("✅ Category Managemnet Toggle button clicked.");
		
		
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the toggle switch to be clickable
		WebElement toggle5 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//label[contains(@class, 'MuiFormControlLabel-root')])[4]")));

		// Click the toggle switch
		toggle5.click();

		System.out.println("✅ Role Managemnet Toggle button clicked.");


		WebElement expandIcon = driver
				.findElement(By.xpath("(//*[name()='svg' and @data-testid='ExpandMoreIcon'])[2]"));
		expandIcon.click();
		System.out.println("✅ Role Managemnet Collapse Option clicked.");

		WebElement UpdateButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Update']")));
		UpdateButton.click();
		System.out.println("✅ Update button clicked successfully");
		
		
		
		
		

	}

}
