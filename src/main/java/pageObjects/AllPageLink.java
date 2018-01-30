package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AllPageLink {
	WebDriver driver;
	private String homePageLink="https://uat.metiz.vn/";
	
	
	public AllPageLink(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
