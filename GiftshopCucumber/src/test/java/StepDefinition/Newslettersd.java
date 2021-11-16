package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import PageObjects.Newsletter;
import ReusableComponents.WebDriverHelper;
import UIStore.LandingpageUI;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Newslettersd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	LandingpageUI lploc;
	String url = rp.getUrl();
	Newsletter nl;
    @Given("^Open the URL in browser$")
    public void open_the_url_in_browser() {
    	driver = CreateAccountsd.getdriver();
		er = CreateAccountsd.getreport();
		driver.get(url);
		lploc = new LandingpageUI(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I Enter the \"([^\"]*)\"$")
    public void i_enter_the_something(String emailid) {
    	nl = new Newsletter(driver, er);
 		nl.subscribetonewsletter(lploc, emailid);
 		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Then("^Navigate and quit$")
    public void navigate_and_quit() {
    	driver.quit();
    }
	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}
}
