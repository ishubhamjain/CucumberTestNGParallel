package automationframework;
/**
 * @author Shubham Jain
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import automationframework.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppDriver {

	public static Boolean browserStatus=null;

	public WebDriver getDriver() {
		WebDriver driver = null;
		
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().version(Configuration.getConfigurationValueForProperty("chrome-version"))
				.setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		// options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		driver.get(Configuration.applicationUnderTestURL());
		Page.setDriver(driver);
		return driver;
	}

	public static void tearUp() {
		AppDriver driver = new AppDriver();
		Page.setDriver(driver.getDriver());
		AutomationLog.info("Webdriver initialized");
		browserStatus = true;

	}

	public static void closed() {
		Page.getDriver().quit();
		browserStatus = false;
	}
}
