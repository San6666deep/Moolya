package Automation;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	WebDriver wd;
	Robot rt;
	
	
	
	@BeforeTest
	public void bt1() {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		
		
		
	}
	 @Test
	 public void dropdown() {
		 wd.get("https://www.amazon.in/");
		 Actions act=new Actions(wd);
		 WebElement we1=wd.findElement(By.xpath("//*[contains(text(),'Account & Lists')]"));
		 act.moveToElement(we1).build().perform();
		 wd.findElement(By.xpath("//*[@id='nav-logo-sprites']")).click();
		  
		 // wd.findElement(By.xpath("//*[contains(text(),'Your Orders')]")).click();
		  
		
		 
	 }

}
