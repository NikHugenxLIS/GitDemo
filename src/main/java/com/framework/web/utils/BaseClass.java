package com.framework.web.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver = null;
    
	
	
	  FileUtility fLib = new FileUtility();
	//WebDriverUtility wLib =new WebDriverUtility();
	//JavaUtility jLib = new JavaUtility();
	//ExcelUtility eLib = new ExcelUtility();
	
	@BeforeClass
	public void configBC(String BROWSER )
	{
		//System.out.println("============Lauch the browser==========");
		//WebDriverManager.chromedriver().setup();
		//driver= new ChromeDriver();
		//driver.manage().window().maximize();
		//wLib.waitForPageToLoad(driver);
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			//wLib.waitForPageToLoad(driver);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			driver.manage().window().maximize();
			//wLib.waitForPageToLoad(driver);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			//wLib.waitForPageToLoad(driver);
		}
		else
		{
			driver = new ChromeDriver();
		}
	}
	
	@BeforeMethod
	public void configBM() throws IOException
	{
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url1");
		String USERNAME = fLib.getPropertyKeyValue("username17");
		String password = fLib.getPropertyKeyValue("password");
		//sDriver=driver;
		driver.get(URL);
		
		//LOGIN lp = new LOGIN(driver);
	//	lp.loginToApp(USERNAME, password);
		

	}
	@AfterMethod
	public void configAM() throws InterruptedException
	{     
		
		//HomePage HomePage = new HomePage(driver);
		Thread.sleep(60000);
		//HomePage.logoutAction();
	}
	
	@AfterClass
	public void configAC()
	{
		driver.close();
	}
	

}
