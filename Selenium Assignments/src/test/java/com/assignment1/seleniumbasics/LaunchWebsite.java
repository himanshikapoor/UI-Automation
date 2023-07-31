// TODO Launch and maximize the website with the given URL
package com.assignment1.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebsite {
	static String chromeDriverPath = ".\\Drivers\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		WebDriver driver = new ChromeDriver();

		String url = "https://www.google.com/";

		try {
			// To open the website
			driver.get(url);

			// Validate if the website is loaded successfully
			if (driver.getTitle().contains("Google")) {
				System.out.println("Website Launched Successfully");
			} else {
				System.out.println("Failed to launch website");
			}

			// To maximize the website
			driver.manage().window().maximize();

			// To close the driver
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
}
