package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import PageObjects.CorporateGifts;
import ReusableComponents.WebDriverHelper;
import UIStore.CorporategiftpageUI;
import UIStore.LandingpageUI;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Corporategiftsd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	LandingpageUI lploc;
	String url = rp.getUrl();
	CorporateGifts cg;
	CorporategiftpageUI cgloc;
	@Given("^The landing page is open$")
    public void the_landing_page_is_open() {
		driver = Searchproductsd.getdriver();
		er = Searchproductsd.getreport();
		driver.get(url);
		lploc = new LandingpageUI(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on Corporate Gift$")
    public void i_click_on_corporate_gift() {
    	cg = new CorporateGifts(driver, er);
		cgloc = new CorporategiftpageUI(driver);
		cg.clickoncorporategift(lploc);
		
    }

    @Then("^Navigate to details page$")
    public void navigate_to_details_page() throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    }

    @And("^Take user input$")
    public void take_user_input() {
    	cg.enterdetails(cgloc);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    

	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}

}
