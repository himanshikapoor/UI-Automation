// TODO Automate the nxtgenaiacademy form filling procedure using locators
package com.assignment2.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateFormFillingProcedure {
	// Chrome Driver
	String chromeDriverPath = ".\\Drivers\\chromedriver.exe";

	// WebSite URL
	String url = "https://nxtgenaiacademy.com/demo-site/";

	// XPaths
	String firstNameXpath = "//*[@id='vfb-5']";
	String lastNameXpath = "//*[@id=\"vfb-7\"]";
	String genderXpath = "//*[@id=\"vfb-31-2\"]";
	String streetAddressXpath = "//*[@id=\"vfb-13-address\"]";
	String cityXpath = "//*[@id=\"vfb-13-city\"]";
	String zipCodeXpath = "//*[@id=\"vfb-13-zip\"]";
	String stateXpath = "//*[@id=\"vfb-13-state\"]";
	String countryXpath = "//*[@id=\"vfb-13-country\"]";
	String emailXpath = "//*[@id=\"vfb-14\"]";
	String hourXpath = "//*[@id=\"vfb-16-hour\"]";
	String minutesXpath = "// *[@id=\"vfb-16-min\"]";
	String mobileNumberXpath = "//*[@id=\"vfb-19\"]";
	String seleniumWebDriverXpath = "//*[@id=\"vfb-20-0\"]";
	String coreJavaXpath = "//*[@id=\"vfb-20-3\"]";
	String queryXpath = "//*[@id=\"vfb-23\"]";
	String submitButtonXpath = "//*[@id=\"vfb-4\"]";

	// ID
	String verificationNumberID = "vfb-3";

	// User Details
	String firstNameString = "Himanshi";
	String lastNameString = "Kapoor";
	String addressString = "J-5/1 Krishna Nagar";
	String cityString = "East Delhi";
	String zipCodeString = "110051";
	String stateString = "Delhi";
	String countryString = "India";
	String emailString = "abc@gmail.com";
	String hourString = "09";
	String minutesString = "25";
	String mobileNumberString = "8826540573";
	String queryString = "What is the duration of the courses specified?";
	String verificationNumberString = "99";

	WebDriver driver;

	public static void main(String[] args) {
		AutomateFormFillingProcedure a = new AutomateFormFillingProcedure();
		a.launchWebsite();
		a.fillDetails();
		a.closeWebsite();
	}

	public void launchWebsite() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Website Launched");
	}

	public void fillDetails() {
		// First Name
		WebElement firstNameElement = driver.findElement(By.xpath(firstNameXpath));
		firstNameElement.sendKeys(firstNameString);
		validateField("First Name", firstNameElement, firstNameString);

		// Last Name
		WebElement lastNameElement = driver.findElement(By.xpath(lastNameXpath));
		lastNameElement.sendKeys(lastNameString);
		validateField("Last Name", lastNameElement, lastNameString);

		// Gender
		WebElement genderElement = driver.findElement(By.xpath(genderXpath));
		genderElement.click();
		validateField("Gender", genderElement, "checked");

		// Address
		WebElement addressElement = driver.findElement(By.xpath(streetAddressXpath));
		addressElement.sendKeys(addressString);
		validateField("Street Address", addressElement, addressString);

		// City
		WebElement cityElement = driver.findElement(By.xpath(cityXpath));
		cityElement.sendKeys(cityString);
		validateField("City", cityElement, cityString);

		// Zip Code
		WebElement zipCodeElement = driver.findElement(By.xpath(zipCodeXpath));
		zipCodeElement.sendKeys(zipCodeString);
		validateField("Zip Code", zipCodeElement, zipCodeString);

		// State
		WebElement stateElement = driver.findElement(By.xpath(stateXpath));
		stateElement.sendKeys(stateString);
		validateField("State", stateElement, stateString);

		// Country
		Select countryElement = new Select(driver.findElement(By.xpath(countryXpath)));
		countryElement.selectByValue(countryString);
		validateField("Country", countryElement.getFirstSelectedOption(), countryString);

		// Email
		WebElement emailElement = driver.findElement(By.xpath(emailXpath));
		emailElement.sendKeys(emailString);
		validateField("Email", emailElement, emailString);

		// Convenient Time
		Select hourElement = new Select(driver.findElement(By.xpath(hourXpath)));
		hourElement.selectByValue(hourString);
		validateField("No. of hours of Convenient Time", hourElement.getFirstSelectedOption(), hourString);

		Select minutesElement = new Select(driver.findElement(By.xpath(minutesXpath)));
		minutesElement.selectByValue(minutesString);
		validateField("No. of minutes of Convenient Time", minutesElement.getFirstSelectedOption(), minutesString);

		// Mobile Number
		WebElement mobileElement = driver.findElement(By.xpath(mobileNumberXpath));
		mobileElement.sendKeys(mobileNumberString);
		validateField("Mobile Number", mobileElement, mobileNumberString);

		// Interested Courses
		WebElement seleniumWebDriverElement = driver.findElement(By.xpath(seleniumWebDriverXpath));
		seleniumWebDriverElement.click();
		validateField("Selenium WebDriver checkbox", seleniumWebDriverElement, "true");

		WebElement coreJavaElement = driver.findElement(By.xpath(coreJavaXpath));
		coreJavaElement.click();
		validateField("Core Java checkbox", coreJavaElement, "true");

		// Query
		WebElement queryElement = driver.findElement(By.xpath(queryXpath));
		queryElement.sendKeys(queryString);
		validateField("Query", queryElement, queryString);

		// Verification Number
		WebElement verificationNumberElement = driver.findElement(By.id(verificationNumberID));
		verificationNumberElement.sendKeys(verificationNumberString);
		validateField("Verification Number", verificationNumberElement, verificationNumberString);

		// Submit Form
		WebElement submitElement = driver.findElement(By.xpath(submitButtonXpath));
		submitElement.click();
		System.out.println("Submit Button is clicked");
	}

	private void validateField(String fieldName, WebElement element, String expectedValue) {
		String actualValue = element.getAttribute("value");
		if (actualValue.equals(expectedValue)) {
			System.out.println(fieldName + " is filled successfully");
		} else {
			System.out.println(fieldName + " field is not filled correctly");
		}
	}

	public void closeWebsite() {
		driver.close();
	}
}
