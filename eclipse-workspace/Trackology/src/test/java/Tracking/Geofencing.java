package Tracking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Geofencing {

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

		WebElement usermanagement = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Tracking & Reporting']")));
		usermanagement.click();
		System.out.println("✅ Clicked on Tracking & Reporting Menu");

		WebElement Geofencing = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//a[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters MuiListItemButton-root MuiListItemButton-gutters fuse-list-item muiltr-dol773']//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary text-lg font-semibold fuse-list-item-text-primary truncate muiltr-dsvsxy'][normalize-space()='Geofencing']")));
		Geofencing.click();
		System.out.println("✅ Clicked on Geofencing Menu");   
		
		driver.findElement(By.xpath("//input[@placeholder='Search Device, Category, IMEI']")).sendKeys("Dog");
		System.out.println("✅ Device search Sucessfully");
          
		// Click on Device status 
		driver.findElement(By.xpath("//input[@type='checkbox' and contains(@class, 'PrivateSwitchBase-input')]")).click();
		WebElement checkboxLabel = driver.findElement(By.xpath("//input[@type='checkbox']/ancestor::label"));
		checkboxLabel.click(); 
		
		System.out.println("✅ Device Status Sucessfully Selected");  
		
		// Livestock Gender
		
		WebElement label = driver.findElement(By.xpath("//input[@type='checkbox']/ancestor::label"));
		label.click();
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox' and contains(@class, 'PrivateSwitchBase-input')]"));
		checkbox.click();
		System.out.println("✅ Livestock Gender Sucessfully Selected");  
		
		// Select Time Period
		driver.findElement(By.xpath("//button[normalize-space()='Last 7 Days']")).click();	
		
		// Select Custom Range
		driver.findElement(By.xpath("//button[normalize-space()='Custom Range']")).click();	
		
		

	}
}
