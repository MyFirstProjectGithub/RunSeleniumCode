package testPackage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassD {
	public static WebDriver driver;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.google.com/");
	    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Guru99" ,Keys.ENTER);
	   
	    WebElement wb  = driver.findElement(By.xpath("//h3/div[contains(text(),'Meet Guru99')]"));
	    String value =  wb.getText();
	    System.out.println("Text Value : " + value);
	    if(value.contains("Meet Guru99")){
	    	long millis=System.currentTimeMillis();
	    	java.util.Date date=new java.util.Date(millis);
	    	System.out.println("Test Passed " + date);
	    	wb.click();
	    	driver.close();
	    }
	}
}

