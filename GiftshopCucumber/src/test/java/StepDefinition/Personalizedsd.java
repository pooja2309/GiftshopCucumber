package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import PageObjects.PersonalizedGift;
import ReusableComponents.WebDriverHelper;
import UIStore.LandingpageUI;
import UIStore.PersonalizedpageUI;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Personalizedsd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	LandingpageUI lploc;
	String url = rp.getUrl();
	PersonalizedGift pg;
	PersonalizedpageUI pgloc;

	@Given("^The home page is open$")
	public void the_home_page_is_open() {
		driver = Corporategiftsd.getdriver();
		er = Corporategiftsd.getreport();
		driver.get(url);
		lploc = new LandingpageUI(driver);
		helper = new WebDriverHelper(driver);
	}

	@When("^I click on Personalized gifts$")
	public void i_click_on_personalized_gifts() {
		pgloc = new PersonalizedpageUI(driver);
		pg = new PersonalizedGift(driver, er);
		pg.clickonpersonalizedgift(lploc);
	}

	@Then("^Navigate to the page and select product$")
	public void navigate_to_the_page_and_select_product() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@And("^Customize the \"([^\"]*)\" to be printed$")
	public void customize_the_something_to_be_printed(String name) throws InterruptedException {
		pg.addproduct(pgloc, name);
		driver = helper.changetonewdriver(driver);
		pg.verify(pgloc);
		driver.get(url);
	}

	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}
}
