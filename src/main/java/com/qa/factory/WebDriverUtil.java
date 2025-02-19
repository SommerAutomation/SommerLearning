package com.qa.factory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class WebDriverUtil {
	DriverFactory  driverfactory;
	Duration timeoutduration = Duration.ofSeconds(30);

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeoutduration);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void wait_Untill_Page_Load() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeoutduration);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='backdrop ng-star-inserted']")));
	}

	public void page_Load_Method() {
		JavascriptExecutor jsDriver = (JavascriptExecutor) DriverFactory.getDriver();
		NgWebDriver ngDriver = new NgWebDriver(jsDriver);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
	}

	public void button_Refresh() {
		JavascriptExecutor jsDriver = (JavascriptExecutor) DriverFactory.getDriver();
		NgWebDriver ngDriver = new NgWebDriver(jsDriver);
		ngDriver.waitForAngularRequestsToFinish();
	}

	public void waitForElementVisiblity(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeoutduration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForinvisibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeoutduration);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElementJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", element);
	}

	public void passTheValueUsingJavaScript(WebElement element, String value) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("arguments[0].value='" + value + "';", element);
	}

	public void waitForTitleContain(String title) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeoutduration);
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void invisiablitiy_Of_Element(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeoutduration);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void wait_For_Page_Load(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void javaViewPoint(WebElement ele) {
		JavascriptExecutor jse2 = (JavascriptExecutor) DriverFactory.getDriver();
		jse2.executeScript("arguments[0].scrollIntoView()", ele);
	}
	@SuppressWarnings({ "deprecation"})
	public void waitForElement() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void deSelectText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByValue(text);
	}

	public void moveToElement(WebElement element) {
		Actions ac = new Actions(DriverFactory.getDriver());
		ac.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) {
		Actions ac = new Actions(DriverFactory.getDriver());
		ac.contextClick(element).build().perform();
	}

	public void doubleClick(WebElement element) {
		Actions ac = new Actions(DriverFactory.getDriver());
		ac.doubleClick(element).build().perform();
	}

	public void dragandDrops(WebElement src, WebElement desti) {
		Actions actions = new Actions(DriverFactory.getDriver());
		Action action = actions.clickAndHold(src).moveToElement(desti).release(desti).build();
		action.perform();
	}

	public void switchToNewTab(String pageTitle) {
		Set<String> setlist = DriverFactory.getDriver().getWindowHandles();
		Iterator<String> it = setlist.iterator();

		while (it.hasNext()) {
			DriverFactory.getDriver().switchTo().window(it.next());
			String actPageTitle = DriverFactory.getDriver().getTitle();

			if (actPageTitle.contains(pageTitle)) {
				break;
			}
		}
	}

	public void acceptAlert() {
		DriverFactory.getDriver().switchTo().alert().accept();
	}

	public void cancelAlert() {
		DriverFactory.getDriver().switchTo().alert().dismiss();
	}

	public String getTitlePage() {
		String title = DriverFactory.getDriver().getTitle();
		return title;
	}

	public void selectByVisibleText(WebElement element, String text) throws InterruptedException {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void switch_To_Frame(String name) {
		DriverFactory.getDriver().switchTo().frame(name);
	}

	public void switch_To_Frame(int number) {
		DriverFactory.getDriver().switchTo().frame(number);
	}

	public void navigate_Back() {
		DriverFactory.getDriver().navigate().back();
	}

	public void page_Refresh() {
		DriverFactory.getDriver().navigate().refresh();
	}

	public void hitTabKey() {
		Actions action = new Actions(DriverFactory.getDriver());
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void hitEnterKey() {
		Actions action = new Actions(DriverFactory.getDriver());
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public void hitEscapeKey() {
		Actions action = new Actions(DriverFactory.getDriver());
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void hitControlTKey() {
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
	}

	public void CreateNewTabWithUrl(String Url) throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.getDriver();
		jsExecutor.executeScript("window.open('" + Url + "');");
		Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
		for (String windowHandle : windowHandles) {
			DriverFactory.getDriver().switchTo().window(windowHandle);
		}
		Thread.sleep(2000);
	}

	public void Uploadfile(String path) throws AWTException, InterruptedException {
		Thread.sleep(5000);
		String filePath = path;
		String absoluteFilePath = new File(filePath).getAbsolutePath();
		StringSelection selection = new StringSelection(absoluteFilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void ReturnToHomePage() throws InterruptedException {
		DriverFactory.getDriver().close();
	}

	public boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	public void CreateNewIncognitoTabWithUrl(String Url) throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverFactory.getDriver();
		jsExecutor.executeScript(
				"window.open('chrome://newtab', '_blank', 'noopener,noreferrer,incognito').location.href = '" + Url
						+ "';");
		Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
		for (String windowHandle : windowHandles) {
			DriverFactory.getDriver().switchTo().window(windowHandle);
		}
		Thread.sleep(2000);
	}
	
	public void uploadMultipleFiles(List<String> paths) throws AWTException, InterruptedException {
        Thread.sleep(5000);

        for (String path : paths) {
            String absoluteFilePath = new File(path).getAbsolutePath();
            StringSelection selection = new StringSelection(absoluteFilePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Optional delay between file uploads
            Thread.sleep(2000);
        }
	}
	public void takeScreenshot(String string,WebDriver driver) throws IOException {
		String screenshotFolder ="Report/Links/";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File(screenshotFolder+"screenshot" + string + ".png"));
	}
}
