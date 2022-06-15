package UtilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility_Class {
	WebDriver driver;
	public String ss(WebDriver driver) throws IOException {
		SimpleDateFormat frm = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
		String date=frm.format(new Date());
		
		File sorce=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=date+".png";
		File dest=new File(path);
		FileHandler.copy(sorce, dest);
		return path;
	}
	public void impli(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	public static WebElement expliciteWait(WebDriver driver, WebElement element ,Duration time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement element1=wait.until(ExpectedConditions.visibilityOf(element));
			return element1;
	}
	public static String GetDataFromExcel(String SheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream("src\\main\\resources\\Test_Data\\Test_Data.xlsx");
		
		Sheet sheet1=WorkbookFactory.create(file).getSheet(SheetName);
		String value=sheet1.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
}
