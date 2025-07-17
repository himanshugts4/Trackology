package AuthanticationFlow;

import java.time.Duration;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Signup {
	
	WebDriver driver;
	@BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://d3upskqh949jf6.cloudfront.net/sign-up");
    }

	  
	 @Test
	 public void signUpTest() {
	

		     driver.findElement(By.xpath("//input[@name='fullName']")).sendKeys("Himanshu");
		     driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Himanshujoshijj@yopmail.com");
		     driver.findElement(By.xpath("//input[@value='no']")).click();
		     driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys("78912348786");

		     // Set Password and Confirm Password
		     String password = "12345678";
		     String confirmPassword = "12345678";

		     // Step 1: Check length >= 8
		     if (password.length() >= 8) {
		         // Step 2: Check if password and confirmPassword match
		         if (password.equals(confirmPassword)) {
		             driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		             driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(confirmPassword);
		             System.out.println("✅ Password validation passed.");
		         } else {
		             System.out.println("❌ Passwords do not match.");
		         }
		     } else {
		         System.out.println("❌ Password must be at least 8 characters long.");
		     }
		     
		      driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		      driver.findElement(By.xpath("(//button[normalize-space()='Create Account'])[1]")).click();
			   
		      
		      try {
		    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    	    WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    	        By.xpath("//p[contains(text(),'Your otp for verification is')]")
		    	    ));

		    	    String toastText = toastElement.getText();

		    	    // OTP extraction
		    	    Pattern pattern = Pattern.compile("\\d{4,6}");
		    	    Matcher matcher = pattern.matcher(toastText);
		    	    String otp = "";
		    	    if (matcher.find()) {
		    	        otp = matcher.group();
		    	        System.out.println("✅ Extracted OTP: " + otp);

		    	        // Send OTP to input boxes
		    	        char[] digits = otp.toCharArray();
		    	        for (int i = 0; i < digits.length; i++) {
		    	            WebElement otpInput = driver.findElement(By.xpath("(//div[contains(@class,'gap-16')]//input)[" + (i + 1) + "]"));
		    	            otpInput.sendKeys(String.valueOf(digits[i]));
		    	        }
		    	    } else {
		    	        System.out.println("❌ OTP pattern not found in toast text.");
		    	    }
		    	} catch (Exception e) {
		    	    System.out.println("❌ OTP toast not found.");
		    	}

		      driver.findElement(By.xpath("(//button[normalize-space()='Verify Account'])[1]")).click();

	 
	 
	 }
	 
		     
		     
		     
	 
	 }

	     
	        
	 
	 
	     
	 


