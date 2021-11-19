package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class Openbrowsersd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
	
	@Given("The chrome browser is open")
	public void the_chrome_browser_is_open() {
		String browser = rp.getdriver();
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			helper = new WebDriverHelper(driver);
		}
    }

	@And("^Navigated to the url \"([^\"]*)\"$")
    public void navigated_to_the_url_something(String url) {
        helper.openwebsite(url);
        er = new Extentreports(driver);
        er.startTest("Opening Website");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.info("Browser opened and fetched URL");
        er.endTest();
    }
    
    public static WebDriver getdriver() {
    	return driver;
    }
    public static Extentreports getreport() {
    	return er;
    }

}
