package POMClass;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClass.Utility_Class;



public class Home_Page_Class {
	WebDriver driver;
	@FindBy(xpath="//input[@name='q']")
	private WebElement search;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchin;
	
	@FindBy(xpath="//div[@class='YUhWwv']")
	private WebElement cart;
	
	@FindBy(xpath="//div[text()='Ranjit']")
	private WebElement profilename;
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	private WebElement productisApper;
	
	public Home_Page_Class(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public  void entersearch(String search1) {
		search.sendKeys(search1);
	}
	public void entersearchin() {
		searchin.click();
	}
	public  void cartclick() {
		cart.click();
	}
	public boolean isprofilenameVisibel() 
	{
		try {
			Utility_Class k=new Utility_Class();
			WebElement element=k.expliciteWait(driver, profilename, null);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
		
		public boolean productisApper() 
		{
			try {
				Utility_Class k=new Utility_Class();
				WebElement element=k.expliciteWait(driver, productisApper, Duration.ofSeconds(10));
				return true;
			}
			catch(Exception e) {
				return false;
			}
		
	}
		public void search(String SearchText) {
			for(int i=0;i<SearchText.length();i++) {
				search.sendKeys(Keys.BACK_SPACE);
				
			}
		}
	public void firstproduct() {
		productisApper.click();
		ArrayList<String> adress=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(adress.get(1));
		
	}
}
