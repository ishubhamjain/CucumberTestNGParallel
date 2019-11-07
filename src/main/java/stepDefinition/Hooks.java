package stepDefinition;
/**
 * @author Shubham Jain
 *
 */

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import automationframework.AppDriver;
import automationframework.AutomationLog;
import automationframework.Configuration;
import automationframework.Page;
import automationframework.WaitFor;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void before() {
		System.out.println("Before executes");
		if(!AppDriver.browserStatus) {
			AppDriver.tearUp();
		}
		
		WaitFor.isloadComplete(Page.getDriver());
		
		Page.getDriver().navigate().to(Configuration.applicationUnderTestURL());
		
		AutomationLog.info("Navigation done");
		
	}
	
	@After
	public void embedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				AppDriver.browserStatus=false;
				byte[] screenshot = ((TakesScreenshot) Page.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				//scenario.write("ase hota hai fail");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
