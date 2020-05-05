package StepDefinitions;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base{

	@Given("^Initialize the browser with crhome$")
    public void initialize_the_browser_with_crhome() throws IOException {
        driver = initializeDriver();
    }

    @Given("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) {
    	driver.get(strArg1);
    }
    
    @Given("^Click on login link home page to land on Secure sign in Page$")
    public void click_on_login_link_home_page_to_land_on_secure_sign_in_page() {
    	
    	LandingPage landPage = new LandingPage(driver);
		landPage.getLogin().click();
		log.info("login button clicked and login page opens..");
    }
	
    @When("^User enters (.+) and (.+) and logs in $")
    public void user_enters_something_and_something_and_logs_in(String username, String password) throws InterruptedException {
    	LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage.getEmail().click();
		loginPage.getEmail().sendKeys(username);
		log.info("Email is entered!");
		loginPage.getPassword().click();
		loginPage.getPassword().sendKeys(password);
		log.info("Password is entered!");
		//loginPage.clickLoginButton();
    }

    @Then("^Verify that user is succesfully logged in$")
    public void verify_that_user_is_succesfully_logged_in() {
        portalHomePage p = new portalHomePage(driver);
        Assert.assertFalse(p.getSearchBox().isDisplayed());
    }
    
    @And("^close browsers$")
    public void close_browsers() {
        driver.close();
    }

    

}
