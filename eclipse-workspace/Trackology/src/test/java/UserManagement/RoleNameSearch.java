package UserManagement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RoleNameSearch {
	
	
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
		
		
	Thread.sleep(5000);
		
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for the input to be visible
		WebElement roleNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(" //input[@placeholder='Search by name']")
		));

		// Send keys to the input
		roleNameInput.sendKeys("A1");

		System.out.println("✅ Role name entered successfully.");

		
		
		
		
		
	}

}
