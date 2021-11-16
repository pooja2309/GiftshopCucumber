package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import PageObjects.Login;
import ReusableComponents.WebDriverHelper;
import UIStore.LandingpageUI;
import UIStore.LoginpageUI;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginsd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	LandingpageUI lploc;
	String url = rp.getUrl();
	LoginpageUI loginloc;
	Login login;
	@Given("^The landing page is open fetch driver$")
    public void the_landing_page_is_open_fetch_driver() {
		driver = Shopbycategorysd.getdriver();
		er = Shopbycategorysd.getreport();
		driver.get(url);
		lploc = new LandingpageUI(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on Signin$")
    public void i_click_on_signin() {
    	login = new Login(driver, er);
    	login.clickonlogin(lploc);
    	loginloc = new LoginpageUI(driver);
    }

    @Then("^Navigate to the page and enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void navigate_to_the_page_and_enter_something_and_something(String emailid, String password) throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.entercorrectdetails(loginloc, emailid, password);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
	
	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}
}
