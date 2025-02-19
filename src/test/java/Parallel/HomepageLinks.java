package Parallel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HomepageLinks {

    public static void main(String[] args) {
        WebDriver driver = initializeDriver();
        try {
            // Navigate to the target page
            driver.get("https://ap.bayatree.com");

            // List of XPaths for buttons and links
            List<String> xpaths = Arrays.asList(
                    "//a[@class='navbar-brand logo m-auto']",
                    "//a[@class='headerBtn mediaLibrary rounded-pill']",
                    "//a[@id='store']",
                    "//a[@id='mathTabtn']",
                    "//a[@id='numberTabtn']",
                    "//a[@id='writingTabtn']",
                    "//a[@id='typingTabtn']",
                    "//a[@class='cardWithImg colorGreen']",
                    "//a[@class='cardWithImg colorPurple']",
                    "//a[@class='cardWithImg colorGreen2']",
                    "//a[@class='cardWithImg colorOrange']",
                    "//a[@class='cardWithImg colorPink']"
            );

            // Iterate through each XPath and handle
            for (int i = 0; i < xpaths.size(); i++) {
                handleXPath(driver, xpaths.get(i), i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
        WebDriver driverr = initializeDriver();
        try {
            // Navigate to the target page
            driverr.get("https://ap.bayatree.com");
            WebElement book=  driverr.findElement(By.xpath("(//div[@class='col-6 d-flex align-items-end justify-content-center position-relative'])[1]"));
            Actions actions = new Actions(driverr);

            // Perform hover action
            actions.moveToElement(book).perform();
            Thread.sleep(2000); // Replace with WebDriverWait for a better approach
            book.click();
            // List of XPaths for buttons and links
            List<String> xpaths = Arrays.asList(
            		"//h2[normalize-space()='Level 1']",
            		"//h2[normalize-space()='Level 2']",
            		"//h2[normalize-space()='Level 3']",
            		"//h2[normalize-space()='Level 4']",
            		"//h2[normalize-space()='Level 5']",
            		"//h2[normalize-space()='Level 6']",
            		"//h2[normalize-space()='Level 7']",
            		"//h2[normalize-space()='Level 8']"
                    
            );

            // Iterate through each XPath and handle
            for (int i = 0; i < xpaths.size(); i++) {
                handleXPath(driverr, xpaths.get(i), i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driverr.quit();
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
            // Find the element using XPath
            WebElement element = driver.findElement(By.xpath(xpath));
            Thread.sleep(2000);

            // Scroll the element into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Get the current URL before clicking
            String currentUrl = driver.getCurrentUrl();

            // Click the element
            element.click();

            // Wait for the page or content to load
            Thread.sleep(5000);

            // Get the URL after clicking
            String newUrl = driver.getCurrentUrl();

            // Take a screenshot of the new page
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshot" + index + ".png"));

            // If the URL has changed, navigate back
            if (!newUrl.equals(currentUrl)) {
                driver.navigate().back();
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println("Failed to handle XPath: " + xpath + ". Error: " + e.getMessage());
        }
    }
    
    private static void phonics(WebDriver driverr, String xpath, int index) {
        try {
            // Find the element using XPath
            WebElement element = driverr.findElement(By.xpath(xpath));

            // Scroll the element into view
            ((JavascriptExecutor) driverr).executeScript("arguments[0].scrollIntoView(true);", element);

            // Get the current URL before clicking
            String currentUrl = driverr.getCurrentUrl();

            // Click the element
            element.click();

            // Wait for the page or content to load
            Thread.sleep(2000);

            // Get the URL after clicking
            String newUrl = driverr.getCurrentUrl();

            // Take a screenshot of the new page
            File screenshot = ((TakesScreenshot) driverr).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("screenshot" + index + ".png"));

            // If the URL has changed, navigate back
            if (!newUrl.equals(currentUrl)) {
                driverr.navigate().back();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Failed to handle XPath: " + xpath + ". Error: " + e.getMessage());
        }
    }
}
