package Parallel;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class PhonicsAllScreensot {
    private ExtentReports extent;
    private ExtentTest test;
    private WebDriver driver;
    private int count = 1;
    private int range = 1;
    
    private String bookNumber;
    private String sectionNumber;
    private String lessonNumber;
    private String totalActivity;
    private String activityNumber;
    
    
    public void breadCrumbs() {
        bookNumber = driver.findElement(By.xpath("(//*[@class='lesson-wrap title_Color']/ul/li/span)[1]")).getText();
        sectionNumber = driver.findElement(By.xpath("(//*[@class='lesson-wrap title_Color']/ul/li/span)[2]")).getText();
        lessonNumber = driver.findElement(By.xpath("(//*[@class='lesson-wrap title_Color']/ul/li/span)[3]")).getText();
        totalActivity = driver.findElement(By.xpath("(//*[@class='lesson-wrap title_Color']/ul/li/span)[4]")).getText();
        activityNumber = totalActivity.substring(0, 1);
    }
    
    public void takeScreenshot() {
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String directoryPath = "D:\\DSScreenshots\\Broken_Links\\Book_" + bookNumber;
//        new File(directoryPath).mkdirs();
//        String filePath = directoryPath + "\\" + bookNumber + "-" + sectionNumber + "-" + lessonNumber + "-" + activityNumber + "-Screenshot-" + range + ".png";
//        screenshot.renameTo(new File(filePath));
//        range++;
    }
    
    public void setUp() {
         ChromeOptions options = new ChromeOptions();
         driver = new ChromeDriver(options);
         driver.manage().window().maximize();
         System.out.print("SetUP page");
    	
         
    }
    
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
    
    public void actionClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }
    
    public void nextButton() {
        WebElement nextButton = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
        actionClick(nextButton);
    }
    
    public void allBooks() throws InterruptedException {
    	
    	driver.get("https://ap.bayatree.com/phonics/lesson/level:1/section:20/lesson:lesson1/activity:1");
      
        
        try {
            driver.findElement(By.cssSelector(".icon-menu-bar .fa")).click();
        } catch (Exception e) {
            e.printStackTrace();
            tearDown();
        }
        
        List<WebElement> books = driver.findElements(By.cssSelector(".menuTabHeader li button"));
        for (WebElement book : books) {
            book.click();
            List<WebElement> sections = driver.findElements(By.xpath("//div[@id='sectionDiv']/div"));
            for (WebElement section : sections) {
                section.click();
                List<WebElement> lessons = driver.findElements(By.xpath("//div[@id='lessonDiv']/div"));
                for (WebElement lesson : lessons) {
                    actionClick(lesson);
                    List<WebElement> activities = driver.findElements(By.xpath("//div[@id='activityListing']/div"));
                    for (WebElement activity : activities) {
                    	System.out.println("1");
                        actionClick(activity);
                        System.out.println("2");
                        breadCrumbs();
                        System.out.println("3");
                        takeScreenshot();
                        System.out.println("4");
                    	Thread.sleep(3000);

                        //test.log(Status.INFO, "Test case: " + count + "------>  URL is Working");
                        nextButton();
                        count++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
    	PhonicsAllScreensot report = new PhonicsAllScreensot();
        report.setUp();
        report.allBooks();
        report.tearDown();
    }
}



