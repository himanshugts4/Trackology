package Device;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeviceSearch {
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
		
		String imei = "350693901679710";

        // 🔐 Login logic if needed (add here...)

        // 🔎 Step 1: Search for IMEI
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@placeholder='Search Name, IMEI']")));
        searchInput.clear();
        searchInput.sendKeys(imei);
        searchInput.sendKeys(Keys.ENTER);
        System.out.println("🔍 IMEI entered in search: " + imei);

        // 🕒 Wait for results to load
        Thread.sleep(2000); // Optional delay

        // 💡 Step 2: Scroll down in case result is below
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");

        // ✅ Step 3: Find IMEI span element
        WebElement imeiSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(text(), '" + imei + "')]")));
        System.out.println("✅ IMEI found on screen: " + imeiSpan.getText());

        // 🧪 Assertion (optional)
        assert imeiSpan.getText().contains(imei) : "IMEI not matched!";
    }
	}


