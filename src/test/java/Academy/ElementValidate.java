package Academy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class ElementValidate extends base{

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
	public void validateNavBar(String email, String password) throws InterruptedException {
		
		LandingPage landPage = new LandingPage(driver);
		Thread.sleep(2000);
		Assert.assertTrue(landPage.getNavBar().isDisplayed());
	
	}

	
}
