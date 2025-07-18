package Category;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditCategory {
	
	WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://d3upskqh949jf6.cloudfront.net/sign-in"); // Replace with actual login URL
        
    }
    @Test
    public void loginAndClickCategoryTest() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("track6@yopmail.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.xpath("(//button[normalize-space()='Sign in'])[1]")).click();

        Thread.sleep(3000); // Optional wait

        try {
            WebElement toggleBtn = driver.findElement(By.xpath("//button[@aria-label='open drawer']"));
            toggleBtn.click();
        } catch (Exception e) {
            System.out.println("Sidebar already open or toggle not found.");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement categoryBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[normalize-space()='Category']")
        ));
        categoryBtn.click();
        System.out.println("✅ Clicked on Category"); 
        
        WebElement svgIcon = driver.findElement(By.xpath("//button[.//*[name()='svg' and contains(@class, 'lucide-ellipsis-vertical')]]"));

        if (svgIcon.isDisplayed() && svgIcon.isEnabled()) {
            svgIcon.click();
            System.out.println("SVG icon clicked successfully.");
        } else {
            System.out.println("SVG icon not clickable.");
        }
        
       
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//li[.//span[normalize-space()='Edit']]")
        ));
        editOption.click();
        System.out.println("✅ 'Edit' option clicked successfully.");
        
        
     // Step 1: Wait and locate the input field for category name
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@placeholder='Enter category name']")
        ));

        // Step 2: Clear old text
        categoryInput.clear();  // This will remove "Animal"
        System.out.println("🧹 Old category name cleared.");

        // Step 3: Enter new text
        String newCategoryName = "Updated Animal";
        categoryInput.sendKeys(newCategoryName);
        System.out.println("✍️ New category name entered: " + newCategoryName);

        // Step 4: Click on the Update Category button
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//button[normalize-space()='Update Category'])[1]")
        ));
        updateButton.click();
        System.out.println("✅ Clicked on 'Update Category' button.");

      

    }

}
