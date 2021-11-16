package StepDefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import PageObjects.SearchService;
import ReusableComponents.WebDriverHelper;
import Utilities.Extentreports;
import Utilities.Readproperty;
import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(Cucumber.class)
public class Searchproductsd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	SearchService search;
	String path;

	@Given("^The Website is open fetch driver$")
	public void the_website_is_open_fetch_driver() {
		driver = Openbrowsersd.getdriver();
		er = Openbrowsersd.getreport();
		helper = new WebDriverHelper(driver);
	}

	@When("^Search box locator is found$")
	public void search_box_locator_is_found() throws Throwable {
		path = System.getProperty("user.dir") + rp.pathsheet();
		System.out.println("Search products here");
		search = new SearchService(driver);
		
	}

	@Then("^Search products mentioned in excel$")
	public void search_products_mentioned_in_excel() throws Throwable {
		search.getproducts(path);
		search.searchforproducts(er);
		
	}
	
	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}

}
