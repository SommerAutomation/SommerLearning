package com.qa.pages;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.qa.factory.WebDriverUtil;

public class Links {
	WebDriverUtil util;

	public void TakeScreenshotAllHomePagelinks() {
		
		WebDriver driver = initializeDriver();
		try {
			// Navigate to the target page
			driver.get("https://ap.bayatree.com");

			// List of XPaths for buttons and links
			List<String> xpaths = Arrays.asList("//a[@class='navbar-brand logo m-auto']",
					"//a[@class='headerBtn mediaLibrary rounded-pill']", "//a[@id='store']", "//a[@id='mathTabtn']",
					"//a[@id='numberTabtn']", "//a[@id='writingTabtn']", "//a[@id='typingTabtn']",
					"//a[@class='cardWithImg colorGreen']", "//a[@class='cardWithImg colorPurple']",
					"//a[@class='cardWithImg colorGreen2']", "//a[@class='cardWithImg colorOrange']",
					"//a[@class='cardWithImg colorPink']");

			// Iterate through each XPath and handle
			for (int i = 0; i < xpaths.size(); i++) {
				String SS = "Homepage page -";
				handleXPath(driver, xpaths.get(i), SS + i);
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
			WebElement phonicsbook = driverr.findElement(By.xpath(
					"(//div[@class='col-6 d-flex align-items-end justify-content-center position-relative'])[1]"));
			Actions actions = new Actions(driverr);

			// Perform hover action
			actions.moveToElement(phonicsbook).perform();
			Thread.sleep(2000); // Replace with WebDriverWait for a better approach
			phonicsbook.click();
			// List of XPaths for buttons and links
			List<String> xpaths = Arrays.asList("//h2[normalize-space()='Level 1']",
					"//h2[normalize-space()='Level 2']", "//h2[normalize-space()='Level 3']",
					"//h2[normalize-space()='Level 4']", "//h2[normalize-space()='Level 5']",
					"//h2[normalize-space()='Level 6']", "//h2[normalize-space()='Level 7']",
					"//h2[normalize-space()='Level 8']"

			);

			// Iterate through each XPath and handle
			for (int i = 0; i < xpaths.size(); i++) {
				phonics(driverr, xpaths.get(i), i);
			}

			WebElement readingbook = driverr
					.findElement(By.xpath("//div[contains(@class,'linkButtons text-balance reading rounded')]"));
			actions.moveToElement(readingbook).perform();
			Thread.sleep(2000); // Replace with WebDriverWait for a better approach
			readingbook.click();
			List<String> xpathss = Arrays.asList("//span[normalize-space()='1']", "//span[normalize-space()='2']",
					"//span[normalize-space()='3']", "//span[normalize-space()='4']", "//span[normalize-space()='5']",
					"//span[normalize-space()='6']", "//span[normalize-space()='7']", "//span[normalize-space()='8']"

			);
			for (int i = 0; i < xpathss.size(); i++) {
				phonics(driverr, xpathss.get(i), i + 8);
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
	private static void handleXPath(WebDriver driver, String xpath, String string) {
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
			String screenshotFolder ="Report/Links/";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(screenshotFolder+"screenshot-" + string + ".png"));

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
			Thread.sleep(2000);

			// Get the current URL before clicking
			String currentUrl = driverr.getCurrentUrl();

			// Click the element
			element.click();

			// Wait for the page or content to load
			Thread.sleep(2000);

			// Get the URL after clicking
			String newUrl = driverr.getCurrentUrl();

			// Take a screenshot of the new page
			String screenshotFolder ="Report/Links/";
			File screenshot = ((TakesScreenshot) driverr).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(screenshotFolder+"screenshot-" + index + ".png"));

			// If the URL has changed, navigate back
			if (!newUrl.equals(currentUrl)) {
				driverr.navigate().back();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println("Failed to handle XPath: " + xpath + ". Error: " + e.getMessage());
		}
	}

	public void TakeScreenshotAllMediaLibrarylinks() {

		WebDriver driver = initializeDriver();
		try {
			// Navigate to the target page
			driver.get("https://ap.bayatree.com/media-library/courses");

			List<String> xpaths = Arrays.asList("//a[@href='https://ap.bayatree.com']", "//a[@href='/media-library']",
					"//a[@href='https://ap.bayatree.com/sts/awards' and contains(@class, 'media-banner-wrap') and @target='_blank']",
					"//a[@href='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/worksheets/Overview+for+Sommer-Time+Stories.pdf' and @target='_blank']",
					"//a[@href='/media-library/see-all/24' and contains(@id, 'mlsee_all')]",
					"//a[@href='/sts/books/en/androcles-and-the-lion' and @target='_blank']",
					"//a[@href='/media-library/see-all/3' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/5' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/7' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/4' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/6' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/8' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/9' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/27' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/12' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/13' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/10' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/21' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/29' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/30' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/15' and contains(@id, 'mlsee_all')]",
					"//a[@href='/sts/books/en/androcles-and-the-lion' and @target='_blank']",
					"//a[@href='/media-library/see-all/16' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/28' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/14' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/see-all/17' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/workbook1']", "//a[@href='/media-library/workbook2']",
					"//a[@href='/media-library/workbook3']", "//a[@href='/media-library/workbook4']",
					"//a[@href='/media-library/workbook5']", "//a[@href='/media-library/workbook6']",
					"//a[@href='/media-library/see-all/18' and contains(@id, 'mlsee_all')]",
					"//a[@href='/media-library/numberbook1/addition']",
					"//a[@href='/media-library/numberbook2/subtraction']",
					"//a[@href='/media-library/numberbook3/multiplication']",
					"//a[@href='/media-library/numberbook4/division']",
					"//a[@href='/media-library/numberbook5/fraction']",
					"//a[@href='/media-library/numberbook6/decimals_percents']",
					"//a[@href='/media-library/see-all/19' and contains(@id, 'mlsee_all')]",
					"//a[@href='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/worksheets/Overview+for+Sommer+Time+Stories+Spanish.pdf' and @target='_blank']",
					"//a[@href='/media-library/see-all/25' and contains(@id, 'mlsee_all')]",
					"//a[@href='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/worksheets/Overview+for+Sommer-Time+Stories.pdf' and @target='_blank']",
					"//a[@href='/media-library/see-all/26' and contains(@id, 'mlsee_all')]",
					"//a[@href='https://ap.bayatree.com/phonics/']", "//a[@href='https://ap.bayatree.com/writing/']",
					"//a[@href='#']", "//a[@href='https://ap.bayatree.com/number/']",
					"//a[@href='https://ap.bayatree.com/typing/']",
					"//a[@href='https://ap.bayatree.com/media-library/']", "//a[@href='#']",
					"//img[@src='https://ap.bayatree.com/media-library/media_library/assets/SL-beta-logo.png' and @alt='Sommer Learning Logo']",
					"//img[@src='https://ap.bayatree.com/media-library/media_library/assets/Logo-Media-Library-colored.png' and contains(@class, 'ML_colored-logo')]",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/printPdf/textbook1/images/large/phonics-adventure-textbook1-1.jpg' and @alt='Book 1' and @title='Book 1']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/printPdf/textbook2/images/large/phonics-adventure-textbook2-1.jpg' and @alt='Book 2' and @title='Book 2']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/printPdf/textbook3/images/large/phonics-adventure-textbook3-1.jpg' and @alt='Book 3' and @title='Book 3']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/printPdf/textbook4/images/large/phonics-adventure-textbook4-1.jpg' and @alt='Book 4' and @title='Book 4']");

			// Iterate through each XPath and handle
			for (int i = 0; i < xpaths.size(); i++) {
				String SS = "Media library M -";
				handleXPath(driver, xpaths.get(i), SS + i);
			}

			List<String> paths = Arrays.asList(
					"//img[@src='https://ap.bayatree.com/media-library/media_library/assets/mediaImg.png' and @alt='Androcles and the Lion' and @title='Androcles and the Lion']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/sts_english_images/Androcles+and+the+Lion.jpg' and @alt='Androcles and the Lion' and @title='Androcles and the Lion']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/sts_english_images/Can+you+Help+Me+Find+My+Smile.jpg' and @alt='Can you Help Me Find My Smile?' and @title='Can you Help Me Find My Smile?']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/sts_english_images/Chicken+Little.jpg' and @alt='Chicken Little' and @title='Chicken Little']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/the_cat.jpg' and @alt='The Cat' and @title='The Cat']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/the_can.jpg' and @alt='The Can' and @title='The Can']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/the_bat.jpg' and @alt='The Bat' and @title='The Bat']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/the_rag.jpg' and @alt='The Rag' and @title='The Rag']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/the_red_hen.jpg' and @alt='The Red Hen' and @title='The Red Hen']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/the_jet.jpg' and @alt='The Jet' and @title='The Jet']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/zag_and_the_cat.jpg' and @alt='Zag and the Cat' and @title='Zag and the Cat']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/the_funny_hat.jpg' and @alt='The Funny Hat' and @title='The Funny Hat']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/play_with_us.jpg' and @alt='Play with Us' and @title='Play with Us']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/matt_and_the_van.jpg' and @alt='Matt and the Van' and @title='Matt and the Van']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/ebooks/phonics_ebooks_images/bell_on_a_pony.jpg' and @alt='Bell on a Pony' and @title='Bell on a Pony']",

					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/MathAdventureStoryBook/Thumbnails/I_Can_Count_to_100-Apple.jpg' and @alt='I Can Count to 100' and @title='I Can Count to 100']",

					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/MathAdventureStoryBook/Thumbnails/lets_share-apple.jpg' and @alt='Let\'s Share' and @title='Let\'s Share']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/MathAdventureStoryBook/Thumbnails/My_First_Book_of_Numbers-Apple.jpg' and @alt='My First Book of Numbers' and @title='My First Book of Numbers']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/MathAdventureStoryBook/Thumbnails/Oh_No!_The_Doorbell-Apple.jpg' and @alt='Oh No! The Doorbell' and @title='Oh No! The Doorbell']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/SuperMathStoryBooks/thumbnail/Where_Is_Math_Used.jpg' and @alt='Where is Math Used?' and @title='Where is Math Used?']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/SuperMathStoryBooks/thumbnail/Addition_To_Ten.jpg' and @alt='Addition To 10' and @title='Addition To 10']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/SuperMathStoryBooks/thumbnail/Subtraction_To_Ten.jpg' and @alt='Subtraction to 10' and @title='Subtraction to 10']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/SuperMathStoryBooks/thumbnail/Addition_To_Hundered.jpg' and @alt='Addition to 100' and @title='Addition to 100']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/SuperMathStoryBooks/thumbnail/Subtraction_To_Hundered.jpg' and @alt='Subtraction to 100' and @title='Subtraction to 100']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/SuperMathStoryBooks/thumbnail/Addition_With_Regrouping.jpg' and @alt='Addition With Regrouping' and @title='Addition With Regrouping']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/stem_images/Airplanes%20To%20Rockets.jpg' and @alt='Airplanes To Rockets' and @title='Airplanes To Rockets']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/stem_images/Becoming A Successful Entrepreneur.jpg' and @alt='Becoming A Successful Entrepreneur' and @title='Becoming A Successful Entrepreneur']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/stem_images/Elephant Ears and Eagle Eyes.jpg' and @alt='Elephant Ears and Eagle Eyes' and @title='Elephant Ears and Eagle Eyes']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/stem_images/Exploring the World.jpg' and @alt='Exploring the World' and @title='Exploring the World']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/stem_images/How Car Engines Work.jpg' and @alt='How Car Engines Work' and @title='How Car Engines Work']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media%20Library/stem_images/How Electricity Is Made.jpg' and @alt='How Electricity Is Made' and @title='How Electricity Is Made']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/questforsuccess/thumbnails/Against-All-Odds.jpg' and @alt='Against All Odds' and @title='Against All Odds']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/questforsuccess/thumbnails/Bamboozled.jpg' and @alt='Bamboozled' and @title='Bamboozled']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/questforsuccess/thumbnails/Better-Together.jpg' and @alt='Better Together' and @title='Better Together']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/questforsuccess/thumbnails/Divide-To-Conquer.jpg' and @alt='Divide To Conquer' and @title='Divide To Conquer']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/questforsuccess/thumbnails/Dream.jpg' and @alt='Dream' and @title='Dream']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/questforsuccess/thumbnails/The-Dream-Job.jpg' and @alt='The Dream Job' and @title='The Dream Job']");

			// Iterate through each XPath and handle
			for (int i = 0; i < paths.size(); i++) {
				String SS = "Media library Ml -";
				handleXPathForNewWindow(driver, paths.get(i), SS + i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}

		try {

			List<String> Crossxpaths = Arrays.asList(
					"//img[@src='https://img.youtube.com/vi/vM3rPHndLLA/hqdefault.jpg' and @alt='Math Adventure Multiplication Songs - Multiply by 2' and @title='Math Adventure Multiplication Songs - Multiply by 2']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/ABC-Bingo-New.jpg' and @alt='ABC Bingo' and @title='ABC Bingo']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/Connect-the-Dots-New.jpg' and @alt='ABC Connect The Dots' and @title='ABC Connect The Dots']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/abc_lets_go_fishing.png' and @alt='ABC Let\'s Go Fishing' and @title='ABC Let\'s Go Fishing']",

					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/abc_lets_play_basketball.png' and @alt='ABC Let's Play Basketball' and @title='ABC Let's Play Basketball']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/abc_lets_play_football.png' and @alt='ABC Let's Play Football' and @title='ABC Let's Play Football']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/bingo.png' and @alt='Bingo' and @title='Bingo']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/lets_go_fishing.png' and @alt='Let's Go Fishing' and @title='Let's Go Fishing']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/lets_play_baseball.png' and @alt='Let's Play Baseball' and @title='Let's Play Baseball']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/lets_play_basketball.png' and @alt='Let's Play Basketball' and @title='Let's Play Basketball']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/lets_play_football.png' and @alt='Let's Play Football' and @title='Let's Play Football']",
					"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/game+library/lets_play_soccer.png' and @alt='Let's Play Soccer' and @title='Let's Play Soccer']",
					"//img[@src='https://ap.bayatree.com/media-library/media_library/assets/mediaImg.png' and @alt='Androcles and the Lion' and @title='Androcles and the Lion']",
					"//img[@src='https://i.ytimg.com/vi/T3K2Yzq4iIc/hqdefault.jpg' and @alt='Androcles and the Lion' and @title='Androcles and the Lion']",
					"//img[@src='https://i.ytimg.com/vi/lHAoMDPW6WU/hqdefault.jpg' and @alt='Ant and the Grasshopper, The' and @title='Ant and the Grasshopper, The']",
					"//img[@src='https://i.ytimg.com/vi/iADJ_5TkS58/hqdefault.jpg' and @alt='Boy Who Cried Wolf, The' and @title='Boy Who Cried Wolf, The']",
					"//img[@src='https://i.ytimg.com/vi/_FZ5l9m3htg/hqdefault.jpg' and @alt='Can You Help Me Find My Smile English' and @title='Can You Help Me Find My Smile English']",
					"//img[@src='https://i.ytimg.com/vi/gw90V8xvYhs/hqdefault.jpg' and @alt='Chicken Little' and @title='Chicken Little']",
					"//img[@src='https://i.ytimg.com/vi/SVZH6Yjxq7Q/hqdefault.jpg' and @alt='Alphabet Song: The Blue Danube Waltz' and @title='Alphabet Song: The Blue Danube Waltz']",
					"//img[@src='https://i.ytimg.com/vi/4SQk1wLP6Tw/hqdefault.jpg' and @alt='Alphabet Song: The Farmer in the Dell' and @title='Alphabet Song: The Farmer in the Dell']",
					"//img[@src='https://i.ytimg.com/vi/9_sFnplmh1Q/hqdefault.jpg' and @alt='Alphabet Song: Alphabet Soup' and @title='Alphabet Song: Alphabet Soup']",
					"//img[@src='https://img.youtube.com/vi/YvqLoI5oagQ/hqdefault.jpg' and @alt='Alphabet Song: Chicken Dance' and @title='Alphabet Song: Chicken Dance']",
					"//img[@src='https://img.youtube.com/vi/9POIQQXK5Bw/hqdefault.jpg' and @alt='Alphabet Song: Cowboy Wagon Trail' and @title='Alphabet Song: Cowboy Wagon Trail']",
					"//img[@src='https://i.ytimg.com/vi/gD46itvR4T0/hqdefault.jpg' and @alt='Alphabet Song: Disco' and @title='Alphabet Song: Disco']",
					"//img[@src='https://img.youtube.com/vi/vM3rPHndLLA/hqdefault.jpg' and @alt='Math Adventure Multiplication Songs - Multiply by 2' and @title='Math Adventure Multiplication Songs - Multiply by 2']",
					"//img[@src='https://img.youtube.com/vi/ljWcu-HemnY/hqdefault.jpg' and @alt='Math Adventure Multiplication Songs - Multiply by 3' and @title='Math Adventure Multiplication Songs - Multiply by 3']",
					"//img[@src='https://img.youtube.com/vi/_BVfOprcTAQ/hqdefault.jpg' and @alt='Math Adventure Multiplication Songs - Multiply by 4' and @title='Math Adventure Multiplication Songs - Multiply by 4']",
					"//img[@src='https://img.youtube.com/vi/WpPvZccZeo0/hqdefault.jpg' and @alt='Math Adventure Multiplication Songs - Multiply by 5' and @title='Math Adventure Multiplication Songs - Multiply by 5']",
					"//img[@src='https://img.youtube.com/vi/yUXUVgawlDI/hqdefault.jpg' and @alt='Math Adventure Multiplication Songs - Multiply by 6' and @title='Math Adventure Multiplication Songs - Multiply by 6']",
					"//img[@src='https://img.youtube.com/vi/_YIkFcTKJNw/hqdefault.jpg' and @alt='Math Adventure Multiplication Songs - Multiply by 7' and @title='Math Adventure Multiplication Songs - Multiply by 7']",
					"//img[@src='https://i.ytimg.com/vi/6A8slVXi8RQ/hqdefault.jpg' and @alt='How Picture Books Are Made 1' and @title='How Picture Books Are Made 1']",
					"//img[@src='https://i.ytimg.com/vi/j-UqzAgm29Y/hqdefault.jpg' and @alt='How Picture Books Are Made 2' and @title='How Picture Books Are Made 2']",
					"//img[@src='https://i.ytimg.com/vi/w2aser22S4E/hqdefault.jpg' and @alt='How Picture Books Are Made 3' and @title='How Picture Books Are Made 3']",
					"//img[@src='https://i.ytimg.com/vi/wQpW9YUA8SI/hqdefault.jpg' and @alt='How Picture Books Are Made 4' and @title='How Picture Books Are Made 4']",
					"//img[@src='https://i.ytimg.com/vi/fALJbFhIpwY/hqdefault.jpg' and @alt='How Picture Books Are Made 5' and @title='How Picture Books Are Made 5']",
					"//img[@src='https://i.ytimg.com/vi/-PUYAoa8lm0/hqdefault.jpg' and @alt='How Picture Books Are Made 6' and @title='How Picture Books Are Made 6']");

			// Iterate through each XPath and handle
			for (int i = 0; i < Crossxpaths.size(); i++) {
				WebDriver driverr = initializeDriver();
				driverr.get("https://ap.bayatree.com/media-library/courses");
				String SS = "Medialibrary - ";
				handleXPathwithcross(driverr, Crossxpaths.get(i), SS + i);
				driverr.quit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}

	}

	// Method to handle each XPath separately

	private static void handleXPathwithcross(WebDriver driverr, String xpath, String string) {
		try {

			WebElement element = driverr.findElement(By.xpath(xpath));
			Thread.sleep(2000);
			element.click();
			Thread.sleep(3000);
			String screenshotFolder ="Report/Links/";
			File screenshot = ((TakesScreenshot) driverr).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(screenshotFolder+"screenshot" + string + ".png"));

		} catch (Exception e) {
			System.out.println("Failed to handle XPath: " + xpath + ". Error: " + e.getMessage());
		}
	}

	private static void handleXPathForNewWindow(WebDriver driver, String xpath, String string) {

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
				String screenshotFolder ="Report/Links/";
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(screenshot, new File(screenshotFolder+"screenshot" + string + ".png"));

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

	public void TakeScreenshotAllSTSlinks() {
		WebDriver driver = initializeDriver();
		try {
			// Navigate to the target page
			driver.get("https://ap.bayatree.com/sts/");

			List<String> xpaths = Arrays.asList("//a[@href='/']",
					"(//a[@href='/sts/books/en/the-tortoise-and-the-hare'])[3]",
					"(//a[@href='/sts/books/en/the-town-musicians-of-bremen'])[3]",
					"(//a[@href='/sts/books/en/the-ugly-caterpillar'])[3]",
					"(//a[@href='/sts/books/en/ugly-princess'])[3]",
					"(//a[@href='/sts/books/en/you-move-you-lose'])[3]", "//a[@href='/sts/books/en/your-job-is-easy']",
					"//a[@href='/sts/books/en/androcles-and-the-lion']",
					"//a[@href='/sts/books/en/the-ant-and-the-grasshopper']",
					"//a[@href='/sts/books/en/the-boy-who-cried-wolf']",
					"//a[@href='/sts/books/en/can-you-help-me-find-my-smile']",
					"//a[@href='/sts/books/en/chicken-little']",
					"//a[@href='/sts/books/en/the-country-mouse-and-the-city-mouse']",
					"//a[@href='/sts/books/en/dare-to-dream']", "//a[@href='/sts/books/en/donkey-fox-and-lion']",
					"//a[@href='/sts/books/en/the-eagle-and-the-chickens']",
					"//a[@href='/sts/books/en/the-emperor-and-the-seed']",
					"//a[@href='/sts/books/en/the-emperors-new-clothes']",
					"//a[@href='/sts/books/en/the-great-royal-race']", "//a[@href='/sts/books/en/i-am-a-lion']",
					"//a[@href='/sts/books/en/if-only-i-were']", "//a[@href='/sts/books/en/its-not-fair']",
					"//a[@href='/sts/books/en/king-of-the-pond']", "//a[@href='/sts/books/en/light-your-candle']",
					"//a[@href='/sts/books/en/the-lion-and-the-mouse']",
					"//a[@href='/sts/books/en/the-lion-and-the-three-bulls']",
					"//a[@href='/sts/books/en/the-little-red-hen']",
					"//a[@href='/sts/books/en/little-red-riding-hood']",
					"//a[@href='/sts/books/en/the-little-red-train']", "//a[@href='/sts/books/en/mayor-for-a-day']",
					"//a[@href='/sts/books/en/the-miller-his-son-and-their-donkey']",
					"//a[@href='/sts/books/en/miserable-millie']", "//a[@href='/sts/books/en/no-longer-a-dilly-dally']",
					"//a[@href='/sts/books/en/no-one-will-ever-know']", "//a[@href='/sts/books/en/noise-noise-noise']",
					"//a[@href='/sts/books/en/proud-rooster-and-little-hen']",
					"//a[@href='/sts/books/en/the-richest-poor-kid']",
					"//a[@href='/sts/books/en/the-sly-fox-and-the-chicks']",
					"//a[@href='/sts/books/en/spike-the-rebel']", "//a[@href='/sts/books/en/stone-soup']",
					"//a[@href='/sts/books/en/three-little-pigs']", "//a[@href='/sts/books/en/tied-up-in-knots']",
					"//a[@href='/sts/books/en/time-remote']", "//a[@href='/sts/books/en/the-tortoise-and-the-hare']",
					"//a[@href='/sts/books/en/the-town-musicians-of-bremen']",
					"//a[@href='/sts/books/en/the-ugly-caterpillar']", "//a[@href='/sts/books/en/ugly-princess']",
					"//a[@href='/sts/books/en/you-move-you-lose']", "//a[@href='/sts/books/en/your-job-is-easy']",
					"//a[@href='#']", "//a[@href='#']", "//a[@href='#']",
					"//a[@class='privacyPolicy' and @href='/privacy-policy']"

			);

			// Iterate through each XPath and handle
			for (int i = 0; i < xpaths.size(); i++) {
				String ss = "STS -";
				handleXPath(driver, xpaths.get(i), ss + i);
			}

			List<String> paths = Arrays.asList(

			);

			// Iterate through each XPath and handle
			for (int i = 0; i < paths.size(); i++) {
				String ss = "STS S-";
				handleXPathForNewWindow(driver, paths.get(i), ss + i);
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
				String ss = "STS S-";
				handleXPathwithcross(driverr, Crossxpaths.get(i), ss + i);
				driverr.quit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}

	}

	public void TakeScreenshotAllStorelinks() {
		WebDriver driver = initializeDriver();
		try {
			// Navigate to the target page
			driver.get("https://ap.bayatree.com/store/");

			// List of XPaths for buttons and links
			List<String> xpaths = Arrays.asList("//a[@href='/' and contains(@class, 'custom-logo-link')]",
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

			// Iterate through each XPath and handle
			for (int i = 0; i < xpaths.size(); i++) {
				String SS = "Store page -";
				handleXPath(driver, xpaths.get(i), SS + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}

	public void TakeScreenshotAllTypingLinks() {

		WebDriver driver = initializeDriver();
		try {
			// Navigate to the target page
			driver.get("https://ap.bayatree.com/typing/courses");

			// Iterate through each XPath and handle
			for (int i = 1; i <= 275; i++) {
				String typingProgram = "//a[@href='/typing/program:" + i + "']";
				String ss = "Typing page-";
				handleXPathwithcross(driver, typingProgram, ss + i);
				driver.navigate().back();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
