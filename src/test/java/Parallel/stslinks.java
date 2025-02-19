package Parallel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class stslinks {

	public static void main(String[] args) {
		WebDriver driver = initializeDriver();
		try {
			// Navigate to the target page
			driver.get("https://ap.bayatree.com/sts/");

            List<String> xpaths = Arrays.asList(
            		"//a[@href='/']",
                    "(//a[@href='/sts/books/en/the-tortoise-and-the-hare'])[3]",
                    "(//a[@href='/sts/books/en/the-town-musicians-of-bremen'])[3]"
                  
          		
			 );

			// Iterate through each XPath and handle
            for (int i = 0; i < xpaths.size(); i++) {
                handleXPath(driver, xpaths.get(i), i);
           }

           List<String> paths = Arrays.asList(
            		
            );

            // Iterate through each XPath and handle
            for (int i = 0; i < paths.size(); i++) {
            	handleXPathForNewWindow(driver, paths.get(i), i);
            }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}

		try {

			List<String> Crossxpaths = Arrays.asList(
					
					);

			// Iterate through each XPath and handle
			for (int i = 0; i < Crossxpaths.size(); i++) {
				WebDriver driverr = initializeDriver();
				driverr.get("https://ap.bayatree.com/sts/");
				handleXPathwithcross(driverr, Crossxpaths.get(i), i);
				driverr.quit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}

	}

	// Method to initialize the WebDriver
	private static WebDriver initializeDriver() {
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	// Method to handle each XPath separately
	private static void handleXPath(WebDriver driver, String xpath, int index) {
		try {

			WebElement element = driver.findElement(By.xpath(xpath));
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			String currentUrl = driver.getCurrentUrl();
			element.click();
			Thread.sleep(3000);
			String newUrl = driver.getCurrentUrl();
			String screenshotFolder ="Report/BugScreenshot/";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(screenshotFolder + "scree" + index + ".png"));
			if (!newUrl.equals(currentUrl)) {
				driver.navigate().back();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println("Failed to handle XPath: " + xpath + ". Error: " + e.getMessage());
		}
	}

	private static void handleXPathwithcross(WebDriver driverr, String xpath, int index) {
		try {

			WebElement element = driverr.findElement(By.xpath(xpath));
			Thread.sleep(2000);
			element.click();
			Thread.sleep(3000);
			File screenshot = ((TakesScreenshot) driverr).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File("screenshot" + index + ".png"));

		} catch (Exception e) {
			System.out.println("Failed to handle XPath: " + xpath + ". Error: " + e.getMessage());
		}
	}

	private static void handleXPathForNewWindow(WebDriver driver, String xpath, int index) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			String originalWindow = driver.getWindowHandle();
			String currentUrl = driver.getCurrentUrl();

			element.click();
			Thread.sleep(5000);

			Set<String> allWindows = driver.getWindowHandles();

			if (allWindows.size() > 1) {
				for (String windowHandle : allWindows) {
					if (!windowHandle.equals(originalWindow)) {
						driver.switchTo().window(windowHandle);
						break;
					}
				}

				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screenshot, new File("screenshot" + index + ".png"));

				driver.close();
				driver.switchTo().window(originalWindow);
				Thread.sleep(3000);
			}

			String newUrl = driver.getCurrentUrl();

			if (!newUrl.equals(currentUrl)) {
				driver.navigate().back();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println("Failed to handle XPath: " + xpath + ". Error: " + e.getMessage());
		}
	}

}
