package com.medicaretestcases;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

//import com.PomFile.PomClass;
import com.medicarePOM.POMFactoryMed;
//import com.PomFile.PomClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CapstoneTestCase {
public WebDriver driver;
	
    POMFactoryMed pf;
	
	@BeforeMethod
	
	public void StartBrowser() throws MalformedURLException, InterruptedException 
	{
		System.setProperty("WebDriver.firefox.driver", ".\\Driver\\geckodriver.exe");		
		FirefoxDriver driver=new FirefoxDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		driver.get(GlobalVariable.url);
		Thread.sleep(5000);
		
		pf = new POMFactoryMed(driver);
		
		}
	
   @Test
	
	public void LoginTestcase() throws InterruptedException
	{
		pf.clickonLogin();
		
		pf.EnterUserID("mani@abc.com");
		
		pf.EnterPassword("Manimalar@2125");
		
		pf.ClickOnLoginButton();
		
		Thread.sleep(4000);
		pf.ViewProduct();
		
		Thread.sleep(4000);
		pf.Tablet();
		
		Thread.sleep(4000);
		pf.CheckOut();
		
		Thread.sleep(4000);
		pf.Select();
		
		Thread.sleep(4000);
		pf.Pay();
		
		Thread.sleep(2000);
	}
	
	@AfterMethod()
	
	public void closeBrowser() throws InterruptedException
	{
		driver.quit();
	}
	}