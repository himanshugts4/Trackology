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

public class EditDevice {

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

		WebElement svgIcon = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/button[1]//*[name()='svg']"));

		if (svgIcon.isDisplayed() && svgIcon.isEnabled()) {
			svgIcon.click();
			System.out.println("SVG icon clicked successfully.");
		} else {
			System.out.println("SVG icon not clickable.");
		}

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement editOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[.//span[normalize-space()='Edit']]")));
		editOption.click();
		System.out.println("✅ 'Edit' option clicked successfully.");
		/*
		 * WebElement deviceNameField = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@name='deviceName']")));
		 * 
		 * // Step 1: Clear old text (if it exists) deviceNameField.clear();
		 * 
		 * // Step 2: Send new device name deviceNameField.sendKeys("Dog Report");
		 * System.out.println("📥 Device name Updated Sucessfully");
		 */

		WebElement deviceNameField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='deviceName']")));

		// Select all + delete
		deviceNameField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		// Enter new device name
		deviceNameField.sendKeys("Dog");
		System.out.println("📥 Device name updated");

		WebElement dropdown = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@role='combobox' and contains(@class, 'MuiSelect-select')]")));
		dropdown.click();

		// Wait for dropdown menu <ul>
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'MuiMenu-list')]")));

		// Select the option (loose match first)
		WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//li[contains(@class, 'MuiMenuItem-root') and contains(text(), '2')]")));

		// Scroll if needed
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		wait.until(ExpectedConditions.elementToBeClickable(option)).click();
		System.out.println("✅ 2 Years option selected");

		WebElement monthInput = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@name='livestockAge' and @placeholder='Months']")));

		// Clear old value
		monthInput.clear();

		// Ensure it's actually cleared (sometimes `clear()` doesn't work with React
		// inputs)
		monthInput.sendKeys(Keys.CONTROL + "a"); // Select all
		monthInput.sendKeys(Keys.BACK_SPACE); // Then delete

		// Enter new value
		monthInput.sendKeys("4");
		System.out.println("📥 Month value '4' updated");

		WebElement deviceNameInput = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='friendlyName' and @type='text']")));

		// Clear properly using CTRL+A + BACKSPACE
		deviceNameInput.sendKeys(Keys.CONTROL + "a");
		deviceNameInput.sendKeys(Keys.BACK_SPACE);

		// Now send new name
		deviceNameInput.sendKeys("Test Device");
		System.out.println("📥 Friend Name updated successfully");
		// Click on Gender dropdown (second combobox usually)
		System.out.println("📍 Waiting for gender dropdown...");
		WebElement genderDropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@role='combobox' and contains(@class, 'MuiSelect-select')])[2]")));
		genderDropdown.click();
		System.out.println("✅ Clicked on Gender Dropdown");

		// Wait for dropdown menu visibility
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'MuiMenu-list')]")));

		// Select "Male" option (or "Female" if needed)
		WebElement genderOption = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//li[@role='option' and normalize-space()='Female']"))); // change to
																											// 'Female'
																											// if needed
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderOption);
		genderOption.click();
		System.out.println("✅ Gender updated to Male");

		// ✅ Update Note field
		WebElement noteField = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='note' and not(@readonly)]")));
		noteField.clear(); // Purana content remove karo
		noteField.sendKeys("Updated test note content");
		System.out.println("📥 Note updated successfully");

		// ✅ Update Description field
		WebElement noteField1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//textarea[@name='description' and not(@aria-hidden)]")));
		noteField1.clear(); // Purana content remove karo
		noteField1.sendKeys("Updated description content");
		System.out.println("📥 Description updated successfully");

		WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement addDeviceBtn1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Update Device']")));
		addDeviceBtn1.click();
		System.out.println("✅ 'Update Device' button clicked successfully.");

	}
}
