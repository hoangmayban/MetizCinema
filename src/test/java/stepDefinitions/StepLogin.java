package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Helpers.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testDataTypes.Account;

public class StepLogin {

	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	TestContext testContext;
	FileReaderManager fileReaderManager;
	
	public StepLogin(TestContext context) {
		
		testContext=context;
		homePage=testContext.getPageObjectManager().getHomePage();
		loginPage=testContext.getPageObjectManager().getLoginPage();
	}
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
	    homePage.navigate_AppURL();
	    
	}

	@When("^he click on Dang Nhap button$")
	public void he_click_on_Dang_Nhap_button() throws Throwable {
		
	    homePage.clickon_DangNhap();
	
	}

	@When("^enter email and password of valid \"([^\"]*)\" at Login Page$")
	public void enter_email_and_password_at_Login_Page(String accountEmail) throws Throwable {
		Account account=FileReaderManager.getInstance().getJsonReader().getAccountByEmail(accountEmail);
		loginPage.enter_Data(account);
	}

	@When("^click on DangNhap button at Login Page$")
	public void click_on_DangNhap_button_at_Login_Page() throws Throwable {
	    loginPage.click_SubmitLogin();
	   
	}

	@Then("^login successfully and username is displayed$")
	public void login_successfully_and_username_is_displayed() throws Throwable {
	    loginPage.verify_Login();
	    
	   
	}
	
	
	
}
