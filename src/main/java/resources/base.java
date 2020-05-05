package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	protected WebDriver driver; 
	protected Properties prop ;
	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());

	
	@BeforeMethod
	public void BeforeTest() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is initialized!");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to HomePage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	@AfterMethod
	public void AfterTest() {
		driver.close();
		log.info("Browser is closed!");
	}
	
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();	
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");
		String headlessMode = prop.getProperty("headlees");

		
		switch(browserName) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			if(headlessMode.equals("true")) 
			{
				chromeOptions.addArguments("headless");
			}
			driver = new ChromeDriver(chromeOptions);
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if(headlessMode.equals("true")) 
			{
				firefoxOptions.addArguments("headless");
			}
			driver = new FirefoxDriver(firefoxOptions);
			break;
				
		default:
			System.out.println("Browser does not exist");
		}
		
		return driver;
	}
	
	
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Program Files\\screenshots\\"+result+".png"));
	}
	
	
}
