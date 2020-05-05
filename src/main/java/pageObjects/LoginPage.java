package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	By emailField = By.cssSelector("#user_email");
	By passwordField = By.cssSelector("#user_password");
	By loginButton = By.xpath("//input[@value='Log In']");
	By alertMessage = By.cssSelector(".alert.alert-danger");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}	
	
	public WebElement getEmail() {
		return driver.findElement(emailField);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passwordField);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public WebElement getAlertMessage() {
		return driver.findElement(alertMessage);
	}
}

