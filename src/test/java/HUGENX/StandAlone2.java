package HUGENX;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HUGENX.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone2 
{
	public static void main(String[] args) {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	LoginPage loginpage = new LoginPage(driver);
	loginpage.goTo();
	loginpage.loginApplication("nikkikumar2017@gmail.com", "23MN@ak1");
	System.out.println("hello");
	System.out.println("hello");
	System.out.println("hello");
	System.out.println("hello");
	System.out.println("hello");
	driver.close();
	
	
	driver.quit();
	
	
	

}
}
