package Parallel;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.pages.Links;
import com.qa.pages.Phonics_adventure;
import com.qa.util.JSONFileClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Links_Tests {
	WebDriver driver;
	Links links;
	JSONFileClass file;
	JSONObject user;
	@When("the user navigate to the Sommer Learning baseurl")
	public void user_navigate_to_the_sommer_learning_baseurl() {
	    
	}
	@Then("then take screenshot all homepage links")
	public void then_take_screenshot_all_homepage_links() {
		links=new Links();
		links.TakeScreenshotAllHomePagelinks();
	  
	}
	@Then("then take screenshot all media library links")
	public void then_take_screenshot_all_media_library_links() {
		links=new Links();
		links.TakeScreenshotAllMediaLibrarylinks();
	  
	}
	@Then("then take screenshot sts links")
	public void then_take_screenshot_all_sts_links() {
		links=new Links();
		links.TakeScreenshotAllSTSlinks();
	  
	}
	@Then("then take screenshot store links")
	public void then_take_screenshot_all_store_links() {
		links=new Links();
		links.TakeScreenshotAllStorelinks();
	  
	}
	@Then("take screenshot of typing links")
	public void then_take_screenshot_all_typing_links() {
		links=new Links();
		links.TakeScreenshotAllTypingLinks();
	  
	}
}
