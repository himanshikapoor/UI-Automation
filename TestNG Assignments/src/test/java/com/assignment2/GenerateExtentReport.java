// TODO Generate Extent Report to display results of form automation
package com.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GenerateExtentReport {
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

	public static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	void launchApplication() {
		try {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println("Website Launched");
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}

	@Test(priority = 1, groups = { "smoke", "sanity" })
	void enterNameAndGender() {
		// First Name
		WebElement firstNameElement = driver.findElement(By.xpath(firstNameXpath));
		firstNameElement.sendKeys(firstNameString);
		String firstNameValue = firstNameElement.getAttribute("value");
		if (firstNameValue.equals(firstNameString)) {
			Reporter.log("First Name field is filled");
		} else {
			Reporter.log("Failed to fill First Name field");
		}

		// Last Name
		WebElement lastNameElement = driver.findElement(By.xpath(lastNameXpath));
		lastNameElement.sendKeys(lastNameString);
		String lastNameValue = lastNameElement.getAttribute("value");
		if (lastNameValue.equals(lastNameString)) {
			Reporter.log("Last name field is filled");
		} else {
			Reporter.log("Failed to fill Last name field");
		}

		// Gender
		WebElement genderElement = driver.findElement(By.xpath(genderXpath));
		genderElement.click();
		boolean isGenderSelected = genderElement.isSelected();
		if (isGenderSelected) {
			Reporter.log("Gender field is selected");
		} else {
			Reporter.log("Failed to select Gender field");
		}

		Assert.fail("Test case intentionally failed to display screenshot");
	}

	@Test(priority = 2, groups = { "smoke", "sanity" })
	void enterAddress() {
		// Street Address
		WebElement addressElement = driver.findElement(By.xpath(streetAddressXpath));
		addressElement.sendKeys(addressString);
		String addressValue = addressElement.getAttribute("value");
		if (addressValue.equals(addressString)) {
			Reporter.log("Street Address field is filled");
		} else {
			Reporter.log("Failed to fill Street Address field");
		}

		// City
		WebElement cityElement = driver.findElement(By.xpath(cityXpath));
		cityElement.sendKeys(cityString);
		String cityValue = cityElement.getAttribute("value");
		if (cityValue.equals(cityString)) {
			Reporter.log("City field is filled");
		} else {
			Reporter.log("Failed to fill City field");
		}

		// Zip Code
		WebElement zipCodeElement = driver.findElement(By.xpath(zipCodeXpath));
		zipCodeElement.sendKeys(zipCodeString);
		String zipCodeValue = zipCodeElement.getAttribute("value");
		if (zipCodeValue.equals(zipCodeString)) {
			Reporter.log("Zip Code field is filled");
		} else {
			Reporter.log("Failed to fill Zip Code field");
		}

		// State
		WebElement stateElement = driver.findElement(By.xpath(stateXpath));
		stateElement.sendKeys(stateString);
		String stateValue = stateElement.getAttribute("value");
		if (stateValue.equals(stateString)) {
			Reporter.log("State field is filled");
		} else {
			Reporter.log("Failed to fill State field");
		}

		// Country
		Select countryElement = new Select(driver.findElement(By.xpath(countryXpath)));
		countryElement.selectByValue(countryString);
		String selectedCountry = countryElement.getFirstSelectedOption().getText();
		if (selectedCountry.equals(countryString)) {
			Reporter.log("Country is selected");
		} else {
			Reporter.log("Failed to select Country");
		}
	}

	@Test(priority = 3, groups = { "regression" })
	void enterContactDetails() {
		// Email
		WebElement emailElement = driver.findElement(By.xpath(emailXpath));
		emailElement.sendKeys(emailString);
		String enteredEmail = emailElement.getAttribute("value");
		if (enteredEmail.equals(emailString)) {
			Reporter.log("Email field is entered");
		} else {
			Reporter.log("Failed to enter Email field");
		}

		// Mobile Number
		WebElement mobileElement = driver.findElement(By.xpath(mobileNumberXpath));
		mobileElement.sendKeys(mobileNumberString);
		String enteredMobileNumber = mobileElement.getAttribute("value");
		if (enteredMobileNumber.equals(mobileNumberString)) {
			Reporter.log("Mobile Number field is entered");
		} else {
			Reporter.log("Failed to enter Mobile Number field");
		}
	}

	@Test(priority = 4, groups = { "regression" })
	void selectConvenientTimeAndCourses() {
		// Convenient Time
		Select hourElement = new Select(driver.findElement(By.xpath(hourXpath)));
		hourElement.selectByValue(hourString);
		String selectedHour = hourElement.getFirstSelectedOption().getText();
		if (selectedHour.equals(hourString)) {
			Reporter.log("No. of hours of Convenient Time is selected");
		} else {
			Reporter.log("Failed to select No. of hours of Convenient Time");
		}

		Select minutesElement = new Select(driver.findElement(By.xpath(minutesXpath)));
		minutesElement.selectByValue(minutesString);
		String selectedMinutes = minutesElement.getFirstSelectedOption().getText();
		if (selectedMinutes.equals(minutesString)) {
			Reporter.log("No. of minutes of Convenient Time is selected");
		} else {
			Reporter.log("Failed to select No. of minutes of Convenient Time");
		}

		// Courses
		WebElement seleniumWebDriverElement = driver.findElement(By.xpath(seleniumWebDriverXpath));
		seleniumWebDriverElement.click();
		if (seleniumWebDriverElement.isSelected()) {
			Reporter.log("Selenium WebDriver checkbox is selected");
		} else {
			Reporter.log("Failed to select Selenium WebDriver checkbox");
		}

		WebElement coreJavaElement = driver.findElement(By.xpath(coreJavaXpath));
		coreJavaElement.click();
		if (coreJavaElement.isSelected()) {
			Reporter.log("Core Java checkbox is selected");
		} else {
			Reporter.log("Failed to select Core Java checkbox");
		}
	}

	@Test(priority = 5, groups = { "sanity" })
	void enterQuery() {
		WebElement queryElement = driver.findElement(By.xpath(queryXpath));
		queryElement.sendKeys(queryString);
		String enteredQuery = queryElement.getAttribute("value");
		if (enteredQuery.equals(queryString)) {
			Reporter.log("Query field is filled");
		} else {
			Reporter.log("Failed to fill the Query field");
		}
	}

	@Test(priority = 6, groups = { "smoke" })
	void submitForm() {
		// Enter verification number
		WebElement verificationNumberElement = driver.findElement(By.id(verificationNumberID));
		verificationNumberElement.sendKeys(verificationNumberString);
		String enteredVerificationNumber = verificationNumberElement.getAttribute("value");
		if (enteredVerificationNumber.equals(verificationNumberString)) {
			Reporter.log("Verification Number field is filled");
		} else {
			Reporter.log("Failed to fill the Verification Number field");
		}

		// Click on the submit button
		WebElement submitElement = driver.findElement(By.xpath(submitButtonXpath));
		if (submitElement.isEnabled()) {
			submitElement.click();
			Reporter.log("Submit Button is clicked");
		} else {
			Reporter.log("Unable to click submit button");
		}
	}

	@AfterClass(alwaysRun = true)
	void closeApplication() {
		driver.close();
	}

}
