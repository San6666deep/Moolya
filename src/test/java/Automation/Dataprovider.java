package Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider {
	WebDriver wd;
	 
	@DataProvider                       //to provide set of data to test methods
	public Object[][] dp(){             //two[][] are used for two data fields i.e.,username and password
		return new Object[][] {          //returns the data provided to the @test method
			new Object[] {"sandeep","Admin123"},    //single [] represents that the object is an array here
			new Object[] {"Admin","admin123"},
			new Object[] {"Admin","admin123"},      //new Object[]{n,s}  
					
		};
		}
	
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test (dataProvider = "dp")         //all the data from data provider is used here
	public void test1(String n,String s) {             //n=username and s=password 
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys(n);
		wd.findElement(By.xpath("//*[@type='password']")).sendKeys(s);
		wd.findElement(By.xpath("//*//*[@type='submit']")).click();
		
		wd.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).click();
		wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]")).click();
	}
}
