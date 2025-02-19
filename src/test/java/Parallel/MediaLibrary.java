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

public class MediaLibrary {

	public static void main(String[] args) {
		WebDriver driver = initializeDriver();
		try {
			// Navigate to the target page
			driver.get("https://ap.bayatree.com/media-library/courses");

            List<String> xpaths = Arrays.asList(
          		"//a[@href='https://ap.bayatree.com']",
        		    "//a[@href='/media-library']",
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
        		    "//a[@href='/media-library/workbook1']",
        		    "//a[@href='/media-library/workbook2']",
        		    "//a[@href='/media-library/workbook3']",
        		    "//a[@href='/media-library/workbook4']",
        		    "//a[@href='/media-library/workbook5']",
        		    "//a[@href='/media-library/workbook6']",
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
        		    "//a[@href='https://ap.bayatree.com/phonics/']",
        		    "//a[@href='https://ap.bayatree.com/writing/']",
        		    "//a[@href='#']",
        		    "//a[@href='https://ap.bayatree.com/number/']",
        		    "//a[@href='https://ap.bayatree.com/typing/']",
        		    "//a[@href='https://ap.bayatree.com/media-library/']",
        		    "//a[@href='#']",
        		    "//img[@src='https://ap.bayatree.com/media-library/media_library/assets/SL-beta-logo.png' and @alt='Sommer Learning Logo']",
        		    "//img[@src='https://ap.bayatree.com/media-library/media_library/assets/Logo-Media-Library-colored.png' and contains(@class, 'ML_colored-logo')]",
			"//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/printPdf/textbook1/images/large/phonics-adventure-textbook1-1.jpg' and @alt='Book 1' and @title='Book 1']",
		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/printPdf/textbook2/images/large/phonics-adventure-textbook2-1.jpg' and @alt='Book 2' and @title='Book 2']",
		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/printPdf/textbook3/images/large/phonics-adventure-textbook3-1.jpg' and @alt='Book 3' and @title='Book 3']",
		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/printPdf/textbook4/images/large/phonics-adventure-textbook4-1.jpg' and @alt='Book 4' and @title='Book 4']"
			 );

			// Iterate through each XPath and handle
            for (int i = 0; i < xpaths.size(); i++) {
                handleXPath(driver, xpaths.get(i), i);
           }

           List<String> paths = Arrays.asList(
            		"//img[@src='https://ap.bayatree.com/media-library/media_library/assets/mediaImg.png' and @alt='Androcles and the Lion' and @title='Androcles and the Lion']",
        		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/sts_english_images/Androcles+and+the+Lion.jpg' and @alt='Androcles and the Lion' and @title='Androcles and the Lion']",
        		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/sts_english_images/The+Ant+and+the+Grasshopper.jpg' and @alt='The Ant and the Grasshopper' and @title='The Ant and the Grasshopper']",
        		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/sts_english_images/The+Boy+Who+Cried+Wolf!.jpg' and @alt='The Boy Who Cried Wolf!' and @title='The Boy Who Cried Wolf!']",
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
        		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/shortStory/Textbook_7_Read_the_Story.jpg' and @alt='Textbook 7' and @title='Textbook 7']",
        		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/MathAdventureStoryBook/Thumbnails/I_Can_Count_to_100-Apple.jpg' and @alt='I Can Count to 100' and @title='I Can Count to 100']",
        		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/MathAdventureStoryBook/Thumbnails/i_cant_and_iwill_try-apple.jpg' and @alt='I Can't and I'll Try ' and @title='I Can't and I'll Try ']",
        		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/MathAdventureStoryBook/Thumbnails/its_too_hard_multiplication-apple.jpg' and @alt='It\'s Too Hard Multiplication' and @title='It\'s Too Hard Multiplication']",
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
        		    "//img[@src='https://d2ku8j53eitc2o.cloudfront.net/Media+Library/ebooks_new/7CON+to+AP/questforsuccess/thumbnails/The-Dream-Job.jpg' and @alt='The Dream Job' and @title='The Dream Job']"
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
        		    "//img[@src='https://i.ytimg.com/vi/-PUYAoa8lm0/hqdefault.jpg' and @alt='How Picture Books Are Made 6' and @title='How Picture Books Are Made 6']"
        		    );

			// Iterate through each XPath and handle
			for (int i = 0; i < Crossxpaths.size(); i++) {
				WebDriver driverr = initializeDriver();
				driverr.get("https://ap.bayatree.com/media-library/courses");
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
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File("screenshot" + index + ".png"));
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
