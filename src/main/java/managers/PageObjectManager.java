package managers;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

 
public class PageObjectManager {
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	
 
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
 
	public HomePage getHomePage() {
		return (homePage == null) ? new HomePage(driver) : homePage;
	}
 
	public LoginPage getLoginPage() {
		return (loginPage == null) ? new LoginPage(driver) : loginPage;
	}
}