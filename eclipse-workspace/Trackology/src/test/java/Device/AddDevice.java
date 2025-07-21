package Device;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        WebElement deviceMgmtBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Device Management']")));
        deviceMgmtBtn.click();
        System.out.println("✅ Clicked on Device Menu");

        // Add New Device
        WebElement addDeviceBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Add New Device']")));
        addDeviceBtn.click();
        System.out.println("✅ Clicked on Add New Device");

        // Add Manually
        WebElement addManually = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[normalize-space()='Add Manually']")));
        addManually.click();
        System.out.println("✅ Clicked on Add Manually");

        // Enter IMEI
        WebElement imeiField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='imei']")));
        imeiField.sendKeys("350693901679710");
        System.out.println("📥 IMEI entered");

        // Enter Device Name
        WebElement deviceNameField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='deviceName']")));
        deviceNameField.clear();
        deviceNameField.sendKeys("Cow Monitor");
        System.out.println("📥 Device name entered");

        // Validation
        if (imeiField.getAttribute("value").isEmpty() || deviceNameField.getAttribute("value").isEmpty()) {
            System.out.println("❌ Validation failed - fields are empty");
        } else {
            System.out.println("✅ Fields validated - values entered successfully");
        }

        // Select Duration
        WebElement form = driver.findElement(By.xpath("//div[@class='flex flex-col md:flex-row gap-24']//form"));
        form.click(); // ensure focus

        WebElement durationDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='combobox' and contains(@class, 'MuiSelect-select') and not(contains(@class, 'Mui-disabled'))]")));
        durationDropdown.click();
        System.out.println("✅ Dropdown opened");

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(@class, 'MuiMenuItem-root') and normalize-space()='1 Year']")));
        option.click();
        System.out.println("✅ 1 Year option selected");

        // Close dropdown
        try {
            form.click();
            Thread.sleep(500);
            new Actions(driver).sendKeys(Keys.ESCAPE).perform();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//ul[contains(@class,'MuiMenu-list')]")));
            System.out.println("✅ Dropdown closed successfully");
        } catch (Exception e) {
            System.out.println("⚠️ Dropdown may not have closed: " + e.getMessage());
        }

        // Enter Month
        WebElement monthInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='livestockAge' and @placeholder='Months']")));
        monthInput.sendKeys("5");
        System.out.println("📥 Month value '5' entered");

        // Enter Friendly Name
        WebElement deviceNameInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='friendlyName' and @type='text']")));
        deviceNameInput.clear();
        deviceNameInput.sendKeys("Test Device");
        System.out.println("📥 Friend Name entered successfully");

        // Gender Dropdown - FIXED
        System.out.println("📍 Waiting for gender dropdown...");
        WebElement genderDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@role='combobox' and contains(@class, 'MuiSelect-select')])[2]")));
        genderDropdown.click();
        System.out.println("✅ Clicked on Gender Dropdown");

        // Wait for dropdown menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[contains(@class,'MuiMenu-list')]")));

        // Select "Male"
        WebElement genderOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[@role='option' and normalize-space()='Male']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderOption);
        wait.until(ExpectedConditions.elementToBeClickable(genderOption)).click();
        System.out.println("✅ Gender selected");

        // Enter Note
        WebElement noteField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//textarea[@name='note' and not(@readonly)]")));
        noteField.sendKeys("This is a test note.");
        
        
        WebElement noteField1 = driver.findElement(By.xpath("//textarea[@name='description' and not(@aria-hidden)]"));
        noteField1.sendKeys("Testing note here");
        System.out.println("📥 Description entered successfully");  
/*        
        
        WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement pin2Image = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//img[@alt='pin2' and contains(@src, 'pin2.svg')])[1]")
        ));
        pin2Image.click();
        System.out.println("✅ Pin2 image clicked successfully.");

*/

        WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement addDeviceBtn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add Device']")));
        addDeviceBtn1.click();
        System.out.println("✅ 'Add Device' button clicked successfully.");


    }
}
