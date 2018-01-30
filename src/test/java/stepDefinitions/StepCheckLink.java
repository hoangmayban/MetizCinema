package stepDefinitions;

import org.openqa.selenium.WebDriver;

import Helpers.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.FileReaderManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class StepCheckLink {

	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	TestContext testContext;
	FileReaderManager fileReaderManager;
	
	public StepCheckLink(TestContext context) {
		
		testContext=context;
		homePage=testContext.getPageObjectManager().getHomePage();
		
	}
	
	@Given("^stand on HomePage$")
	public void stand_on_HomePage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   homePage.navigate_AppURL();
	}

	@Then("^verify all link of HomePage$")
	public void verify_all_link_of_HomePage() throws Throwable {
	    homePage.test_all_homepake_link();
	    
	}
	
}
