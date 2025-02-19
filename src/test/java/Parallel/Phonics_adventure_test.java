package Parallel;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import com.qa.pages.Phonics_adventure;
import com.qa.util.JSONFileClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Phonics_adventure_test {
	WebDriver driver;
	Phonics_adventure phonics_adventure;
	JSONFileClass file;
	JSONObject user;
	@When("user navigate to the Sommer Learning baseurl")
	public void user_navigate_to_the_sommer_learning_baseurl() {
	    
	}
	@Then("Click on Phonics adventure")
	public void click_on_phonics_adventure() {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.clickOnPhonicsAdventure();
	   
	}
	@Then("Click on kindergarten")
	public void click_on_kindergarten() {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.clickOnKindergarten();
	}
	@Then("choose all wordfinder of book 2")
	public void choose_all_wordfinder_of_book_2() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.chooseAllWordFinderOfBook2();
	    
	}
	@Then("choose all wordfinder of book 3")
	public void choose_all_wordfinder_of_book_3() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.chooseAllWordFinderOfBook3();
	    
	}
	@Then("choose all wordfinder of book 4")
	public void choose_all_wordfinder_of_book_4() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.chooseAllWordFinderOfBook4();
	    
	}
	@Then("choose all wordfinder of book 8")
	public void choose_all_wordfinder_of_book_8() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.chooseAllWordFinderOfBook8();
	    
	}
	@Then("choose all wordfinder of book 5")
	public void choose_all_wordfinder_of_book_5() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.chooseAllWordFinderOfBook5();
	    
	}
	@Then("choose all wordfinder of book 6")
	public void choose_all_wordfinder_of_book_6() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.chooseAllWordFinderOfBook6();
	    
	}
	@Then("choose all wordfinder of book 7")
	public void choose_all_wordfinder_of_book_7() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.chooseAllWordFinderOfBook7();
	    
	}
	@When("enter the wordfinder {string}")
	public void enter_the_email(String WordFinder) {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.enterTheEmail(WordFinder);
	}
	@Then("Check the UI of books")
	public void check_the_ui_of_books() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.checkTheUIofBooks();
	    
	}
	@Then("Click on the write book")
	public void click_on_the_write_book() throws InterruptedException {
		phonics_adventure=new Phonics_adventure(DriverFactory.getDriver());
		phonics_adventure.ClickOnTheRightBook();
	    
	}

}
