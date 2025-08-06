package Reports;

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

public class GenerateReport {

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
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Tracking & Reporting']")));
		usermanagement.click();
		System.out.println("✅ Clicked on Tracking & Reporting Menu");

		// Click General Report Menu
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement usersMenu = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='General Reports']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", usersMenu);
		System.out.println("✅ Clicked on General Report menu");

		// Click on Device Registration
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement AddRole = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Device Registration']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddRole);
		System.out.println("✅ Clicked on Device Registration Tab ");

		// Click on Device Registration
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement Subscription = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Subscription']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subscription);
		System.out.println("✅ Clicked on Subscription Tab ");

		// Click on User Activity
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement UserActivity = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='User Activity']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", UserActivity);
		System.out.println("✅ Clicked on User Activity Tab ");

		// Click on Geofence Activity
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement GeofenceActivity = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Geofence Activity']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", GeofenceActivity);
		System.out.println("✅ Clicked on Geofence Activity Tab ");

	
		
		// Click to open the start date picker
		driver.findElement(By.xpath("//input[@placeholder='Select start date']")).click();

		// Click on the Previous Month button (move calendar back by one month)
		driver.findElement(By.xpath("//button[@title='Previous month']//*[name()='svg']")).click();

		// [Optional] Click on calendar icon (unclear from previous code, but including as you had it)
		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M7 10l5 5 ')]")).click();

		// Click on the year "2024"
		driver.findElement(By.xpath("//button[normalize-space()='2024']")).click();

		// Click on a specific date — for example, 5th of the month
		driver.findElement(By.xpath("//button[normalize-space()='5']")).click();

		// Click OK to confirm date selection (if required by the calendar UI)
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();

		System.out.println("✅ Start Date Successfully Selected");  
		
		
		// Click to open the End date picker
				driver.findElement(By.xpath("//input[@placeholder='Select end date']")).click();

				// Click on the Previous Month button (move calendar back by one month)
				driver.findElement(By.xpath("//button[@title='Previous month']//*[name()='svg']")).click();

				// [Optional] Click on calendar icon (unclear from previous code, but including as you had it)
				driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M7 10l5 5 ')]")).click();

				// Click on the year "2024"
				driver.findElement(By.xpath("//button[normalize-space()='2024']")).click();

				// Click on a specific date — for example, 5th of the month
				driver.findElement(By.xpath("//button[normalize-space()='6']")).click();

				// Click OK to confirm date selection (if required by the calendar UI)
				driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();

				System.out.println("✅ End Date Successfully Selected");  

				// Date Filter Reset
				driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
		
				System.out.println("✅ Date Filter reset Successfully");  
		

	}

}
