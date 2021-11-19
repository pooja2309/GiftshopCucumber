package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.CreateAccount;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.LandingpageUI;
import UIStore.LoginpageUI;
import UIStore.SignuppageUI;
import Utilities.Extentreports;
import Utilities.Readproperty;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountsd {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static Extentreports er;
	LandingpageUI lploc;
	String url = rp.getUrl();
	CreateAccount ca;
	SignuppageUI suloc;
	LoginpageUI loginpageloc;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
    @Given("^Fetch the driver and open home page$")
    public void fetch_the_driver_and_open_home_page() {
    	driver = Loginsd.getdriver();
		er = Loginsd.getreport();
		driver.get(url);
		lploc = new LandingpageUI(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on click on Sign in$")
    public void i_click_on_click_on_sign_in() {
    	loginpageloc = new LoginpageUI(driver);
    	ca = new CreateAccount(driver, er);
		driver.get(url);
		ca.clickonlogin(lploc);
    }

    @Then("^Navigate to the respective page and click on create account$")
    public void navigate_to_the_respective_page_and_click_on_create_account() throws InterruptedException {
		driver = helper.changetonewdriver(driver);
		ca.clickoncreateaccount(loginpageloc);
		driver = helper.changetonewdriver(driver);
		log.info("Create Account - Successful");
    }

    @And("^Enter credentials$")
    public void enter_credentials() {
    	ca.enterdetails();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Creating account");
		driver.get(url);
    }

	public static WebDriver getdriver() {
		return driver;
	}

	public static Extentreports getreport() {
		return er;
	}
}
