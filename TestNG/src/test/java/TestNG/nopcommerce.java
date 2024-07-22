package TestNG;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class nopcommerce {

	WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	
	public void getlogin() throws InterruptedException {
		
	    WebElement ele = driver.findElement(By.id("Email"));
	    ele.clear();
	    ele.sendKeys("admin@yourstore.com");
		WebElement ele1 = driver.findElement(By.className("password"));
		ele1.clear();
		ele1.sendKeys("admin");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		
	}
	
	@Test
	
	public void AddNewCustomer() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p/i")).click();
		driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.id("Email")).sendKeys("ritikasrivastava912@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("xyz123");
		driver.findElement(By.id("FirstName")).sendKeys("Ritika");
		Thread.sleep(2000);
		
		driver.findElement(By.id("LastName")).sendKeys("Srivastava");
		driver.findElement(By.id("Gender_Female")).click();
		driver.findElement(By.id("DateOfBirth")).sendKeys("09/12/1998");
    	Thread.sleep(2000);
    	
		driver.findElement(By.id("Company")).sendKeys("cetpa");
		driver.findElement(By.xpath("//*[@id=\"IsTaxExempt\"]")).click();
		WebElement ele2=driver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/span/span[1]/span/ul/li/input"));
		ele2.sendKeys("abc");
		Thread.sleep(2000);
		
		WebElement ele3 = driver.findElement(By.name("VendorId"));
		Select drp3 = new Select(ele3);
		drp3.selectByValue("2");
		Thread.sleep(2000);
		
		 WebElement ele4=driver.findElement(By.id("AdminComment"));
		 ele4.sendKeys("abc");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/div/div/div/div[2]/div/label/span")).click();
		Thread.sleep(3000);
		
	    File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(f,new File("C:\\Users\\admin\\Desktop\\ritika\\TestNG\\screenshot.jpg"));
	}
	@AfterMethod
	public void teardwon() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}