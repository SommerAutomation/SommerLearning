package com.qa.pages;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.WebDriverUtil;
import com.qa.util.JSONFileClass;

public class Phonics_adventure {
	@FindBy(xpath = "//a[normalize-space()='Menu']")
	WebElement Menubar;
	@FindBy(xpath = "//span[normalize-space()='Interactivity']")
	WebElement intractactivebutton;
	@FindBy(xpath = "//div[contains(@class, 'flip-divider')]//div[contains(@class, 'cardUp') and contains(@audiosrc, '.mp3')]")
	WebElement correctBook;
	@FindBy(xpath = "//div[@class='fontface_ADV_CALIBRI cardFontFace']")
	WebElement divBox;
	@FindBy(xpath = "//div[@class='fontface_ADV_CALIBRI cardFontFace']/span")
	WebElement spanText;
	@FindBy(xpath = "//div[@class='fc-imgwrap layout-align-center-center layout-row']")
	WebElement divImgBox;
	@FindBy(xpath = "//div[@class='fc-imgwrap layout-align-center-center layout-row']/img")
	WebElement imgElement;
	@FindBy(xpath = "//img[@src='assets/img/Phonics-LOGO.png']")
	WebElement phonicadventurButton;
	@FindBy(xpath = "//img[@class='shape-one']")
	WebElement kindergartenButton;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='2']")
	WebElement Book2Button;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='3']")
	WebElement Book3Button;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='4']")
	WebElement Book4Button;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='5']")
	WebElement Book5Button;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='6']")
	WebElement Book6Button;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='7']")
	WebElement Book7Button;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][normalize-space()='8']")
	WebElement Book8Button;

	WebDriver driver;
	WebDriverUtil util;
	JSONFileClass file;
	JSONObject user;
	String UrlText;

	public Phonics_adventure(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnPhonicsAdventure() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(phonicadventurButton);
		phonicadventurButton.click();

	}

	public void clickOnKindergarten() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(kindergartenButton);
		kindergartenButton.click();

	}

	public void chooseAllWordFinderOfBook2() {
		util = new WebDriverUtil();
		Menubar.click();
		util.waitForElementToBeClickable(Book2Button);
		Book2Button.click();

	}
	public void chooseAllWordFinderOfBook3() {
		util = new WebDriverUtil();
		Menubar.click();
		util.waitForElementToBeClickable(Book3Button);
		Book3Button.click();

	}
	public void chooseAllWordFinderOfBook4() {
		util = new WebDriverUtil();
		Menubar.click();
		util.waitForElementToBeClickable(Book4Button);
		Book4Button.click();

	}
	public void chooseAllWordFinderOfBook5() {
		util = new WebDriverUtil();
		Menubar.click();
		util.waitForElementToBeClickable(Book5Button);
		Book5Button.click();

	}
	public void chooseAllWordFinderOfBook6() {
		util = new WebDriverUtil();
		Menubar.click();
		util.waitForElementToBeClickable(Book6Button);
		Book6Button.click();

	}
	public void chooseAllWordFinderOfBook7() {
		util = new WebDriverUtil();
		Menubar.click();
		util.waitForElementToBeClickable(Book7Button);
		Book7Button.click();

	}
	public void chooseAllWordFinderOfBook8() {
		util = new WebDriverUtil();
		Menubar.click();
		util.waitForElementToBeClickable(Book8Button);
		Book8Button.click();

	}

	public void CheckTextIsAlignedorNot() {
		int divX = divBox.getLocation().getX();
		int divY = divBox.getLocation().getY();
		int divWidth = divBox.getSize().getWidth();
		int divHeight = divBox.getSize().getHeight();

		// Get the dimensions and location of the span element
		int spanX = spanText.getLocation().getX();
		int spanY = spanText.getLocation().getY();
		int spanWidth = spanText.getSize().getWidth();
		int spanHeight = spanText.getSize().getHeight();

		// Check if span is within the div boundaries
		boolean isTextWithinDiv = spanX >= divX && spanY >= divY && (spanX + spanWidth) <= (divX + divWidth)
				&& (spanY + spanHeight) <= (divY + divHeight);

		Assert.assertTrue(isTextWithinDiv);

	}

	public void CheckImgIsAlignedorNot() {
		int divX = divImgBox.getLocation().getX();
		int divY = divImgBox.getLocation().getY();
		int divWidth = divImgBox.getSize().getWidth();
		int divHeight = divImgBox.getSize().getHeight();

		// Get the dimensions and location of the img element
		int imgX = imgElement.getLocation().getX();
		int imgY = imgElement.getLocation().getY();
		int imgWidth = imgElement.getSize().getWidth();
		int imgHeight = imgElement.getSize().getHeight();

		// Check if image is within the div boundaries
		boolean isImageWithinDiv = imgX >= divX && imgY >= divY && (imgX + imgWidth) <= (divX + divWidth)
				&& (imgY + imgHeight) <= (divY + divHeight);
		
		Assert.assertTrue(isImageWithinDiv);
	}

	public void enterTheEmail(String WordFinder) {
		util = new WebDriverUtil();

		intractactivebutton.click();
		WebElement wordFinder = driver.findElement(
				By.xpath("(//span[@class='interactivity-name'][normalize-space()='Word Finder'])[" + WordFinder + "]"));
		wordFinder.click();
	}

	public void checkTheUIofBooks() throws InterruptedException {
		int[][] screenSizes = { { 1920, 1080 },
//		            {1366, 768},
//		            {768, 1024},
//		            {375, 667}
		};

		for (int[] size : screenSizes) {
			int width = size[0];
			int height = size[1];

//		            driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
		            Thread.sleep(2000);
		            WebElement textElement = driver.findElement(By.cssSelector(".cardfront-text"));
		            WebElement parentElement = driver.findElement(By.cssSelector(".testcard1_ff"));

		            // Get the bounding rectangles of the parent and text elements
		            Rectangle parentRect = parentElement.getRect();
		            Rectangle textRect = textElement.getRect();

		            // Define a small tolerance/margin allowed around the centered text (in pixels)
		            int marginTolerance = 10;  // You can adjust this value to suit your needs

		            // Step 1: Check if the text is fully visible (not clipped)
		            boolean isTextVisible = (textRect.getX() >= parentRect.getX()) &&
		                                    (textRect.getY() >= parentRect.getY()) &&
		                                    (textRect.getX() + textRect.getWidth() <= parentRect.getX() + parentRect.getWidth()) &&
		                                    (textRect.getY() + textRect.getHeight() <= parentRect.getY() + parentRect.getHeight());

		            // If the text is not fully visible, assert failure
		            if (!isTextVisible) {
		                Assert.fail("Text is not fully visible within the parent element.");
		            }

		            // Step 2: Check if the parent element has 'overflow: hidden' or other clipping styles
		            String overflowX = parentElement.getCssValue("overflow-x");
		            String overflowY = parentElement.getCssValue("overflow-y");

		            if ("hidden".equals(overflowX) || "hidden".equals(overflowY)) {
		                if (textRect.getX() + textRect.getWidth() > parentRect.getX() + parentRect.getWidth() ||
		                    textRect.getY() + textRect.getHeight() > parentRect.getY() + parentRect.getHeight()) {
		                    Assert.fail("Text is being clipped due to parent's overflow property.");
		                }
		            }

		            // Step 3: Verify the text is aligned in the center (with a small margin tolerance)
		            // Horizontal center alignment with tolerance
		            boolean isHorizontallyCenteredWithMargin = Math.abs((parentRect.getX() + parentRect.getWidth() / 2) - (textRect.getX() + textRect.getWidth() / 2)) <= marginTolerance;

		            // Vertical center alignment with tolerance
		            boolean isVerticallyCenteredWithMargin = Math.abs((parentRect.getY() + parentRect.getHeight() / 2) - (textRect.getY() + textRect.getHeight() / 2)) <= marginTolerance;

		            // Assert that both conditions are true
		            if (!isHorizontallyCenteredWithMargin || !isVerticallyCenteredWithMargin) {
		                Assert.fail("Text is not properly centered in the parent element with the expected margin.");
		            }

		            // Step 4: (Optional) Check if the text is inside the visible area of the viewport
		            // Get the dimensions of the viewport
		            Dimension viewportSize = driver.manage().window().getSize();
		            Point viewportLocation = driver.manage().window().getPosition();

		            // Check if the text is fully within the viewport
		            boolean isTextInViewport = (textRect.getX() >= viewportLocation.getX()) &&
		                                       (textRect.getY() >= viewportLocation.getY()) &&
		                                       (textRect.getX() + textRect.getWidth() <= viewportLocation.getX() + viewportSize.getWidth()) &&
		                                       (textRect.getY() + textRect.getHeight() <= viewportLocation.getY() + viewportSize.getHeight());

		            if (!isTextInViewport) {
		                Assert.fail("Text is not fully visible within the viewport.");
		            }



		}}


	public void ClickOnTheRightBook() throws InterruptedException {
		util = new WebDriverUtil();
		List<WebElement> elements=driver.findElements(
				By.xpath("//div[@class='fa fa-star-o']"));
		int star=elements.size();
		for (int i = 1; i <=star; i++) {
			
			correctBook.click();
			CheckTextIsAlignedorNot();
			CheckImgIsAlignedorNot();
			Thread.sleep(10000);
		}

	}

}
