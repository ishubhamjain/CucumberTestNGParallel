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
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;


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
				scenario.embed(screenshot, "image/png"); // this embed the image in report
				//scenario.write("ase hota hai fail");
				scenario.write(scenario.getName()+" = failed"); // this write text in report
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
/*	@BeforeStep
	public void beforehook() {
		System.out.println("Before Hook");
	}
	
	@AfterStep
	public void Afterhook() {
		System.out.println("After Hook");
	}*/
}
