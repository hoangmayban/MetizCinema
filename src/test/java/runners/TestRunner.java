package runners;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)

@CucumberOptions( 
		features = "src/test/resources/TestCases",
		glue= {"stepDefinitions"},
		tags= {"~@testlink"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome=true
		)

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
}

/*@CucumberOptions(
features = "src/test/resources/TestCases",
glue= {"stepDefinitions"},
		monochrome = true,
		//all report
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports"}

	
)
*/

