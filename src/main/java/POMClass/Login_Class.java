package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Class {
	WebDriver driver;
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement email;
	
	@FindBy(xpath="(//input[@type='password'])")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement login;
	
	public Login_Class(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void enteremail() {
		email.sendKeys("hemke86r@gmail.com");
		
	}
	public void enterpassword() {
		password.sendKeys("7620353124");
	}
	public void presslogin() throws InterruptedException {
		login.click();
		Thread.sleep(2000);
	}
	
	
}
