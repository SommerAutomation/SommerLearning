package Parallel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class program {
    private WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        program program = new program();
        program.setup();
        program.fetchButtonAndLinkXpaths();
        program.tearDown();
    }

    // Setup WebDriver
    public void setup() throws InterruptedException {
        // Setup ChromeDriver
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://ap.bayatree.com/store/");  
       // Replace with your target URL
    }

    // Fetch all button and link XPaths
    public void fetchButtonAndLinkXpaths() {
        // Find all buttons on the page
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        // Find all links on the page
        List<WebElement> links = driver.findElements(By.xpath("//a"));

        System.out.println("Buttons:");
        for (WebElement button : buttons) {
            // Print the XPath for each button
            String buttonXPath = getElementXPath(button);
            System.out.println(buttonXPath);
        }

        System.out.println("\nLinks:");
        for (WebElement link : links) {
            // Print the XPath for each link
            String linkXPath = getElementXPath(link);
            System.out.println(linkXPath);
        }
    }

    // Method to generate XPath for an element dynamically
    public String getElementXPath(WebElement element) {
        // Try to get a unique and accurate XPath by traversing its hierarchy
        String tagName = element.getTagName();
        String path = tagName;

        // Check if the element has an 'id' or 'name' attribute to make it unique
        String id = element.getAttribute("id");
        if (id != null && !id.isEmpty()) {
            return tagName + "[@id='" + id + "']";
        }

        // If not, use class name or other attributes to build a more specific XPath
        String className = element.getAttribute("class");
        if (className != null && !className.isEmpty()) {
            return tagName + "[@class='" + className + "']";
        }

        // Use index if no unique attributes are found
        List<WebElement> siblings = element.findElements(By.xpath("..//" + tagName));
        int index = siblings.indexOf(element) + 1; // XPath is 1-indexed
        return tagName + "[" + index + "]";
    }

    // TearDown WebDriver
    public void tearDown() {
        driver.quit();
    }
}
