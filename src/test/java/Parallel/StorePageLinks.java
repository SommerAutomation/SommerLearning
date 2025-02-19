package Parallel;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class StorePageLinks {

	public static void main(String[] args) {
	      
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // Navigate to the target page
        	driver.get("https://ap.bayatree.com/store/");

            // List of XPaths for buttons and links
            List<String> xpaths = Arrays.asList(
            		
            		"//a[@href='/' and contains(@class, 'custom-logo-link')]",
            		"//a[@href='https://ap.bayatree.com/store' and contains(@class, 'departments-menu-title')]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/graded-kits/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/phonics-adventure-text-books/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/guided-companion-readers-ages-5-7/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/advanced-companion-readers-ages-6-8/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/guided-target-readers-ages-5-7/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/advanced-target-readers-ages-6-8/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/non-fiction-readers-ages-5-7/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/advanced-non-fiction-readers-ages-6-8/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/stem-readers-ages-6-9/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/sommer-time-stories-ages-5-10/'])[3]",
            		"(//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/quest-for-success-chapter-books/'])[3]",

            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/sommer-time-stories-ages-5-10-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/advanced-companion-readers-ages-6-8-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/advanced-target-readers-ages-6-8-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/non-fiction-readers-ages-5-7-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/advanced-non-fiction-readers-ages-6-8-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/stem-readers-ages-6-9-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/quest-for-success-chapter-books-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/math-adventure-storybooks-ages-5-12/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/super-math-series-ages-5-11/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/early-readers/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/early-readers/read-to-me-readersages-4-6/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/early-readers/guided-companion-readers-ages-5-7-early-readers/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/early-readers/guided-target-readers-ages-5-7-early-readers/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/early-readers/non-fiction-readers-ages-5-7-early-readers/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/early-readers/math-adventure-storybooks-just-early-one-ages-5-7/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/math-adventure-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/math-adventure-storybooks/super-math-series-ages-5-11-math-adventure-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/math-adventure-storybooks/math-adventure-storybooks-ages-5-12-math-adventure-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/phonics-adventure-textbooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/number-success-textbooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/writing-workbooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/number-success-card-games/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/spanish-bilingual/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/spanish-bilingual/spanish-sommer-time-stories/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/spanish-bilingual/bilingual-sommer-time-stories/']",
            		"//a[@href='https://ap.bayatree.com/store/cart/' and contains(@class, 'cart-contents')]",
            		"//a[@href='https://ap.bayatree.com/store/wishlist-2/' and contains(@class, 'header-wishlist')]",
            		"//a[@class='login_auth' and @data-key='Sommertime']",
            		"//a[@href='https://ap.bayatree.com/media-library/sso-register/' and @title='Register']",
            		
            		"//a[@href='/' and contains(@class, 'custom-logo-link')]",
            		"//a[@href='https://ap.bayatree.com/store' and contains(@class, 'departments-menu-title')]",
            		"//a[@href='https://ap.bayatree.com/store/product-category/math-adventure-storybooks/super-math-series-ages-5-11-math-adventure-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/math-adventure-storybooks/math-adventure-storybooks-ages-5-12-math-adventure-storybooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/phonics-adventure-textbooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/number-success-textbooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/writing-workbooks/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/number-success-card-games/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/spanish-bilingual/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/spanish-bilingual/spanish-sommer-time-stories/']",
            		"//a[@href='https://ap.bayatree.com/store/product-category/spanish-bilingual/bilingual-sommer-time-stories/']",
            		"//a[@href='https://ap.bayatree.com/store/cart/' and contains(@class, 'cart-contents header-icon-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/androcles-and-the-lion/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/can-you-help-me-find-my-smile/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/the-cat/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/the-cat-and-the-hat/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/zag-and-the-cat/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/the-kicking-champ/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/arctic-animals/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/animal-babies/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/dare-to-dream/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/the-boy-who-cried-wolf/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/the-can/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product/the-cat-on-the-van/' and contains(@class, 'woocommerce-LoopProduct-link')]",
            		"//a[@href='/store/?product-page=2' and contains(@class, 'page-numbers next')]",
            		"//a[@href='/store/?product-page=3' and contains(@class, 'page-numbers')]",
            		"//a[@href='/store/?product-page=4' and contains(@class, 'page-numbers')]",
            		"//a[@href='https://ap.bayatree.com/store/product-category/storybooks/' and contains(@class, 'cat-item-link')]",
            		"//a[@href='https://ap.bayatree.com/store/product-category/phonics-adventure/' and contains(@class, 'cat-item-link')]",

            		"//a[@href='#' and @data-toggle='collapse' and @data-target='#children-of-term-383' and contains(@class, 'child-indicator collapsed')]",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/early-readers/read-to-me-readersages-4-6/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/early-readers/guided-companion-readers-ages-5-7-early-readers/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/early-readers/guided-target-readers-ages-5-7-early-readers/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/early-readers/non-fiction-readers-ages-5-7-early-readers/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/early-readers/math-adventure-storybooks-just-early-one-ages-5-7/' and @style='']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/math-adventure-storybooks/' and @style='']",
            		"//a[@href='#' and @data-toggle='collapse' and @data-target='#children-of-term-389' and contains(@class, 'child-indicator collapsed') and @style='']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/math-adventure-storybooks/super-math-series-ages-5-11-math-adventure-storybooks/' and @style='']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/math-adventure-storybooks/math-adventure-storybooks-ages-5-12-math-adventure-storybooks/' and @style='']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/spanish-bilingual/' and @style='']",
            		"//a[@href='#' and @data-toggle='collapse' and @data-target='#children-of-term-412' and contains(@class, 'child-indicator collapsed')]",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/spanish-bilingual/spanish-sommer-time-stories/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/spanish-bilingual/bilingual-sommer-time-stories/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/']",
            		"//a[@href='#' and @data-toggle='collapse' and @data-target='#children-of-term-392' and contains(@class, 'child-indicator collapsed')]",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/phonics-adventure-textbooks/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/number-success-textbooks/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/writing-workbooks/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/textbooks-workbooks-games/number-success-card-games/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/417/']",
            		"//a[@class='cat-item-link' and @href='https://ap.bayatree.com/store/product-category/uncategorized/']",
            		"//a[@href='https://ap.bayatree.com/support']",
            		"//a[@href='https://ap.bayatree.com/store/terms-and-conditions/']",
            		"(//a[@class='social-icon facebook' and @target='_blank' and @href='#' and @rel='noopener'])[1]",
            		"(//a[@class='social-icon instagram' and @target='_blank' and @href='#' and @rel='noopener'])[1]",
            		"(//a[@class='social-icon twitter' and @target='_blank' and @href='#' and @rel='noopener'])[1]",
            		"(//a[@class='social-icon googleplus' and @target='_blank' and @href='#' and @rel='noopener'])[1]",
            		"(//a[@class='social-icon linkedin' and @target='_blank' and @href='#' and @rel='noopener'])[1]"
            		

            
               
            );

            // Iterate through each XPath
            for (int i = 0; i < xpaths.size(); i++) {
                try {
                    // Find the element using XPath
                    WebElement element = driver.findElement(By.xpath(xpaths.get(i)));
                    Thread.sleep(2000);

                    // Scroll the element into view
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                    // Get the current URL before clicking
                    String currentUrl = driver.getCurrentUrl();

                    // Click the element
                    
                    element.click();

                    // Wait for the page or content to load (replace with explicit waits if needed)
                    Thread.sleep(5000);

                    // Get the URL after clicking
                    String newUrl = driver.getCurrentUrl();

                    // Take a screenshot of the new page
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    FileHandler.copy(screenshot, new File("screenshot" + i + ".png"));

                    // If the URL has changed, navigate back
                    if (!newUrl.equals(currentUrl)) {
                        driver.navigate().back();

                        // Wait for the original page to load
                        Thread.sleep(5000);
                    }
                } catch (Exception e) {
                    System.out.println("Failed to handle XPath: " + xpaths.get(i) + ". Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
