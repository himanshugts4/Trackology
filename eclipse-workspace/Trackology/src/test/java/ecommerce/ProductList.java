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

public class ProductList {

	
	
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
		driver.findElement(By.xpath("//button[@class='text-[#21272a] text-[16px] hover:text-[#225a50] font-medium'][normalize-space()='Products']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[normalize-space(text())='Buy'])[1]")).click(); 
		
		Thread.sleep(3000);
		
		try {
			
			WebElement titleElement = driver.findElement(By.xpath("//h2[normalize-space(text())='Product Detail']"));

			
			String pageTitle = titleElement.getText();
            System.out.println("Page Title: " + pageTitle);

		} catch (Exception e) {
			System.out.println("page title not display");
		}
		
		
		
		/*
		 * By plusBtn = By.
		 * xpath("//button[.//*[local-name()='svg' and contains(@class,'lucide-plus')]]"
		 * );
		 * 
		 * int quantity = 3;
		 * 
		 * WebElement plusButton = driver.findElement(plusBtn); for(int i=0; i<quantity;
		 * i++){ plusButton.click(); Thread.sleep(500);
		 * System.out.println("Inventory increase"); }
		 */
		
		
		
		//driver.findElement(By.xpath("//button[.//*[local-name()='svg' and contains(@class,'lucide-plus')]]")).click();
		
		WebElement Addcart= driver.findElement(By.xpath("//button[normalize-space()='Add To Cart']"));
		Addcart.click();
		System.out.println("Add To Cart Product"); 
		
		
		 driver.findElement(By.
		 xpath("//*[local-name()='path' and @d='M2.05 2.05h2l2.66 12.42a2 2 0 0 0 2 1.58h9.78a2 2 0 0 0 1.95-1.57l1.65-7.43H5.12']")).
		 click();
		 System.out.println("Sucessfully Click on Add to cart button");
		 
		//button[normalize-space()='Login'] 
		 Thread.sleep(3000);
			/*
			 * WebElement loginbtn =
			 * driver.findElement(By.xpath("//button[normalize-space()='Login']"));
			 * loginbtn.click(); System.out.println("Sucessfuly CLick On login Button ");
			 */
		
		
		WebElement radiobtn = driver.findElement(By.xpath("//input[@type='radio']"));
		radiobtn.click();
		System.out.println("Sucessfuly CLick On Address Radio Button ");

		WebElement processtopay = driver.findElement(By.xpath("//button[normalize-space()='Proceed To Pay']"));
		processtopay.click();
		System.out.println("Sucessfuly CLick OnProceed To Pay");  
		
		
		//Stripe Details (Card Detail)
		
		
         
		WebElement cardnumber = driver.findElement(By.xpath("//input[@id='cardNumber']"));
		cardnumber.sendKeys("4242424242424242");
		System.out.println("Sucessfuly Added Card Number field");  
		
		 
		WebElement cardExpiry = driver.findElement(By.xpath("//input[@id='cardExpiry']"));
		cardExpiry.sendKeys("0226");
		System.out.println("Sucessfuly Added Expiry"); 
		
		
		
		
		WebElement cardCvc = driver.findElement(By.xpath("//input[@id='cardCvc']"));
		cardCvc.sendKeys("123");
		System.out.println("Sucessfuly Added CVV Number");  
		
		//input[@id='billingName']
		
		WebElement billingName = driver.findElement(By.xpath("//input[@id='billingName']"));
		billingName.sendKeys("123");
		System.out.println("Sucessfuly Added Customer Name");   
		
		//div[@class='SubmitButton-IconContainer']
		
		WebElement paybutton = driver.findElement(By.xpath("//div[@class='SubmitButton-IconContainer']"));
		paybutton.click();
		System.out.println("Sucessfuly Click on pay Button");   
		
		
		WebElement BacktoOrders = driver.findElement(By.xpath("//button[normalize-space()='Back to Orders']"));
		BacktoOrders.click();
		System.out.println("Sucessfuly Back To Order"); 
		
		
}

}
