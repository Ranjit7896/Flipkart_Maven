
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.Base_Class;
import POMClass.Home_Page_Class;

import POMClass.Login_Class;

public class VerifyUseCanBuyProduct {
	WebDriver driver;
	Home_Page_Class kk;
	Login_Class k;
	
	@Parameters("browser")
	  @BeforeClass
	  public void beforeClass(String A) {
		   driver=Base_Class.getmethod(A);
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  k =new Login_Class(driver);
		  kk =new Home_Page_Class(driver);
		  
	  }
	  @Test
	  public void test1() throws InterruptedException {
		  	
		  	k.enteremail();
			k.enterpassword();
			k.presslogin();
			
			if(kk.isprofilenameVisibel()) {
				System.out.println("Login");
			}
			else {
				System.out.println();
				Assert.fail();
			}

}
	  
}
