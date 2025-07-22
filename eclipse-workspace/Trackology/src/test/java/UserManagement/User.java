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

public class User {

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

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement usersMenu = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//a[contains(@href, '/user-management') and contains(@class, 'fuse-list-item')]")
		));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", usersMenu);
		System.out.println("✅ Clicked on Users menu");
		
		
		//Click On Invite Button 
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement inviteBtn = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//button[normalize-space()='Invite User']")
		));
		inviteBtn.click();
		System.out.println("✅ Invite User button clicked successfully");

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//input[@placeholder='Enter email address']")
		));
		emailInput.sendKeys("lakshya@yopmail.com");
		System.out.println("✅ Email entered successfully");

		
		// Select Role 
		
		// 1. Click on the dropdown to expand it
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//div[@role='combobox' and contains(@class, 'MuiSelect-select')]")
		));
		dropdown.click();

		// 2. Wait for the option and click on "Supervisor"
		WebElement supervisorOption = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//li[text()='Supervisor']")
		));
		supervisorOption.click();

		System.out.println("✅ 'Supervisor' option selected successfully"); 
		
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the Send Invitation button to be clickable
		WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//button[normalize-space()='Send Invitation']")
		));

		// Click the button
		sendButton.click();

		System.out.println("✅ 'Send Invitation' button clicked successfully.");


		
	}

}
