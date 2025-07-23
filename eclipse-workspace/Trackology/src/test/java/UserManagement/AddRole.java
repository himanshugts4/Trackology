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

public class AddRole {

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

		WebElement usersMenu = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//a[normalize-space()='Roles & Permissions']")
		));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", usersMenu);
		System.out.println("✅ Clicked on Role & Permission menu");
		
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement AddRole = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//button[normalize-space()='Add New Role']")
		));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddRole);
		System.out.println("✅ Clicked on Add Role Button");
		
		
		// Enter Role Name
		WebElement role = driver.findElement(By.xpath("//input[@placeholder='Enter role name']"));
		role.sendKeys("A1");
		System.out.println("📥 entered Role Name");  
		
	/*	
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the toggle switch to be clickable
		WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//label[contains(@class, 'MuiFormControlLabel-root')]//span[contains(@class,'MuiSwitch-switchBase')]")
		));

		// Click the toggle switch
		toggle.click();

		System.out.println("✅ All Toggle button clicked.");

		*/
		
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the toggle switch to be clickable
		WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("(//label[contains(@class, 'MuiFormControlLabel-root')])[2]")
		));

		// Click the toggle switch
		toggle.click();

		System.out.println("✅ User Managemnet Toggle button clicked.");
		
		// Click User Management Collesp option
		WebElement expandIcon = driver.findElement(By.xpath("(//*[name()='svg' and @data-testid='ExpandMoreIcon'])[1]"));
		expandIcon.click();
		System.out.println("✅ User Managemnet Collesp Option clicked.");
		
		// Click User Managment Sub Toggle Button 
		WebElement toggle1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("(//input[contains(@class, 'PrivateSwitchBase-input')])[1]")
			));
			toggle1.click();

			System.out.println("✅ User Managemnet Collesp Option clicked.11");
		
		

	}
}
