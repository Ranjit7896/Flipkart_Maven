package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class {
	public static WebDriver getmethod(String browser) {
		int a=10;
		WebDriver driver =null;
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		return driver;
}}
