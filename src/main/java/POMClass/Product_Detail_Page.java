package POMClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClass.Utility_Class;

public class Product_Detail_Page {
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='BUY NOW']")
	private WebElement first;
	
	@FindBy(xpath="//h1")
	private WebElement productname;
	
	@FindBy(xpath="(//button['@class=_2KpZ6l _2U9uOA _3v1-ww'])[2]")
	private WebElement AddToCart;
	
	public Product_Detail_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public boolean isbuybuttonApper() {
		try {
			Utility_Class k=new Utility_Class();
			WebElement element=k.expliciteWait(driver, first, Duration.ofSeconds(10));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public String getproductname() 
	{
		return productname.getText().trim();
	}
	public void ClickAddToCart() {
		AddToCart.click();
	}
	
	
}
