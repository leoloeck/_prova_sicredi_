package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import core.Propriedades;

public class DriverFactory {
	
    private static WebDriver driver;
	
	
	public DriverFactory() {

	}
	
	public WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.grocerycrud.com/demo/bootstrap_theme");
		
		return driver;
	}
	
	public static WebDriver getDriver(){
		if(driver == null) {
			

			//switch (Propriedades.browser) {
				//case FIREFOX: driver = new FirefoxDriver(); break;
				//case CHROME: driver = new ChromeDriver(); break;
			//}
			//driver.manage().window().setSize(new Dimension(1200, 765));			
		}

		
		return driver;
	}
	
	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
	}
	
}
