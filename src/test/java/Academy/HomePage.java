package Academy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{

	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][2];
		data[0][0] = "abc@gm.com";
		data[0][1] = "lol";
		
		data[1][0] = "ddomash@ukr.com";
		data[1][1] = "heloMatherfucker";
		
		return data;
	}
	

	@Test(dataProvider="getData")
	public void basePageNavigation(String email, String password) throws InterruptedException {
		
		LandingPage landPage = new LandingPage(driver);
		//Thread.sleep(2000);
		landPage.getLogin().click();
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.getEmail().click();
		loginPage.getEmail().sendKeys(email);
		log.info("Email is entered!");
		loginPage.getPassword().click();
		loginPage.getPassword().sendKeys(password);
		log.info("Password is entered!");
		loginPage.clickLoginButton();
		log.info("Login button clicked");
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getAlertMessage().getText(), "Invalid email or password.");
	}
	
}
