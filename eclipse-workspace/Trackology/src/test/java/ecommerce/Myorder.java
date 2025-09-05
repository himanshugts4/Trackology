package ecommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Myorder {
	
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://d3upskqh949jf6.cloudfront.net/home");
	}

	@Test
	public void productmenuclick() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.findElement(By.xpath("//button[normalize-space(text())='Log In']")).click();
		
		

		driver.findElement(By.name("email")).sendKeys("arvindra829@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.xpath("(//button[normalize-space()='Sign in'])[1]")).click();
		Thread.sleep(3000);
	
		
		driver.findElement(By.xpath("(//button[normalize-space(text())='Go to Dashboard'])[1]")).click();
		System.out.println("Sucessfuly Redirect To Dashboard"); 
		
		
		// Sidebar toggle (if needed)
		try {
			WebElement toggleBtn = driver.findElement(By.xpath("//button[@aria-label='open drawer']"));
			toggleBtn.click();
		} catch (Exception e) {
			System.out.println("Sidebar already open or toggle not found.");
		}

		WebElement myOrdersBtn = driver.findElement(By.xpath("//a[.//span[normalize-space()='My Orders']]"));
		myOrdersBtn.click();
		System.out.println("Successfully clicked on My Orders button");

		WebElement myOrdersCan = driver.findElement(By.xpath("(//button[.//*[local-name()='svg' and contains(@class,'lucide-ellipsis-vertical')]])[1]"));
		myOrdersCan.click();
		System.out.println("Successfully clicked on My Orders cancel");

		WebElement myOrdersCansu = driver.findElement(By.xpath("(//li[normalize-space()='Cancel Order']"));
		myOrdersCansu.click();
		System.out.println("My Orders cancel Successfully  ");

		
		


		
		
		
	
	}
}
