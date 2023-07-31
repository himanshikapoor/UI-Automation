// TODO Perform end-to-end automation of CodeForces website
package com.assignment3.endtoendautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateCodeforcesRegistration {
	// Driver Path
	static String chromeDriverPath = ".\\Drivers\\chromedriver.exe";

	// Website URL
	static String url = "https://codeforces.com/register/";

	// User Details
	static String userHandle = "abc120009";
	static String userEmail = "tipesaf981@iturchia.com";
	static String userPassword = "@Welcome12345#";

	// Name locator
	static String handleNameLocator = "handle";

	// XPath locators
	static String emailXpath = "//*[@id=\"registerForm\"]/table/tbody/tr[5]/td[2]/input";
	static String passwordXpath = "//*[@id=\"registerForm\"]/table/tbody/tr[6]/td[2]/input";
	static String confirmPasswordXpath = "//*[@id=\"registerForm\"]/table/tbody/tr[8]/td[2]/input";
	static String registerButtonXpath = "//*[@id=\"registerForm\"]/table/tbody/tr[9]/td/div[1]/input";

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		autoFillRegistrationDetails();
		clickOnRegisterButton();
		System.out.println("Registration is Successful");
		closeWebsite();
	}

	static void autoFillRegistrationDetails() {
		// Handle Field
		WebElement handle = driver.findElement(By.name(handleNameLocator));
		handle.sendKeys(userHandle);
		System.out.println("Handle is entered");

		// Email Field
		WebElement email = driver.findElement(By.xpath(emailXpath));
		email.sendKeys(userEmail);
		System.out.println("E-mail is entered");

		// Password Field
		WebElement pwd = driver.findElement(By.xpath(passwordXpath));
		pwd.sendKeys(userPassword);
		System.out.println("Password is entered");

		// Confirm Password Field
		WebElement cnfPwd = driver.findElement(By.xpath(confirmPasswordXpath));
		cnfPwd.sendKeys(userPassword);
		System.out.println("Confirmed Password is entered");
	}

	static void clickOnRegisterButton() {
		// Register Button
		WebElement regBtn = driver.findElement(By.xpath(registerButtonXpath));
		regBtn.click();
		System.out.println("Register Button is clicked");
	}

	static void closeWebsite() {
		driver.close();
	}
}
