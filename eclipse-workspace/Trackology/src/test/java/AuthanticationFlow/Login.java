package AuthanticationFlow;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;



public class Login {
	
	WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://d3upskqh949jf6.cloudfront.net/sign-in"); // Replace with actual login URL
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"track6@yopmail.com", "12345678", "valid"},         // ✅ Valid credentials
            {"invalidEmail", "12345678", "invalid_email"},       // ❌ Invalid email format
            {"track6@yopmail.com", "wrongpass", "invalid_pass"}, // ❌ Wrong password
            {"", "", "blank"},                                   // ❌ Blank fields
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password, String expectedResultType) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("(//button[normalize-space()='Sign in'])[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        switch (expectedResultType) {
            case "valid":
                // Wait for successful login, like dashboard or URL change
                boolean success = wait.until(ExpectedConditions.urlContains("dashboard"));
                Assert.assertTrue(success, "✅ Login should be successful.");
                break;

            case "invalid_email":
                WebElement invalidEmailToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(),'Invalid email')]")));
                Assert.assertTrue(invalidEmailToast.isDisplayed(), "❌ Invalid email should show error.");
                break;

            case "invalid_pass":
                WebElement invalidPassToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(),'Invalid credentials')]")));
                Assert.assertTrue(invalidPassToast.isDisplayed(), "❌ Wrong password should show error.");
                break;

            case "blank":
                WebElement blankToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(),'required')]")));
                Assert.assertTrue(blankToast.isDisplayed(), "❌ Blank fields should trigger validation.");
                break;

            default:
                Assert.fail("Unknown expected result type.");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
