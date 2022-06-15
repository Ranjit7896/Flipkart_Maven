package TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.Base_Class;

import POMClass.Home_Page_Class;
import POMClass.Login_Class;
import POMClass.Product_Detail_Page;
import UtilClass.Utility_Class;



public class VerifyUseCanBuyProduct {
	
		WebDriver driver;
		Home_Page_Class kk;
		Login_Class k;
		Utility_Class A;
		Product_Detail_Page B;
		ExtentHtmlReporter htmlreporter;
		ExtentReports report;
		ExtentTest test;
		
	
		
		@Parameters("browser")
		  @BeforeClass
		  public void beforeClass(String A) {
			//For HTML sheet report
			htmlreporter= new ExtentHtmlReporter("ExtentReporter.html");
			report=new ExtentReports();
			report.attachReporter(htmlreporter);
			test=report.createTest("VerifyUseCanBuyProduct");
			driver=Base_Class.getmethod(A);
		  }
		  @BeforeMethod
		  public void beforeMethod() {
			  k =new Login_Class(driver);
			  kk=new Home_Page_Class(driver);
			  B=new Product_Detail_Page(driver);
			  A=new Utility_Class();
			 
		  }
		  @Test(priority=1)
		  public void VerifyUserCanLLogin() throws InterruptedException {
			  	
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
		  @Test(priority=2)
		  public void VerifyUserCanSearchProduct() throws Exception {
			String data=  Utility_Class.GetDataFromExcel("Sheet1", 0, 0);
			
			  kk.entersearch(data);
			  kk.entersearchin();
			  
			  
			  Assert.assertTrue(kk.productisApper());
		  }
		  @Test (priority=3)
		  public void VerifyUsercanSelectTheProductAndMoveTodetailPage() {
			  kk.firstproduct();
			  Assert.assertTrue(B.isbuybuttonApper());
			  B.ClickAddToCart();			  
	  }
		 
		  
		  
		  
		  @AfterMethod
		  //Creat Log for HTML Reporter
		  public void aftermethod(ITestResult result) throws IOException {
			  if(result.getStatus()==ITestResult.SUCCESS) {
				  String path=  A.ss(driver);
				  test.log(Status.PASS,"Test is Pass"+result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			  }
			  else {
				
				  test.log(Status.FAIL, "Test Is Fail"+result.getName());
				  
			  }
			  
		  }
		  @AfterClass
		  public void afterclass() {
			  report.flush();
			  
		  }
}
