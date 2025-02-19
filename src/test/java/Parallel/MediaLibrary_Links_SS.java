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

public class MediaLibrary_Links_SS {
	public static void main(String[] args) {
	      
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // Navigate to the target page
        	driver.get("https://ap.bayatree.com/media-library/courses");

            // List of XPaths for buttons and links
            List<String> xpaths = Arrays.asList(
//            		    "//a[@href='https://ap.bayatree.com']",
//            		    "//a[@href='/media-library']",
//            		    "//a[@href='https://ap.bayatree.com/sts/awards' and contains(@class, 'media-banner-wrap') and @target='_blank']",
//            		    "//a[@href='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/worksheets/Overview+for+Sommer-Time+Stories.pdf' and @target='_blank']",
//            		    "//a[@href='/media-library/see-all/24' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/sts/books/en/androcles-and-the-lion' and @target='_blank']",
//            		    "//a[@href='/media-library/see-all/3' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/5' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/7' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/4' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/6' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/8' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/9' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/27' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/12' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/13' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/10' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/21' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/29' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/30' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/15' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/sts/books/en/androcles-and-the-lion' and @target='_blank']",
//            		    "//a[@href='/media-library/see-all/16' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/28' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/14' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/see-all/17' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/workbook1']",
//            		    "//a[@href='/media-library/workbook2']",
//            		    "//a[@href='/media-library/workbook3']",
//            		    "//a[@href='/media-library/workbook4']",
//            		    "//a[@href='/media-library/workbook5']",
//            		    "//a[@href='/media-library/workbook6']",
//            		    "//a[@href='/media-library/see-all/18' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='/media-library/numberbook1/addition']",
//            		    "//a[@href='/media-library/numberbook2/subtraction']",
//            		    "//a[@href='/media-library/numberbook3/multiplication']",
//            		    "//a[@href='/media-library/numberbook4/division']",
//            		    "//a[@href='/media-library/numberbook5/fraction']",
//            		    "//a[@href='/media-library/numberbook6/decimals_percents']",
//            		    "//a[@href='/media-library/see-all/19' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/worksheets/Overview+for+Sommer+Time+Stories+Spanish.pdf' and @target='_blank']",
//            		    "//a[@href='/media-library/see-all/25' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/worksheets/Overview+for+Sommer-Time+Stories.pdf' and @target='_blank']",
//            		    "//a[@href='/media-library/see-all/26' and contains(@id, 'mlsee_all')]",
//            		    "//a[@href='https://ap.bayatree.com/phonics/']",
//            		    "//a[@href='https://ap.bayatree.com/writing/']",
//            		    "//a[@href='#']",
//            		    "//a[@href='https://ap.bayatree.com/number/']",
//            		    "//a[@href='https://ap.bayatree.com/typing/']",
//            		    "//a[@href='https://ap.bayatree.com/media-library/']",
//            		    "//a[@href='#']",

//            		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/banner/home-page-banner.jpg']",
//            		    
            		   
            		
            		    

            		    
            		    
            		   

               
            );

            // Iterate through each XPath
            for (int i = 0; i < xpaths.size(); i++) {
                try {
                    WebElement element = driver.findElement(By.xpath(xpaths.get(i)));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                    String currentUrl = driver.getCurrentUrl();
                    
                    element.click();
                    Thread.sleep(6000);

                    String newUrl = driver.getCurrentUrl();

                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    FileHandler.copy(screenshot, new File("screenshot" + i + ".png"));

                    if (!newUrl.equals(currentUrl)) {
                        driver.navigate().back();
                        Thread.sleep(2000);
                    }
                } catch (Exception e) {
                    System.out.println("Failed to handle XPath: " + xpaths.get(i) + ". Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}