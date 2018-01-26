package stepDefinitions;

import java.util.concurrent.TimeUnit;

import Helpers.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext=context;
	}
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		testContext.getWebDriverManager().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		testContext.getWebDriverManager().closeDriver();
	}
}
