package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import managers.WebDriverManager;
import net.bytebuddy.asm.Advice.This;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@class='dropdown hover-user-header']//a[@href='/login/']")
	private WebElement a_Login;
	
	public void clickon_DangNhap() {
		a_Login.click();
	}
	
	public void navigate_AppURL() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
}
