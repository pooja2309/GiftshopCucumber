package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.GiftCard;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.GiftcardpageUI;
import UIStore.LandingpageUI;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Giftcardsd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	LandingpageUI lploc;
	GiftcardpageUI gcploc;
	GiftCard gc;
	String url = rp.getUrl();
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
    @Given("^Browser and url is open$")
    public void browser_and_url_is_open() {
    	driver = CreateAccountsd.getdriver();
		er = CreateAccountsd.getreport();
		driver.get(url);
		lploc = new LandingpageUI(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on click on Gift card$")
    public void i_click_on_click_on_gift_card() {
    	gcploc = new GiftcardpageUI(driver);
		gc = new GiftCard(driver, er);
		gc.clickongiftcard(lploc);
    }

    @Then("^Navigate to the page and check COD$")
    public void navigate_to_the_page_and_check_cod() throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
		gc.checkCOD(gcploc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		gc.getAvailability(gcploc);
		log.info("Cash On Delivery - Successful");
    }

    @And("^Add to Wishlist$")
    public void add_to_wishlist() {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gc.addtowishlist(gcploc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Add to Wishlist - Succesful");
		
    }
	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}
}
