package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id=\"email\"]")
	private WebElement btn_Email;
	

	@FindBy(xpath="//input[@id=\"password\"]")
	private WebElement btn_Password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement btn_Login;
	
	@FindBy(xpath="//a[@href=\"/profile/\"]")
	private WebElement a_Profile;
	
	public void enter_Data() {
		btn_Email.sendKeys("v2hoang@gmail.com");
		btn_Password.sendKeys("Abc@1234");
		
	}
	
	public void click_SubmitLogin() {
		btn_Login.submit();
	}
	
	public void verify_Login() {
		try {
			if(a_Profile.isDisplayed());
			System.out.println("login thanh cong");
		}
		catch(NoSuchElementException e) {
			System.out.println(e.getMessage().toString());
		}
	}
}
