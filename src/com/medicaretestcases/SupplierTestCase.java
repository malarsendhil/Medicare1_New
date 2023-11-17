package com.medicaretestcases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medicarePOM.POMFactoryMed;

public class SupplierTestCase {
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
		
		pf.EnterUserID("malar@sup.com");
		
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
