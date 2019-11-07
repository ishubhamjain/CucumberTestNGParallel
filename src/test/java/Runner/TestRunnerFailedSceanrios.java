package Runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import automationframework.AppDriver;
import automationframework.AutomationLog;
import automationframework.Page;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@ExtendedCucumberOptions(jsonReport = "target/cucumber.json"
		,retryCount = 2
		,detailedReport = true
		,detailedAggregatedReport = true
		,overviewReport = true
		,coverageReport = true
		,jsonUsageReport = "target/cucumber-usage.json"
		,usageReport = true
		,toPDF = true
		//,excludeCoverageTags = {"@flaky" }
		,includeCoverageTags = {"@passed" }
		,outputFolder = "target"
)

@CucumberOptions(
			features = {"@reports/rerun.txt"} 
			, glue="stepDefinition"
			,plugin = { "pretty", "html:target/cucumber-default-report",
					"json:target/cucumber.json"
}
//			,tags= {"@smoke"}  // Run tests in groups
			,monochrome = false
//			,dryRun = true
			)

public class TestRunnerFailedSceanrios extends AbstractTestNGCucumberTests {
	
    @BeforeSuite
    public static void setUp()  {
    	AppDriver driver = new AppDriver();
		Page.setDriver(driver.getDriver()); 
		AutomationLog.info("Webdriver initialized for failed Scenarios");
    }
    
    @AfterSuite
    public static void tearDown() {
       Page.getDriver().quit();
       AutomationLog.info("Webdriver closed successfully");
   }   

}
