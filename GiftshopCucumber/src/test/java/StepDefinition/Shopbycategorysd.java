package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.Shopbycategory;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.LandingpageUI;
import UIStore.ShopobycategoryUI;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Shopbycategorysd {
	
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	LandingpageUI lploc;
	String url = rp.getUrl();
	ShopobycategoryUI scloc;
	Shopbycategory sc;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
    @Given("^The page is open fetch driver$")
    public void the_page_is_open_fetch_driver() {
    	driver = Corporategiftsd.getdriver();
		er = Corporategiftsd.getreport();
		driver.get(url);
		lploc = new LandingpageUI(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on click on shop by category$")
    public void i_click_on_click_on_shop_by_category() {
    	sc = new Shopbycategory(driver, er);
		scloc = new ShopobycategoryUI(driver);
		sc.clickonshopbycategory(lploc);
    }

    @Then("^Navigate to the respective page$")
    public void navigate_to_the_respective_page() throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
    	log.info("Shop by category");
    }

    @And("^Sort in order$")
    public void sort_in_order() {
    	sc.sortBy(scloc);
    	log.info("Sorting products");
    }
	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}
}
