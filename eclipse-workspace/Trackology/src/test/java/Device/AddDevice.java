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

public class AddDevice {
	
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
        driver.findElement(By.name("email")).sendKeys("kavita1@yopmail.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.xpath("(//button[normalize-space()='Sign in'])[1]")).click();

        Thread.sleep(3000);

        try {
            WebElement toggleBtn = driver.findElement(By.xpath("//button[@aria-label='open drawer']"));
            toggleBtn.click();
        } catch (Exception e) {
            System.out.println("Sidebar already open or toggle not found.");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement deviceMgmtBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Device Management']")));
        deviceMgmtBtn.click();
        System.out.println("✅ Clicked on Device Menu");

        WebElement addDeviceBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Add New Device']")));
        addDeviceBtn.click();
        System.out.println("✅ Clicked on Add New Device");

        WebElement addManually = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space()='Add Manually']")));
        addManually.click();
        System.out.println("✅ Clicked on Add Manually");

        // Wait for IMEI field to be visible and enabled
        WebElement imeiField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='imei']")));
        imeiField.sendKeys("359811266377222");
        System.out.println("📥 IMEI entered");

        // Wait for deviceName field to be visible and enabled
        WebElement deviceNameField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='deviceName']")));
        deviceNameField.clear(); // Clear if any default
        deviceNameField.sendKeys("Cow Monitor");
        System.out.println("📥 Device name entered");

        // Validate if form fields are filled (optional)
        if (imeiField.getAttribute("value").isEmpty() || deviceNameField.getAttribute("value").isEmpty()) {
            System.out.println("❌ Validation failed - fields are empty");
        } else {
            System.out.println("✅ Fields validated - values entered successfully");
        }

        // Click outside to trigger blur if needed (form click)
        WebElement form = driver.findElement(By.xpath("//div[@class='flex flex-col md:flex-row gap-24']//form"));
        form.click();
    }
}


