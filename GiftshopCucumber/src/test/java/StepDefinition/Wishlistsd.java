package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.WishList;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.LandingpageUI;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Wishlistsd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	LandingpageUI lploc;
	String url = rp.getUrl();
	WishList wl;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
    @Given("^Open the URL$")
    public void open_the_url() {
    	driver = CreateAccountsd.getdriver();
		er = CreateAccountsd.getreport();
		driver.get(url);
		lploc = new LandingpageUI(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on click on Wish List$")
    public void i_click_on_click_on_wish_list() {
    	wl = new WishList(driver, er);
		wl.clickonwishlist(lploc);
    }

    @Then("^Navigate to the page and display$")
    public void navigate_to_the_page_and_display() throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		log.info("Wish List - Successful");
    }
	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}
}
