package Runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import automationframework.AppDriver;
import automationframework.AutomationLog;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@ExtendedCucumberOptions(jsonReport = "target/cucumber.json"
		,retryCount = 0
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
			features = {"classpath:Features"} 
			, glue="stepDefinition"
			,plugin = { "pretty", "html:target/cucumber-default-report",
					"json:target/cucumber.json"
					//,"junit:target/cucumber-results.xml"
					,"usage:target/cucumber-usage.json"
					,"rerun:reports/rerun.txt"}
//			,tags= {"@smoke"}  // Run tests in groups
			,monochrome = false
//			,dryRun = true
			)

public class TestRunner extends AbstractTestNGCucumberTests {
	
    @BeforeSuite
    public static void setUp()  {
    	AppDriver.tearUp();
		AutomationLog.info("Webdriver initialized for suite");

    }
    
    @AfterSuite
    public static void tearDown() {
        AppDriver.closed();
    	AutomationLog.info("Webdriver closed successfully");
   }   

}
