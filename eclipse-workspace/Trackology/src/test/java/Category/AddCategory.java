package Category;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCategory {
	
	
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
        driver.findElement(By.name("email")).sendKeys("kavita1@yopmail.com");
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
        
        
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement categoryBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[normalize-space()='Add New Category']")
        ));
        categoryBtn1.click();
        System.out.println("✅ Click On Add Category Button ");  
        
        
        driver.findElement(By.xpath("//input[contains(@class, 'MuiInputBase-input') and @placeholder='Enter category name']\r\n"
        		)).sendKeys("Animal");

        
        driver.findElement(By.xpath("//button[text()='Add Category']")).click();
    }


    	   
       }


