package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class stepLogin {

	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	PageObjectManager pageObjectManager;
	WebDriverManager driverManager;
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    driverManager=new WebDriverManager();
	    driver=driverManager.getDriver();
	    driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	    
	}

	@When("^he click on Dang Nhap button$")
	public void he_click_on_Dang_Nhap_button() throws Throwable {
	    pageObjectManager= new PageObjectManager(driver);
		homePage=pageObjectManager.getHomePage();
	    homePage.clickon_DangNhap();
	
	}

	@When("^enter email and password at Login Page$")
	public void enter_email_and_password_at_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage=pageObjectManager.getLoginPage();
		loginPage.enter_Data();
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
