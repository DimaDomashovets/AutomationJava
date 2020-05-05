package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signIn = By.cssSelector("#homepage > header > div.tools > div > nav > ul > li:nth-child(4) > a > i");
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	
	
}
