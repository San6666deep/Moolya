package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting {
	WebDriver wd;

	@Parameters("MyBrowser")
	@BeforeTest()
	public void bt1(String mybrowser) {
		
		if(mybrowser.equalsIgnoreCase("chrome"))
		{
		  WebDriverManager.chromedriver().setup();
			wd=new ChromeDriver();
		
		}
		else if (mybrowser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			wd=new FirefoxDriver();
		}
		
	}
	@Test()
	public void test() throws InterruptedException
	{
		Thread.sleep(3000);
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		wd.findElement(By.xpath("//*[@type='password']")).sendKeys("admin123");
		wd.findElement(By.xpath("//*//*[@type='submit']")).click();
		  
		
		}

}
